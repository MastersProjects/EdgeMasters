package ch.masters.edgemasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ch.masters.edgemasters.model.Game;
import ch.masters.edgemasters.model.Player;

public class MenuViewActionlistener implements ActionListener {

	private String buttonname;
	private JTextField name;
	private Game game;
	private JButton goButton;
	
	public MenuViewActionlistener(String buttonname, JTextField name, Game game, JButton goButton){
		this.buttonname = buttonname;
		this.name = name; 
		this.game = game;
		this.goButton = goButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.buttonname.equals("Add")){
			if (!name.getText().isEmpty()) {
				System.out.println(name.getText());
				
				Player player = new Player();
				player.setName(name.getText());
				this.game.getPlayers().add(player);
				
				//Wenn min. 2 Spieler dann kann man Create Game
				if (this.game.getPlayers().size() > 1) {
					this.goButton.setEnabled(true);
				}
				this.name.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Bitte alles ausfuellen.","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
