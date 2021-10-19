package diduler.model.person;

import java.util.*;

import diduler.model.PersonInfo;

public class PersonManagement implements java.io.Serializable,PersonJoin,PersonModify,PersonRemove,PersonSearch
{
	private List<PersonGroup> personGroup;
	public PersonManagement()
	{
		personGroup = new LinkedList<PersonGroup>();
	}
	public PersonManagement(List<PersonGroup> personGroup)
	{
		this.personGroup=personGroup;
	}
	public List<PersonGroup> getPersonGroup() 
	{
		return personGroup;
	}
	public List<Person> search(PersonInfo info, String content) 
	{
		List<Person> tmp = new LinkedList<Person>();
		if(info==PersonInfo.NAME)
		{
			for(int i=0;i<personGroup.size();i++)
			{
				for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
				{
					if(personGroup.get(i).getPersonList().get(j).getName().contains(content))
					{
						tmp.add(personGroup.get(i).getPersonList().get(j));
					}
				}
			}
			return tmp;
		}
		else if(info==PersonInfo.BIRTHDAY)
		{
			for(int i=0;i<personGroup.size();i++)
			{
				for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
				{
					if(personGroup.get(i).getPersonList().get(j).getBirthday().contains(content))
					{
						tmp.add(personGroup.get(i).getPersonList().get(j));
					}
				}
			}
			return tmp;
		}
		else if(info==PersonInfo.EMAIL)
		{
			for(int i=0;i<personGroup.size();i++)
			{
				for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
				{
					if(personGroup.get(i).getPersonList().get(j).getEmail().contains(content))
					{
						tmp.add(personGroup.get(i).getPersonList().get(j));
					}
				}
			}
			return tmp;
		}
		else
		{
			for(int i=0;i<personGroup.size();i++)
			{
				for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
				{
					if(personGroup.get(i).getPersonList().get(j).getPhone().contains(content))
					{
						tmp.add(personGroup.get(i).getPersonList().get(j));
					}
				}
			}
			return tmp;
		}
	}
	public PersonGroup search(String personGroup) 
	{
		for(int i=0;i<this.personGroup.size();i++)
		{
			if(this.personGroup.get(i).getGroupName().equals(personGroup))
			{
				return this.personGroup.get(i);
			}
		}
		return null;
	}
	public boolean remove()
	{
		for(int i=0;i<personGroup.size();i++)
		{
			for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
			{
				personGroup.get(i).getPersonList().remove(j);
			}
		}
		return true;
	}
	public boolean remove(List<Person> list) //false 할수잇는경우..
    {		
		for(int i=0 ; i<list.size() ; i++)
		{
			for(int j=0;j<personGroup.size();j++)
			{
				if(personGroup.get(j).getPersonList().indexOf(list.get(i))!=-1)
				{
					personGroup.get(j).getPersonList().remove(list.get(i));
				}
			}
		}
		return true;
	/*	for(int i=0;i<personGroup.size();i++)
		{
			for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
			{
				for(int k=0 ; k<people.size() ; k++)
				{
					if(personGroup.get(i).getPersonList().get(j).equals(people.get(k)))
					{
						personGroup.get(i).removePerson(people.get(k));
					}
				}
			}
		}
		return true;*/
	}
	public boolean remove(String groupName) 
	{
		for(int i=0;i<personGroup.size();i++)
		{
			if(personGroup.get(i).getGroupName().equals(groupName))
			{
				for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
				{
					personGroup.get(i).getPersonList().remove(i);
				}
				return true;
			}
		}
		return false;
	}
	public boolean remove(Person person)
	{
		for(int i=0;i<personGroup.size();i++)
		{
			for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
			{
				if(personGroup.get(i).getPersonList().get(j).equals(person))
				{
					personGroup.get(i).removePerson(person);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean modify(String oldGroupName, String newGroupName) 
	{
		for(int i=0;i<personGroup.size();i++)
		{
			if(personGroup.get(i).getGroupName().equals(oldGroupName))
			{
				personGroup.get(i).setGroupName(newGroupName);
				return true;
			}
		}
		return false;
	}
	public boolean modify(Person oldPerson, Person newPerson)
	{
		for(int i=0;i<personGroup.size();i++)
		{
			for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
			{
				if(personGroup.get(i).getPersonList().get(j).equals(oldPerson))
				{
					personGroup.get(i).getPersonList().get(j).modify(newPerson);
					return true;
				}
			}
		}
		return false;
	}
	public boolean modify(Person oldPerson,String oldGroupName, Person newPerson,String newGroupName) //새로운오버라이딩
	{
		remove(oldPerson);
		boolean check = join(newPerson,newGroupName);
		if(check==false)
			return false;
		return true;
	}
	public boolean modify(String oldName, String oldPhone, String newName,String newPhone) 
	{
		for(int i=0;i<personGroup.size();i++)
		{
			for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
			{
				if(personGroup.get(i).getPersonList().get(j).getName().equals(oldName)&&personGroup.get(i).getPersonList().get(j).getPhone().equals(oldPhone))
				{
					personGroup.get(i).getPersonList().get(j).setName(newName);
					personGroup.get(i).getPersonList().get(j).setName(newPhone);
					return true;
				}
			}
		}
		return false;
	}
	public String searchGroup(String name,String phone)
	{
		for(int i=0;i<personGroup.size();i++)
		{
			for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
			{
				if(personGroup.get(i).getPersonList().get(j).getName().equals(name)&&personGroup.get(i).getPersonList().get(j).getPhone().equals(phone))
				{
				    return personGroup.get(i).getGroupName();
				}
			}
		}
		return null;
	}
	public boolean join(Person person)
	{
		for(int i=0;i<personGroup.size();i++)
		{
			for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
			{
				if(personGroup.get(i).getPersonList().get(j).getName().equals(person.getName())&&personGroup.get(i).getPersonList().get(j).getPhone().equals(person.getPhone()))
				{
					return false;
				}
			}
		}
		for(int i=0;i<personGroup.size();i++)
		{
			if(personGroup.get(i).getGroupName().equals("미지정"))
			{
				personGroup.get(i).getPersonList().add(person);
			}
		}
		return true;
	}
	public boolean join(Person person, String groupName) 
	{
		for(int i=0;i<personGroup.size();i++)
		{
			for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
			{
				if(personGroup.get(i).getPersonList().get(j).getName().equals(person.getName())&&personGroup.get(i).getPersonList().get(j).getPhone().equals(person.getPhone()))
				{
					return false;
				}
			}
		}
		for(int i=0;i<personGroup.size();i++)
		{
			if(personGroup.get(i).getGroupName().equals(groupName))
			{
				personGroup.get(i).getPersonList().add(person);
			}
		}
		return true;
	}
	public boolean join(String name, String email, String phone,String birthday, String groupName) 
	{	
		for(int i=0;i<personGroup.size();i++)
		{
			for(int j=0;j<personGroup.get(i).getPersonList().size();j++)
			{
				if(personGroup.get(i).getPersonList().get(j).getName().equals(name)&&personGroup.get(i).getPersonList().get(j).getPhone().equals(phone))
				{
					return false;
				}
			}
		}
		for(int i=0;i<personGroup.size();i++)
		{
			if(personGroup.get(i).getGroupName().equals(groupName))
			{
				personGroup.get(i).getPersonList().add(new Person(name,email,phone,birthday));
			}
		}
		return true;
	}
	public void setPersonGroup(List<PersonGroup> personGroup) 
	{
		this.personGroup = personGroup;
	}
	public int getGroupNum()
	{
		return personGroup.size();
	}
	public void createPersonGroup(PersonGroup personGroup)
	{
		this.personGroup.add(personGroup);
	}
}
