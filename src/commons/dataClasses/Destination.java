package commons.dataClasses;

import java.util.Date;

public class Destination {
	private ConcertInfo concertInfo;
	private String artist;
	private String city;
	private String venue;
	private Date startTime;
	private GeoPoint position;
	private double distance; //how far is the events
	private String distanceUnits; // "KM" or "MI"
	public Destination(String artist, String city, String venue,
			Date startDate, GeoPoint position) {
		this.concertInfo = new ConcertInfo(artist, city, venue, startDate, position);
	}
	public ConcertInfo getConcertInfo() {
		return concertInfo;
	}
	public void setConcertInfo(ConcertInfo concertInfo) {
		this.concertInfo = concertInfo;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public Date getStartDate() {
		return startTime;
	}
	public void setStartDate(Date startDate) {
		this.startTime = startTime;
	}
	public GeoPoint getPosition() {
		return position;
	}
	public void setPosition(GeoPoint position) {
		this.position = position;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getDistanceUnits() {
		return distanceUnits;
	}
	public void setDistanceUnits(String distanceUnits) {
		this.distanceUnits = distanceUnits;
	}
	public Destination(ConcertInfo concertInfo) {
		this.concertInfo = concertInfo;
	}
	

}
