package diduler.mainUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DayCalendarUI extends JPanel {

	private JButton downYear_day;
	private JButton downDay_day;
	private JButton downMonth_day;
	private JButton upDay_day;
	private JButton upMonth_day;
	private JButton upYear_day;

	private JLabel monthLabel_day;
	private JLabel yearLabel_day;
	private JLabel dayLabel_day;

	private JTable scheduleTable; // 이거 이름 scheduleTable로 바꾸기
	private JTable diaryTable; // 이거 이름 diaryTable로 바꾸기
	
	private class ButtonListener implements ActionListener
	{
		
		private CalendarController control = new CalendarController();
	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==upYear_day)
			{
				yearLabel_day.setText((Integer.parseInt(yearLabel_day.getText())+1)+"");
				dayLabel_day.setText("1");
			}
			else if(e.getSource()==downYear_day)
			{
				yearLabel_day.setText((Integer.parseInt(yearLabel_day.getText())-1)+"");
				dayLabel_day.setText("1");
			}
			else if(e.getSource()==upMonth_day)
			{
				if(monthLabel_day.getText().equals("12"))
				{
					yearLabel_day.setText((Integer.parseInt(yearLabel_day.getText())+1)+"");
					monthLabel_day.setText("1");
					dayLabel_day.setText("1");
				}
				else
				{
					monthLabel_day.setText((Integer.parseInt(monthLabel_day.getText())+1)+"");
					dayLabel_day.setText("1");
				}	
			}
			else if(e.getSource()==downMonth_day)
			{
				if(monthLabel_day.getText().equals("1"))
				{
					yearLabel_day.setText((Integer.parseInt(yearLabel_day.getText())-1)+"");
					monthLabel_day.setText("12");
					dayLabel_day.setText("1");
				}
				else
				{
					monthLabel_day.setText((Integer.parseInt(monthLabel_day.getText())-1)+"");
					dayLabel_day.setText("1");
				}
			}
			else if(e.getSource()==upDay_day)
			{
				
				int maxDate = control.getDateInDayUI(Integer.parseInt(yearLabel_day.getText()), Integer.parseInt(monthLabel_day.getText()));
				if(dayLabel_day.getText().equals(maxDate+""))
				{
					if(monthLabel_day.getText().equals("12"))
					{
						yearLabel_day.setText((Integer.parseInt(yearLabel_day.getText())+1)+"");
						monthLabel_day.setText("1");
						dayLabel_day.setText("1");
					}
					else
					{
						monthLabel_day.setText((Integer.parseInt(monthLabel_day.getText())+1)+"");
						dayLabel_day.setText("1");
					}
				}
				else
					dayLabel_day.setText((Integer.parseInt(dayLabel_day.getText())+1)+"");
			}
			else if(e.getSource()==downDay_day)
			{
				if(dayLabel_day.getText().equals("1"))
				{
					if(monthLabel_day.getText().equals("1"))
					{
						yearLabel_day.setText((Integer.parseInt(yearLabel_day.getText())-1)+"");
						monthLabel_day.setText("12");
						dayLabel_day.setText(""+control.getDateInDayUI(Integer.parseInt(yearLabel_day.getText()), Integer.parseInt(monthLabel_day.getText())));
					}
					else
					{
						monthLabel_day.setText((Integer.parseInt(monthLabel_day.getText())-1)+"");
						dayLabel_day.setText(""+control.getDateInDayUI(Integer.parseInt(yearLabel_day.getText()), Integer.parseInt(monthLabel_day.getText())));
					}
				}
				else
					dayLabel_day.setText((Integer.parseInt(dayLabel_day.getText())-1)+"");	
			}
			ScheduleController control = ScheduleController.getInstance();
			List<String[]> list = control.searchTodaySchedule(yearLabel_day.getText(),monthLabel_day.getText(),dayLabel_day.getText());
			String[] arr = new String[3];
			int size = list.size();
			
			DefaultTableModel model = (DefaultTableModel)scheduleTable.getModel();
		
			while(model.getRowCount()>0)
				model.removeRow(0);
			
			for (int cnt = 0; cnt < size; cnt++) {
				arr[0] = list.get(cnt)[0];
				arr[1] = list.get(cnt)[1];
				arr[2] = list.get(cnt)[2];
				
				model.addRow(arr);
			}
			DiaryController control1 = DiaryController.getInstance();
			list = control1.searchTodayDiary(yearLabel_day.getText(),monthLabel_day.getText(),dayLabel_day.getText());
			arr = new String[3];
			size = list.size();
			
			DefaultTableModel model1 = (DefaultTableModel)diaryTable.getModel();
		
			while(model1.getRowCount()>0)
				model1.removeRow(0);
			
			for (int cnt = 0; cnt < size; cnt++) {
				arr[0] = list.get(cnt)[0];
				arr[1] = list.get(cnt)[1];
				arr[2] = list.get(cnt)[2];
				
				model1.addRow(arr);
			}
			
		}
		
	}
	public DayCalendarUI() {
		initComponents();
		
	}

	private void initComponents() {

		MouseAdapter tableMouseListener = new TableMouseListener();
		yearLabel_day = new JLabel("",SwingConstants.CENTER);
		upYear_day = new JButton();
		downYear_day = new JButton();
		dayLabel_day = new JLabel("",SwingConstants.CENTER);
		upDay_day = new JButton();
		downDay_day = new JButton();

		downMonth_day = new JButton();
		monthLabel_day = new JLabel("",SwingConstants.CENTER);
		upMonth_day = new JButton();
		JLabel diaryLabel = new JLabel();
		JLabel scheduleLabel = new JLabel();
		JScrollPane schedule = new JScrollPane();
		scheduleTable = new JTable();
		JScrollPane diary = new JScrollPane();
		diaryTable = new JTable();

		this.setBackground(new java.awt.Color(255, 255, 255));
		this.setLayout(null);

		yearLabel_day.setFont(new java.awt.Font("함초롬돋움", 0, 14)); // NOI18N
		yearLabel_day.setText(Calendar.getInstance().get(Calendar.YEAR)+"");
		this.add(yearLabel_day);
		yearLabel_day.setBounds(180, 10, 50, 19);

		upYear_day.setText(">");
		this.add(upYear_day);
		upYear_day.setBounds(240, 10, 41, 20);

		downYear_day.setText("<");
		this.add(downYear_day);
		downYear_day.setBounds(130, 10, 41, 20);

		dayLabel_day.setFont(new java.awt.Font("함초롬돋움", 0, 14)); // NOI18N
		dayLabel_day.setText(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"");
		this.add(dayLabel_day);
		dayLabel_day.setBounds(540, 10, 30, 20);

		upDay_day.setText(">");
		this.add(upDay_day);
		upDay_day.setBounds(580, 10, 41, 20);

		downDay_day.setText("<");
		this.add(downDay_day);
		downDay_day.setBounds(490, 10, 41, 20);

		downMonth_day.setText("<");
		this.add(downMonth_day);
		downMonth_day.setBounds(310, 10, 41, 20);

		monthLabel_day.setFont(new java.awt.Font("함초롬돋움", 0, 14)); // NOI18N
		monthLabel_day.setText(1+Calendar.getInstance().get(Calendar.MONTH)+"");
		this.add(monthLabel_day);
		monthLabel_day.setBounds(370, 10, 30, 20);

		upMonth_day.setText(">");
		this.add(upMonth_day);
		upMonth_day.setBounds(410, 10, 41, 20);

		diaryLabel.setFont(new java.awt.Font("함초롬돋움", 0, 14)); // NOI18N
		diaryLabel.setForeground(new java.awt.Color(51, 51, 255));
		diaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		diaryLabel.setText("다이어리");
		diaryLabel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(
				0, 0, 0)));
		this.add(diaryLabel);
		diaryLabel.setBounds(80, 190, 70, 30);

		scheduleLabel.setFont(new java.awt.Font("함초롬돋움", 0, 14)); // NOI18N
		scheduleLabel.setForeground(new java.awt.Color(0, 0, 255));
		scheduleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scheduleLabel.setText("일정");
		scheduleLabel.setBorder(BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		this.add(scheduleLabel);
		scheduleLabel.setBounds(80, 50, 50, 30);

		schedule.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N

		scheduleTable.setFont(new java.awt.Font("함초롬돋움", 1, 14)); // NOI18N
		scheduleTable.addMouseListener(tableMouseListener); // 추가 리스너

		scheduleTable.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null } }, new String[] {
				"          제목", "          날짜", "       공개범위" }) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		});

		schedule.setViewportView(scheduleTable);

		this.add(schedule);
		schedule.setBounds(100, 90, 540, 90);

		diary.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		diaryTable.setFont(new java.awt.Font("함초롬돋움", 1, 14)); // NOI18N

		diaryTable.addMouseListener(tableMouseListener); // 추가 리스너

		diaryTable.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null } }, new String[] {
				"          제목", "          날짜", "       공개범위" }) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		});
		diary.setViewportView(diaryTable);

		this.add(diary);
		diary.setBounds(100, 230, 540, 90);

		ButtonListener buttonListener = new ButtonListener();
		downYear_day.addActionListener(buttonListener);
		downDay_day.addActionListener(buttonListener);
		downMonth_day.addActionListener(buttonListener);
		upDay_day.addActionListener(buttonListener);
		upMonth_day.addActionListener(buttonListener);
		upYear_day.addActionListener(buttonListener);

	}
	
	public void setVisible(boolean b)
	{
		super.setVisible(b);
		DiaryController control1 = DiaryController.getInstance();
		List<String[]> list = control1.searchTodayDiary(yearLabel_day.getText(),monthLabel_day.getText(),dayLabel_day.getText());
		String[] arr = new String[3];
		int size = list.size();
		DefaultTableModel model = (DefaultTableModel)diaryTable.getModel();
	
		while(model.getRowCount()>0)
			model.removeRow(0);
		
		
		for (int cnt = 0; cnt < size; cnt++) {
			arr[0] = list.get(cnt)[0];
			arr[1] = list.get(cnt)[1];
			arr[2] = list.get(cnt)[2];
			
			model.addRow(arr);
		}
		
		ScheduleController control = ScheduleController.getInstance();
		list = control.searchTodaySchedule(yearLabel_day.getText(),monthLabel_day.getText(),dayLabel_day.getText());
		arr = new String[3];
		size = list.size();
		DefaultTableModel model1 = (DefaultTableModel)scheduleTable.getModel();
	
		while(model1.getRowCount()>0)
			model1.removeRow(0);
		
		for (int cnt = 0; cnt < size; cnt++) {
			arr[0] = list.get(cnt)[0];
			arr[1] = list.get(cnt)[1];
			arr[2] = list.get(cnt)[2];
			
			model1.addRow(arr);
		}
	}
	private class TableMouseListener extends MouseAdapter {
		private DiaryController con = DiaryController.getInstance();
		private ScheduleController scon = ScheduleController.getInstance();
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) //더블클릭
			{
				if((scheduleTable.getSelectedRowCount()==1)&&(diaryTable.getSelectedRowCount()==0))
				{
					List<String> list =scon.getSearch(scheduleTable.getSelectedRow());
					ViewScheduleUI viewSchedule = new ViewScheduleUI(new String[]{yearLabel_day.getText(),monthLabel_day.getText(),dayLabel_day.getText()},scheduleTable,scheduleTable.getSelectedRow(), scon.getSelList().get(scheduleTable.getSelectedRow()), list.get(0), list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8), list.get(9),list.get(10));
					viewSchedule.setVisible(true);
				}
				else if((scheduleTable.getSelectedRowCount()==0)&&(diaryTable.getSelectedRowCount()==1)) //다이어리 
				{
					List<String> list =con.getSearch(diaryTable.getSelectedRow());

					Image bk=null;
					try {
						if(list.get(2)!=null)
							bk = ImageIO.read(new File(list.get(2))); //파일을 생성 

					} catch (IOException ie) {
					}
					new ViewDiaryUI(list.get(0),list.get(1),bk,list.get(3),con.getSelList().get(diaryTable.getSelectedRow()),diaryTable, new String[]{yearLabel_day.getText(),monthLabel_day.getText(),dayLabel_day.getText()}).setVisible(true);
				}
				else
				{
					scheduleTable.clearSelection();
					diaryTable.clearSelection();
				}
			}
			
		}

	}

}
