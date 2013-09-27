package player;

import commons.interfaces.IPlayer;

import commons.DeviceManager;
import player.Track;


public class Player implements IPlayer
{
	private Tracks playList;
	private Track currentTrack = new Track();
	private String artist;
	private String title;
	private int currentIndex = 0;

	public Player()
	{
		//DeviceManager.Instance.Player = this;
		DeviceManager.getInstance().setPlayer(this);
	}

	public final Tracks getPlayList()
	{
		return playList;
	}
	public final void setPlayList(Tracks value)
	{
		playList = value;
		currentIndex = 0;
	}

	public final Track getCurrentTrack()
	{
		return currentTrack;
	}
	public final void setCurrentTrack(Track value)
	{
		currentTrack = value.clone();
		//Play(currentTrack.artist, currentTrack.title);
		Play(this.currentTrack.getArtist(),this.currentTrack.getTitle());
		currentIndex = playList.indexOf(currentTrack.clone());
		
	}

	public final void Next()
	{
		currentIndex = (currentIndex + 1) % getPlayList().size();

		currentTrack = playList[currentIndex];
		//Play(currentTrack.artist, currentTrack.title);
		Play(this.currentTrack.getArtist(),this.currentTrack.getTitle());
	}

	public final void Play(String artist, String title)
	{
		setCurrentArtist(artist);
		setCurrentTitle(title);
	}

	public final String getCurrentTitle()
	{
		return title;
	}
	public final void setCurrentTitle(String value)
	{
		title = value;
	}

	public final String getCurrentArtist()
	{
		return artist;
	}
	public final void setCurrentArtist(String value)
	{
		artist = value;
	}

}

/*
 * resolve this Tracks then errors of this file
 * will be removed, hopefully
 */

public class Tracks extends System.Collections.ObjectModel.ObservableCollection<Track>
{
}

