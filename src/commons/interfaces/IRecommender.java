package commons.interfaces;

import java.util.List;

import commons.dataClasses.Destination;
import commons.dataClasses.Recomendation;
import commons.dataClasses.Recommendation;

public interface IRecommender {
	IConnector getConnector();
	void setConnector(IConnector connector);
	List<Recommendation> getRecommendations();
	List<Destination> getDestinationsForArtists(String artist);
	List<Destination> buildItineraryForArtists(List<String> artists);
}
