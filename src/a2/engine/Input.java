package a2.engine;

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
}
