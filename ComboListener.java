import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ComboListener implements ActionListener {
	private MousePaintListener listener;
	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unchecked")
		JComboBox<String> data = (JComboBox<String>)e.getSource();
        String b= (String)data.getSelectedItem();
        switch(b) {
			case "線":
				listener.setMode("line");
				break;
			case "三角":
				listener.setMode("tri");
				break;
			case "ペン":
				listener.setMode("sen");
				break;
			case "虹":
				listener.setMode("rai");
				break;
			case "消しゴム":
				listener.setMode("era");
				break;
        }
	}
	
	public ComboListener(MousePaintListener listener) {
		this.listener = listener;
	}
}
