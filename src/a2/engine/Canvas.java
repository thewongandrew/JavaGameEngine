package a2.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;

import a2.engine.sceneObjects.Sphere;
import a2.engine.utils.RenderUtils;
import a2.engine.utils.Util;

import javax.swing.*;

/* GLCanvas object that handles the render logic */
@SuppressWarnings("serial")
public class Canvas extends GLCanvas implements GLEventListener, MouseWheelListener, ActionListener {

	private BasicShader rendering_program;
	private Camera camera;
	
	// One vertex array index for a single object
	private int vao[] = new int[1];
	
	private Sphere mySphere;
	private Transform transform;
	private Material material;

	private Timer timer;
	
	private float temp = 0.0f;
	
	public void display(GLAutoDrawable drawable) {
		GL4 gl = drawable.getGL().getGL4();

		timer = new Timer(0, this);
		timer.setInitialDelay( 0 );
		
		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glBindVertexArray(vao[0]);
		
		RenderUtils.clearScreen();
		
		temp += 0.02f;
//		transform.setTranslation((float)(Math.sin(temp) * 2.0f * Math.sinh(1.0f)), 
//								 (float)(Math.cos(temp+10f) * 2.0f * Math.cosh(1.0f)), 
//								 -10.0f);
		transform.setTranslation(0,0,-10);
		transform.setRotation(0, temp*75, 0);
		
		this.rendering_program.updateUniforms(transform.getTransformation(),
											  transform.getProjectedTransformation(),
											  material);

		mySphere.draw();
	}

	public void init(GLAutoDrawable drawable) {
		GL4 gl = drawable.getGL().getGL4();
		RenderUtils.initGLSettings();
					
		// Print out version data as per assignment instructions
		System.out.println("OpenGL Version: " + gl.glGetString(GL4.GL_VERSION));
        System.out.println("JOGL Version: " + Package.getPackage("com.jogamp.opengl").getImplementationVersion());
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Aspect Ratio: " + this.getWidth() + "x" + this.getHeight());
		
		// Initialize shader programs and uniforms to be used
		this.rendering_program = new BasicShader();

		
		// Initialize the projection values
		camera = new Camera();
		Transform.setCamera(camera);
		Transform.setProjection(60.0f, this.getWidth(), this.getHeight(), 0.1f, 1000.0f);
		
		material = new Material(Util.loadTexture("src/a2/resources/textures/HandsomeSquidward.png"));

		mySphere = new Sphere(100);
		transform = new Transform();
		
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {/* TODO */}
	public void dispose(GLAutoDrawable drawable) {/* TODO */}
	public void mouseWheelMoved(MouseWheelEvent arg0) {/* TODO */}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
