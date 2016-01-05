package ch.masters.edgemasters.main;

import ch.masters.edgemasters.model.Game;
import ch.masters.edgemasters.model.Player;
import ch.masters.edgemasters.view.MenuView;
import ch.masters.edgemasters.view.PlayView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		Player player = new Player();
		game.getPlayers().add(player);
		new PlayView(game);
//		new MenuView();
	}

}
