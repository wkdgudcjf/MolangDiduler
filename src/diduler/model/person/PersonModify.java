package diduler.model.person;

public interface PersonModify 
{
	public abstract boolean modify(String oldGroupName,String newGroupName);
	public abstract boolean modify(Person oldPerson,Person newPerson);
	public abstract boolean modify(String oldName,String oldPhone ,String newName ,String newPhone);
	public abstract boolean modify(Person oldPerson,String oldGroupName, Person newPerson,String newGroupName);
}
