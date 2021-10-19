package diduler.model.bgm;

import java.io.IOException;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Time;

import diduler.model.BGMState;

public class BGMController extends Thread {

	private static BGMController instance = new BGMController();
	private BGMManagement bgmManager;
	private Player player;
	private Time sync;

	private BGMController() {
		this(new BGMManagement());
	}
	private BGMController(BGMManagement bgmManager) {
		this.bgmManager = bgmManager;
	}	
	public static BGMController getInstance()
	{
		return instance;
	}
	public String getTitle()
	{
		return bgmManager.getBgmList().get(bgmManager.getNowPlaying()).getTitle();
	}
	public int getListNum()
	{
		return bgmManager.getBgmList().getBGMListNum();
	}
	public boolean getPlayingState()
	{
		if(bgmManager.getBgmList().getBGMListNum()==0)
			return false;
		if(bgmManager.getBgmList().get(bgmManager.getNowPlaying()).getState()==BGMState.STOP)
			return false;
		else
			return true;
	}
	public void setNowPlaying(int nowPlaying)
	{
		if(nowPlaying<bgmManager.getBgmList().getBGMListNum())
		{
			bgmManager.getBgmList().get(bgmManager.getNowPlaying()).setState(BGMState.STOP);
			sync = new Time(0);
			bgmManager.setNowPlaying(nowPlaying);
		}
	}
	public void setNowPlaying(String title)
	{
		if(bgmManager.getBgmList().get(title)!=null)
		{
			bgmManager.getBgmList().get(bgmManager.getNowPlaying()).setState(BGMState.STOP);
			sync = new Time(0);
			bgmManager.setNowPlaying(bgmManager.getBgmList().indexOf(bgmManager.getBgmList().get(title)));
			bgmManager.setNowPlaying(bgmManager.getBgmList().indexOf(bgmManager.getBgmList().get(title)));
			bgmManager.setNowPlaying(bgmManager.getBgmList().indexOf(bgmManager.getBgmList().get(title)));
		}
	}
	public void addBGM(String title, String location) {
		bgmManager.addBGM(new BGM(title, location));
	}
	public void run() {
		while (true) {
			if (bgmManager.getBgmList().get(bgmManager.getNowPlaying()).getState() == BGMState.PAUSE) 
			{
				bgmManager.getBgmList().get(bgmManager.getNowPlaying()).setState(BGMState.PLAYING);
				player.start();
			} 
			else if (bgmManager.getBgmList().get(bgmManager.getNowPlaying()).getState() == BGMState.STOP) 
			{
				bgmManager.getBgmList().get(bgmManager.getNowPlaying()).setState(BGMState.PLAYING);
				try {
					MediaLocator locator = new MediaLocator("file:/"+ bgmManager.getBgmList().get(bgmManager.getNowPlaying()).getLocation());
					player = Manager.createPlayer(locator);
					player.addControllerListener(new ControllerListener() {
						public void controllerUpdate(ControllerEvent e) {
							if (e instanceof EndOfMediaEvent) {
								bgmManager.getBgmList().get(bgmManager.getNowPlaying()).setState(BGMState.STOP);
								if (bgmManager.getNowPlaying() + 1 < bgmManager.getBgmList().getBGMListNum())
									bgmManager.setNowPlaying(bgmManager.getNowPlaying()+1);
								else
									bgmManager.setNowPlaying(0);

								try {
									player = Manager.createPlayer(new MediaLocator("file:/"+ bgmManager.getBgmList().get(bgmManager.getNowPlaying()).getLocation()));
									player.realize();
									player.start();
								} catch (Exception e2) {
								}
							}

						}
					});

					player.realize();
					player.start();

				} catch (NoPlayerException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void pausePlay() {
		if (bgmManager.getBgmList().get(bgmManager.getNowPlaying()).getState() == BGMState.PLAYING) {
			player.stop();
			bgmManager.getBgmList().get(bgmManager.getNowPlaying()).setState(BGMState.PAUSE);
			this.suspend();
			sync = player.getStopTime();
		}
	}
	public void stopPlay() {
		if((bgmManager.getBgmList().get(bgmManager.getNowPlaying()).getState()==BGMState.PLAYING)||(bgmManager.getBgmList().get(bgmManager.getNowPlaying()).getState()==BGMState.PAUSE))
		{
			player.stop();
			player.close();
			bgmManager.getBgmList().get(bgmManager.getNowPlaying()).setState(BGMState.STOP);
			if (bgmManager.getNowPlaying() + 1 < bgmManager.getBgmList().getBGMListNum())
				bgmManager.setNowPlaying(bgmManager.getNowPlaying()+1);
			else
				bgmManager.setNowPlaying(0);
			this.suspend();
		}

	}
}