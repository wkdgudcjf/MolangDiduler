package diduler.model;

public enum BGMState {
	PLAYING("재생중"), PAUSE("일시정지"), STOP("정지");
	private String state;
	private BGMState(String state)
	{
		this.state = state;
	}
	public String getState()
	{
		return this.state;
	}
}
