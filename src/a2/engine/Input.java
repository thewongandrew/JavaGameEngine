//package a2.engine;
//
//import java.awt.Container;
//import java.awt.event.ActionEvent;
//import java.awt.event.KeyEvent;
//import java.lang.reflect.Method;
//
//import javax.swing.AbstractAction;
//import javax.swing.ActionMap;
//import javax.swing.InputMap;
//import javax.swing.JComponent;
//import javax.swing.JPanel;
//import javax.swing.KeyStroke;
//
//public class Input {
//	
//	private JComponent contentPane;
//	private InputMap imap;
//	private ActionMap amap;
//	
//	public Input(JComponent contentPane) {
//		this.setContentPane(contentPane);
//		imap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//		amap = contentPane.getActionMap();
//	};
//	
//	@SuppressWarnings("serial")
//	public void addAction(int keyValue, Method method) {
//		imap.put(KeyStroke.getKeyStroke(keyValue, 0), keyValue);
//		amap.put(keyValue, new AbstractAction() {
//	        @Override
//	        public void actionPerformed(ActionEvent e) {
//	            method.invoke(Camera, args)
//	        }
//	    });
//	}
//
//	public JComponent getContentPane() {
//		return contentPane;
//	}
//
//	public void setContentPane(JComponent contentPane) {
//		this.contentPane = contentPane;
//	}
//	
//	
////	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), KeyEvent.VK_S);
////	amap.put(KeyEvent.VK_S, MoveBackward.getInstance());
////	
////	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), KeyEvent.VK_A);
////	amap.put(KeyEvent.VK_A, MoveLeft.getInstance());
////	
////	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), KeyEvent.VK_D);
////	amap.put(KeyEvent.VK_D, MoveRight.getInstance());
////	
////	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), KeyEvent.VK_E);
////	amap.put(KeyEvent.VK_E, MoveDown.getInstance());
////	
////	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), KeyEvent.VK_Q);
////	amap.put(KeyEvent.VK_Q, MoveUp.getInstance());
////	
////	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), KeyEvent.VK_LEFT);
////	amap.put(KeyEvent.VK_LEFT, PanLeft.getInstance());
////	
////	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), KeyEvent.VK_RIGHT);
////	amap.put(KeyEvent.VK_RIGHT, PanRight.getInstance());
////	
////	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), KeyEvent.VK_UP);
////	amap.put(KeyEvent.VK_UP, PitchUp.getInstance());
////	
////	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), KeyEvent.VK_DOWN);
////	amap.put(KeyEvent.VK_DOWN, PitchDown.getInstance());
////	
////	imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), KeyEvent.VK_SPACE);
////	amap.put(KeyEvent.VK_SPACE, displayAxis);
////	
////	this.requestFocus();
//}
