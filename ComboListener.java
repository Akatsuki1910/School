import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ComboListener implements ActionListener {
	private MousePaintListener listener;
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox data = (JComboBox)e.getSource();
        String b= (String)data.getSelectedItem();
        if(b.equals("線")) {
			listener.setMode("line");
        }else if(b.equals("三角")) {
        	listener.setMode("tri");
        }else if(b.equals("ペン")) {
        	listener.setMode("sen");
		}
	}
	
	public ComboListener(MousePaintListener listener) {
		this.listener = listener;
	}
}
