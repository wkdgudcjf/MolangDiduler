package diduler.model.diary;

import java.awt.Image;

import diduler.model.diduler.DidulerAdd;

public interface DiaryAdd extends DidulerAdd{
	
	public void add(Diary diary);
	public void add(String title, String content, String imageLocation, boolean isPublic);
	public void add(String  title, String content, String imageLocation);
	
}
