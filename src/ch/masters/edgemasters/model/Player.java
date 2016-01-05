package ch.masters.edgemasters.model;


import java.awt.Graphics;

import ch.masters.edgemasters.gameobject.PlayerPoint;

public class Player {
	
	private String name;
	private String color;
	private int points;
	
	private PlayerPoint playerPoints;
	
	public Player(){
		playerPoints = new PlayerPoint();
	}
	
	public void paint(Graphics g){
		
	}
	
	public void update(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public PlayerPoint getPlayerPoints() {
		return playerPoints;
	}

	public void setPlayerPoints(PlayerPoint playerPoints) {
		this.playerPoints = playerPoints;
	}
	
	
	
}
