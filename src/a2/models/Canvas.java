package a2.models;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;

import a2.utils.ShaderProgram;
import a2.utils.Transform;
import a2.utils.Vertex;
import graphicslib3D.Point3D;

/*
 * GLCanvas object that handles the render logic
 */
@SuppressWarnings("serial")
public class Canvas extends GLCanvas implements GLEventListener, MouseWheelListener {

	private ShaderProgram rendering_program;
	
	// One vertex array index for a single object
	private int vao[] = new int[1];
	
	private Mesh myMesh;
	private Sphere mySphere;
	private float temp = 0.0f;
	private Transform transform;
	
	public void display(GLAutoDrawable drawable) {
		GL4 gl = drawable.getGL().getGL4();
		
		// Clear, Update, Draw loop
		gl.glClear(GL4.GL_DEPTH_BUFFER_BIT);
		gl.glClear(GL4.GL_COLOR_BUFFER_BIT);
		gl.glEnable(GL4.GL_CULL_FACE);
		gl.glFrontFace(GL4.GL_CCW);
	
		temp += 0.03f;
		float sinTemp = (float)Math.sin(temp);
//		transform.setTranslation(3*(float)Math.cos(temp), 3*sinTemp, -10);
		transform.setTranslation((float)Math.sin(temp) * 2.0f * (float)Math.sinh(1.0f), 
								  0.0f, 
								  (float)Math.cos(temp+10f) * 2.0f * (float)Math.cosh(1.0f)*3-10.0f);
		transform.setRotation(sinTemp*180, sinTemp*180, sinTemp*180);
		
		
		this.rendering_program.bind();
		this.rendering_program.setMatrixUniform("transform", transform.getProjectedTransformation());

//		myMesh.draw();
		mySphere.draw();
	}

	public void init(GLAutoDrawable drawable) {
		GL4 gl = drawable.getGL().getGL4();
		
		// Initialize the projection values
		Transform.setProjection(60.0f, this.getWidth(), this.getHeight(), 0.1f, 1000.0f);
		
		// Set color for screen to be cleared to
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		// Print out version data as per assignment instructions
		System.out.println("OpenGL Version: " + gl.glGetString(GL4.GL_VERSION));
        System.out.println("JOGL Version: " + Package.getPackage("com.jogamp.opengl").getImplementationVersion());
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Aspect Ratio: " + this.getWidth() + "x" + this.getHeight());
		
		// Initialize shader programs and uniforms to be used
		this.rendering_program = new ShaderProgram();
		this.rendering_program.addVertexShader("src/a2/resources/shaders/vertex.vert");
		this.rendering_program.addFragmentShader("src/a2/resources/shaders/fragment.frag");
		this.rendering_program.useUniform("transform");
		
		myMesh = new Mesh();
		
		Vertex[] vertices = new Vertex[] { new Vertex( new Point3D(-0.5f, -0.5f, -0.5f)),
									       new Vertex( new Point3D(-0.5f,  0.5f, -0.5f)),
									       new Vertex( new Point3D( 0.5f,  0.5f, -0.5f)),
									       new Vertex( new Point3D( 0.5f, -0.5f, -0.5f)),
									       new Vertex( new Point3D(-0.5f, -0.5f,  0.5f)),
									       new Vertex( new Point3D(-0.5f,  0.5f,  0.5f)),
									       new Vertex( new Point3D( 0.5f,  0.5f,  0.5f)),
									       new Vertex( new Point3D( 0.5f, -0.5f,  0.5f))};
		
		int[] indices = new int[] {
									// Front face
							        0,1,2,
							        0,2,3,
							        // Back face
							        4,6,5,
							        4,7,6,
							        // Left face
							        4,5,1,
							        4,1,0,
							        // Right face
							        3,2,6,
							        3,6,7,
							        // Top face
							        1,5,6,
							        1,6,2,
							        // Bottom face
							        4,0,3,
							        4,3,7,
								   };
 		
		myMesh.setVertices(vertices, indices);
		
		
		mySphere = new Sphere(100);
		transform = new Transform();
		
		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glBindVertexArray(vao[0]);
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {/* TODO */}
	public void dispose(GLAutoDrawable drawable) {/* TODO */}
	public void mouseWheelMoved(MouseWheelEvent arg0) {/* TODO */}
}
