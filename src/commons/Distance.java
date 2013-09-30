package commons;

import commons.dataClasses.GeoPoint;



public class Distance {
	
	public static double ComputeDistance(GeoPoint p1, GeoPoint p2, String units)
	{
		try {
			throw new SQATException("You have to implement this");
		} catch (SQATException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static double Deg2Rad(double deg)
	{
		return (deg * Math.PI / 180.0);
	}

}
