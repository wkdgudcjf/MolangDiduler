package diduler.member;


import java.io.Serializable;
import java.util.*;

public class MemberList implements Serializable{
	
	private List<MemberInfo> list;
	
	public MemberList()
	{
		this.list=new LinkedList<MemberInfo>();
	}
	public MemberList(List<MemberInfo> list)
	{
		this.list=list;
	}
	
	public MemberInfo getMemberInfo(int index)
	{
		return this.list.get(index);
	}
	
	public void add(MemberInfo info)
	{
		this.list.add(info);
	}
	
	public void add(String name, String id, String pw, String email,
			String phone, String addr, Date birthday, boolean isMen)
	{
		this.list.add(new MemberInfo(name,id,pw,email,phone,addr,birthday,isMen));
	}
	
	public void add(String name, String id, String pw, String email)
	{
		this.list.add(new MemberInfo(name,id,pw,email));
	}
	
	public void remove()
	{
		this.list.removeAll(list);
	}
	
	public void remove(int index)
	{
		this.list.remove(index);
	}
	public void remove(MemberInfo info)
	{
		this.list.remove(info);
	}
	public MemberInfo get(int index)
	{
		return list.get(index);
	}
	public MemberInfo get(String id) 
	{
		MemberInfo info=null;
		
		for(int i=0; i<this.list.size(); i++)
		{
			String getid=this.list.get(i).getId();
			if(id.equals(getid)) //같은 걸 찾으면 
			{	info=this.list.get(i);
				break;
			}
		}
		return info;
		
	}
	
	public MemberInfo get(String id, String pw)
	{
		
		MemberInfo info=null;
		for(int i=0; i<this.list.size(); i++)
		{
			String getId=this.list.get(i).getId(); 
			String getPw=this.list.get(i).getPw();
			if(id.equals(getId)&&pw.equals(getPw))
			{
				info=this.list.get(i);
				break;
			}
		}
		return info;
	
	}
	
	public MemberInfo get(String id, String name, String email)
	{
		MemberInfo info=null;
		for(int i=0; i<this.list.size(); i++)
		{
			String getId=this.list.get(i).getId(); 
			String getName=this.list.get(i).getName();
			String getEmail=this.list.get(i).getEmail(); 
			if(id.equals(getId)&&name.equals(getName)&&email.equals(getEmail))
			{
				info=this.list.get(i);
				break;
			}
		}
		return info;
	
	}
	

	public boolean set(int index, MemberInfo info)
	{
		this.list.set(index, info);	
		return true;
	}
	public boolean modify(int index,MemberInsert field, String fieldContent)
	{
		MemberInfo find = list.get(index);
		
		if(field == MemberInsert.EMAIL)
			find.setEmail(fieldContent);
		else if(field==MemberInsert.PASSWORD)
			find.setPw(fieldContent);
		else if(field==MemberInsert.PHONE)
			find.setPhone(fieldContent);
			
		return true;
	}
	public int indexOf(MemberInfo info)
	{
		return list.indexOf(info);
	}

	public List<MemberInfo> getList() {
		return list;
	}
	public void setList(List<MemberInfo> list) {
		this.list = list;
	}
	public int size()
	{
		return this.list.size();
	}

}
