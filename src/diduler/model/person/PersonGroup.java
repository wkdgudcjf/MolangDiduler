package diduler.model.person;

import java.util.*;
public class PersonGroup implements java.io.Serializable
{
	private List<Person> personList;
	private String groupName; 
	public PersonGroup()
	{
		this(new LinkedList<Person>());
	}
	public PersonGroup(List<Person> personList)
	{
		this(personList, "πÃ¡ˆ¡§");
	}
	public PersonGroup(List<Person> personList,String groupName)
	{
		this.personList = personList;
		this.groupName = groupName;
	}
	public List<Person> getPersonList() {
		return personList;
	}
	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public void addPerson(String name,String email ,String phone,String birthday)
	{
		personList.add(new Person(name,email,phone,birthday));
	}
	public void  addPerson(Person person)
	{
		personList.add(person);
	}
	public void removePerson(Person person)  
	{
		personList.remove(person);
	}
	public void removePerson(String name,String phone) 
	{
	    for(int i=0;i<personList.size();i++)
	    {
	        if(personList.get(i).getName().equals(name) && personList.get(i).getPhone().equals(phone))
	        {
	        	personList.remove(i);
	        }
	    }
	}
	public int getPersonNum()
	{
		return personList.size();
	}
}
