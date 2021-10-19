package diduler.model.person;

import java.util.*;
import diduler.model.*;
public interface PersonSearch
{
	public abstract List<Person> search(PersonInfo info,String content);
	public abstract PersonGroup search(String personGroup);
}
