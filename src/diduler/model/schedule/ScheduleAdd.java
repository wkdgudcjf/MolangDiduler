package diduler.model.schedule;
import java.util.*;
import diduler.model.diduler.*;

public interface ScheduleAdd extends DidulerAdd{
	void add(String title, String content, boolean priority, boolean isPublic, Alarm alarm, Date startDate, Date endDate);
	void add(String title, String content, Date startDate, Date endDate);
	void add(String title, String content, boolean priority, Alarm alarm, Date startDate, Date endDate);
	void add(String title, String content, boolean priority, boolean isPublic, Date startDate, Date endDate);
}
