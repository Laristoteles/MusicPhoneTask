package commons;

import java.util.List;

import commons.dataClasses.Destination;
import commons.dataClasses.Recommendation;
import commons.interfaces.IConnector;
import commons.interfaces.IRecommender;

public class Recommender implements IRecommender {

	@Override
	public IConnector getConnector() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnector(IConnector connector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Recommendation> getRecommendations() {
		// TODO Auto-generated method stub
		return null;
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
