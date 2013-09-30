package commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import commons.dataClasses.ConcertInfo;
import commons.dataClasses.Destination;
import commons.dataClasses.GeoPoint;
import commons.dataClasses.Recommendation;
import commons.interfaces.IConnector;
import commons.interfaces.IRecommender;

import commons.utils.CustomComparator;


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
		throw new SQATException("You need to implement this");
	}

	@Override
	public List<Destination> getDestinationsForArtists(String artist) {
		try {
			throw new SQATException("You need to implement this!");
		} catch (SQATException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Destination> buildItineraryForArtists(List<String> artists) throws SQATException  {
		throw new SQATException("You have to implement this");
	}

}
