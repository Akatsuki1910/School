import java.awt.event.*;
import javax.swing.JMenuItem;

public class StampListener implements ActionListener {

	private MousePaintListener listener;
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem b = (JMenuItem)e.getSource();
		switch(b.getText()){
		case "丸":
			listener.setStamp("maru");
			break;
		case "四角":
            listener.setStamp("shikaku");
			break;
		case "☆":
            listener.setStamp("hoshi");
			break;
		}
	}

	public StampListener(MousePaintListener listener) {
		this.listener = listener;
	}
}
