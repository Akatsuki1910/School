import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.event.*;

public class MousePaintListener implements MouseInputListener {

	private Graphics g;
	private int flg = 0;
	private int[][] point = new int[3][3];
	private int pensize = 2;
	
	public MousePaintListener(Graphics g) {
		this.g = g;
		Graphics2D g2 = (Graphics2D)g;
        BasicStroke bs = new BasicStroke(pensize);
        g2.setStroke(bs);
	}
	
	public void setColor() {
		flg = 0;
	}
	
	public void setSize(String s) {
		switch(s) {
		case "dai":
			pensize = 6;
			break;
		case "tyuu":
			pensize = 4;
			break;
		case "syou":
			pensize = 2;
			break;
		}
		Graphics2D g2 = (Graphics2D)g;
        BasicStroke bs = new BasicStroke(pensize);
        g2.setStroke(bs);
	}
	
	public void setMode(String s) {
		for(int i=0;i<point.length;i++){
			Arrays.fill(point[i], 0);
		}
		switch(s) {
			case "sen":
				flg = 0;
				break;
			case "line":
				flg = 1;
				break;
			case "tri":
				flg = 2;
				break;
        }
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		switch(flg){
			case 0:
				System.out.println(pensize);
				g.fillOval(e.getX (), e.getY (), pensize, pensize);
			case 1:
				for(int i=0;i<point.length;i++){
					if(point[i][0] == 0){
						point[i][0] = 1;
						point[i][1] = e.getX();
						point[i][2] = e.getY();
						break;
					}
				}
				if(point[1][0]==1){
					g.drawLine(point[0][1], point[0][2], point[1][1], point[1][2]);
					for(int i=0;i<point.length;i++){
						Arrays.fill(point[i], 0);
					}
				}
				break;
			case 2:
				for(int i=0;i<point.length;i++){
					if(point[i][0] == 0){
						point[i][0] = 1;
						point[i][1] = e.getX();
						point[i][2] = e.getY();
						break;
					}
				}
				if(point[2][0]==1){
					int[] xPoint = {point[0][1],point[1][1],point[2][1]};
					int[] yPoint = {point[0][2],point[1][2],point[2][2]};
					g.drawPolygon(xPoint,yPoint,3);
					for(int i=0;i<point.length;i++){
						Arrays.fill(point[i], 0);
					}
				}
				break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(flg==0){
			point[0][1] = e.getX();
			point[0][2] = e.getY();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(flg==0){
			point[1][1] = e.getX();
			point[1][2] = e.getY();
			g.drawLine(point[0][1], point[0][2], point[1][1], point[1][2]);
			point[0][1] = point[1][1];
			point[0][2] = point[1][2];
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
