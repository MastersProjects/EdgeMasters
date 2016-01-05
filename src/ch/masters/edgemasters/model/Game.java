package ch.masters.edgemasters.model;

import java.awt.Graphics;
import java.util.ArrayList;

public class Game {
	
	private int round;
	private ArrayList<Player> players;
	
	public Game(){
		setPlayers(new ArrayList<>());
	}
	
	public void paint(Graphics g){
		for(Player player : players){
			player.paint(g);
		}
	}
	
	public void update(){
		for(Player player : players){
			player.update();
		}
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	
}
