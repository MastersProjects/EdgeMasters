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
		
	}
	
	public void update(){
		
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
