package diduler.model.diduler;

public abstract class DidulerManagement implements DidulerAdd, DidulerModify, DidulerRemove, DidulerSearch{
	private DidulerList didulerList;
	
	public DidulerManagement()
	{
		this(null);
	}
	public DidulerManagement(DidulerList didulerList)
	{
		this.didulerList = didulerList;
	}
	public DidulerList getDidulerList() {
		return didulerList;
	}
	public void setDidulerList(DidulerList didulerList) {
		this.didulerList = didulerList;
	}
	
	
	
}
