package a2.controllers;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jogamp.opengl.util.FPSAnimator;

import a2.models.Canvas;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	private Canvas canvas;
	
	private static final String TITLE = "CSC 155 - Assignment #1: Triangle Choke";
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 576;
	private static final int FPS_CAP = 60;
	
	public Window() {
		this.setTitle(TITLE);
		this.setSize(WIDTH, HEIGHT);
		
		canvas = new Canvas();
		canvas.addGLEventListener(canvas);
		canvas.addMouseWheelListener(canvas);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.BLACK);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		getContentPane().add(canvas);
		setVisible(true);
		FPSAnimator animator = new FPSAnimator(canvas, FPS_CAP);
		animator.start();
	}
}
