package player;

import java.util.Observable;
import java.util.Observer;

import player.PlayerAdapter;

public class PlayerAdapterObserver implements Observer{
	
	private PlayerAdapter adapter;
	
	public PlayerAdapterObserver()
	{
		adapter = new PlayerAdapter();
	}
	
	public void setAdapter(PlayerAdapter value)
	{
		this.adapter = value;
	}
	
	public PlayerAdapter getAdapter()
	{
		return adapter;
	}

	@Override
	public void update(Observable obj, Object arg1) {
		
		//Observable playerAdapter = obj;
		this.setAdapter((PlayerAdapter)obj);
	}
	
	
	

}
