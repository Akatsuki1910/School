import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class PenListener implements ActionListener {
	private MousePaintListener listener;
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem b = (JMenuItem)e.getSource();
		if(b.getText().equals("大")) {
        	listener.setSize("dai");
		}else if(b.getText().equals("中")) {
			listener.setSize("tyuu");
		}else if(b.getText().equals("小")) {
			listener.setSize("syou");
		}
	}
	
	public PenListener(MousePaintListener listener) {
		this.listener = listener;
	}
}
