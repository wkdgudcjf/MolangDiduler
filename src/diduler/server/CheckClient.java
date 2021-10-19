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
		readFile(); //���� �о ����Ʈ�� �ε�
		boolean check=this.manager.checkIdPw(id, pw); 
		if(check==true) //�α��� ������
		{
			writer.println(manager.getMember().get(id).getName());  //�α��� ������ Ŭ���̾�Ʈ���� yes ������
			writer.flush();
			this.list.add(id); //����Ʈ�� ���̵� �߰�
			ExportDAO exportdao=new ExportDAO(id,socket); 
			exportdao.exportAll(); //���� ��������
			
			
			return true;
		}
			
		else
		{	
			writer.println();  //�α��� ������ Ŭ���̾�Ʈ���� yes ������
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
		if(i==-1) //�α��ε� ���̵� ���� ���
		{
			writer.println("no");
			writer.flush();
			return false;
		}
		
		else //����Ʈ�� ���̵� �ִ°��
		{
			writer.println("yes");
			writer.flush();
			this.list.remove(i); //����Ʈ���� ���̵� �����
			ImportDAO importdao=new ImportDAO(id,socket);
			importdao.importAll(); //�α��� ������ ���� �ҷ�����
			return true;
			
		}
	}
	private void close(Socket socket) throws IOException
	{
		socket.close();
	}
	
	private void readFile() //member.dat �����о����
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
