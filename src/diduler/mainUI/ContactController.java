package diduler.mainUI;


import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import diduler.model.PersonInfo;
import diduler.model.person.*;

public class ContactController
{
	private PersonManagement personM;
	private Person oldPerson;
	private String oldgroupName;
	private static ContactController instance = new ContactController();
	
	private ContactController()
	{	
	    personM = new PersonManagement();
	    personM.createPersonGroup(new PersonGroup(new LinkedList<Person>(),"미지정"));
	    personM.createPersonGroup(new PersonGroup(new LinkedList<Person>(),"친구"));
	    personM.createPersonGroup(new PersonGroup(new LinkedList<Person>(),"가족"));
	    personM.createPersonGroup(new PersonGroup(new LinkedList<Person>(),"직장"));
	}
	public static ContactController getInstance()
	{
		return instance;
	}
	public void addPerson(String name,String email,String phone,String date,String group)
	{
		Person person = new Person(name,email,phone,date);
		personM.join(person, group);
	}
	public String confirmGroup(String name,String phone)
	{
		return personM.searchGroup(name,phone);
	}
	public void modify(String name,String email,String phone,String date,String group)
	{
		//Person person = new Person(nameField.getText(),emailField1.getText()+"@"+emailField2.getText(),phoneField1.getText()+"-"+phoneField2.getText()+"-"+phoneField3.getText(),monthComboBox.getSelectedItem()+"월 "+dayComboBox.getSelectedItem()+"일");
		Person person = new Person(name,email,phone,date);
		if(oldgroupName.equals(group))
		{
			personM.modify(oldPerson, person);
		}
		else
		{
		    personM.modify(oldPerson,oldgroupName,person,group);
		}
    }
	public void setPersonInfo(Person oldperson,String oldgroupName)
	{
		this.oldPerson=oldperson;
		this.oldgroupName=oldgroupName;
	}

	public Person getOldperson()
	{
		return oldPerson;
	}
	public List<String> search(PersonInfo info,String content)
	{
		List<Person> list;
	  
	    LinkedList<String> str = new LinkedList<String>();
	    	    
	    list=personM.search(info,content);
	    for(int i=0;i<list.size();i++)
	    {
	    	str.add(list.get(i).getName());
	    	str.add(list.get(i).getEmail());
	    	str.add(list.get(i).getPhone());
	    	str.add(list.get(i).getBirthday());
	    }
	    return str;
	}
	public List<String> getWholeTable()
	{
		LinkedList<String> whole1 = new LinkedList<String>();
		for(int i=0;i<personM.getPersonGroup().size();i++)
		{
			for(int j=0;j<personM.getPersonGroup().get(i).getPersonList().size();j++)
			{
				whole1.add(personM.getPersonGroup().get(i).getPersonList().get(j).getName());
				whole1.add(personM.getPersonGroup().get(i).getPersonList().get(j).getEmail());
				whole1.add(personM.getPersonGroup().get(i).getPersonList().get(j).getPhone());
				whole1.add(personM.getPersonGroup().get(i).getPersonList().get(j).getBirthday());
			}
		}
		return whole1;
	}
	public List<String> getDefaultTable()
	{
		
		LinkedList<String> default1 = new LinkedList<String>();
		for(int i=0;i<personM.getPersonGroup().get(0).getPersonList().size();i++)
		{
			default1.add(personM.getPersonGroup().get(0).getPersonList().get(i).getName());
			default1.add(personM.getPersonGroup().get(0).getPersonList().get(i).getEmail());
			default1.add(personM.getPersonGroup().get(0).getPersonList().get(i).getPhone());
			default1.add(personM.getPersonGroup().get(0).getPersonList().get(i).getBirthday());
		}
		return default1;
	}
	public List<String> getFriendTable()
	{
		LinkedList<String> friend1 = new LinkedList<String>();
		for(int i=0;i<personM.getPersonGroup().get(1).getPersonList().size();i++)
		{
			friend1.add(personM.getPersonGroup().get(1).getPersonList().get(i).getName());
			friend1.add(personM.getPersonGroup().get(1).getPersonList().get(i).getEmail());
			friend1.add(personM.getPersonGroup().get(1).getPersonList().get(i).getPhone());
			friend1.add(personM.getPersonGroup().get(1).getPersonList().get(i).getBirthday());
		}
		return friend1;
	}
	public List<String> getFamilyTable()
	{
		LinkedList<String> family1 = new LinkedList<String>();
		for(int i=0;i<personM.getPersonGroup().get(2).getPersonList().size();i++)
		{
			family1.add(personM.getPersonGroup().get(2).getPersonList().get(i).getName());
			family1.add(personM.getPersonGroup().get(2).getPersonList().get(i).getEmail());
			family1.add(personM.getPersonGroup().get(2).getPersonList().get(i).getPhone());
			family1.add(personM.getPersonGroup().get(2).getPersonList().get(i).getBirthday());
		}
		return family1;
	}
	public List<String> getJobTable()
	{
		LinkedList<String> job1 = new LinkedList<String>();
		for(int i=0;i<personM.getPersonGroup().get(3).getPersonList().size();i++)
		{
			job1.add(personM.getPersonGroup().get(3).getPersonList().get(i).getName());
			job1.add(personM.getPersonGroup().get(3).getPersonList().get(i).getEmail());
			job1.add(personM.getPersonGroup().get(3).getPersonList().get(i).getPhone());
			job1.add(personM.getPersonGroup().get(3).getPersonList().get(i).getBirthday());
		}
		return job1;
	}
	public void remove(List<String> list)
	{
		LinkedList<Person> people = new LinkedList<Person>();
		Person person;
		for(int i = 0 ;i<list.size();i+=4)
		{
			person = new Person(list.get(i),list.get(i+1),list.get(i+2),list.get(i+3));
			people.add(person);
		}
		int answer =JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제 확인", JOptionPane.INFORMATION_MESSAGE);
		if(answer==0)
		{
			personM.remove(people);
		}
	}
	public PersonManagement getPersonM()
	{
		return personM;
	}
	public void setPersonM(PersonManagement personM)
	{
		this.personM = personM;
	}
}

