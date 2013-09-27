package commons;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import commons.dataClasses.Destination;
import commons.dataClasses.Recommendation;
import commons.interfaces.IConnector;
import commons.interfaces.IRecommender;
import commons.utils.ValueComparator;

public class Recommender implements IRecommender {
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
	public List<Recommendation> getRecommendations() throws Exception {
		ArrayList<Recommendation> rec = new ArrayList<>();
		String currentArtist = "cher"; //DeviceManager.getInstance().getPlayer().getCurrentArtist();
		HashMap<String, Integer> artists = new HashMap<String, Integer>();
		try {
			List<String> topFans = this.connector.getTopFansForArtist(currentArtist);
			for (String fan : topFans) {
				List<String> artist = this.connector.getTopArtistsByFan(fan);
				for (String art : artist) {
					if(artists.containsKey(art)) artists.put(art, artists.get(art) + 1);
					else artists.put(art, 1);
				}
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		//ValueComparator bvc = new ValueComparator(artists);
		//TreeMap<String, Integer> sortedDict = new TreeMap<String, Integer>(bvc);
	
		for (Entry<String, Integer> entry : artists.entrySet()) {
			
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
//		for (int i = 0; i < 20; i++) {
//	
//			rec.add(new Recommendation(artists.firstEntry().getKey(), sortedDict.firstEntry().getValue()));
//			sortedDict.remove(sortedDict.firstEntry().getKey());
//		}
		return rec;
	}

	@Override
	public List<Destination> getDestinationsForArtists(String artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Destination> buildItineraryForArtists(List<String> artists) {
		// TODO Auto-generated method stub
		return null;
	}

}
