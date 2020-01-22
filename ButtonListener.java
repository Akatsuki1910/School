import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class ButtonListener implements ActionListener {
	
	private Graphics g;
	private MousePaintListener listener;
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem b = (JMenuItem)e.getSource();
		switch(b.getText()){
		case "黒":
			g.setColor(new Color(0,0,0));
			break;
		case "赤":
			g.setColor(new Color(255,0,0));
			break;
		case "緑":
			g.setColor(new Color(0,255,0));
			break;
		case "青":
			g.setColor(new Color(0,0,255));
			break;
		}
		
	}
	
	public ButtonListener(Graphics g, MousePaintListener listener) {
		this.g = g;
		this.listener = listener;
	}
}
