package diduler.mainUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class WeekCalendarUI extends JPanel {

	private class ListMouseListener extends MouseAdapter {
		private DiaryController con = DiaryController.getInstance();
		public void mouseClicked(MouseEvent e) {

			if (e.getClickCount() == 2) {
				
				if ((JTable) e.getSource() == scheduleList[0]) {
					/*
					List<String> list =con.getSearch(scheduleList[0].getSelectedRow());

					Image bk=null;
					try {
						if(list.get(2)!=null)
							bk = ImageIO.read(new File(list.get(2))); //파일을 생성 

					} catch (IOException ie) {
					}
					new ViewDiaryUI(list.get(0),list.get(1),bk,list.get(3),con.getSelList().get(diaryTable.getSelectedRow()),diaryTable, new String[]{yearLabel_day.getText(),monthLabel_day.getText(),dayLabel_day.getText()}).setVisible(true);
*/
					// 일요일 일정 더블클릭
				} else if ((JTable) e.getSource() == scheduleList[1]) {
					// 월요일 일정 더블클릭
				} else if ((JTable) e.getSource() == scheduleList[2]) {
					// 화요일 일정 더블클릭
				} else if ((JTable) e.getSource() == scheduleList[3]) {
					// 수요일 일정 더블클릭
				} else if ((JTable) e.getSource() == scheduleList[4]) {
					// 목요일 일정 더블클릭
				} else if ((JTable) e.getSource() == scheduleList[5]) {
					// 금요일 일정 더블클릭
				} else if ((JTable) e.getSource() == scheduleList[6]) {
					// 토요일 일정 더블클릭
				} else if ((JTable) e.getSource() == diaryList[0]) {
					// 일요일 다이어리 더블클릭
				} else if ((JTable) e.getSource() == diaryList[1]) {
					// 월요일 다이어리 더블클릭
				} else if ((JTable) e.getSource() == diaryList[2]) {
					// 화요일 다이어리 더블클릭
				} else if ((JTable) e.getSource() == diaryList[3]) {
					// 수요일 다이어리 더블클릭
				} else if ((JTable) e.getSource() == diaryList[4]) {
					// 목요일 다이어리 더블클릭
				} else if ((JTable) e.getSource() == diaryList[5]) {
					// 금요일 다이어리 더블클릭
				} else if ((JTable) e.getSource() == diaryList[6]) {
					// 토요일 다이어리 더블클릭
				}
			}
		}
	}

	private class ButtonListener implements ActionListener {
		private CalendarController control = new CalendarController();

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == upYear_week) {
				yearLabel_week.setText((Integer.parseInt(yearLabel_week
						.getText()) + 1) + "");
				monthLabel_week.setText("1");
				weekLabel_week.setText("1");
			} else if (e.getSource() == downYear_week) {
				yearLabel_week.setText((Integer.parseInt(yearLabel_week
						.getText()) - 1) + "");
				monthLabel_week.setText("1");
				weekLabel_week.setText("1");
			} else if (e.getSource() == upMonth_week) {
				if (monthLabel_week.getText().equals("12")) {
					yearLabel_week.setText((Integer.parseInt(yearLabel_week
							.getText()) + 1) + "");
					monthLabel_week.setText("1");
				} else
					monthLabel_week.setText((Integer.parseInt(monthLabel_week
							.getText()) + 1) + "");
				weekLabel_week.setText("1");
			} else if (e.getSource() == downMonth_week) {
				if (monthLabel_week.getText().equals("1")) {
					yearLabel_week.setText((Integer.parseInt(yearLabel_week
							.getText()) - 1) + "");
					monthLabel_week.setText("12");
				} else
					monthLabel_week.setText((Integer.parseInt(monthLabel_week
							.getText()) - 1) + "");
				weekLabel_week.setText("1");
			} else if (e.getSource() == upWeek_week) {
				if (Integer.parseInt(weekLabel_week.getText()) == control
						.getMaximumInWeekUI(
								Integer.parseInt(yearLabel_week.getText()),
								Integer.parseInt(monthLabel_week.getText()))) {
					if (monthLabel_week.getText().equals("12")) {
						yearLabel_week.setText((Integer.parseInt(yearLabel_week
								.getText()) + 1) + "");
						monthLabel_week.setText("1");
						weekLabel_week.setText("1");
					} else {
						monthLabel_week.setText((Integer
								.parseInt(monthLabel_week.getText()) + 1) + "");
						weekLabel_week.setText("1");
					}
				} else {
					weekLabel_week.setText((Integer.parseInt(weekLabel_week
							.getText()) + 1) + "");
				}
			} else if (e.getSource() == downWeek_week) {
				if (weekLabel_week.getText().equals("1")) {
					if (monthLabel_week.getText().equals("1")) {
						yearLabel_week.setText((Integer.parseInt(yearLabel_week
								.getText()) - 1) + "");
						monthLabel_week.setText("12");
						weekLabel_week.setText(control.getMaximumInWeekUI(
								Integer.parseInt(yearLabel_week.getText()),
								Integer.parseInt(monthLabel_week.getText()))
								+ "");
					} else {
						monthLabel_week.setText((Integer
								.parseInt(monthLabel_week.getText()) - 1) + "");
						weekLabel_week.setText(control.getMaximumInWeekUI(
								Integer.parseInt(yearLabel_week.getText()),
								Integer.parseInt(monthLabel_week.getText()))
								+ "");
					}
				} else {
					weekLabel_week.setText((Integer.parseInt(weekLabel_week
							.getText()) - 1) + "");
				}

			}
			LinkedList<String> list = control.getDateInWeekUI(
					Integer.parseInt(yearLabel_week.getText()),
					Integer.parseInt(monthLabel_week.getText()),
					Integer.parseInt(weekLabel_week.getText()));
			for (int i = 0; i < 7; i++)
				date[i].setText(list.get(i));
			setting();
		}
	}

	private JLabel[] date = new JLabel[7];

	private JTable[] scheduleList = new JTable[7];
	private JTable[] diaryList = new JTable[7];

	private JLabel monthLabel_week;
	private JLabel yearLabel_week;
	private JButton downMonth_week;
	private JButton downWeek_week;
	private JButton downYear_week;
	private JButton upMonth_week;
	private JButton upWeek_week;
	private JButton upYear_week;
	private JLabel weekLabel_week;

	private void setting()
	{
		for(int i=0; i<7; i++)
		{
			DefaultTableModel model = (DefaultTableModel)scheduleList[i].getModel();
			
			while(model.getRowCount()>0)
				model.removeRow(0);			
			
			model = (DefaultTableModel)diaryList[i].getModel();
			
			while(model.getRowCount()>0)
				model.removeRow(0);
		}
		DiaryController dcon = DiaryController.getInstance();
		String arr[] = new String[1];
		List<String> list=null;
		int year=0;
		int month=0;
		int dat=0;
		try {
			year = Integer.parseInt(yearLabel_week.getText());
			month = Integer.parseInt(monthLabel_week.getText());
		} catch (Exception e) {
			// TODO: handle exception
		}
		for(int i=0; i<7; i++)
		{
			if(i!=0)
			{
				try {
					if(Integer.parseInt(date[i-1].getText())+1==Integer.parseInt(date[i].getText()))
						list = dcon.searchTodayDiary(i, year+"", month+"", date[i].getText());
					else
					{
						if(month==12)
						{
							year++;
							month=1;
							list = dcon.searchTodayDiary(i, year+"", month+"", date[i].getText());
						}
						else
						{
							month++;
							list = dcon.searchTodayDiary(i, year+"", month+"", date[i].getText());
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			else
			{
				list = dcon.searchTodayDiary(i, yearLabel_week.getText(), monthLabel_week.getText(), date[i].getText());
			}
			DefaultTableModel model = (DefaultTableModel)diaryList[i].getModel();
			for (int cnt = 0; cnt < list.size(); cnt++) {
				arr[0]= list.get(cnt);
				model.addRow(arr.clone());
			}
		}
	}
	public void setVisible(boolean b) {
		super.setVisible(b);
		setting();
	}

	public WeekCalendarUI() {
		ListMouseListener listListener;

		JLabel jLabel55;
		JLabel jLabel56;
		JLabel jLabel57;
		JLabel jLabel58;
		JLabel jLabel59;
		JLabel jLabel60;
		JLabel jLabel61;
		JScrollPane jScrollPane1;
		JScrollPane jScrollPane10;
		JScrollPane jScrollPane11;
		JScrollPane jScrollPane12;
		JScrollPane jScrollPane13;
		JScrollPane jScrollPane14;
		JScrollPane jScrollPane15;
		JScrollPane jScrollPane16;
		JScrollPane jScrollPane17;

		JScrollPane jScrollPane5;
		JScrollPane jScrollPane6;
		JScrollPane jScrollPane7;
		JScrollPane jScrollPane8;
		JScrollPane jScrollPane9;
		JSeparator jSeparator6;
		JSeparator jSeparator7;
		JSeparator jSeparator8;
		JSeparator jSeparator9;
		JSeparator jSeparator10;
		JSeparator jSeparator11;
		JSeparator jSeparator16;

		jLabel55 = new JLabel();
		jLabel56 = new JLabel();
		jLabel57 = new JLabel();
		jLabel58 = new JLabel();
		jLabel59 = new JLabel();
		jLabel60 = new JLabel();
		jLabel61 = new JLabel();
		String colNames[] = {"Diary"};
		String colNames2[] = {"Schedule"};
		for (int i = 0; i < 7; i++) {
			date[i] = new JLabel();
			

			date[i].setFont(new java.awt.Font("휴먼명조", 1, 14)); // NOI18N
			date[i].setForeground(new java.awt.Color(0, 0, 0));
			date[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(date[i]);
		
			
			DefaultTableModel model = new DefaultTableModel(colNames, 0){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}
			};
			DefaultTableModel model2 = new DefaultTableModel(colNames2, 0){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}
			};

			diaryList[i] = new JTable(model);
			scheduleList[i] = new JTable(model2);
			
			diaryList[i].setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
			scheduleList[i].setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
			
			
		}
		date[0].setForeground(new java.awt.Color(255, 0, 0));
		date[6].setForeground(new java.awt.Color(0, 0, 255));
		
		date[0].setBounds(50, 90, 40, 17);
		date[1].setBounds(150, 90, 40, 17);
		date[2].setBounds(250, 90, 40, 17);
		date[3].setBounds(350, 90, 40, 17);
		date[4].setBounds(450, 90, 40, 17);
		date[5].setBounds(550, 90, 40, 17);
		date[6].setBounds(640, 90, 40, 17);

		jSeparator6 = new JSeparator();
		jSeparator7 = new JSeparator();
		jSeparator8 = new JSeparator();
		jSeparator9 = new JSeparator();
		jSeparator10 = new JSeparator();
		jSeparator16 = new JSeparator();
		jSeparator11 = new JSeparator();
		jScrollPane1 = new JScrollPane();
		jScrollPane5 = new JScrollPane();
		jScrollPane6 = new JScrollPane();
		jScrollPane7 = new JScrollPane();
		jScrollPane8 = new JScrollPane();
		jScrollPane9 = new JScrollPane();
		jScrollPane10 = new JScrollPane();
		jScrollPane11 = new JScrollPane();
		jScrollPane12 = new JScrollPane();
		jScrollPane13 = new JScrollPane();
		jScrollPane14 = new JScrollPane();
		jScrollPane15 = new JScrollPane();
		jScrollPane16 = new JScrollPane();
		jScrollPane17 = new JScrollPane();

		jSeparator6.setOrientation(SwingConstants.VERTICAL);
		add(jSeparator6);
		jSeparator6.setBounds(620, 60, 10, 310);

		jSeparator7.setOrientation(SwingConstants.VERTICAL);
		add(jSeparator7);
		jSeparator7.setBounds(110, 60, 10, 310);

		jSeparator8.setOrientation(SwingConstants.VERTICAL);
		add(jSeparator8);
		jSeparator8.setBounds(220, 60, 10, 310);

		jSeparator9.setOrientation(SwingConstants.VERTICAL);
		add(jSeparator9);
		jSeparator9.setBounds(320, 60, 10, 310);

		jSeparator10.setOrientation(SwingConstants.VERTICAL);
		add(jSeparator10);
		jSeparator10.setBounds(420, 60, 10, 310);

		jSeparator16.setOrientation(SwingConstants.VERTICAL);
		add(jSeparator16);
		jSeparator16.setBounds(520, 60, 10, 310);
		upYear_week = new JButton();
		downYear_week = new JButton();
		weekLabel_week = new JLabel();
		upWeek_week = new JButton();
		downWeek_week = new JButton();
		downMonth_week = new JButton();
		upYear_week.setText(">");
		monthLabel_week = new JLabel("", SwingConstants.CENTER);
		upMonth_week = new JButton();

		yearLabel_week = new JLabel("", SwingConstants.CENTER);
		yearLabel_week.setText(Calendar.getInstance().get(Calendar.YEAR) + "");
		add(yearLabel_week);
		yearLabel_week.setBounds(200, 10, 50, 16);

		add(upYear_week);
		upYear_week.setBounds(260, 10, 41, 20);

		downYear_week.setText("<");
		add(downYear_week);
		downYear_week.setBounds(150, 10, 41, 20);

		weekLabel_week.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		weekLabel_week.setText(Calendar.getInstance().get(
				Calendar.WEEK_OF_MONTH)
				+ "");
		add(weekLabel_week);
		weekLabel_week.setBounds(550, 10, 19, 20);

		JLabel week = new JLabel("주");
		add(week);
		week.setBounds(565, 11, 20, 20);

		upWeek_week.setText(">");
		add(upWeek_week);
		upWeek_week.setBounds(590, 10, 41, 20);

		downWeek_week.setText("<");
		add(downWeek_week);
		downWeek_week.setBounds(500, 10, 41, 20);

		setBackground(new java.awt.Color(255, 255, 255));
		setLayout(null);

		yearLabel_week.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jLabel55.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		jLabel55.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel55.setText("Sat");
		add(jLabel55);
		jLabel55.setBounds(630, 40, 50, 19);

		jLabel56.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		jLabel56.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel56.setText("Sun");
		add(jLabel56);
		jLabel56.setBounds(40, 40, 50, 19);

		jLabel57.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		jLabel57.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel57.setText("Mon");
		add(jLabel57);
		jLabel57.setBounds(140, 40, 50, 19);

		jLabel58.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		jLabel58.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel58.setText("Tue");
		add(jLabel58);
		jLabel58.setBounds(240, 40, 50, 19);

		jLabel59.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		jLabel59.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel59.setText("Wed");
		add(jLabel59);
		jLabel59.setBounds(340, 40, 50, 19);

		jLabel60.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		jLabel60.setText("Thur");
		add(jLabel60);
		jLabel60.setBounds(440, 40, 50, 19);

		jLabel61.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		jLabel61.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel61.setText("Fri");
		add(jLabel61);
		jLabel61.setBounds(540, 40, 50, 19);

		downMonth_week.setText("<");
		add(downMonth_week);
		downMonth_week.setBounds(340, 10, 41, 20);

		monthLabel_week.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		monthLabel_week.setText(Calendar.getInstance().get(Calendar.MONTH) + 1
				+ "");
		add(monthLabel_week);
		monthLabel_week.setBounds(390, 10, 26, 20);

		upMonth_week.setText(">");
		add(upMonth_week);
		upMonth_week.setBounds(430, 10, 41, 20);

		jScrollPane5.setViewportView(scheduleList[2]);

		add(jScrollPane5);
		jScrollPane5.setBounds(230, 130, 80, 100);

		jScrollPane6.setViewportView(scheduleList[0]);

		add(jScrollPane6);
		jScrollPane6.setBounds(20, 130, 80, 100);

		jScrollPane8.setViewportView(scheduleList[1]);

		add(jScrollPane8);
		jScrollPane8.setBounds(130, 130, 80, 100);

		jScrollPane10.setViewportView(scheduleList[3]);

		add(jScrollPane10);
		jScrollPane10.setBounds(330, 130, 80, 100);

		jScrollPane12.setViewportView(scheduleList[4]);

		add(jScrollPane12);
		jScrollPane12.setBounds(430, 130, 80, 100);

		jScrollPane14.setViewportView(scheduleList[5]);

		add(jScrollPane14);
		jScrollPane14.setBounds(530, 130, 80, 100);

		jScrollPane16.setViewportView(scheduleList[6]);

		add(jScrollPane16);
		jScrollPane16.setBounds(630, 130, 80, 100);

		add(jSeparator11);
		jSeparator11.setBounds(10, 120, 690, 20);

		listListener = new ListMouseListener();
		for (int i = 0; i < 7; i++) {
			diaryList[i].addMouseListener(listListener);
			scheduleList[i].addMouseListener(listListener);
		}

		ButtonListener buttonListener = new ButtonListener();
		downMonth_week.addActionListener(buttonListener);
		downWeek_week.addActionListener(buttonListener);
		downYear_week.addActionListener(buttonListener);
		upMonth_week.addActionListener(buttonListener);
		upWeek_week.addActionListener(buttonListener);
		upYear_week.addActionListener(buttonListener);

		jScrollPane7.setViewportView(diaryList[0]);

		add(jScrollPane7);
		jScrollPane7.setBounds(20, 260, 80, 110);

		jScrollPane9.setViewportView(diaryList[1]);

		add(jScrollPane9);
		jScrollPane9.setBounds(130, 260, 80, 110);

		jScrollPane1.setViewportView(diaryList[2]);

		add(jScrollPane1);
		jScrollPane1.setBounds(230, 260, 80, 110);

		jScrollPane11.setViewportView(diaryList[3]);

		add(jScrollPane11);
		jScrollPane11.setBounds(330, 260, 80, 110);

		jScrollPane13.setViewportView(diaryList[4]);

		add(jScrollPane13);
		jScrollPane13.setBounds(430, 260, 80, 110);

		jScrollPane15.setViewportView(diaryList[5]);

		add(jScrollPane15);
		jScrollPane15.setBounds(530, 260, 80, 110);

		jScrollPane17.setViewportView(diaryList[6]);

		add(jScrollPane17);
		jScrollPane17.setBounds(630, 260, 80, 110);

		LinkedList<String> list = new CalendarController().getDateInWeekUI(
				Integer.parseInt(yearLabel_week.getText()),
				Integer.parseInt(monthLabel_week.getText()),
				Integer.parseInt(weekLabel_week.getText()));
		for (int i = 0; i < 7; i++)
			date[i].setText(list.get(i));
		
		
	}
}
