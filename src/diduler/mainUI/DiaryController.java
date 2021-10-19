package diduler.mainUI;

import java.util.*;

import diduler.model.DiaryInfo;
import diduler.model.SearchType;
import diduler.model.diary.*;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTable;

import diduler.model.diduler.*;
import diduler.model.schedule.Schedule;
import diduler.model.schedule.ScheduleManagement;

public class DiaryController {

	private DiaryManagement diaryManagement;
	private Diary oldDiary;
		
	private List<Integer> selList;
	private List[] weekList = new List[7];
	
	private static DiaryController instance=new DiaryController();
	public List<String> get(int sel)
	{ 
		Diary diary = (Diary) diaryManagement.getDidulerList().getDidulerList().get(sel);
	
		LinkedList<String> list = new LinkedList<String>();

		list.add(diary.getTitle());
		list.add(diary.getContent());
		list.add(diary.getImageLocation());
		list.add(diary.getIsPublic() + "");
		
		return list;
	}
	public List<String> getSearch(int day, int sel)
	{
		//System.out.println("getSearch에 들어온 sel"+sel);
		
		Diary diary = (Diary) diaryManagement.getDidulerList().getDidulerList().get((Integer)weekList[day].get(sel));
		LinkedList<String> list = new LinkedList<String>();
	
		list.add(diary.getTitle());
		list.add(diary.getContent());
		list.add(diary.getImageLocation());
		list.add(diary.getIsPublic() + "");


/*		list.add((1900 + diary.getWrittenDate().getYear()) + "."
				+ (diary.getWrittenDate().getMonth() + 1) + "."
				+ diary.getWrittenDate().getDate());
		list.add(diary.getIsPublic() + "");*/
	
		return list;
	}
	
	public List<String> getSearch(int sel)
	{
		//System.out.println("getSearch에 들어온 sel"+sel);
		
		Diary diary = (Diary) diaryManagement.getDidulerList().getDidulerList().get(selList.get(sel));
		LinkedList<String> list = new LinkedList<String>();
	
		list.add(diary.getTitle());
		list.add(diary.getContent());
		list.add(diary.getImageLocation());
		list.add(diary.getIsPublic() + "");


/*		list.add((1900 + diary.getWrittenDate().getYear()) + "."
				+ (diary.getWrittenDate().getMonth() + 1) + "."
				+ diary.getWrittenDate().getDate());
		list.add(diary.getIsPublic() + "");*/
	
		return list;
	}
	public List<Integer> getSelList()
	{
		return selList;
	}
	public List<String[]> getTableValueList()
	{
		List<String[]> list = new LinkedList<String[]>();
		String[] str = new String[3];
		Diary diary;

		for (int cnt = 0; cnt < diaryManagement.getDidulerList()
				.getDidulerListNum(); cnt++) {
			diary = (Diary) diaryManagement.getDidulerList()
					.getDidulerList().get(cnt);
			str[0] = diary.getTitle();
			str[1] = (1900 + diary.getWrittenDate().getYear()) + "."
					+ (diary.getWrittenDate().getMonth() + 1) + "."
					+ diary.getWrittenDate().getDate();
			str[2] = Boolean.toString(diary.getIsPublic()).equals("true") ? "공개"
					: "비공개";

			list.add(str.clone());
		}
		return list;
	}
	public List<String> searchTodayDiary(int day, String year, String month, String date)
	{
		String str;	
		weekList[day] = new LinkedList<Integer>();	
		List<String> list = new LinkedList<String>();
		Diary diary;
		Date compareDate = new Date(Integer.parseInt(year)-1900, Integer.parseInt(month)-1, Integer.parseInt(date));
		
		for (int cnt = 0; cnt < diaryManagement.getDidulerList().getDidulerListNum(); cnt++) 
		{
		    
			diary = (Diary) diaryManagement.getDidulerList()
					.getDidulerList().get(cnt);
			
			String arr = year+"."+month+"."+date;
			if (arr.equals((1900 + diary.getWrittenDate().getYear()) + "."
					+ (diary.getWrittenDate().getMonth() + 1) + "."
					+ diary.getWrittenDate().getDate())) 
			{
				weekList[day].add(cnt);
				str= diary.getTitle();
				
				list.add(str);
			}
		}
		return list;
	}
	public List<String[]> searchTodayDiary(String year, String month, String date) {
		List<String[]> list = new LinkedList<String[]>();
		String[] str = new String[3];
		Diary diary;
		selList=new LinkedList<Integer>();
		Date compareDate = new Date(Integer.parseInt(year)-1900, Integer.parseInt(month)-1, Integer.parseInt(date));
		
		for (int cnt = 0; cnt < diaryManagement.getDidulerList().getDidulerListNum(); cnt++) 
		{
		    
			diary = (Diary) diaryManagement.getDidulerList()
					.getDidulerList().get(cnt);
			
			String arr = year+"."+month+"."+date;
			if (arr.equals((1900 + diary.getWrittenDate().getYear()) + "."
					+ (diary.getWrittenDate().getMonth() + 1) + "."
					+ diary.getWrittenDate().getDate())) 
			{
				selList.add(cnt);
				str[0] = diary.getTitle();
				str[1] = (1900 + diary.getWrittenDate().getYear()) + "."
						+ (diary.getWrittenDate().getMonth() + 1) + "."
						+ diary.getWrittenDate().getDate();
				str[2] = Boolean.toString(diary.getIsPublic())
						.equals("true") ? "공개" : "비공개";

				list.add(str.clone());
			}
		}
		return list;
	}
	public static DiaryController getInstance()
	{
		return instance;
	}
	private DiaryController()  
	{
		diaryManagement =new DiaryManagement(new DiaryList());  //리스트를 넣는다
	}
    public void addDiary(Diduler diduler)
    {
    	diaryManagement.add(diduler);
    }
    public void addDiary(String title,String content)
    {
    	diaryManagement.add(new Diary(title,content));
    }
    public void addDiary(Diary diary)
    {
    	diaryManagement.add(diary);
    }
    
