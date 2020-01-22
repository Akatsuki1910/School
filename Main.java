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
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu menu1 = new JMenu("色");
		menubar.add(menu1);
        JMenuItem menuitem1 = new JMenuItem("黒");
        JMenuItem menuitem2 = new JMenuItem("赤");
        JMenuItem menuitem3 = new JMenuItem("緑");
        JMenuItem menuitem4 = new JMenuItem("青");
        menu1.add(menuitem1);
        menu1.add(menuitem2);
        menu1.add(menuitem3);
        menu1.add(menuitem4);
		
		JMenu menu2 = new JMenu("太さ");
		menubar.add(menu2);
		JMenuItem pensize1 = new JMenuItem("大");
		JMenuItem pensize2 = new JMenuItem("中");
		JMenuItem pensize3 = new JMenuItem("小");
		menu2.add(pensize1);
		menu2.add(pensize2);
		menu2.add(pensize3);
		
		String[] combo_text = {"ペン","線","三角"};
		JComboBox combo = new JComboBox(combo_text);
		combo.setVisible(true);
		menubar.add(combo);
		
		MousePaintListener listener = new MousePaintListener(g);
		menuitem1.addActionListener(new ButtonListener(g,listener));
        menuitem2.addActionListener(new ButtonListener(g,listener));
        menuitem3.addActionListener(new ButtonListener(g,listener));
        menuitem4.addActionListener(new ButtonListener(g,listener));
        pensize1.addActionListener(new PenListener(listener));
		pensize2.addActionListener(new PenListener(listener));
		pensize3.addActionListener(new PenListener(listener));
		combo.addActionListener(new ComboListener(listener));
		
		frame.addMouseListener(listener);
		frame.addMouseMotionListener(listener);

		frame.setVisible(true);
	}
}