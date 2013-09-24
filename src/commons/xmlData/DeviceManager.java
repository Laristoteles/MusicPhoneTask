package commons.xmlData;

import commons.interfaces.IGps;
import commons.interfaces.IPlayer;

public final class DeviceManager {
	
	///#region Singleton members

			private static final DeviceManager instance = new DeviceManager();
			private DeviceManager()
			{
			}
			public static DeviceManager getInstance()
			{
				return instance;
			}

			///#endregion

			private IPlayer privatePlayer;
			public IPlayer getPlayer()
			{
				return privatePlayer;
			}
			public void setPlayer(IPlayer value)
			{
				privatePlayer = value;
			}

			private IGps privateGps;
			public IGps getGps()
			{
				return privateGps;
			}
			public void setGps(IGps value)
			{
				privateGps = value;
			}

}
