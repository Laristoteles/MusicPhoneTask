package commons;

import commons.dataClasses.GeoPoint;
public class Distance {
	public static double computeDistance(GeoPoint p1, GeoPoint p2, String units){
		return new Distance().myComputeDistance(p1, p2, units);
	}
	public final double EarthRadiusMI = 3958.76;
	public final double EarthRadiusKM = 6371.01;
	private double myComputeDistance(GeoPoint p1, GeoPoint p2, String units) {
		double distance = 0.0;
		
		if(p1==null) throw new IllegalArgumentException("p1");
		if(p2==null) throw new IllegalArgumentException("p2");
		if(units == null) throw new IllegalArgumentException("units");
		
		units = units.toLowerCase();
		if(units!="km" && units!="mi") throw new IllegalArgumentException("Invalid value");
		double p1Lat = Double.parseDouble(p1.getLatitude());
		double p1Lon = Double.parseDouble(p1.getLongitude());
		
		double p2Lat = Double.parseDouble(p2.getLatitude());
		double p2Lon = Double.parseDouble(p2.getLongitude());
		
		 if (p1Lat < -90 || p1Lat > 90)
             throw new IllegalArgumentException("Latitude must be between -90 and 90.");

         if (p1Lon < -180 || p1Lon > 180)
             throw new IllegalArgumentException("Longitude must be between -180 and 180.");

         if (p2Lat < -90 || p2Lat > 90)
             throw new IllegalArgumentException("Latitude must be between -90 and 90.");

         if (p2Lon < -180 || p2Lon > 180)
             throw new IllegalArgumentException("Longitude must be between -180 and 180.");
         
         p1Lat *= Math.PI/180;
         p1Lon *= Math.PI/180;
         
         p2Lat *= Math.PI/180;
         p2Lon *= Math.PI/180;
         
         double a = Math.pow(Math.sin((p2Lat-p1Lat) /2), 2) + Math.cos(p1Lat)*Math.cos(p2Lat)*Math.pow(Math.sin((p2Lon-p1Lon)/2), 2);
         double centralAngle = 2* Math.asin(Math.min(1.0, Math.sqrt(a)));
         
         if(units.equalsIgnoreCase("mi")) distance = centralAngle * EarthRadiusMI;
         else distance = centralAngle*EarthRadiusKM;
      
         return distance;
	}
}
