package diduler.mainUI;

import diduler.model.schedule.*;

import java.util.*;

public class ScheduleController {
	private ScheduleManagement scheduleManagement;
	private Schedule oldSchedule;
	private List<Integer> selList;
	private static ScheduleController instance;

	static
	{
		instance = new ScheduleController();
	}
	public ScheduleController() {
		scheduleManagement = new ScheduleManagement(new ScheduleList());
	}

	public void setScheduleManagement(ScheduleManagement scheduleManagement)
	{
		this.scheduleManagement = scheduleManagement;
	}
	public static ScheduleController getInstance() {
		return instance;
	}

	public void addSchedule(String title, String content, boolean priority,
			boolean isPublic, Date startDate, Date endDate) {
		scheduleManagement.add(new Schedule(title, content, priority, isPublic,
				startDate, endDate));
	}

	public void setOldSchedule(int sel) {
		oldSchedule = (Schedule) scheduleManagement.getDidulerList()
				.getDidulerList().get(sel);
	}

	public void modify(String title, String content, String startYear,
			String startMon, String startDay, String endYear, String endMon,
			String endDay, String isPublic, String priority) {
		boolean isPub;
		boolean prior;
		if (isPublic.equals("true"))
			isPub = true;
		else
			isPub = false;

		if (priority.equals("true"))
			prior = true;
		else
			prior = false;
		try {

			oldSchedule.setTitle(title);
			oldSchedule.setContent(content);
			oldSchedule
					.setStartDate(new Date(Integer.parseInt(startYear)-1900,
							Integer.parseInt(startMon) - 1, Integer
									.parseInt(startDay)));
			oldSchedule.setEndDate(new Date(Integer.parseInt(endYear)-1900,
					Integer.parseInt(endMon) - 1, Integer.parseInt(endDay)));
			oldSchedule.setIsPublic(isPub);
			oldSchedule.setPriority(prior);
			//System.out.println(oldSchedule);
		} catch (Exception e) {

		}
	}

	public List<String[]> read() {
		List<String[]> list = new LinkedList<String[]>();
		String[] str = new String[3];
		Schedule schedule;

		for (int cnt = 0; cnt < scheduleManagement.getDidulerList()
				.getDidulerListNum(); cnt++) {
			schedule = (Schedule) scheduleManagement.getDidulerList()
					.getDidulerList().get(cnt);
			str[0] = schedule.getTitle();
			str[1] = (1900 + schedule.getWrittenDate().getYear()) + "."
					+ (schedule.getWrittenDate().getMonth() + 1) + "."
					+ schedule.getWrittenDate().getDate();
			str[2] = Boolean.toString(schedule.getIsPublic()).equals("true") ? "공개"
					: "비공개";

			list.add(str.clone());
		}
		return list;
	}

	public List<String[]> searchTodaySchedule(String year, String month, String date) {
		List<String[]> list = new LinkedList<String[]>();
		String[] str = new String[3];
		Schedule schedule;
		selList=new LinkedList<Integer>();
		Date compareDate = new Date(Integer.parseInt(year)-1900, Integer.parseInt(month)-1, Integer.parseInt(date));
		for (int cnt = 0; cnt < scheduleManagement.getDidulerList()
				.getDidulerListNum(); cnt++) {
			schedule = (Schedule) scheduleManagement.getDidulerList()
					.getDidulerList().get(cnt);
			if ((schedule.getStartDate().compareTo(compareDate)<=0)&&(schedule.getEndDate().compareTo(compareDate)>=0)) 
			{	
				selList.add(cnt);
				str[0] = schedule.getTitle();
				str[1] = (1900 + schedule.getWrittenDate().getYear()) + "."
						+ (schedule.getWrittenDate().getMonth() + 1) + "."
						+ schedule.getWrittenDate().getDate();
				str[2] = Boolean.toString(schedule.getIsPublic())
						.equals("true") ? "공개" : "비공개";

				list.add(str.clone());
			}
		}
		return list;
	}

	public ScheduleManagement getScheduleManagement() {
		return scheduleManagement;
	}

	public void remove(int sel) {
		scheduleManagement.getDidulerList().remove(sel);
	}

	public List<String> get(int sel) {
		Schedule schedule = (Schedule) scheduleManagement.getDidulerList()
				.getDidulerList().get(sel);
		LinkedList<String> list = new LinkedList<String>();

		list.add(schedule.getTitle());
		list.add(schedule.getContent());
		list.add((1900 + schedule.getWrittenDate().getYear()) + "."
				+ (schedule.getWrittenDate().getMonth() + 1) + "."
				+ schedule.getWrittenDate().getDate());
		list.add(1900+schedule.getStartDate().getYear() + "");
		list.add(1 + schedule.getStartDate().getMonth() + "");
		list.add(schedule.getStartDate().getDate() + "");
		list.add(1900+schedule.getEndDate().getYear() + "");
		list.add(1 + schedule.getEndDate().getMonth() + "");
		list.add(schedule.getEndDate().getDate() + "");
		list.add(schedule.getIsPublic() + "");
		list.add(schedule.getPriority() + "");
		return list;
	}
	public List<String> getSearch(int sel)
	{
		Schedule schedule = (Schedule) scheduleManagement.getDidulerList()
				.getDidulerList().get(selList.get(sel));
		LinkedList<String> list = new LinkedList<String>();

		list.add(schedule.getTitle());
		list.add(schedule.getContent());
		list.add((1900 + schedule.getWrittenDate().getYear()) + "."
				+ (schedule.getWrittenDate().getMonth() + 1) + "."
				+ schedule.getWrittenDate().getDate());
		list.add(1900+schedule.getStartDate().getYear() + "");
		list.add(1 + schedule.getStartDate().getMonth() + "");
		list.add(schedule.getStartDate().getDate() + "");
		list.add(1900+schedule.getEndDate().getYear() + "");
		list.add(1 + schedule.getEndDate().getMonth() + "");
		list.add(schedule.getEndDate().getDate() + "");
		list.add(schedule.getIsPublic() + "");
		list.add(schedule.getPriority() + "");
		return list;
	}
	public List<Integer> getSelList()
	{
		return selList;
	}
}
