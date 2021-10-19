package diduler.model.backup;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import diduler.mainUI.DiaryController;
import diduler.model.diary.DiaryList;
import diduler.model.diary.DiaryManagement;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import net.sf.jazzlib.*;

public class BackUp {
	private static final int COMPRESSION_LEVEL = 8;
	private static final int BUFFER_SIZE = 64 * 1024;
	private static final char FS = File.separatorChar;

	public static void allExport(OutputStream out) throws IOException {
		int cnt;
		byte[] buffer = new byte[BUFFER_SIZE];
		FileInputStream finput = null;
		FileOutputStream foutput;

		// 압축할 폴더를 파일 객체로 생성한다.
		File file = new File("import");
		String filePath = file.getAbsolutePath();

		// 폴더 안에 있는 파일들을 파일 배열 객체로 가져온다.
		File[] fileArray = file.listFiles();

		// Zip 파일을 만든다.
		File zfile = new File("import.zip");
		// Zip 파일 객체를 출력 스트림에 넣는다.
		foutput = new FileOutputStream(zfile);

		// 집출력 스트림에 집파일을 넣는다.
		ZipOutputStream zoutput = new ZipOutputStream((OutputStream) foutput);

		ZipEntry zentry = null;

		try {
			for (int i = 0; i < fileArray.length; i++) {
				// 압축할 파일 배열 중 하나를 꺼내서 입력 스트림에 넣는다.
				finput = new FileInputStream(fileArray[i]);

				zentry = new ZipEntry(fileArray[i].getName());

				zoutput.putNextEntry(zentry);

				// 압축 레벨을 정하는것, 9가 가장 높은 압축률.
				// 그 대신 속도는 젤 느림. 디폴트는 8.

				zoutput.setLevel(COMPRESSION_LEVEL);

				cnt = 0;
				while ((cnt = finput.read(buffer)) != -1) {
					zoutput.write(buffer, 0, cnt);
				}

				finput.close();
				zoutput.closeEntry();
			}
			zoutput.close();
			foutput.close();

			DataOutputStream dout = new DataOutputStream(out);
			long size = zfile.length();
			dout.writeLong(size);

			BufferedInputStream bip = new BufferedInputStream(
					new FileInputStream(zfile));
			BufferedOutputStream output = new BufferedOutputStream(out);
			int c;

			while (size != 0) {
				c = bip.read();
				output.write(c);
				size--;
			}
			output.flush();
			bip.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (finput != null) {

				finput.close();
			}
			if (zoutput != null) {
				zoutput.close();
			}
			if (foutput != null) {
				foutput.close();
			}
		}
	}

	public static void allImport(InputStream in) {
		BufferedInputStream input = null; // 받는 input
		BufferedOutputStream fi = null;
		try {
			input = new BufferedInputStream(in);
			fi = new BufferedOutputStream(new FileOutputStream("import.zip"));

			DataInputStream din = new DataInputStream(in);
			long size = din.readLong();

			int c;

			while (size != 0) {
				c = input.read();
				fi.write(c);
				size--;
			}
			fi.flush();
			fi.close();

			byte[] buffer = new byte[BUFFER_SIZE];

			File file = new File("import.zip");

			FileInputStream finput = new FileInputStream(file);
			ZipInputStream zinput = new ZipInputStream((InputStream) finput);
			ZipEntry entry;

			// 압축을 풀 디렉토리를 생성한다. 디렉토리 명은 압축 파일명으로 한다.
			File zipDir = new File("import");
			if (!zipDir.exists()) {
				zipDir.mkdirs();
			}

			while ((entry = zinput.getNextEntry()) != null) {

				String outputFileNm = entry.getName().replace('/',
						File.separatorChar);

				File entryFile = new File("import" + FS + outputFileNm);

				FileOutputStream foutput = new FileOutputStream(entryFile);

				int cnt;

				while ((cnt = zinput.read(buffer)) != -1) {
					foutput.write(buffer, 0, cnt);
				}
				// System.out.println("zip파일 폴더로만드는중");

				foutput.flush();
				if (foutput != null) {
					foutput.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
