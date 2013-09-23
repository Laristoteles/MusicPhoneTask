package gps;

import java.util.Observable;
import java.util.Observer;

public class GpsAdapterObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		GpsAdapter newValue = (GpsAdapter)o;
		String newDistance = newValue.getDistanceUnits();
		System.out.print("changed " + newDistance);

	}

}
