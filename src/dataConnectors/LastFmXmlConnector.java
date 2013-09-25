package dataConnectors;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpression;

import org.w3c.dom.Document;

import commons.dataClasses.ConcertInfo;
import commons.interfaces.IConnector;

public class LastFmXmlConnector implements IConnector{
	public static String projectFolder = "MusicPhone";
	public static String baseDir = System.getProperty("user.dir") + "\bin\xmlData";
	private parseXML()
	@Override
	public List<String> getTopFansForArtist(String artist) throws ParserConfigurationException {
		if(artist == null) throw new IllegalArgumentException("artist");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		XPathExpression expr = null;
		builder= factory.newDocumentBuilder();
		doc = builder.parse(f);
		return null;
	}

	@Override
	public List<String> getTopArtistsByFan(String fanName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConcertInfo> getConcertsForArtist(String artist) {
		// TODO Auto-generated method stub
		return null;
	}

}
