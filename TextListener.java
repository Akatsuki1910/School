import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TextListener implements ActionListener {
	
	JTextField text;
	Graphics g;
	JTextField textX;
	JTextField textY; 
	public TextListener(JTextField text, Graphics g, JTextField textX, JTextField textY) {
		this.text = text;
		this.g = g;
		this.textX = textX;
		this.textY = textY;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String t = text.getText();
		int tx = Integer.valueOf(textX.getText());
		int ty = Integer.valueOf(textY.getText());
		g.drawString(t, tx, ty);

	}

}
