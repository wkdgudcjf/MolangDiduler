package diduler.model.diary;

import java.awt.Image;
import java.util.*;
import diduler.model.diduler.*;
import diduler.model.schedule.ScheduleList;
import diduler.model.*;

public class DiaryManagement extends DidulerManagement implements DiaryModify, DiaryAdd {

	private DiaryList list;
	
	public DiaryManagement()
	{
		this(new DiaryList());
	}
	public DiaryManagement(DiaryList diaryList)
	{
		super(diaryList);
		list = diaryList;
	}

	public void setDiaryList(DiaryList diaryList)
	{
		this.list = diaryList;
		super.setDidulerList(diaryList);
	}
	public DiaryList getDiaryList()
	{
		return list;
	}
	
	@Override
	public boolean remove()
	{
		return super.getDidulerList().getDidulerList().removeAll(super.getDidulerList().getDidulerList());
	}

	@Override
	public boolean remove(int sel) 
	{
		try
		{
			super.getDidulerList().getDidulerList().remove(sel);
			return true;
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}		
	}

	public boolean remove(Diduler diduler)
	{
		if(super.getDidulerList().remove(diduler))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	/**
	 * 다중 삭제 가능한 메소드 
	 */
	public boolean remove(int[] sel)   
	{
		try
		{
			for(int cnt=0; cnt < sel.length; cnt++)
			{
				super.getDidulerList().getDidulerList().remove(sel[cnt]);
			}
			return true;
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}	
	}


	public Diduler[] search(SearchType t, String content)
	{
		Diduler[] array = new Diduler[]{};
		int size = super.getDidulerList().getDidulerList().size();
		for(int cnt=0; cnt<size; cnt++)
		{
			Diduler diduler = super.getDidulerList().getDidulerList().get(cnt);
			if(t == SearchType.TITLE)
			{
				if(diduler.getTitle().contains(content))
				{
					array[cnt] = diduler;
				}
			}
			else if(t == SearchType.TITLE_CONTENT)
			{
				if(diduler.getTitle().contains(content) || diduler.getContent().contains(content))
				{
					array[cnt] = diduler;
				}
			}
		}
		return array;
	}
	


	@Override
	/**
	 *  날짜로 검색 
	 */
	public Diduler[] search(Date date)  
	{
		Diduler[] array = new Diduler[]{};
		int size = super.getDidulerList().getDidulerList().size();
		for(int cnt=0; cnt<size; cnt++)
		{
			Diduler diduler = super.getDidulerList().getDidulerList().get(cnt);
			if(diduler.getWrittenDate().equals(date))
			{
				array[cnt] = diduler;
			}
		}
		return array;
	}


	public void add(Diary diary)
	{
		//super.getDidulerList().add(diary);
		list.addDiary(diary);
	
	}
	@Override
	public void add(Diduler diduler) {
	    list.add(diduler);
	}

	@Override
	public void add(String title, String content) {
		
		Diary obj=new Diary(title,content);
		list.add(obj);
	}

	@Override
	public void add(String title, String content, boolean isPublic) {
		Diary obj=new Diary(title,content,isPublic);
		list.add(obj);
	}

	@Override
	public void add(String title, String content, String imageLocation, boolean isPublic) {
		Diary obj=new Diary(title,content,imageLocation,isPublic);
		list.add(obj);
		
	}

	@Override
	public void add(String title, String content, String imageLocation) {
		Diary obj=new Diary(title,content,imageLocation);
	    list.add(obj);

	}

	@Override
	public boolean modify(Diduler oldDiduler, Diduler newDiduler) {
		// TODO Auto-generated method stub
		
	    	int index=super.getDidulerList().getDidulerList().indexOf(oldDiduler); //해당 인덱스 번호를 찾아준다
	    	

			if(index == -1)
				return false;
			
			super.getDidulerList().set(index, newDiduler);
			
			index = list.indexOf(oldDiduler);
			if(index==-1)
				return false;
			
			list.set(index, newDiduler);
			return true;
	    }
		
	@Override
	public boolean modify(Diary oldDiary, Diary newDiary) {
		int index = super.getDidulerList().indexOf(oldDiary);
		
		if(index == -1)
			return false;
		
		super.getDidulerList().set(index, newDiary);
		
		/*
		index = list.indexOf(oldDiary);
		if(index==-1)
			return false;
		
		list.set(index, newDiary);
		*/
		return true;
	}

	@Override
	/**
	 * 다이어리의 내용 혹은 이미지 수정 
	 */
	public boolean modify(Diary diary, DiaryInfo field, String fieldContent) {
		int index = super.getDidulerList().getDidulerList().indexOf(diary);
		if(index == -1)
			return false;
		if(field == DiaryInfo.TITLE)
		{
			super.getDidulerList().getDidulerList().get(index).setTitle(fieldContent);
		}
		else if(field == DiaryInfo.CONTENT)
		{
			super.getDidulerList().getDidulerList().get(index).setContent(fieldContent);
		}
		else if(field == DiaryInfo.IMAGE)
		{
			Diary obj=(Diary)super.getDidulerList().getDidulerList().get(index);
			obj.setImageLocation(fieldContent);
		}
		return true;
	}
	/**
	 * 다이어리의 이미지만 수정 
	 */
	/*
	public boolean modify(Diary diary, DiaryInfo field, String fieldContent) {
		
		int index=super.getDidulerList().getDidulerList().indexOf(diary);  //해당 다이어리의 인덱스를 찾아서
		if(index==-1)
		{
			return false;
		}
		else
		{
			if(field==DiaryInfo.IMAGE) //이미지 이면 
			{
				Diary obj=(Diary)super.getDidulerList().getDidulerList().get(index);
				obj.setImage(fieldContent);
			}
					
			return true;
		}
	}
*/
	/**
	 * 다이어리의 공개범위를 수정하는 경우 
	 */
	@Override
	public boolean modify(Diary diary, DiaryInfo field, boolean fieldContent) {
		// TODO Auto-generated method stub
		int index=super.getDidulerList().getDidulerList().indexOf(diary);  //해당 다이어리의 인덱스를 찾아서
		if(index==-1)
		{
			return false;
		}
		else
		{
			if(field==DiaryInfo.ISPUBLIC) //이미지 이면 
			{
				super.getDidulerList().getDidulerList().get(index).setIsPublic(fieldContent);
			}
			
			return true;
		}
		
	}

	@Override
	public String toString() {
		return "DiaryManagement [getDidulerList()=" + getDidulerList()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
		
}


	
	
