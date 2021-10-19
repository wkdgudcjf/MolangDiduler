package diduler.model.person;

public interface PersonJoin 
{
	public abstract boolean join(Person person);
	public abstract boolean join(Person person ,String groupName);
	public abstract boolean join(String name,String email,String phone,String birthday,String groupName);
}
