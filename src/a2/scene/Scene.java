package a2.scene;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.jogamp.opengl.util.FPSAnimator;

import a2.engine.Canvas;
import a2.engine.Input;

@SuppressWarnings("serial")
public class Scene extends JFrame {
	
	private JPanel mainPanel;
	private Canvas canvas;
	private Input input;
	
	private static final String TITLE = "CSC 155 - Assignment #2: Intergalactic Planetary";
	private static final int WIDTH = 1096;
	private static final int HEIGHT = 1119;
	private static final int FPS_CAP = 240;
	
	public Scene() {
		this.setTitle(TITLE);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(layout);
        
		canvas = new Canvas();
		canvas.addGLEventListener(canvas);
		canvas.addMouseWheelListener(canvas);
		
//		input = new Input(this.getContentPane().get);
		
		mainPanel.add(canvas);
		this.add(canvas);
		setVisible(true);
		FPSAnimator animator = new FPSAnimator(canvas, FPS_CAP);
		animator.start();
	}
}
