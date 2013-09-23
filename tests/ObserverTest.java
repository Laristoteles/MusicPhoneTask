import static org.junit.Assert.*;
import gps.GpsAdapter;
import gps.GpsAdapterObserver;

import org.junit.Test;


public class ObserverTest {

	@Test
	public void shouldCallTheObservedGpsObservable() {
		GpsAdapter gps =new GpsAdapter();
		GpsAdapterObserver gpsAO = new GpsAdapterObserver();
		
		gps.addObserver(gpsAO);
		gps.setDistanceUnits("MT");
		assertTrue(gps.hasChanged());
		gps.notifyObservers();

	}

}
