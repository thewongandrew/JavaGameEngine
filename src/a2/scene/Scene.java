package a2.scene;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.jogamp.opengl.util.FPSAnimator;

import a2.engine.Canvas;

@SuppressWarnings("serial")
public class Scene extends JFrame {
	
	private Canvas canvas;
	
	private static final String TITLE = "CSC 155 - Assignment #2: Intergalactic Planetary";
	private static final int WIDTH = 1096;
	private static final int HEIGHT = 1119;
	private static final int FPS_CAP = 240;
	
	public Scene() {
		this.setTitle(TITLE);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		canvas.addGLEventListener(canvas);
		canvas.addMouseWheelListener(canvas);

		getContentPane().add(canvas);
		setVisible(true);
		FPSAnimator animator = new FPSAnimator(canvas, FPS_CAP);
		animator.start();
	}
}
