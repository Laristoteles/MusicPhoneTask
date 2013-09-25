
package commons.interfaces;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import commons.dataClasses.ConcertInfo;

public interface IConnector {
	List<String> getTopFansForArtist(String artist) throws ParserConfigurationException;
	List<String> getTopArtistsByFan(String fanName);
	List<ConcertInfo> getConcertsForArtist(String artist);
}
