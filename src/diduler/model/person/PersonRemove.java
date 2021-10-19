package diduler.model.person;

import java.util.*;
public interface PersonRemove
{
	public abstract boolean remove();
	public abstract boolean remove(List<Person> people);
	public abstract boolean remove(String groupName);
	public abstract boolean remove(Person person);
}