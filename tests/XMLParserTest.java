import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import commons.dataClasses.ConcertInfo;

import dataConnectors.LastFmXmlConnector;




public class XMLParserTest {

	
	public void shouldReturnAConcertInfoObject() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    Document configuration = builder.parse("C:\\Users\\dfucci\\Desktop\\GitHub\\MusicPhone\\bin\\xmlData\\events_keane.xml");

	    XPathFactory xpathFactory = XPathFactory.newInstance();
	    XPath xpath = xpathFactory.newXPath();
	    XPathExpression expr = xpath.compile("//event");
	    
	    Object result = expr.evaluate(configuration, XPathConstants.NODESET);
	    NodeList nodes = (NodeList) result;
	    
	    for (int i = 0; i < nodes.getLength(); i++) {
	       Node node = nodes.item(i);
	       String venueObj = (String) xpath.compile("venue/location/city/text()").evaluate(node, XPathConstants.STRING);
	    
	       System.out.println(venueObj);
	       
	    }
	    
	    assertEquals(nodes.getLength(), 37);

	}
	
	@Test
	public void shouldAddConcertCorrectly() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, ParseException{
		LastFmXmlConnector lfmc = new LastFmXmlConnector();
		List<ConcertInfo> info= lfmc.getConcertsForArtist("keane");
		assertEquals(info.size(), 37);
		assertEquals(info.get(1).getCity(), "Fremantle");
	}

}
