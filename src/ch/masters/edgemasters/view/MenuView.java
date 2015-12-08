package ch.masters.edgemasters.view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;

public class MenuView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame menuViewFrame;
	
	//Label
	private JLabel playersTableLabel;
	private JLabel mapLabel;
	
	//TextField
	private JTextField addPlayerTextField;
	
	//Button
	private JButton addPlayerButton;
	private JButton map1Button;
	private JButton map2Button;
	private JButton goButton;
	
	//Table
	private JTable playersTable;
	
	
	public MenuView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		menuViewFrame = new JFrame();
		menuViewFrame.setTitle("Menu - Edgefever");
		menuViewFrame.setBounds(100, 100, 895, 560);
		menuViewFrame.getContentPane().setLayout(null);
		
		playersTableLabel = new JLabel("Players:");
		playersTableLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		playersTableLabel.setBounds(73, 154, 110, 22);
		menuViewFrame.getContentPane().add(playersTableLabel);
		
		mapLabel = new JLabel("Map:");
		mapLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		mapLabel.setBounds(658, 156, 110, 22);
		menuViewFrame.getContentPane().add(mapLabel);
		
		addPlayerTextField = new JTextField();
		addPlayerTextField.setText("new Player");
		addPlayerTextField.setBounds(71, 57, 186, 20);
		menuViewFrame.getContentPane().add(addPlayerTextField);
		addPlayerTextField.setColumns(10);
		
		addPlayerButton = new JButton("Add");
		addPlayerButton.setFont(new Font("Tahoma", Font.BOLD, 12));		
		addPlayerButton.setBounds(305, 56, 89, 23);
		menuViewFrame.getContentPane().add(addPlayerButton);
		
		map1Button = new JButton("Map 1");
		map1Button.setBounds(575, 262, 79, 75);
		menuViewFrame.getContentPane().add(map1Button);
		
		map2Button = new JButton("Map 2");
		map2Button.setBounds(706, 262, 79, 75);
		menuViewFrame.getContentPane().add(map2Button);
		
		goButton = new JButton("GO!");
		goButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		goButton.setBounds(393, 441, 120, 41);
		menuViewFrame.getContentPane().add(goButton);
		
		playersTable = new JTable();
		playersTable.setBounds(34, 187, 463, 210);
		menuViewFrame.getContentPane().add(playersTable);
		
		menuViewFrame.setVisible(true);
	}
}
