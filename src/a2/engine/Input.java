package a2.engine;

import java.awt.Container;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class Input {
	
	private JComponent contentPane;
	private static InputMap imap;
	private static ActionMap amap;
	
	public Input(JComponent contentPane) {
		this.contentPane = contentPane;
		imap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		amap = contentPane.getActionMap();
	};
	
	public static void addAction(int keyValue, AbstractAction action) {
		imap.put(KeyStroke.getKeyStroke(keyValue, 0), keyValue);
		amap.put(keyValue, action);
	}

	public JComponent getContentPane() {
		return contentPane;
	}

	public void setContentPane(JComponent contentPane) {
		this.contentPane = contentPane;
	}
	
	
//	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), KeyEvent.VK_S);
//	amap.put(KeyEvent.VK_S, MoveBackward.getInstance());
//	
//	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), KeyEvent.VK_A);
//	amap.put(KeyEvent.VK_A, MoveLeft.getInstance());
//	
//	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), KeyEvent.VK_D);
//	amap.put(KeyEvent.VK_D, MoveRight.getInstance());
//	
//	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), KeyEvent.VK_E);
//	amap.put(KeyEvent.VK_E, MoveDown.getInstance());
//	
//	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), KeyEvent.VK_Q);
//	amap.put(KeyEvent.VK_Q, MoveUp.getInstance());
//	
//	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), KeyEvent.VK_LEFT);
//	amap.put(KeyEvent.VK_LEFT, PanLeft.getInstance());
//	
//	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), KeyEvent.VK_RIGHT);
//	amap.put(KeyEvent.VK_RIGHT, PanRight.getInstance());
//	
//	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), KeyEvent.VK_UP);
//	amap.put(KeyEvent.VK_UP, PitchUp.getInstance());
//	
//	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), KeyEvent.VK_DOWN);
//	amap.put(KeyEvent.VK_DOWN, PitchDown.getInstance());
//	
//	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), KeyEvent.VK_SPACE);
//	amap.put(KeyEvent.VK_SPACE, displayAxis);
//	
//	this.requestFocus();
}