    public void addDiary(String title, String content, boolean isPublic)
    {
    	diaryManagement.add(new Diary(title,content,isPublic));
    }
    public void addDiary(String title, String content, String imageLocation, boolean isPublic)
    {
    	diaryManagement.add(new Diary(title,content,imageLocation,isPublic));
    }
    public void addDiary(String title, String content, boolean isPublic, String[] date)
    {
    	Diary n = new Diary(title, content, isPublic);
    	try {
    		n.setWrittenDate(new Date(Integer.parseInt(date[0])-1900,Integer.parseInt(date[1]) - 1, Integer
									.parseInt(date[2])));
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	diaryManagement.add(n);
    }
    public void addDiary(String title, String content, String imageLocation, boolean isPublic, String[] date)
    {
    	Diary n = new Diary(title, content, imageLocation,isPublic);
    	try {
    		n.setWrittenDate(new Date(Integer.parseInt(date[0])-1900,Integer.parseInt(date[1]) - 1, Integer
									.parseInt(date[2])));
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	diaryManagement.add(n);
    	//diaryManagement.add(new Diary(title,content,imageLocation,isPublic));
    }
    
    public void addDiary(String  title, String content, String imageLocation)
    {
    	diaryManagement.add(new Diary(title,content,imageLocation,true));
    }

    public void removeDiary()
    {  
    	diaryManagement.remove();
    }
   
    public void removeDiary(int sel)
    {
    	diaryManagement.getDidulerList().remove(sel);
    }
    
    public void removeDiary(int []sel)
    {
    	diaryManagement.remove(sel);
    }
    
    public List<String> search(SearchType t, String content)
    {
    	List<String> list = new LinkedList<String>();
    	Diduler[] obj = diaryManagement.search(t, content);    	
    	
    	for(int cnt=0; cnt<obj.length; cnt++)
		{
    		list.add(obj[cnt].getTitle());
    		String date=(1900+obj[cnt].getWrittenDate().getYear())+"."+(obj[cnt].getWrittenDate().getMonth()+1)+"."+obj[cnt].getWrittenDate().getDate();
    		list.add(date);
    		String isPublic=(obj[cnt].getIsPublic()== true) ? "공개" : "비공개";
    		list.add(isPublic);
		}		
   	
    	return list;   
    	
    }
   
	public DiaryManagement getDiaryManagement() {
		return diaryManagement;
	}
	public void setDiaryManagement(DiaryManagement diaryManagement) {
		this.diaryManagement = diaryManagement;
	}
	public Diduler[] search(Date date)  
	{
		return diaryManagement.search(date);
	}
		
	public boolean modify(Diduler oldDiduler, Diduler newDiduler) 
	{
	   	return diaryManagement.modify(oldDiduler, newDiduler);
	}
	
	
	public boolean modify(Diary oldDiary, Diary newDiary) 
	{
		return diaryManagement.modify(oldDiary, newDiary);
	}
	
	public String getDiaryTitle(int index)
	{
		Diary obj=(Diary)diaryManagement.getDidulerList().getDiduler(index);
		return obj.getTitle();
	}

	public String getDiaryContent(int index)
	{
		Diary obj=(Diary)diaryManagement.getDidulerList().getDiduler(index);
		return obj.getContent();
		
		
	}
	public Image getDiaryImage(int index)
	{
		Diary obj=(Diary)diaryManagement.getDidulerList().getDiduler(index);
		Image image=null;
		try {
			image = ImageIO.read(new File(obj.getImageLocation())); //파일을 생성 

		} catch (IOException e) {
			//e.printStackTrace();
		}
		
		return image;
		
	}
	
	public boolean getDiaryisPublic(int index)
	{
		Diary obj=(Diary)diaryManagement.getDidulerList().getDiduler(index);
		return obj.getIsPublic();
	}
	public Date getDiaryWrittenDate(int index)
	{
		Diary obj=(Diary)diaryManagement.getDidulerList().getDiduler(index);
		return obj.getWrittenDate();
		
	}
	
	public boolean modify(int index,String title, String content,boolean isPublic)
	{
		Diary ex=(Diary)diaryManagement.getDidulerList().getDiduler(index);
		ex.setTitle(title);
		ex.setContent(content);
		ex.setIsPublic(isPublic);
		//작성 날짜 변경 test
//		String location = ex.getImageLocation();
//		Diary obj=new Diary(title,content,location,isPublic);
//		diaryManagement.getDidulerList().getDidulerList().set(index, obj);

		return true;
	}

}
