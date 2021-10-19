package diduler.model.backup;

import java.io.*;
import java.util.StringTokenizer;

import diduler.mainUI.DiaryController;
import diduler.mainUI.ScheduleController;
import diduler.model.diary.DiaryList;
import diduler.model.diary.DiaryManagement;
import diduler.model.schedule.ScheduleList;
import diduler.model.schedule.ScheduleManagement;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class DiaryBackUp {
	private static final int COMPRESSION_LEVEL = 8;
	private static final int BUFFER_SIZE = 64*1024;
	private static final char FS = File.separatorChar;
	public static void imageToFile() throws IOException
	{
		int cnt;
        byte[] buffer = new byte[BUFFER_SIZE];
        FileInputStream finput = null;
        FileOutputStream foutput;
        
        // ������ ������ ���� ��ü�� �����Ѵ�.
        File file = new File("image");
        String filePath = file.getAbsolutePath();

        // ���� �ȿ� �ִ� ���ϵ��� ���� �迭 ��ü�� �����´�.
        File[] fileArray = file.listFiles();
             
        // Zip ������ �����.
        File zfile = new File("import//image.zip");
        // Zip ���� ��ü�� ��� ��Ʈ���� �ִ´�.
        foutput = new FileOutputStream(zfile);

        // ����� ��Ʈ���� �������� �ִ´�.
        ZipOutputStream zoutput = new ZipOutputStream((OutputStream)foutput);

        ZipEntry zentry = null;

        try {
            for (int i=0; i < fileArray.length; i++) 
            {
                // ������ ���� �迭 �� �ϳ��� ������ �Է� ��Ʈ���� �ִ´�.
                finput = new FileInputStream(fileArray[i]);
               
                zentry = new ZipEntry(fileArray[i].getName());

                zoutput.putNextEntry(zentry);
                
              //   ���� ������ ���ϴ°�, 9�� ���� ���� �����.
              //   �� ��� �ӵ��� �� ����. ����Ʈ�� 8.
                
                zoutput.setLevel(COMPRESSION_LEVEL);

                cnt = 0;
                while ((cnt = finput.read(buffer)) != -1)
                {
                    zoutput.write(buffer, 0, cnt);
                }

                finput.close();
                zoutput.closeEntry();
            }
            zoutput.close();
            foutput.close();
        }
        catch (Exception e)
        {
             e.printStackTrace();
        }
        finally 
        {
            if (finput != null) 
            {
            	
                finput.close();
            }
            if (zoutput != null) 
            {
                zoutput.close();
            }
            if (foutput != null) 
            {
                foutput.close();
            }
        }
	}



	public static void importDiary() {

		
		ObjectInputStream in = null;
		DiaryManagement manager = new DiaryManagement();

		try 
		{
			in = new ObjectInputStream(new FileInputStream("import//diary.dat"));
			manager.setDiaryList((DiaryList) in.readObject());
			in.close();
		} 
		catch (Exception e) 
		{
		}
		if (manager.getDiaryList().getDidulerListNum() > 0)
			DiaryController.getInstance().setDiaryManagement(manager);
	
	}
	
	public static void exportDiary() {

		ObjectOutputStream out = null;
		try 
		{
			out = new ObjectOutputStream(new FileOutputStream("import//diary.dat"));
			out.writeObject(DiaryController.getInstance()
					.getDiaryManagement().getDiaryList());
			out.close();
		} 
		catch (Exception e) 
		{
		}

	}
	public static void exportDiary(OutputStream output) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(output);
			if(DiaryController.getInstance().getDiaryManagement().getDiaryList().getDidulerListNum()>0)
			{
				out.writeObject(DiaryController.getInstance().getDiaryManagement().getDiaryList());
			}
			else
			{
				out.writeObject(null);
			}
			out.flush();
		} catch (Exception e) {
		}
	}
	
	public static void fileToImage()
	{
		
		byte[] buffer = new byte[BUFFER_SIZE];
		try
		{
	   File file = new File("import/image.zip");

       FileInputStream finput = new FileInputStream(file);
       ZipInputStream zinput = new ZipInputStream((InputStream)finput);
       ZipEntry entry;
       
       
       //������ Ǯ ���丮�� �����Ѵ�. ���丮 ���� ���� ���ϸ����� �Ѵ�.
       File zipDir = new File("image");
       if (!zipDir.exists()) 
       {
           zipDir.mkdirs();
       }

      
           while ( (entry = zinput.getNextEntry()) != null) 
           {

                   String outputFileNm = entry.getName().replace('/', File.separatorChar);
                 
                   File entryFile = new File("image" + FS + outputFileNm);
                  
                   FileOutputStream foutput = new FileOutputStream(entryFile);
                 
                   int cnt;

                   while ((cnt = zinput.read(buffer)) != -1) 
                   {
                       foutput.write(buffer, 0, cnt);
                   }
                   //System.out.println("zip���� �����θ������");
                  

                   foutput.flush();
                   if (foutput != null)
                   {
                       foutput.close();
                   }
             }
           
		}
		catch (Exception e) 
		{
               e.printStackTrace();
		}
	}
}
       
	


