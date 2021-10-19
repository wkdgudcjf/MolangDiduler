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
import diduler.model.person.PersonGroup;
import diduler.model.person.PersonManagement;

public class PersonBackUp {
	public static void importPerson() {
		ObjectInputStream in = null;
		PersonManagement manager = new PersonManagement();
		List<PersonGroup> persongroup = new LinkedList<PersonGroup>();
		try {
			in = new ObjectInputStream(new FileInputStream("import//person.dat"));
			while (true) {
				PersonGroup group = (PersonGroup) in.readObject();
				persongroup.add(group);
			}

		} catch (Exception e) {
		}
		manager.setPersonGroup(persongroup);
		if (persongroup.size() > 0)
			ContactController.getInstance().setPersonM(manager);
	}

	public static void exportPerson() {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("import//person.dat"));
			List<PersonGroup> persongroup = ContactController.getInstance()
					.getPersonM().getPersonGroup();
			for (int i = 0; i < ContactController.getInstance().getPersonM()
					.getGroupNum(); i++)
				out.writeObject(persongroup.get(i));
		} catch (Exception e) {
		}

	}
}
