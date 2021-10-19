package diduler.model.backup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import diduler.mainUI.ContactController;
import diduler.mainUI.ScheduleController;
import diduler.model.person.PersonGroup;
import diduler.model.person.PersonManagement;
import diduler.model.schedule.Schedule;
import diduler.model.schedule.ScheduleList;
import diduler.model.schedule.ScheduleManagement;

public class ScheduleBackUp {
	
	public static void importSchedule() {
		
		ObjectInputStream in = null;
		ScheduleManagement manager = new ScheduleManagement();
		
		try {
			in = new ObjectInputStream(new FileInputStream("import//schedule.dat"));
			manager.setScheduleList((ScheduleList) in.readObject());
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		if(manager.getScheduleList().getDidulerListNum()>0)	
			ScheduleController.getInstance().setScheduleManagement(manager);
			
	}
		
	public static void exportSchedule() {
		
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("import//schedule.dat"));
			out.writeObject(ScheduleController.getInstance().getScheduleManagement().getScheduleList());
		} catch (Exception e) {
				}
				
	}

}
