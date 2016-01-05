package ch.masters.edgemasters.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PlayerPoint {
	
	private int x = 1;
	private int y = 1;
	
	public void paint(Graphics g){
		 Graphics2D g2d = (Graphics2D) g;
		 Color blue = new Color(0, 0, 205);
		 g2d.setColor(blue);
	     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	     g2d.fillOval(x, y, 10, 10);
	}
	
	public void update(){
		x++;
		y++;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
