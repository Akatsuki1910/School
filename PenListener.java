import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class PenListener implements ActionListener {
	private MousePaintListener listener;
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem b = (JMenuItem)e.getSource();
		switch(b.getText()) {
		case "大":
			listener.setSize("dai");
			break;
		case "中":
			listener.setSize("tyuu");
			break;
		case "小":
			listener.setSize("syou");
			break;
		}
	}
	
	public PenListener(MousePaintListener listener) {
		this.listener = listener;
	}
}
