package diduler.mainUI;

import java.awt.event.*;
import java.util.Calendar;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewScheduleUI extends JFrame {

	private JButton cancelButton;
	private JButton deleteButton;
	private JButton modifyButton;

	private JTextField titleTextField;
	private JTextArea contentArea;
	private JLabel writtenDateLabel;

	private JComboBox startYearCombo;
	private JComboBox startDayCombo;
	private JComboBox startMonCombo;
	private JComboBox endYearCombo;
	private JComboBox endMonCombo;
	private JComboBox endDayCombo;
	private JComboBox isPublicCombo;
	private JComboBox priorityCombo;

	private JTable jtable;
	private int sel;
	private int sel2;
	private String[] date;

	public ViewScheduleUI() {
		initComponents();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}

	public ViewScheduleUI(JTable jtable, int sel, String title, String content,
			String writtenDate, String startYear, String startMon,
			String startDay, String endYear, String endMon, String endDay,
			String isPublic, String priority) {
		this.date = null;
		initComponents();
		this.sel = sel;
		this.sel2 = sel;
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		this.jtable = jtable;
		ScheduleController.getInstance().setOldSchedule(sel);
		this.titleTextField.setText(title);
		this.contentArea.setText(content);
		this.writtenDateLabel.setText(writtenDate);
		this.startYearCombo.setSelectedItem(startYear);
		this.startMonCombo.setSelectedItem(startMon);
		this.startDayCombo.setSelectedItem(startDay);
		this.endYearCombo.setSelectedItem(endYear);
		this.endMonCombo.setSelectedItem(endMon);
		this.endDayCombo.setSelectedItem(endDay);
		if (isPublic.equals("true"))
			this.isPublicCombo.setSelectedItem("공개");
		else
			this.isPublicCombo.setSelectedItem("비공개");
		if (priority.equals("true"))
			this.priorityCombo.setSelectedItem("중요");
		else
			this.priorityCombo.setSelectedItem("보통");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		System.out.println(isPublic + priority);
	}

	public ViewScheduleUI(String [] date,JTable jtable, int sel, int sel2, String title,
			String content, String writtenDate, String startYear,
			String startMon, String startDay, String endYear, String endMon,
			String endDay, String isPublic, String priority) {
		this.date = date;
		initComponents();
		this.sel = sel;
		this.sel2 = sel2;
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		this.jtable = jtable;
		ScheduleController.getInstance().setOldSchedule(sel);
		this.titleTextField.setText(title);
		this.contentArea.setText(content);
		this.writtenDateLabel.setText(writtenDate);
		this.startYearCombo.setSelectedItem(startYear);
		this.startMonCombo.setSelectedItem(startMon);
		this.startDayCombo.setSelectedItem(startDay);
		this.endYearCombo.setSelectedItem(endYear);
		this.endMonCombo.setSelectedItem(endMon);
		this.endDayCombo.setSelectedItem(endDay);
		if (isPublic.equals("true"))
			this.isPublicCombo.setSelectedItem("공개");
		else
			this.isPublicCombo.setSelectedItem("비공개");
		if (priority.equals("true"))
			this.priorityCombo.setSelectedItem("중요");
		else
			this.priorityCombo.setSelectedItem("보통");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		/*
		 * 이 부분이 day panel에서 수정할때 부르는 부분
		 */
		System.out.println("1."+isPublic+priority);
		System.out.println(sel+""+sel2);
	}

	private void initComponents() {
		JLabel startYearLabel;
		JLabel startDayLabel;
		JLabel startMonLabel;
		JLabel endDayLabel;
		JLabel endMonLabel;
		JLabel endYearLabel;
		JLabel termLabel;
		JLabel tiltLabel;
		JLabel timeLabel;
		JLabel titleLabel;
		JLabel imageLabel;
		JLabel isPublicLabel;
		JLabel priorityLabel;
		JPanel schedulePanel;
		JScrollPane jScrollPane;

		schedulePanel = new JPanel();
		titleLabel = new JLabel();
		timeLabel = new JLabel();
		writtenDateLabel = new JLabel();
		modifyButton = new JButton();
		deleteButton = new JButton();
		cancelButton = new JButton();
		jScrollPane = new JScrollPane();
		contentArea = new JTextArea();
		imageLabel = new JLabel();
		isPublicLabel = new JLabel();
		isPublicCombo = new JComboBox();
		priorityLabel = new JLabel();
		priorityCombo = new JComboBox();
		termLabel = new JLabel();
		titleTextField = new JTextField();
		startYearCombo = new JComboBox();
		startYearLabel = new JLabel();
		startDayCombo = new JComboBox();
		startMonLabel = new JLabel();
		startMonCombo = new JComboBox();
		startDayLabel = new JLabel();
		tiltLabel = new JLabel();
		endYearCombo = new JComboBox();
		endYearLabel = new JLabel();
		endMonCombo = new JComboBox();
		endMonLabel = new JLabel();
		endDayCombo = new JComboBox();
		endDayLabel = new JLabel();

		setTitle("일정 보기");

		schedulePanel.setBackground(new java.awt.Color(255, 255, 255));
		schedulePanel.setPreferredSize(new java.awt.Dimension(440, 450));
		schedulePanel.setLayout(null);

		titleLabel.setText("제   목: ");
		schedulePanel.add(titleLabel);
		titleLabel.setBounds(10, 10, 44, 23);

		timeLabel.setText("시   간: ");
		schedulePanel.add(timeLabel);
		timeLabel.setBounds(10, 100, 44, 15);

		writtenDateLabel.setText("글쓴시간");
		schedulePanel.add(writtenDateLabel);
		writtenDateLabel.setBounds(60, 100, 73, 15);

		modifyButton.setText("수  정");
		schedulePanel.add(modifyButton);
		modifyButton.setBounds(140, 384, 73, 23);

		deleteButton.setText("삭  제");
		schedulePanel.add(deleteButton);
		deleteButton.setBounds(240, 384, 73, 23);

		cancelButton.setText("취  소");
		schedulePanel.add(cancelButton);
		cancelButton.setBounds(335, 384, 75, 23);

		contentArea.setColumns(20);
		contentArea.setRows(5);
		contentArea.setEnabled(false);
		jScrollPane.setViewportView(contentArea);

		schedulePanel.add(jScrollPane);
		jScrollPane.setBounds(12, 156, 425, 210);

		imageLabel.setIcon(new ImageIcon("그림8.png")); // NOI18N
		schedulePanel.add(imageLabel);
		imageLabel.setBounds(350, 110, 50, 40);

		isPublicLabel.setText("공개범위:");
		schedulePanel.add(isPublicLabel);
		isPublicLabel.setBounds(10, 130, 60, 15);

		isPublicCombo.setModel(new DefaultComboBoxModel(new String[] { "공개",
				"비공개" }));
		isPublicCombo.setEnabled(false);
		schedulePanel.add(isPublicCombo);
		isPublicCombo.setBounds(70, 125, 70, 21);

		priorityLabel.setText("중요도:");
		schedulePanel.add(priorityLabel);
		priorityLabel.setBounds(160, 130, 60, 15);

		priorityCombo.setModel(new DefaultComboBoxModel(new String[] { "중요",
				"보통" }));
		priorityCombo.setEnabled(false);
		schedulePanel.add(priorityCombo);
		priorityCombo.setBounds(210, 125, 60, 21);

		termLabel.setText("기   간: ");
		schedulePanel.add(termLabel);
		termLabel.setBounds(10, 40, 44, 23);

		titleTextField.setEnabled(false);
		schedulePanel.add(titleTextField);
		titleTextField.setBounds(60, 10, 375, 25);

		startYearCombo.setEnabled(false);
		schedulePanel.add(startYearCombo);
		startYearCombo.setBounds(10, 70, 65, 21);

		startYearLabel.setText("년");
		schedulePanel.add(startYearLabel);
		startYearLabel.setBounds(75, 75, 12, 15);

		startMonCombo.setEnabled(false);
		schedulePanel.add(startMonCombo);
		startMonCombo.setBounds(90, 70, 50, 21);

		startMonLabel.setText("월");
		schedulePanel.add(startMonLabel);
		startMonLabel.setBounds(140, 75, 12, 15);

		startDayCombo.setEnabled(false);
		schedulePanel.add(startDayCombo);
		startDayCombo.setBounds(155, 70, 50, 21);

		startDayLabel.setText("일");
		schedulePanel.add(startDayLabel);
		startDayLabel.setBounds(205, 75, 12, 15);

		tiltLabel.setText("~");
		schedulePanel.add(tiltLabel);
		tiltLabel.setBounds(220, 75, 9, 15);

		endYearCombo.setEnabled(false);
		schedulePanel.add(endYearCombo);
		endYearCombo.setBounds(230, 70, 65, 21);

		endYearLabel.setText("년");
		schedulePanel.add(endYearLabel);
		endYearLabel.setBounds(295, 75, 12, 15);

		endMonCombo.setEnabled(false);
		schedulePanel.add(endMonCombo);
		endMonCombo.setBounds(310, 70, 50, 21);

		endMonLabel.setText("월");
		schedulePanel.add(endMonLabel);
		endMonLabel.setBounds(360, 75, 12, 15);

		endDayCombo.setEnabled(false);
		schedulePanel.add(endDayCombo);
		endDayCombo.setBounds(375, 70, 50, 21);

		endDayLabel.setText("일");
		schedulePanel.add(endDayLabel);
		endDayLabel.setBounds(425, 75, 12, 15);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(schedulePanel,
				GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(schedulePanel,
				GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));

		pack();

		// 이로운 리스너
		calendarSetting();

		ScheduleButtonListener scheduleListener = new ScheduleButtonListener();
		ComboBoxListener comboBoxListener = new ComboBoxListener();

		modifyButton.addActionListener(scheduleListener);
		deleteButton.addActionListener(scheduleListener);
		cancelButton.addActionListener(scheduleListener);

		startYearCombo.addActionListener(comboBoxListener);
		startMonCombo.addActionListener(comboBoxListener);
		endYearCombo.addActionListener(comboBoxListener);
		endMonCombo.addActionListener(comboBoxListener);
	}

	public void calendarSetting() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day);
		int lastDay = calendar.getActualMaximum(Calendar.DATE);

		for (int cnt = year - 10; cnt <= year + 10; cnt++) {
			startYearCombo.addItem(Integer.toString(cnt));
			endYearCombo.addItem(Integer.toString(cnt));
		}
		startYearCombo.setSelectedItem(Integer.toString(year));
		endYearCombo.setSelectedItem(Integer.toString(year));

		for (int cnt = 1; cnt <= 12; cnt++) {
			startMonCombo.addItem(Integer.toString(cnt));
			endMonCombo.addItem(Integer.toString(cnt));
		}
		startMonCombo.setSelectedItem(Integer.toString(month));
		endMonCombo.setSelectedItem(Integer.toString(month));

		for (int cnt = 1; cnt <= lastDay; cnt++) {
			startDayCombo.addItem(Integer.toString(cnt));
			endDayCombo.addItem(Integer.toString(cnt));
		}
		startDayCombo.setSelectedItem(Integer.toString(day));
		endDayCombo.setSelectedItem(Integer.toString(day));
	}

	private class ComboBoxListener implements ActionListener // 콤보박스
	{
		public ComboBoxListener() {
		}

		public int getMaxDay(JComboBox yearCombo, JComboBox monthCombo) {
			Calendar calendar = Calendar.getInstance();
			int year = Integer.parseInt((String) yearCombo.getSelectedItem());
			int month = Integer.parseInt((String) monthCombo.getSelectedItem());
			calendar.set(year, month - 1, 1);

			return calendar.getActualMaximum(Calendar.DATE);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == (JComboBox) startYearCombo
					|| e.getSource() == (JComboBox) startMonCombo) {
				int maxDay = getMaxDay(startYearCombo, startMonCombo);
				startDayCombo.removeAllItems();
				for (int cnt = 1; cnt <= maxDay; cnt++) {
					startDayCombo.addItem(Integer.toString(cnt));
				}
			} else if (e.getSource() == (JComboBox) endYearCombo
					|| e.getSource() == (JComboBox) endMonCombo) {
				int maxDay = getMaxDay(endYearCombo, endMonCombo);
				endDayCombo.removeAllItems();
				for (int cnt = 1; cnt <= maxDay; cnt++) {
					endDayCombo.addItem(Integer.toString(cnt));
				}
			}
		}
	}

	public void setEditMode() {
		titleTextField.setEnabled(true);
		contentArea.setEnabled(true);
		startYearCombo.setEnabled(true);
		startMonCombo.setEnabled(true);
		startDayCombo.setEnabled(true);
		endYearCombo.setEnabled(true);
		endMonCombo.setEnabled(true);
		endDayCombo.setEnabled(true);
		isPublicCombo.setEnabled(true);
		priorityCombo.setEnabled(true);
		modifyButton.setText("확   인");
	}

	private class ScheduleButtonListener implements ActionListener {
		public ScheduleButtonListener() {

		}

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("확   인")) {
				/*
				 * 확인해야 할 사항 month calendar 일 경우 schedule과 diary를 한 table에 뿌림
				 * day/ week는 따로 뿌림. 확인할 무언가가 필요함 ㅠㅠ
				 */
				
				String pub;
				if (isPublicCombo.getSelectedItem().equals("공개")) {
					pub = "true";
				} else {
					pub = "false";
				}
				String prior;
				if (priorityCombo.getSelectedItem().equals("중요")) {
					prior = "true";
				} else {
					prior = "false";
				}
				ScheduleController control = ScheduleController.getInstance();
				control.modify(titleTextField.getText(), contentArea.getText(),
						startYearCombo.getSelectedItem() + "",
						startMonCombo.getSelectedItem() + "",
						startDayCombo.getSelectedItem() + "",
						endYearCombo.getSelectedItem() + "",
						endMonCombo.getSelectedItem() + "",
						endDayCombo.getSelectedItem() + "", pub, prior);
				
				
				if(date!=null)
				{
					List<String[]> list = control.searchTodaySchedule(date[0],date[1],date[2]);
					String[] arr = new String[3];
					int size = list.size();
					DefaultTableModel model = (DefaultTableModel) jtable.getModel();

					while (model.getRowCount() > 0) {
						model.removeRow(0);
					}
					for (int cnt = 0; cnt < size; cnt++) {
						arr[0] = list.get(cnt)[0];
						arr[1] = list.get(cnt)[1];
						arr[2] = list.get(cnt)[2];

						model.addRow(arr);
					}

				}
				else
				{
					List<String[]> list = control.read();
					String[] arr = new String[3];
					int size = list.size();
					DefaultTableModel model = (DefaultTableModel) jtable.getModel();

					while (model.getRowCount() > 0) {
						model.removeRow(0);
					}
					for (int cnt = 0; cnt < size; cnt++) {
						arr[0] = list.get(cnt)[0];
						arr[1] = list.get(cnt)[1];
						arr[2] = list.get(cnt)[2];

						model.addRow(arr);
					}
					
					List<String[]> list2 =DiaryController.getInstance().getTableValueList();
					String[] arr2 = new String[3];
					size = list2.size();

					for (int i = 0; i < size; i++) {
						arr2[0] = list2.get(i)[0];
						arr2[1] = list2.get(i)[1];
						arr2[2] = list2.get(i)[2];

						model.addRow(arr2);
					}

				}
				
				/*
				 * month calendar일 경우의 코드 - >최종본 아님
				 * 
				 * ScheduleController.getInstance().modify(titleTextField.getText
				 * (), contentArea.getText(),
				 * startYearCombo.getSelectedItem()+"",
				 * startMonCombo.getSelectedItem()+"",
				 * startDayCombo.getSelectedItem()+"",
				 * endYearCombo.getSelectedItem()+"",
				 * endMonCombo.getSelectedItem()+"",
				 * endDayCombo.getSelectedItem()+"",
				 * isPublicCombo.getSelectedItem()+"",
				 * priorityCombo.getSelectedItem()+""); ScheduleController
				 * control = ScheduleController.getInstance(); List<String[]>
				 * list = control.read(); String[] arr = new String[3]; int size
				 * = list.size(); DefaultTableModel model =
				 * (DefaultTableModel)jtable.getModel();
				 * 
				 * System.out.println(model.getRowCount());
				 * while(model.getRowCount()>0) model.removeRow(0);
				 * 
				 * for (int cnt = 0; cnt < size; cnt++) { arr[0] =
				 * list.get(cnt)[0]; arr[1] = list.get(cnt)[1]; arr[2] =
				 * list.get(cnt)[2];
				 * 
				 * model.addRow(arr); }
				 * 
				 * 
				 * 
				 * DiaryController con = DiaryController.getInstance();
				 * List<String[]> list2 = con.getTableValueList(); String[] arr2
				 * = new String[3]; size = list2.size();
				 * 
				 * for (int cnt = 0; cnt < size; cnt++) { arr2[0] =
				 * list2.get(cnt)[0]; arr2[1] = list2.get(cnt)[1]; arr2[2] =
				 * list2.get(cnt)[2];
				 * 
				 * model.addRow(arr2); }
				 */
				setVisible(false);

			} else if (e.getActionCommand().equals("수  정")) {
				setEditMode();
			} else if (e.getActionCommand().equals("삭  제")) {
				DefaultTableModel model = (DefaultTableModel) jtable.getModel();
				model.removeRow(sel);
				ScheduleController.getInstance().remove(sel2);
				setVisible(false);
			} else if (e.getActionCommand().equals("취  소")) {
				setVisible(false);
			}
		}
	}

}
