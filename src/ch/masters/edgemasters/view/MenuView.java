package ch.masters.edgemasters.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import ch.masters.edgemasters.actionlistener.MenuViewActionlistener;
import ch.masters.edgemasters.model.Game;

public class MenuView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame menuViewFrame;
	
	//Label
	private JLabel playersTableLabel;
	
	//TextField
	private JTextField addPlayerTextField;
	
	//Button
	private JButton addPlayerButton;
	private JButton goButton;
	
	//Table
	private JTable playersTable;
	
	private Game game;
	
	public MenuView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game = new Game(); 
		menuViewFrame = new JFrame();
		menuViewFrame.setTitle("Menu - Edgefever");
		menuViewFrame.setBounds(100, 100, 895, 560);
		menuViewFrame.getContentPane().setLayout(null);
		
		playersTableLabel = new JLabel("Players:");
		playersTableLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		playersTableLabel.setBounds(206, 156, 110, 22);
		menuViewFrame.getContentPane().add(playersTableLabel);
			
		goButton = new JButton("GO!");
		
		addPlayerTextField = new JTextField();
  		addPlayerTextField.setText("new Player");
 		addPlayerTextField.setBounds(278, 89, 186, 20);
  		menuViewFrame.getContentPane().add(addPlayerTextField);
  		addPlayerTextField.setColumns(10);
  		
		addPlayerButton = new JButton("Add");
		addPlayerButton.addActionListener(new MenuViewActionlistener("Add", this.addPlayerTextField, this.game, this.goButton));
		addPlayerButton.setFont(new Font("Tahoma", Font.BOLD, 12));		
		addPlayerButton.setBounds(489, 87, 89, 23);
		menuViewFrame.getContentPane().add(addPlayerButton);
		
		goButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		goButton.setBounds(382, 441, 120, 41);
		goButton.setEnabled(false);
		menuViewFrame.getContentPane().add(goButton);
		
		playersTable = new JTable();
		playersTable.setBounds(206, 187, 463, 210);
		menuViewFrame.getContentPane().add(playersTable);
		
		menuViewFrame.setVisible(true);
	}
}
