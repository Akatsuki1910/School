import java.awt.*;
import javax.swing.*;
public class Main {
public static void main(String[] args ){
		JFrame frame = new JFrame ("Hello from GUI!!!!");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setResizable(false);
		Graphics g = frame.getGraphics();
		MousePaintListener listener = new MousePaintListener(g);
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu menu1 = new JMenu("色");
		menubar.add(menu1);
		String[] color = {"黒","赤","緑","青"};
		JMenuItem[] colorEvent = new JMenuItem[color.length];
		for(int i=0;i<color.length;i++) {
			colorEvent[i] = new JMenuItem(color[i]);
			menu1.add(colorEvent[i]);
			colorEvent[i].addActionListener(new ButtonListener(g,listener));
		}
		
		JMenu menu2 = new JMenu("太さ");
		menubar.add(menu2);
		String[] size = {"大","中","小"};
		JMenuItem[] sizeEvent = new JMenuItem[size.length];
		for(int i=0;i<size.length;i++) {
			sizeEvent[i] = new JMenuItem(size[i]);
			menu2.add(sizeEvent[i]);
			sizeEvent[i].addActionListener(new PenListener(listener));
		}
		
		String[] combo_text = {"ペン","線","三角","虹"};
		JComboBox combo = new JComboBox(combo_text);
		combo.setVisible(true);
		menubar.add(combo);
		combo.addActionListener(new ComboListener(listener));
		
		frame.addMouseListener(listener);
		frame.addMouseMotionListener(listener);

		frame.setVisible(true);
	}
}