package diduler.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import diduler.member.MemberInfo;
import diduler.member.MemberList;
import diduler.model.diary.Diary;
import diduler.model.diary.DiaryList;
import diduler.model.person.Person;
import diduler.model.person.PersonGroup;
import diduler.model.schedule.Schedule;
import diduler.model.schedule.ScheduleList;


public class Translator {
	
	private ObjectInputStream in; 
	private ObjectOutputStream out;
	
	public Translator()
	{
		new File("backup").mkdir();
	}
	public Translator(ObjectInputStream in)
	{
		this.in=in;
	}
	public Translator(ObjectOutputStream out)
	{
		this.out=out;
		new File("backup").mkdir();
	}
	
	public List<String[]> diaryToArray()
	{
		File[] file = new File("backup\\").listFiles();
		List<String []> list = new LinkedList<String[]>();
		for(int i=0; i<file.length; i++)
		{
			if(file[i].isDirectory())
			{
				File[] file2 = file[i].listFiles();
				for(int j=0; j<file2.length; j++)
				{
					if(file2[j].getName().equals("diary.dat"))
					{
						try {
							in = new ObjectInputStream(new FileInputStream(file2[j]));
							DiaryList d = (DiaryList)in.readObject();
							String name =file[i].getName();
							for(int k=0; k<d.size(); k++)
							{
								Diary diary = (Diary)d.getDiduler(k);
								if(diary.getIsPublic())
									list.add(new String[]{name, diary.getTitle(), diary.getContent(), "공개", diary.getImageLocation(), (diary.getWrittenDate().getYear()+1900)+"/"+(diary.getWrittenDate().getMonth()+1)+"/"+diary.getWrittenDate().getDate()}.clone());
								else
									list.add(new String[]{name, diary.getTitle(), diary.getContent(), "비공개", diary.getImageLocation(), (diary.getWrittenDate().getYear()+1900)+"/"+(diary.getWrittenDate().getMonth()+1)+"/"+diary.getWrittenDate().getDate()}.clone());
							}
								
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return list;
	}
	
	public List<String[]> memberToArray() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		MemberList memlist =null;
		in = new ObjectInputStream(new FileInputStream("backup\\member.dat"));
		memlist =(MemberList) in.readObject();
		List<String[]> list = new LinkedList<String[]>(); 
		
		for(int i=0; i<memlist.size(); i++)
		{
			MemberInfo info = memlist.get(i);
			if(info.isMen())
				list.add(new String[]{info.getId(), info.getPw(), info.getName(), (info.getBirthday().getYear()+1900)+"/"+(info.getBirthday().getMonth()+1)+"/"+info.getBirthday().getDate(), "남", info.getPhone(), info.getAddr(), info.getEmail()}.clone());
			else
				list.add(new String[]{info.getId(), info.getPw(), info.getName(), (info.getBirthday().getYear()+1900)+"/"+(info.getBirthday().getMonth()+1)+"/"+info.getBirthday().getDate(), "여", info.getPhone(), info.getAddr(), info.getEmail()}.clone());
		}
		close(in);
		return list;
	}
	public List<String[]> scheduleToArray()
	{
		File[] file = new File("backup\\").listFiles();
		List<String []> list = new LinkedList<String[]>();
		for(int i=0; i<file.length; i++)
		{
			if(file[i].isDirectory())
			{
				File[] file2 = file[i].listFiles();
				for(int j=0; j<file2.length; j++)
				{
					if(file2[j].getName().equals("schedule.dat"))
					{
						try {
							
							in = new ObjectInputStream(new FileInputStream(file2[j]));
							ScheduleList d = (ScheduleList)in.readObject();
							String name =file[i].getName();
							
							for(int k=0; k<d.size(); k++)
							{
								Schedule schedule = (Schedule)d.getDiduler(k);
								if(schedule.getIsPublic())
									list.add(new String[]{name, schedule.getTitle(), schedule.getContent(), (schedule.getStartDate().getYear()+1900)+"/"+(schedule.getStartDate().getMonth()+1)+"/"+schedule.getStartDate().getDate(), (schedule.getEndDate().getYear()+1900)+"/"+(schedule.getEndDate().getMonth()+1)+"/"+schedule.getEndDate().getDate(),"공개"}.clone());
								else
									list.add(new String[]{name, schedule.getTitle(), schedule.getContent(), (schedule.getStartDate().getYear()+1900)+"/"+(schedule.getStartDate().getMonth()+1)+"/"+schedule.getStartDate().getDate(), (schedule.getEndDate().getYear()+1900)+"/"+(schedule.getEndDate().getMonth()+1)+"/"+schedule.getEndDate().getDate(),"비공개"}.clone());
							}
								
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		/*
		for(int i=0; i<list.size();i++)
		{
			for(int j=0; j<list.get(i).length; j++)
				System.out.println(list.get(i)[j]);
		}
		*/
		return list;
	}
	public List<String[]> contactToArray()
	{
		File[] file = new File("backup\\").listFiles();
		List<String []> list = new LinkedList<String[]>();
		for(int i=0; i<file.length; i++)
		{
			if(file[i].isDirectory())
			{
				File[] file2 = file[i].listFiles();
				for(int j=0; j<file2.length; j++)
				{
					if(file2[j].getName().equals("person.dat"))
					{
						try {
							
							in = new ObjectInputStream(new FileInputStream(file2[j]));
							String name =file[i].getName();
							while(true)
							{
								PersonGroup group = (PersonGroup) in.readObject();
								for(int k=0; k<group.getPersonNum(); k++)
								{
									Person person = (Person) group.getPersonList().get(k);

									list.add(new String[]{name, person.getName(), person.getPhone(), person.getEmail(), person.getBirthday(),group.getGroupName()}.clone());
								}
							}
							
						} catch (Exception e) {
						}
					}
				}
			}
		}
		
		return list;
	}
	
	public void arrayToDiary(ResultSet rs) throws SQLException, FileNotFoundException, IOException
	{
		HashMap<String, DiaryList> map = new HashMap<String, DiaryList>();
		
		while(rs.next())
		{
			String id = rs.getString("id");
			String title = rs.getString("title");
			String content = rs.getString("Content");
			String public_scope = rs.getString("Public_scope");
			String image = rs.getString("Image_url");

			boolean scope;
			if(public_scope.equals("공개"))
				scope = true;
			else scope = false;

			if(map.containsKey(id))
				map.get(id).addDiary(title, content, image, scope);
			else
			{
				map.put(id, new DiaryList());
				map.get(id).addDiary(title, content, image, scope);
			}
		}
		
		Set<String> keyset = map.keySet();
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext())
		{
			String key = iter.next();
			String loc = "backup\\"+key;
			new File(loc).mkdir();
			out = new ObjectOutputStream(new FileOutputStream("backup\\"+key+"\\diary.dat"));
			out.writeObject(map.get(key));
		}
		close(out);
	}

	public void arrayToMember(ResultSet rs) throws SQLException, FileNotFoundException, IOException
	{
		MemberList memlist = new MemberList();
		while(rs.next())
		{
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			Date birth = rs.getDate("birthday");
			String sex = rs.getString("sex");
			String phone = rs.getString("phone");
			String address = rs.getString("addr");
			String email = rs.getString("email");
			
			if(sex.equals("남"))	
				memlist.add(name, id, password, email, phone, address, birth, true);
			else
				memlist.add(name, id, password, email, phone, address, birth, false);
		}
		out = new ObjectOutputStream(new FileOutputStream("backup\\member.dat"));
		out.writeObject(memlist);
		close(out);
	}
	public void arrayToSchedule(ResultSet rs) throws SQLException, FileNotFoundException, IOException
	{
		HashMap<String, ScheduleList> map = new HashMap<String, ScheduleList>();
		
		while(rs.next())
		{
			String id = rs.getString("id");
			String title = rs.getString("title");
			String content = rs.getString("Content");
			Date sd = rs.getDate("startdate");
			Date ed = rs.getDate("enddate");
			String public_scope = rs.getString("Public_scope");

			boolean scope;
			if(public_scope.equals("공개"))
				scope = true;
			else scope = false;

			if(map.containsKey(id))
			{
				Schedule temp = new Schedule(title, content, sd, ed);
				temp.setIsPublic(scope);
				map.get(id).add(temp);
			}
			else
			{
				map.put(id, new ScheduleList());
				Schedule temp = new Schedule(title, content, sd, ed);
				temp.setIsPublic(scope);
				map.get(id).add(temp);
			}
		}
		
		Set<String> keyset = map.keySet();
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext())
		{
			String key = iter.next();
			String loc = "backup\\"+key;
			new File(loc).mkdir();
			out = new ObjectOutputStream(new FileOutputStream("backup\\"+key+"\\schedule.dat"));
			out.writeObject(map.get(key));
			close(out);
		}
		
	}
	public void arrayToContact(ResultSet rs) throws SQLException, FileNotFoundException, IOException
	{
		HashMap<String, List<PersonGroup>> map = new HashMap<String, List<PersonGroup>>();
		
		while(rs.next())
		{
			String id = rs.getString("id");
			String name = rs.getString("contact_name");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			String birthday = rs.getString("birthday");
			String group = rs.getString("contact_group");

			if(!map.containsKey(id))
			{
				List<PersonGroup> list = new LinkedList<PersonGroup>();
				list.add(new PersonGroup());
				list.add(new PersonGroup());
				list.add(new PersonGroup());
				list.add(new PersonGroup());
				map.put(id, list);
				
			}
			if(group.equals("미지정"))
				map.get(id).get(0).addPerson(name, email, phone, birthday);
			else if(group.equals("친구"))
				map.get(id).get(1).addPerson(name, email, phone, birthday);
			else if(group.equals("가족"))
				map.get(id).get(2).addPerson(name, email, phone, birthday);
			else if(group.equals("직장"))
				map.get(id).get(3).addPerson(name, email, phone, birthday);
		}
		
		Set<String> keyset = map.keySet();
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext())
		{
			String key = iter.next();
			String loc = "backup\\"+key;
			new File(loc).mkdir();
			out = new ObjectOutputStream(new FileOutputStream("backup\\"+key+"\\person.dat"));
			for(int i=0; i<map.get(key).size(); i++)
				out.writeObject(map.get(key).get(i));
			close(out);
		}
		
	}
	
	
	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}
	
	private void close(ObjectInputStream in) throws IOException
	{
		in.close();
	}
	private void close(ObjectOutputStream out) throws IOException
	{
		out.close();
	}
	
}
