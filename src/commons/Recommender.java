package commons;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import commons.dataClasses.ConcertInfo;
import commons.dataClasses.Destination;
import commons.dataClasses.GeoPoint;
import commons.dataClasses.Recommendation;
import commons.interfaces.IConnector;
import commons.interfaces.IGps;
import commons.interfaces.IPlayer;
import commons.interfaces.IRecommender;
import dataConnectors.LastFmConnectionException;




public class Recommender implements IRecommender {
	public Recommender(IConnector connector) {
	
		this.connector = connector;
	}
	
	public Recommender(){
		this.connector = null;
	}

	private IConnector connector;
	@Override
	public IConnector getConnector() {

		return this.connector;
	}

	@Override
	public void setConnector(IConnector connector) {
		this.connector = connector;

	}

	@Override
	public List<Recommendation> getRecommendations() throws SQATException {
		ArrayList<Recommendation> recs = new ArrayList<Recommendation>();
		if(DeviceManager.getInstance().getPlayer() == null || DeviceManager.getInstance().getPlayer().getCurrentArtist()==""){
			throw new IllegalStateException("Cannot read information from Player");
		}
		
		try {
			String artist =DeviceManager.getInstance().getPlayer().getCurrentArtist();
			List<String> topFans = getConnector().getTopFansForArtist(artist);
			if(topFans.size()==0) return new ArrayList<Recommendation>();
			
			List<String> allArtists = new ArrayList<String>();
			for (String fan : topFans) {
				allArtists.addAll(getConnector().getTopArtistsByFan(fan));
			}
			HashMap<String, Integer> artistFan = new HashMap<String, Integer>();
			for (String entry : allArtists) {
				if(artistFan.containsKey(entry)){
					artistFan.put(entry, artistFan.get(entry)+1);
				}else{
					artistFan.put(entry, 1);
				}
			}
			Iterator recsIterator = artistFan.entrySet().iterator();
			while (recsIterator.hasNext()) {
				Map.Entry mapEntry = (Map.Entry)recsIterator.next();
				Recommendation rec = new Recommendation(mapEntry.getKey().toString(), Integer.parseInt(mapEntry.getValue().toString()));
				recs.add(rec);
			}
		} catch (LastFmConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collections.sort(recs, new Comparator<Recommendation>() {
			public int compare(Recommendation a, Recommendation b){
				return a.getFanCount()-b.getFanCount();
			}
		});
		
		 List<Recommendation> top20 = recs.subList(recs.size()-20, recs.size());
		Collections.reverse(top20);
		return top20;
		
	}

	@Override
	public List<Destination> getDestinationsForArtists(String artist) {
//		try {
//			throw new SQATException("You need to implement this!");
//		} catch (SQATException e) {
//			e.printStackTrace();
//		}
//		return null;
		if(artist==null) throw new IllegalArgumentException("Invalid artist name");
		if(DeviceManager.getInstance().getGps() == null) throw new IllegalStateException("Cannot access GPS device");
		GeoPoint currentPosition = DeviceManager.getInstance().getGps().getCurrentPosition();
		String units = DeviceManager.getInstance().getGps().getDistanceUnits();
		if(currentPosition == null || units == "") throw new IllegalStateException("Cannot read information from GPS device");
		List<Destination> destinationsForArtist = new ArrayList<Destination>();
		List<ConcertInfo> concerts = null;
		try {
			concerts = connector.getConcertsForArtist(artist);
		} catch (LastFmConnectionException e) {
			return new ArrayList<Destination>();
		}
		for (ConcertInfo info : concerts) {
			Destination d = new Destination(info);
			d.setDistance(Distance.computeDistance(currentPosition, info.getPosition(), units));
			d.setDistanceUnits(units);
			destinationsForArtist.add(d);
		}
		return destinationsForArtist;
	}

	@Override
	public List<Destination> buildItineraryForArtists(List<String> artists) throws SQATException  {
		throw new SQATException("You have to implement this");
	}
	
	public  IPlayer getPlayer(){
		return DeviceManager.getInstance().getPlayer();
	}
	
	public  IGps getGps(){
		return DeviceManager.getInstance().getGps();
	}

}
