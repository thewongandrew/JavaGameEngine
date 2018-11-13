package a2.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import a2.engine.math.Vector3D;
import a2.engine.singletons.BasicShader;
import a2.engine.singletons.PhongShader;
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

	// One vertex array index for a single object
	private int vao[] = new int[1];

    private ShaderProgram basicShader;
    private ShaderProgram phongShader;
	private Transform transform;
	private Material material;
    private Sphere mySphere;
    private Camera camera;
    private String handsomeSquidward = "src/a2/resources/textures/HandsomeSquidward.png";

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

        transform.setTranslation(0,0,-10);
		transform.setRotation(0, temp*75, 0);
		
		phongShader.updateUniforms(transform.getTransformation(),
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
        System.out.println("Aspect Ratio: " + getWidth() + "x" + getHeight());

        /* Initialize the shader programs to be used */
//		basicShader = BasicShader.getInstance();
        phongShader = PhongShader.getInstance();

        /* Initialize the projection values */
		camera = new Camera();
		Transform.setCamera(camera);
		Transform.setProjection(60.0f, getWidth(), getHeight(), 0.1f, 1000.0f);
		
		material = new Material(Util.loadTexture(handsomeSquidward), new Vector3D(0, 1, 1));

		mySphere = new Sphere(100);
		transform = new Transform();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {/* TODO */}

	@Override
	public void dispose(GLAutoDrawable drawable) {/* TODO */}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {/* TODO */}

	@Override
	public void actionPerformed(ActionEvent e) {/* TODO */}
}
