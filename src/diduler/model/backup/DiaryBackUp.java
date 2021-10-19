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
        
        // 압축할 폴더를 파일 객체로 생성한다.
        File file = new File("image");
        String filePath = file.getAbsolutePath();

        // 폴더 안에 있는 파일들을 파일 배열 객체로 가져온다.
        File[] fileArray = file.listFiles();
             
        // Zip 파일을 만든다.
        File zfile = new File("import//image.zip");
        // Zip 파일 객체를 출력 스트림에 넣는다.
        foutput = new FileOutputStream(zfile);

        // 집출력 스트림에 집파일을 넣는다.
        ZipOutputStream zoutput = new ZipOutputStream((OutputStream)foutput);

        ZipEntry zentry = null;

        try {
            for (int i=0; i < fileArray.length; i++) 
            {
                // 압축할 파일 배열 중 하나를 꺼내서 입력 스트림에 넣는다.
                finput = new FileInputStream(fileArray[i]);
               
                zentry = new ZipEntry(fileArray[i].getName());

                zoutput.putNextEntry(zentry);
                
              //   압축 레벨을 정하는것, 9가 가장 높은 압축률.
              //   그 대신 속도는 젤 느림. 디폴트는 8.
                
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
       
       
       //압축을 풀 디렉토리를 생성한다. 디렉토리 명은 압축 파일명으로 한다.
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
                   //System.out.println("zip파일 폴더로만드는중");
                  

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
       
	


