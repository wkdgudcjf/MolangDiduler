package diduler.model;

public enum BGMState {
	PLAYING("�����"), PAUSE("�Ͻ�����"), STOP("����");
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
