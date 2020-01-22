import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

import javax.swing.event.*;

public class MousePaintListener implements MouseInputListener {

	private Graphics g;
	private int flg = 0;
	private int[][] point = new int[3][3];
	private int pensize = 2;
	private Color memColor = new Color(0,0,0);
	private boolean rainbow = false;
	
	public MousePaintListener(Graphics g) {
		this.g = g;
		Graphics2D g2 = (Graphics2D)g;
        BasicStroke bs = new BasicStroke(pensize);
        g2.setStroke(bs);
	}
	
	public void memColor(Color c) {
		this.memColor = c;
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
		rainbow=false;
		g.setColor(memColor);
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
			case "rai":
				flg = 0;
				rainbow = true;
				break;
			case "era":
				flg = 0;
				g.setColor(new Color(255,255,255));
				break;
        }
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		switch(flg){
			case 0:
				g.fillOval(e.getX (), e.getY (), pensize, pensize);
				if(rainbow) {
					Random r = new Random();
					g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
				}
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
			if(rainbow) {
				Random r = new Random();
				g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
