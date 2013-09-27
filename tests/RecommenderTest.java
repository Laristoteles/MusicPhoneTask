import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import commons.Recommender;
import commons.dataClasses.Recommendation;

import dataConnectors.LastFmXmlConnector;


public class RecommenderTest {

	@Test
	public void shouldSortAnHash() throws Exception {
		LastFmXmlConnector lfmconn = new LastFmXmlConnector();
		Recommender rec = new Recommender();
		rec.setConnector(lfmconn);
		List<Recommendation> myRec = new ArrayList<>();
		myRec=rec.getRecommendations();
		for (int i = 0; i < myRec.size(); i++) {
			System.out.println(myRec.get(i).getArtist());
			System.out.println(myRec.get(i).getFanCount());
		}
	}

}
