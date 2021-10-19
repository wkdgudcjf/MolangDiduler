package diduler.model.diary;

import java.awt.Image;
import java.io.*;
import java.util.*;

import diduler.model.diduler.*;
import diduler.model.schedule.Alarm;
import diduler.model.schedule.Schedule;

/**
 * 다이어리를 리스트로 갖고있는 클래스 
 * @author kim sang a
 *
 */
public class DiaryList extends DidulerList implements Serializable{
	private List<Diary> diaryList;
	
	
	
	public DiaryList()
	{
		super();
		diaryList = new LinkedList<Diary>();
	}
	
	public boolean remove(Schedule schedule)
	{
		return super.remove(schedule);
	}
	public DiaryList(List<Diary> diaryList)
	{
		super();
		this.diaryList = diaryList;
		for(int i=0; i<diaryList.size(); i++)
		{
			super.add(diaryList.get(i));
		}
		
	}
	
	public void addDiary(Diary diary)
	{
		super.add(diary);
		diaryList.add(diary);
	}
	
	public void addDiary(String  title, String content, String imageLocation)
	{
		super.add(new Diary(title,content,imageLocation)); 
		diaryList.add(new Diary(title, content, imageLocation));
	}
	
	public void addDiary(String title,String content, String imageLocation, boolean isPublic)
	{
		super.add(new Diary(title,content,imageLocation,isPublic));
		diaryList.add(new Diary(title, content, imageLocation,isPublic));
	}
	
	public void addDiary(String title,String content, boolean isPublic)
	{
		super.add(new Diary(title,content,isPublic));
		diaryList.add(new Diary(title, content,isPublic));
	}
					
	public boolean removeDiary(Diary diary)
	{
		diaryList.remove(diary);
		return super.remove(diary);
	}
	
	public boolean removeDiary(int sel)
	{
		diaryList.remove(sel);
		return super.remove(sel);
    }
}
