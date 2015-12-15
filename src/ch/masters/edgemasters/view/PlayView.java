package ch.masters.edgemasters.view;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PlayView {

	private JPanel gamePanel;
	private JPanel gameStatPanel;
	
	private JFrame menuViewFrame;
	private JTable rankingTable;
	
	private JScrollPane scrollPane;
		
	
	public PlayView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		menuViewFrame = new JFrame();
		menuViewFrame.setTitle("Play - Edgefever");
		menuViewFrame.setBounds(100, 100, 895, 560);
		menuViewFrame.getContentPane().setLayout(null);
		
		gamePanel = new GamePanel();
		gamePanel.setBounds(377, 20, 480, 480);
		menuViewFrame.getContentPane().add(gamePanel);
		
		gameStatPanel = new JPanel();
		gameStatPanel.setBounds(21, 20, 268, 480);
		menuViewFrame.getContentPane().add(gameStatPanel);
		gameStatPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 248, 458);
		gameStatPanel.add(scrollPane);
		
		rankingTable = new JTable();
		scrollPane.setViewportView(rankingTable);
		
		
		
		menuViewFrame.setVisible(true);
	}
}
