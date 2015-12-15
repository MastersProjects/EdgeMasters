package ch.masters.edgemasters.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import ch.masters.edgemasters.model.Point;

public class GamePanel extends JPanel implements Runnable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Point point= new Point();
	
    private final int DELAY = 15;
    
    int x = 1;


    private Thread animator;
       
    private boolean running = true;

    public GamePanel() {

        initBoard();
    }



    private void initBoard() {
        setDoubleBuffered(true);		
    }
    
    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (running) {
         	
        	update();
        	this.repaint();	
        

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }

            beforeTime = System.currentTimeMillis();
        }   
    }


	private void update() {
		point.update();
		
	}
	
    @Override
    public void paint(Graphics g) {
    	
    	//for no painting error
    	if(x<=4){
    		super.paint(g);
    	}
        
        point.paint(g);
        x = x + 1;
        
        
     
    }

	@Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }
}
