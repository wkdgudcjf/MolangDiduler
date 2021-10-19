package diduler.server;

import java.io.*;
import java.util.*;
import java.net.*;

import diduler.member.MemberList;
import diduler.member.MemberManagement;
import diduler.server.dao.MemberIO;

public class CheckClient 
{
	private List<String> list ;
	private MemberManagement manager;
	
	public CheckClient()
	{
		this.list=new LinkedList<String>();
		this.manager=new MemberManagement(); 
	}
	public CheckClient(List<String> list,MemberManagement manager)
	{
		this.list=list;
		this.manager=manager;
	}
	
	
	public boolean login(Socket socket) throws Exception
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer=new PrintWriter(socket.getOutputStream());
		
		
		String id=reader.readLine(); //id
		String pw=reader.readLine(); //pw
		readFile(); //파일 읽어서 리스트에 로딩
		boolean check=this.manager.checkIdPw(id, pw); 
		if(check==true) //로그인 성공시
		{
			writer.println(manager.getMember().get(id).getName());  //로그인 성공시 클라이언트에게 yes 보낸다
			writer.flush();
			this.list.add(id); //리스트에 아이디 추가
			ExportDAO exportdao=new ExportDAO(id,socket); 
			exportdao.exportAll(); //파일 내보내기
			
			
			return true;
		}
			
		else
		{	
			writer.println();  //로그인 성공시 클라이언트에게 yes 보낸다
			writer.flush();
			return false;
			
		}
		
			
	}
	
	public boolean logout(Socket socket) throws Exception
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer=new PrintWriter(socket.getOutputStream());
		String id=reader.readLine(); //id
		
		int i=this.list.indexOf(id);
		if(i==-1) //로그인된 아이디 없는 경우
		{
			writer.println("no");
			writer.flush();
			return false;
		}
		
		else //리스트에 아이디 있는경우
		{
			writer.println("yes");
			writer.flush();
			this.list.remove(i); //리스트에서 아이디 지우고
			ImportDAO importdao=new ImportDAO(id,socket);
			importdao.importAll(); //로그인 성공시 파일 불러오기
			return true;
			
		}
	}
	private void close(Socket socket) throws IOException
	{
		socket.close();
	}
	
	private void readFile() //member.dat 파일읽어오기
	{	
		this.manager.setMember(MemberIO.memberImport());
	}
	
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public MemberManagement getManager() {
		return manager;
	}
	public void setManager(MemberManagement manager) {
		this.manager = manager;
	}
}
