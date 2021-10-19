package diduler.member;

import java.util.Date;

public class MemberManagement {

	private MemberList member;
	
	public MemberManagement()
	{
		this.member=new MemberList();
	}
	
	public MemberManagement(MemberList member)
	{
		this.member=member;
	}
	public void join(MemberInfo info)
	{
		this.member.add(info);
	}
	public void join(String name, String id,String pw, String email)
	{
		this.member.add(name, id, pw, email);
	}
	public void join(String name, String id, String pw, String email,String phone, String addr, Date birthday, boolean isMen)
	{
		this.member.add(name, id, pw, email, phone, addr, birthday, isMen);
	}
	
	public boolean checkIdPw(MemberInfo info)
	{
		if(this.member.indexOf(info)!=-1)
			return true;
		else
			return false;
		
	}
	public boolean checkIdPw(String id, String pw)
	{
		if(this.member.get(id, pw)!=null)
			return true;
		else
			return false;
		
	}
	
	public void withdraw(int index)
	{
		this.member.remove(index);
	}
	public void withdraw(MemberInfo info)
	{
		this.member.remove(info);
	}
	public MemberList getMember() {
		return member;
	}

	public void setMember(MemberList member) {
		this.member = member;
	}

}
	