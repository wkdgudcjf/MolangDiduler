package diduler.model.schedule;
import diduler.model.diduler.*;

import java.util.*;

public interface ScheduleModify extends DidulerModify{
	boolean modify(Schedule schedule, ScheduleInfo field, String fieldContent);
	boolean modify(Schedule schedule, ScheduleInfo field, boolean fieldContent);
	boolean modify(Schedule schedule, ScheduleInfo field, Date fieldContent);
	boolean modify(Schedule schedule, ScheduleInfo field, Alarm fieldContent);
}
