package dataConnectors;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JPopupMenu.Separator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import commons.dataClasses.ConcertInfo;
import commons.dataClasses.GeoPoint;
import commons.interfaces.IConnector;

public class LastFmXmlConnector implements IConnector{
	public static String separator = System.getProperty("file.separator");
	private static String baseDir = System.getProperty("user.dir").concat(separator).concat("bin").concat(separator).concat("xmlData").concat(separator);




	@Override
	public List<String> getTopFansForArtist(String artist) throws  LastFmConnectionException   {
		if(artist==null) throw new IllegalArgumentException("artist");
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document configuration;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr;
		Object result = null;
		try {
			builder = domFactory.newDocumentBuilder();
			configuration = builder.parse(baseDir+ "topFans_" + artist.toLowerCase() +".xml");
			expr = xpath.compile("//user/name");
			result = expr.evaluate(configuration, XPathConstants.NODESET);
		} catch (Exception e) {
			throw new LastFmConnectionException("Could not load Topfans XML file",e);
		}
		
		NodeList nodes = (NodeList) result;
		ArrayList<String> topFans = new ArrayList<>();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			topFans.add(node.getTextContent());
		}
		return topFans;
	}

	//TODO: To be implemented
	@SuppressWarnings("unused")
	private static String removeInvalidChars(String fileName) {
		return "";
	}

	@Override
	public List<String> getTopArtistsByFan(String fanName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConcertInfo> getConcertsForArtist(String artist) throws LastFmConnectionException {
		if(artist==null) throw new IllegalArgumentException("artist");
		SimpleDateFormat simpleDate = new SimpleDateFormat("EEE, dd MMM YYYY", Locale.US);
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document configuration;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr;
		Object result;

		try {
			builder = domFactory.newDocumentBuilder();
			configuration = builder.parse(baseDir+ "events_" + artist.toLowerCase() +".xml");
			expr = xpath.compile("//event");
			result = expr.evaluate(configuration, XPathConstants.NODESET);
		} catch (Exception e) {
			throw new LastFmConnectionException("Could not load Events XML file", e);
		}

		NodeList nodes = (NodeList) result;
		ArrayList<ConcertInfo> events = new ArrayList<>();

		String venue;
		String name;
		String dateStr;
		String geoLat;
		String geoLon;
		
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			try {
				venue = (String) xpath.compile("venue/location/city/text()").evaluate(node, XPathConstants.STRING);
				name = (String) xpath.compile("venue/name/text()").evaluate(node, XPathConstants.STRING);
				dateStr = (String) xpath.compile("startDate/text()").evaluate(node, XPathConstants.STRING);
				Date date = simpleDate.parse(dateStr);
				geoLat = (String) xpath.compile("venue/location/geo:point/geo:lat").evaluate(node, XPathConstants.STRING);
				geoLon = (String) xpath.compile("venue/location/geo:point/geo:lon").evaluate(node, XPathConstants.STRING);
				GeoPoint point = new GeoPoint(geoLat, geoLon);
				ConcertInfo info = new ConcertInfo(artist, venue, name, date, point);
				events.add(info);
			} catch (Exception e){
				throw new LastFmConnectionException("Could not parse XML data",e);
			}
		}
		return events;
	}

}
