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
	float temp = 0.0f;
	
	public void display(GLAutoDrawable drawable) {
		GL4 gl = drawable.getGL().getGL4();
		
		gl.glClear(GL4.GL_COLOR_BUFFER_BIT);
		
		temp += 0.02f;
		this.rendering_program.setFloatUniform("uniformFloat", (float) Math.abs(Math.sin(temp)));
		
		myMesh.draw();
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
		this.rendering_program.useUniform("uniformFloat");
		this.rendering_program.bind();
		
		myMesh = new Mesh();
		
		Vertex[] data = new Vertex[] { new Vertex( new Point3D(-1.0f, -1.0f, 0.0f)),
				   					   new Vertex( new Point3D( 0.0f,  1.0f, 0.0f)),
									   new Vertex( new Point3D( 1.0f, -1.0f, 0.0f))};
		
		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glBindVertexArray(vao[0]);
		
		myMesh.setVertices(data);
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {/* TODO */}
	public void dispose(GLAutoDrawable drawable) {/* TODO */}
	public void mouseWheelMoved(MouseWheelEvent arg0) {/* TODO */}
}
