package diduler.model.bgm;

import java.util.LinkedList;
import java.util.List;

public class BGMList implements BGMRemove, BGMAdd{
	private List<BGM> bgmList;

	public BGMList(){
		this(new LinkedList<BGM>());
	}
	public BGMList(List<BGM> bgmList)
	{
		this.bgmList = bgmList;
	}
	public List<BGM> getBgmList() {
		return bgmList;
	}

	public void setBgmList(List<BGM> bgmList) {
		this.bgmList = bgmList;
	}
	public int indexOf(BGM bgm)
	{
		return bgmList.indexOf(bgm);
	}
	public boolean contains(BGM bgm)
	{
		if(bgmList.contains(bgm))
			return true;
		else
			return false;
	}
	public BGM get(String title)
	{
		for(int i=0; i<bgmList.size(); i++)
		{
			if(bgmList.get(i).getTitle().equals(title))
			{
				return bgmList.get(i);
			}
		}
		return null;
	}
	public BGM get(int sel)
	{
		return bgmList.get(sel);
	}
	public void addBGM(BGM bgm)
	{
		bgmList.add(bgm);
	}
	public boolean removeBGM(BGM bgm)
	{
		return bgmList.remove(bgm);
	}
	public boolean removeBGM(int sel)
	{
		if(bgmList.remove(sel)==null)
			return false;
		else
			return true;
	}
	public boolean removeBGM(String title)
	{
		for(int i=0; i<bgmList.size(); i++)
		{
			if(bgmList.get(i).getTitle().equals(title))
			{
				bgmList.remove(i);
				return true;
			}
		}
		return false;
	}
	public int getBGMListNum()
	{
		return bgmList.size();
	}
}
