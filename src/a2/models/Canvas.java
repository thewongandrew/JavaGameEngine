package a2.models;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;

import a2.utils.Mesh;
import a2.utils.ShaderProgram;
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
		gl.glClear(GL4.GL_COLOR_BUFFER_BIT);
		
		temp += 0.1f;
		transform.setScale(0.2f, 0.2f, 0.2f);
		transform.setRotation(temp*30, temp*30, temp*30);
		transform.setTranslation((float)Math.sin(temp), 0.0f, 0.0f);
		
		this.rendering_program.bind();
		this.rendering_program.setMatrixUniform("transform", transform.getTransformation());

//		myMesh.draw();
		mySphere.draw();
	}

	public void init(GLAutoDrawable drawable) {
		GL4 gl = drawable.getGL().getGL4();
		
		// Set color for screen to be cleared to
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		// Print out version data as per assignment instructions
		System.out.println("OpenGL Version: " + gl.glGetString(GL4.GL_VERSION));
        System.out.println("JOGL Version: " + Package.getPackage("com.jogamp.opengl").getImplementationVersion());
        System.out.println("Java Version: " + System.getProperty("java.version"));
		
		// Initialize shader programs and uniforms to be used
		this.rendering_program = new ShaderProgram();
		this.rendering_program.addVertexShader("src/a2/resources/shaders/vertex.vert");
		this.rendering_program.addFragmentShader("src/a2/resources/shaders/fragment.frag");
		this.rendering_program.useUniform("transform");
		
		myMesh = new Mesh();
		mySphere = new Sphere(48);
		
		Vertex[] vertices = new Vertex[] { new Vertex( new Point3D(-1.0f, -1.0f,  1.0f)),
				   					       new Vertex( new Point3D(-1.0f,  1.0f,  1.0f)),
				   					       new Vertex( new Point3D(-1.0f, -1.0f, -1.0f)),
				   					       new Vertex( new Point3D(-1.0f,  1.0f, -1.0f)),
				   					       new Vertex( new Point3D( 0.0f,  0.0f,  1.0f))};
		
		int[] indices = new int[] {4, 0, 1,
								   4, 1, 3,
								   4, 3, 2,
								   4, 2, 1,
								   0, 1, 2,
								   1, 3, 2};
 		
		myMesh.setVertices(vertices, indices);
		
		transform = new Transform();
		transform.setProjection(60.0f, this.getWidth(), this.getHeight(), 0.1f, 1000.0f);
		
		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glBindVertexArray(vao[0]);
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {/* TODO */}
	public void dispose(GLAutoDrawable drawable) {/* TODO */}
	public void mouseWheelMoved(MouseWheelEvent arg0) {/* TODO */}
}
