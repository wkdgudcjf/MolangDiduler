package diduler.model.bgm;

public class BGMManagement implements BGMAdd, BGMRemove{
	private BGMList bgmList;
	private int nowPlaying;
	
	public BGMManagement()
	{
		this(new BGMList());
	}
	public BGMManagement(BGMList bgmList)
	{
		this.bgmList =bgmList;
		nowPlaying=0;
	}
	public BGMList getBgmList() {
		return bgmList;
	}
	public void setBgmList(BGMList bgmList) {
		this.bgmList = bgmList;
	}
	public int getNowPlaying() {
		return nowPlaying;
	}
	public void setNowPlaying(int nowPlaying) {
		this.nowPlaying = nowPlaying;
	}
	
	public void play()
	{
		bgmList.get(nowPlaying).play();
	}
	public void play(int sel)
	{
		bgmList.get(sel).play();
		nowPlaying = sel;
	}
	public void play(BGM bgm)
	{
		if(bgmList.contains(bgm))
		{
			bgm.play();
			nowPlaying = bgmList.indexOf(bgm);
		}
		
	}
	public void play(String title)
	{
		BGM temp = bgmList.get(title);
		if(temp!=null)
		{
			temp.play();
			nowPlaying = bgmList.indexOf(temp);
		}
		
	}
	public void pause()
	{
		bgmList.get(nowPlaying).pause();
	}
	public void stop()
	{
		bgmList.get(nowPlaying).stop();
	}
	public boolean removeBGM(int sel) {
		return bgmList.removeBGM(sel);
	}
	public boolean removeBGM(String title) {
		return bgmList.removeBGM(title);
	}
	public boolean removeBGM(BGM bgm) {
		return bgmList.removeBGM(bgm);
	}
	@Override
	public void addBGM(BGM bgm) {
		bgmList.addBGM(bgm);
	}
	public void addBGM(String location) {
		bgmList.addBGM(new BGM(location,location));		
	}
}

/*
public class BGMManagement implements BGMAdd, BGMRemove, BGMPrint{
	private BGMList bgmList;
	private BGM nowPlaying;
	
	public BGMManagement()
	{
		this(new BGMList());
	}
	public BGMManagement(BGMList bgmList)
	{
		this.bgmList =bgmList;
		nowPlaying=null;
	}
	public BGMList getBgmList() {
		return bgmList;
	}
	public void setBgmList(BGMList bgmList) {
		this.bgmList = bgmList;
	}
	public BGM getNowPlaying() {
		return nowPlaying;
	}
	public void setNowPlaying(BGM nowPlaying) {
		this.nowPlaying = nowPlaying;
	}
	
	public void play()
	{
		bgmList.get(0).play();
		nowPlaying = bgmList.get(0);
	}
	public void play(int sel)
	{
		bgmList.get(sel).play();
		nowPlaying = bgmList.get(sel);
	}
	
	public void play(BGM bgm)
	{
		if(bgmList.contains(bgm))
		{
			bgm.play();
			nowPlaying = bgm;
		}
		
	}
	public void play(String title)
	{
		BGM temp = bgmList.get(title);
		if(temp!=null)
		{
			temp.play();
			nowPlaying = temp;
		}
		
	}
	public void pause()
	{
		nowPlaying.pause();
	}
	public void stop()
	{
		nowPlaying.stop();
	}
	public void printBGMList() {
		//구현 필요
	}
	
	public boolean removeBGM(int sel) {
		return bgmList.removeBGM(sel);
	}
	public boolean removeBGM(String title) {
		return bgmList.removeBGM(title);
	}
	public boolean removeBGM(BGM bgm) {
		return bgmList.removeBGM(bgm);
	}
	@Override
	public void addBGM(BGM bgm) {
		bgmList.addBGM(bgm);
	}
	public void addBGM(String location) {
		bgmList.addBGM(new BGM(location,location));		
	}
}
*/