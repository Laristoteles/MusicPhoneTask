package commons.xmlData;

import commons.dataClasses.GeoPoint;



public class Distance {
	
	public static double ComputeDistance(GeoPoint p1, GeoPoint p2, String units)
	{
		double dist = 0.0, a = 0.0, radius = 0.0;
		double p1lat = 0.0;
		double p1lon = 0.0;
		double p2lat = 0.0;
		double p2lon = 0.0;

		if (units.equals("km"))
		{
			radius = 6371.01;
		}
		if (units.equals("mi"))
		{
			radius = 3958.76;
		}
		if (radius == 0 || p1.getLatitude() == null || p2.getLatitude() == null || p1.getLongitude() == null || p2.getLongitude() == null)
		{
			throw new RuntimeException();
		}
		try
		{
			p1lat = Distance.Deg2Rad((double)Double.parseDouble(p1.getLatitude()));
			p1lon = Distance.Deg2Rad((double)Double.parseDouble(p1.getLongitude()));
			p2lat = Distance.Deg2Rad((double)Double.parseDouble(p2.getLatitude()));
			p2lon = Distance.Deg2Rad((double)Double.parseDouble(p2.getLatitude()));
		}
		catch (java.lang.Exception e)
		{
			throw new RuntimeException();
		}
		a = (Math.sin((p1lat - p2lat) / 2.0) * Math.sin((p1lat - p2lat) / 2.0)) + (Math.cos(p1lat) * Math.cos(p2lat) * Math.sin((p1lon - p2lon) / 2.0) * Math.sin((p1lon - p2lon) / 2.0));


		dist = 2 * Math.asin(Math.min(1.0, Math.sqrt(a))) * radius;

		return dist;
	}

	public static double Deg2Rad(double deg)
	{
		return (deg * Math.PI / 180.0);
	}

}
