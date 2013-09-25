package player;

import commons.interfaces.IPlayer;


public class PlayerAdapter implements INotifyPropertyChanged, IPlayer
{
		private Player player;

		public PlayerAdapter()
		{
			player = new Player();
		}

		public final Tracks getPlayList()
		{
			//return player.PlayList;
			return player.getPlayList();
		}
		public final void setPlayList(Tracks value)
		{
			//player.PlayList = value;
			player.setPlayList(value);
			OnPropertyChanged("PlayList");
		}

		public final Track getCurrentTrack()
		{
			return player.getCurrentTrack();
		}
		public final void setCurrentTrack(Track value)
		{
			//player.CurrentTrack = value;
			player.setCurrentTrack(value);
			OnPropertyChanged("CurrentTrack");
		}

		public final void Next()
		{
			player.Next();
			OnPropertyChanged("CurrentTrack");
		}


		public final String getCurrentTitle()
		{
			//return player.CurrentTitle;
			return player.getCurrentTitle();
		}
		public final void setCurrentTitle(String value)
		{
			//player.CurrentTitle = value;
			player.setCurrentTitle(value);
			OnPropertyChanged("CurrentTitle");
		}

		public final String getCurrentArtist()
		{
			//return player.CurrentArtist;
			return player.getCurrentArtist();
		}
		public final void setCurrentArtist(String value)
		{
			//player.CurrentArtist = value;
			player.setCurrentArtist(value);
			OnPropertyChanged("CurrentArtist");
		}

//		public event PropertyChangedEventHandler PropertyChanged;

		private void OnPropertyChanged(String p)
		{
			PropertyChangedEventHandler handler = PropertyChanged;
			if (handler != null)
			{
				handler(this, new PropertyChangedEventArgs(p));
			}
		}

}
