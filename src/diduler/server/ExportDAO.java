package diduler.server;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

import diduler.model.diary.DiaryList;

public class ExportDAO {
	private OutputStream out;
	private String id;

	public ExportDAO() {
		this.out = null;
		this.id = null;
	}

	public ExportDAO(String id, Socket socket) throws Exception {
		this.id = id;
		out = socket.getOutputStream();
	}

	public ExportDAO(String id, OutputStream out) {
		this.id = id;
		this.out = out;
	}

	public void exportAll() 
	{
		exportFile();
	}

	private void exportFile() 
	{
		BufferedOutputStream output = null;
		try 
		{
			output = new BufferedOutputStream(out);
			
			File zfile = new File("import_"+id+".zip");
									
			BufferedInputStream bip = new BufferedInputStream(new FileInputStream(zfile));
            
            long size = zfile.length();
            DataOutputStream dout = new DataOutputStream(out);
            dout.writeLong(size);
			int c;

			while (size!=0) {
				c=bip.read();
				output.write(c);
				size--;
			}
			output.flush();
			bip.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}




	public OutputStream getOut() {
		return out;
	}

	public void setOut(OutputStream out) {
		this.out = out;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
