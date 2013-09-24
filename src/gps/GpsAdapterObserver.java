package gps;

import java.util.Observable;
import java.util.Observer;

public class GpsAdapterObserver implements Observer {
	private GpsAdapter adapter;
	public GpsAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(GpsAdapter adapter) {
		this.adapter = adapter;
	}

	public GpsAdapterObserver(){adapter= new GpsAdapter();}
	
	@Override
	public void update(Observable o, Object arg) {
		GpsAdapter gpsAdapter = (GpsAdapter)o;
		this.setAdapter(gpsAdapter);

	}

}
