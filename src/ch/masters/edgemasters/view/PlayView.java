package ch.masters.edgemasters.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ch.masters.edgemasters.model.Game;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PlayView implements KeyListener{

	private JPanel gamePanel;
	private JPanel gameStatPanel;
	
	private JFrame playViewFrame;
	private JTable rankingTable;
	
	private JScrollPane scrollPane;
	
	private Game game;
		
	
	public PlayView(Game game) {
		
		this.setGame(game);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		playViewFrame = new JFrame();
		playViewFrame.setTitle("Play - Edgefever");
		playViewFrame.setBounds(100, 100, 895, 560);
		playViewFrame.getContentPane().setLayout(null);
		
		playViewFrame.addKeyListener(this);
		playViewFrame.setFocusable(true);
		playViewFrame.setFocusTraversalKeysEnabled(false);
		
		gamePanel = new GamePanel();
		gamePanel.setBounds(377, 20, 480, 480);
		playViewFrame.getContentPane().add(gamePanel);
		
		gameStatPanel = new JPanel();
		gameStatPanel.setBounds(21, 20, 268, 480);
		playViewFrame.getContentPane().add(gameStatPanel);
		gameStatPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 248, 458);
		gameStatPanel.add(scrollPane);
		
		rankingTable = new JTable();
		scrollPane.setViewportView(rankingTable);		
		
		playViewFrame.setVisible(true);
		
		((GamePanel) gamePanel).start(game);
	
	}
	


	@Override
	public void keyPressed(KeyEvent e) {
		((GamePanel) gamePanel).keyPressed(e);
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		((GamePanel) gamePanel).keyReleased(e);
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		((GamePanel) gamePanel).keyTyped(e);
		
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}

}
