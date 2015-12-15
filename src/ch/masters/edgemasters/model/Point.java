package ch.masters.edgemasters.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Point {
	
	int x = 0;
	int y = 0;
	
	
	
	public void paint(Graphics g) {               
        Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(x, y, 10, 10);
    }



	public void update() {
		x = x + 1;
		y = y + 1;
		
	}
}
