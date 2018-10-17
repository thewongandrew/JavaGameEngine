package a2.controllers;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.jogamp.opengl.util.FPSAnimator;

import a2.models.Canvas;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	private Canvas canvas;
	
	private static final String TITLE = "CSC 155 - Assignment #2: Intergalactic Planetary";
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;
	private static final int FPS_CAP = 240;
	
	public Window() {
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
