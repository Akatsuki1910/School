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
		frame.getContentPane().setBackground( Color.RED );

		JPanel panel = new JPanel();
		panel.setSize(500,500);
		panel.setBackground(Color.WHITE);
		frame.add(panel);
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);

		JMenu menu1 = new JMenu("色");
		menubar.add(menu1);
		String[] color = {"黒","赤","緑","青","他の色"};
		JMenuItem[] colorEvent = new JMenuItem[color.length];
		for(int i=0;i<color.length;i++) {
			colorEvent[i] = new JMenuItem(color[i]);
			menu1.add(colorEvent[i]);
		}
		
		JMenu menu2 = new JMenu("太さ");
		menubar.add(menu2);
		String[] size = {"大","中","小"};
		JMenuItem[] sizeEvent = new JMenuItem[size.length];
		for(int i=0;i<size.length;i++) {
			sizeEvent[i] = new JMenuItem(size[i]);
			menu2.add(sizeEvent[i]);
		}

		JMenu menu3 = new JMenu("スタンプ");
		menubar.add(menu3);
		String[] stamp = {"丸","四角","☆","初期化"};
		JMenuItem[] stampEvent = new JMenuItem[stamp.length];
		for(int i=0;i<stamp.length;i++) {
			stampEvent[i] = new JMenuItem(stamp[i]);
			menu3.add(stampEvent[i]);
		}
		
		JTextField text = new JTextField(10);
		JTextField textX = new JTextField(2);
		JTextField textY = new JTextField(2);
		JButton textbutton = new JButton("Get");
		menubar.add(text);
		menubar.add(textX);
		menubar.add(textY);
		menubar.add(textbutton);
		
		String[] combo_text = {"ペン","線","三角","虹","消しゴム"};
		JComboBox<String> combo = new JComboBox<String>(combo_text);
		combo.setVisible(true);
		menubar.add(combo);
		
		frame.setVisible(true);

		Graphics g = panel.getGraphics();
		MousePaintListener listener = new MousePaintListener(g);
		
		
		for(int i=0;i<color.length;i++) {
			colorEvent[i].addActionListener(new ButtonListener(panel,g,listener));
		}
		for(int i=0;i<size.length;i++) {
			sizeEvent[i].addActionListener(new PenListener(listener));
		}
		for(int i=0;i<stamp.length;i++) {
			stampEvent[i].addActionListener(new StampListener(listener));
		}
		textbutton.addActionListener(new TextListener(text,g,textX,textY));
		combo.addActionListener(new ComboListener(listener));
		
		panel.addMouseListener(listener);
		panel.addMouseMotionListener(listener);
		
	}
}