
package commons.interfaces;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import commons.dataClasses.ConcertInfo;
import dataConnectors.LastFmConnectionException;

public interface IConnector {
	List<String> getTopFansForArtist(String artist) throws LastFmConnectionException;
	List<String> getTopArtistsByFan(String fanName) throws LastFmConnectionException;
	List<ConcertInfo> getConcertsForArtist(String artist) throws LastFmConnectionException;
}
