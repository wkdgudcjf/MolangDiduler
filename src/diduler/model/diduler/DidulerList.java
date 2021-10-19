package diduler.model.diduler;

import java.util.LinkedList;
import java.util.List;

public abstract class DidulerList implements java.io.Serializable{
	private List<Diduler> didulerList;
	
	public DidulerList()
	{
		this(new LinkedList<Diduler>());
	}
	public DidulerList(List<Diduler> didulerList)
	{
		this.didulerList = didulerList;
	}
	
	public List<Diduler> getDidulerList() {
		return didulerList;
	}

	public void setDidulerList(List<Diduler> didulerList) {
		this.didulerList = didulerList;
	}
	public void add(Diduler diduler)
	{
		didulerList.add(diduler);
	}
	public void add(List<Diduler> diduler)
	{
		didulerList.addAll(diduler);
	}
	public boolean remove(int sel)
	{
		if(didulerList.remove(sel)==null)
			return false;
		else
			return true;
	}
	public boolean remove(Diduler diduler)
	{
		return didulerList.remove(diduler);
	}
	public int getDidulerListNum()
	{
		return didulerList.size();
	}
	public void set(int sel, Diduler diduler)
	{
		if((0<sel)&&(sel<didulerList.size()))
			didulerList.set(sel, diduler);
	}
	public int indexOf(Diduler diduler)
	{
		return didulerList.indexOf(diduler);
	}
	public Diduler getDiduler(int index)
	{
		return didulerList.get(index);
	}
	public int size()
	{
		return didulerList.size();
	}
}
