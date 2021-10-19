package diduler.model.bgm;
import java.net.*;
import java.sql.Time;
import diduler.model.BGMState;


public class BGM {
	private String title;
	private String location;
	private Time playingPoint;
	private BGMState state;
	
	public BGM()
	{
		this("","");
	}
	public BGM(String title, String location)
	{
		this.title = title;
		this.location = location;
		this.playingPoint = new Time(0, 0, 0);
		this.state = BGMState.STOP;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Time getPlayingPoint() {
		return playingPoint;
	}
	public void setPlayingPoint(Time playingPoint) {
		this.playingPoint = playingPoint;
	}
	public BGMState getState() {
		return state;
	}
	public void setState(BGMState state) {
		this.state = state;
	}
	
	public void play()
	{
		//구현 필요
		this.state = BGMState.PLAYING;
	}
	public void pause()
	{
		//구현 필요
		this.state =BGMState.PAUSE;
	}
	public void stop()
	{
		//구현 필요
		this.state = BGMState.STOP;
	}
	
}
