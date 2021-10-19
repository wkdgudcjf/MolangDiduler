package diduler.member;

import java.io.Serializable;
import java.util.*;

public class MemberInfo implements Serializable{

	private String name;
	private String id;
	private String pw;
	private String email;
	private String phone;
	private String addr;
	private Date birthday;
	private boolean isMen;
	
	public MemberInfo()
	{
		
	}
	


	public MemberInfo(String name, String id, String pw, String email) {
		this(name, id, pw, email, "","",new Date(),true);
		
	}
	public MemberInfo(String name, String id, String pw, String email, String addr, String phone, Date birthday, boolean isMen)
	{
		this.name = name; this.id = id; this.pw=pw; this.email = email; this.addr =addr; this.phone= phone; this.birthday = birthday; this.isMen=isMen;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public boolean isMen() {
		return isMen;
	}



	public void setMen(boolean isMen) {
		this.isMen = isMen;
	}


}
