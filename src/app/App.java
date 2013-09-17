package app;

import player.PlayerUI;
import recommender.RecommenderUI;
import gps.GpsUI;

public class App {

	
	public static void main(String[] args) {
		
    PlayerUI playObject = new PlayerUI();	
	PlayerUI.createAndShowGUI();
	
		
	RecommenderUI RecObject = new RecommenderUI();
	RecObject.createAndShowGUI();
	
		
	GpsUI gpsObject = new GpsUI();
	GpsUI.createAndShowGUI();

	}

}
