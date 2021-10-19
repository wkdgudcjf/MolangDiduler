package diduler.server.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import diduler.member.MemberList;

public class MemberIO {
	public static MemberList memberImport()
	{

		try {
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream("backup\\member.dat"));
			return (MemberList)reader.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new MemberList();
	}
}
