package diduler.model.diary;

import java.awt.Image;
import java.io.*;
import diduler.model.diduler.*;

public class Diary extends Diduler implements Serializable{


	//private Image image;
	private String imageLocation;
	public Diary()
	{
			super();
	}


	public Diary(String title,String content, String imageLocation) //공개 비공개 설정 안할경우
	{
		super(title,content,true); //공개 비공개 설정 안하면 공개로
		this.imageLocation=imageLocation;
		
	}
	
	public Diary(String title,String content,String imageLocation,boolean isPublic)
	{
		super(title,content,isPublic);
		this.imageLocation=imageLocation;
	}
	
	public Diary(String title, String content, boolean isPublic)
	{
		super(title,content,isPublic);
		this.imageLocation=null;
		
	}
	
	public Diary(String title, String content)
	{
		super(title,content,true);
		this.imageLocation=null;
	}

	public String getImageLocation() {
		return imageLocation;
	}
	


	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	@Override
	public String toString() {
		return "Diary [image=" + imageLocation + "]";
	}

		
	
}
