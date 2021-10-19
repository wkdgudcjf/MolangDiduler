package diduler.mainUI;
/*
import java.util.*;

import diduler.model.DiaryInfo;
import diduler.model.SearchType;
import diduler.model.diary.*;
import java.util.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import diduler.model.diduler.*;

public class DidulerController {

	private DidulerManagement diary;
	private DidulerList list=new DiaryList(); 
	private DiaryList diaryList=new DiaryList();
	//private List<Integer> searchNum=new LinkedList<Integer>();

	public DiaryList getDiaryList() {
		return diaryList;
		
	}

	public void setDiaryList(DiaryList diaryList) {
		this.diaryList = diaryList;
	}
	private static DidulerController instance=new DidulerController();
		
	
	public List<String> getTableValueList()
	{
		List<String> obj=new LinkedList<String>();
	
		for(int cnt=0; cnt<list.getDidulerListNum(); cnt++)
		{
		   obj.add(this.getDiaryTitle(cnt));
		   String date=(1900+getDiaryWrittenDate(cnt).getYear())+"."+(getDiaryWrittenDate(cnt).getMonth()+1)+"."+getDiaryWrittenDate(cnt).getDate();
		   obj.add(date);
		   String isPublic=(getDiaryisPublie(cnt)== true) ? "공개" : "비공개";
		   obj.add(isPublic);
		}
		
		return obj;
	}

	

	public static DidulerController getInstance()
	{
		return instance;
	}

	private DidulerController()  
	{
		this.diary=new DiaryManagement(list);  //리스트를 넣는다
	}
	
	public DidulerManagement getDiary() {
		return diary;
	}

	public void setDiary(DidulerManagement diary) {
		this.diary = diary;
	}
	
    public void addDiary(Diduler diduler)
    {
    	this.diary.add(diduler);
    	this.diaryList.add(diduler);
    }
    public void addDiary(String title, String content, boolean isPublic)
    {
    	this.diary.add(title, content, isPublic);
    	this.diaryList.addDiary(title, content, isPublic);
    }
    public void addDiary(String title,String content)
    {
    	this.diary.add(title, content);
    	this.diaryList.addDiary(title, content, true);
    }
    
    public void addDiary(Diary diary)
    {
    	this.diary.add(diary);
    	this.diaryList.addDiary(diary);
    	
    }
    public void addDiary(String title, String content, Image image, boolean isPublic)
    {
        
        this.diary.add(new Diary(title,content,image,isPublic));
        this.diaryList.addDiary(title, content, image, isPublic);
        
    }
    public void addDiary(String title, String content, String location, boolean isPublic)
    {
    	System.out.println(location);
       
    	Image image;
		try {
			image = ImageIO.read(new File(location)); //파일을 생성 

	        this.diary.add(new Diary(title,content,image,isPublic));
	    	this.diaryList.addDiary(title, content, image, isPublic);
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일아이오익셉션 ");
			e.printStackTrace();
		}
	
        
    }
    
    public void addDiary(String  title, String content, Image image)
    {
    	this.diary.add(new Diary(title,content,image,true));
    	this.diaryList.addDiary(title, content, image);
    }
    

   
    public void removeDiary()
    {  
    	this.diary.remove();
    }
   
    public void removeDiary(int sel)
    {
    	this.diary.remove(sel);
    }
    
    public void removeDiary(int []sel)
    {
    	this.diary.remove(sel);
    	
    }
   
    public List<String> search(SearchType t, String content)
    {
    	List<String> list=new LinkedList<String>();
    	List<Diduler> obj=this.diary.search(t, content);
    	
    	
    	for(int cnt=0; cnt<obj.size(); cnt++)
		{
    		this.searchNum.add();
		   list.add(obj.get(cnt).getTitle());
		   String date=(1900+obj.get(cnt).getWrittenDate().getYear())+"."+(obj.get(cnt).getWrittenDate().getMonth()+1)+"."+obj.get(cnt).getWrittenDate().getDate();
		   list.add(date);
		   String isPublic=(obj.get(cnt).getIsPublic()== true) ? "공개" : "비공개";
		   list.add(isPublic);
		}
		
		
    	
    	return list;
    	
    }
    public void doubleClick()
    {
    	
    }
    

	public Diduler[] search(Date date)  
	{
		return this.diary.search(date);
	}
	
	
	public boolean modify(Diduler oldDiduler, Diduler newDiduler) 
	{
	    	return this.diary.modify(oldDiduler, newDiduler);
	}
	
	
	public boolean modify(Diary oldDiary, Diary newDiary) 
	{
		return this.diary.modify(oldDiary, newDiary);
	
	}
	
	public boolean modify(int index,DiaryInfo field,boolean isPublic)
	{
		//this.diary.
		return true;
	}

	public String getDiaryTitle(int index)
	{
		Diary obj=(Diary)this.diary.getDidulerList().getDiduler(index);
		return obj.getTitle();
	}

	public String getDiaryContent(int index)
	{
		Diary obj=(Diary)this.diary.getDidulerList().getDiduler(index);
		return obj.getContent();
		
		
	}
	public Image getDiaryImage(int index)
	{
		Diary obj=(Diary)this.diary.getDidulerList().getDiduler(index);
		return obj.getImage();	
	}
	
	public boolean getDiaryisPublie(int index)
	{

			Diary obj=(Diary)this.diary.getDidulerList().getDiduler(index);
			return obj.getIsPublic();
	}
	
	public Date getDiaryWrittenDate(int index)
	{
		Diary obj=(Diary)this.diary.getDidulerList().getDiduler(index);
		return obj.getWrittenDate();
		
	}
	
	public boolean modify(int index,String title, String content,Image image,boolean isPublic)
	{
	
		Diary obj=new Diary(title,content,image,isPublic);
		diary.getDidulerList().getDidulerList().set(index, obj);
	
		return true;
		
	}
	public boolean modify(int index,String title, String content,boolean isPublic)
	{
	
		Diary obj=new Diary(title,content,isPublic);
		diary.getDidulerList().getDidulerList().set(index, obj);

		return true;
	}

}
*/

    
    
