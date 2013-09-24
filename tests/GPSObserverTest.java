import static org.junit.Assert.*;
import gps.Gps;
import gps.GpsAdapter;
import gps.GpsAdapterObserver;

import org.junit.Test;

import commons.dataClasses.GeoPoint;


public class GPSObserverTest {

	@Test
	public void observesTheChangeOfaGPSAttribute() {
		GpsAdapter gps = new GpsAdapter();
		
		GpsAdapterObserver gao = new GpsAdapterObserver();
		gps.addObserver(gao);
		
		GeoPoint point = new GeoPoint("10", "20");
		
		gps.setCurrentPosition(point);
		assertTrue(gps.hasChanged());
//		gps.setDistanceUnits("KM");
//	
//		gps.setDistanceUnits("MI");
//		assertEquals(gps.getCurrentPosition().getLatitude(), "10");
	}

}
