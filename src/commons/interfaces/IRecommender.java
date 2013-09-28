package commons.interfaces;

import java.util.List;

import commons.NotImplementedException;
import commons.SQATException;
import commons.dataClasses.Destination;
import commons.dataClasses.Recommendation;

public interface IRecommender {
	IConnector getConnector();
	void setConnector(IConnector connector);
	List<Recommendation> getRecommendations() throws Exception;
	List<Destination> getDestinationsForArtists(String artist);
	List<Destination> buildItineraryForArtists(List<String> artists) throws SQATException;
}