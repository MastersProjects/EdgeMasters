package ch.masters.edgemasters.view;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ch.masters.edgemasters.model.Game;


public class GamePanel extends JPanel implements Runnable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Game game;
	
    private final int DELAY = 15;
    
    private int paintDelay = 1;

    private Thread animator;
       
    private boolean running = true;

    public void start(Game game) {
    	setGame(game);
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
		if(game != null){
			game.update();
		}
		
	}
	
    @Override
    public void paint(Graphics g) {
    	
    	//for no painting error
    	if(paintDelay<=4){
    		super.paint(g);
    	}
        
    	game.paint(g);

        paintDelay++;
        
        
     
    }

	@Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }
	

	public void keyPressed(KeyEvent e) {
		System.out.println("Char: " + e.getKeyChar());
		System.out.println("Code: " + e.getKeyCode());
		if(e.getKeyCode() == 87){
			System.out.println("LAUF");
		}
		
	}


	public void keyReleased(KeyEvent e) {
		
		
	}

	public void keyTyped(KeyEvent e) {
		
		
	}




	public Game getGame() {
		return game;
	}





	public void setGame(Game game) {
		this.game = game;
	}






}
