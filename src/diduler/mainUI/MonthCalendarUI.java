package diduler.mainUI;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.Calendar;
import java.util.LinkedList;

public class MonthCalendarUI extends JPanel {
	private JButton downMonth_month;
	private JButton downYear_month;
	private JButton upMonth_month;
	private JButton upYear_month;

	private JLabel monthLabel_month; // 달력
	private JLabel yearLabel_month;

	private JPopupMenu didulerPopUpmenu;
	private JMenuItem addDiduler;
	private JMenuItem viewDidulerList;

	private JLabel[] dateLabel = new JLabel[42];

	private class UpDownButtonListener implements ActionListener {

		private CalendarController control = new CalendarController();

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == upYear_month) {
				yearLabel_month.setText((Integer.parseInt(yearLabel_month
						.getText()) + 1) + "");
			} else if (e.getSource() == downYear_month) {
				yearLabel_month.setText((Integer.parseInt(yearLabel_month
						.getText()) - 1) + "");
			} else if (e.getSource() == upMonth_month) {
				if (monthLabel_month.getText().equals("12")) {
					yearLabel_month.setText((Integer.parseInt(yearLabel_month
							.getText()) + 1) + "");
					monthLabel_month.setText("1");
				} else
					monthLabel_month.setText((Integer.parseInt(monthLabel_month
							.getText()) + 1) + "");

			} else if (e.getSource() == downMonth_month) {
				if (monthLabel_month.getText().equals("1")) {
					yearLabel_month.setText((Integer.parseInt(yearLabel_month
							.getText()) - 1) + "");
					monthLabel_month.setText("12");
				} else
					monthLabel_month.setText((Integer.parseInt(monthLabel_month
							.getText()) - 1) + "");

			}

			LinkedList<String> list = control.getDateInMonthUI(
					Integer.parseInt(yearLabel_month.getText()),
					Integer.parseInt(monthLabel_month.getText()));

			for (int i = 0; i < list.size(); i++) {
				dateLabel[i].setOpaque(false);
				if (i % 7 == 0)
					dateLabel[i].setForeground(Color.RED);
				else if (i % 7 == 6)
					dateLabel[i].setForeground(Color.BLUE);
				else
					dateLabel[i].setForeground(Color.BLACK);
				dateLabel[i].setText(list.get(i));
			}
			if ((Integer.parseInt(yearLabel_month.getText()) == Calendar
					.getInstance().get(Calendar.YEAR))
					&& (Integer.parseInt(monthLabel_month.getText()) - 1 == Calendar
							.getInstance().get(Calendar.MONTH))) {
				int index = list.indexOf(Calendar.getInstance().get(
						Calendar.DAY_OF_MONTH)
						+ "");
				dateLabel[index].setOpaque(true);
				dateLabel[index].setBackground(Color.cyan);
			}

		}
	}
	
	private class AddListener extends MouseAdapter
	{
		private String clicked;
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			if (e.getButton() == 3)
				clicked = ((JLabel) e.getSource()).getText();
		}
		public String getClicked()
		{
			return clicked;
		}
	}
	private class MonthDidulerButtonListener implements ActionListener {
		private AddDidulerUI addDidulerUI = new AddDidulerUI();
		private ViewDidulerUI viewDidulerUI = new ViewDidulerUI();
		private AddListener addListener;
		public MonthDidulerButtonListener(AddListener addListener)
		{
			this.addListener = addListener;
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == addDiduler) {
				
				addDidulerUI.setVisible(true, new String[]{yearLabel_month.getText(),monthLabel_month.getText(),addListener.getClicked()});
				
			} else if (e.getSource() == viewDidulerList) {
				viewDidulerUI.setVisible(true);
			}
		}
	}

	public MonthCalendarUI() {
		initComponents();
	}

	private void initComponents() {
		UpDownButtonListener updownListener;
		MonthDidulerButtonListener monthDidulerListener;

		setBackground(new java.awt.Color(255, 255, 255));
		setLayout(null);
		for (int i = 0; i < 42; i++)
			dateLabel[i] = new JLabel("*", SwingConstants.CENTER);
		didulerPopUpmenu = new JPopupMenu();
		addDiduler = new JMenuItem();

		yearLabel_month = new JLabel();
		upYear_month = new JButton();
		downYear_month = new JButton();
		monthLabel_month = new JLabel();
		upMonth_month = new JButton();
		downMonth_month = new JButton();

		viewDidulerList = new JMenuItem();

		JLabel sunLabel = new JLabel();
		JLabel satLabel = new JLabel();
		JLabel thurLabel = new JLabel();
		JLabel friLabel = new JLabel();
		JLabel monLabel = new JLabel();
		JLabel wedLabel = new JLabel();
		JLabel tueLabel = new JLabel();

		updownListener = new UpDownButtonListener();
		AddListener addListener = new AddListener();
		monthDidulerListener = new MonthDidulerButtonListener(addListener);

		JSeparator monthline1 = new JSeparator();
		JSeparator monthline2 = new JSeparator();
		JSeparator monthline3 = new JSeparator();
		JSeparator monthline4 = new JSeparator();
		JSeparator monthline5 = new JSeparator();
		JSeparator monthline6 = new JSeparator();

		addDiduler.setText("Diduler 추가");
		didulerPopUpmenu.add(addDiduler);
		viewDidulerList.setText("Diduler 목록보기");

		didulerPopUpmenu.add(viewDidulerList);

		yearLabel_month.setFont(new java.awt.Font("함초롬돋움", 1, 14)); // NOI18N
		yearLabel_month.setText(Calendar.getInstance().get(Calendar.YEAR) + "");
		add(yearLabel_month);
		yearLabel_month.setBounds(280, 10, 50, 19);

		upYear_month.setText(">");

		add(upYear_month);
		upYear_month.setBounds(340, 10, 41, 20);

		downYear_month.setText("<");

		add(downYear_month);
		downYear_month.setBounds(200, 10, 41, 20);

		monthLabel_month.setFont(new java.awt.Font("함초롬돋움", 1, 14)); // NOI18N
		monthLabel_month.setText(1 + Calendar.getInstance().get(Calendar.MONTH)
				+ "");
		add(monthLabel_month);
		monthLabel_month.setBounds(470, 10, 30, 20);

		upMonth_month.setText(">");
		add(upMonth_month);
		upMonth_month.setBounds(510, 10, 41, 20);

		downMonth_month.setText("<");
		add(downMonth_month);
		downMonth_month.setBounds(410, 10, 41, 20);
		add(monthline1);
		monthline1.setBounds(30, 150, 650, 2);
		add(monthline2);
		monthline2.setBounds(30, 210, 650, 10);
		add(monthline3);
		monthline3.setBounds(30, 270, 650, 10);
		add(monthline4);
		monthline4.setBounds(30, 330, 650, 10);
		add(monthline5);
		monthline5.setBounds(30, 390, 650, 2);
		add(monthline6);
		monthline6.setBounds(30, 450, 650, 2);

		dateLabel[0].setText(" ");
		dateLabel[0].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[0]);
		dateLabel[0].setBounds(40, 100, 60, 50);

		dateLabel[1].setText(" ");
		dateLabel[1].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[1]);
		dateLabel[1].setBounds(140, 100, 60, 50);

		dateLabel[2].setText(" ");
		dateLabel[2].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[2]);
		dateLabel[2].setBounds(240, 100, 60, 50);

		dateLabel[3].setText(" ");
		dateLabel[3].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[3]);
		dateLabel[3].setBounds(340, 100, 60, 50);

		dateLabel[4].setText(" ");
		dateLabel[4].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[4]);
		dateLabel[4].setBounds(440, 100, 60, 50);

		dateLabel[5].setText(" ");
		dateLabel[5].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[5]);
		dateLabel[5].setBounds(540, 100, 60, 50);

		dateLabel[6].setText(" ");
		dateLabel[6].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[6]);
		dateLabel[6].setBounds(630, 100, 60, 50);

		dateLabel[7].setText(" ");
		dateLabel[7].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[7]);
		dateLabel[7].setBounds(40, 160, 60, 50);

		dateLabel[8].setText(" ");
		dateLabel[8].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[8]);
		dateLabel[8].setBounds(140, 160, 60, 50);

		dateLabel[9].setText(" ");
		dateLabel[9].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[9]);
		dateLabel[9].setBounds(240, 160, 60, 50);

		dateLabel[10].setText(" ");
		dateLabel[10].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[10]);
		dateLabel[10].setBounds(340, 160, 60, 50);

		dateLabel[11].setText(" ");
		dateLabel[11].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[11]);
		dateLabel[11].setBounds(440, 160, 60, 50);

		dateLabel[12].setText(" ");
		dateLabel[12].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[12]);
		dateLabel[12].setBounds(540, 160, 60, 50);

		dateLabel[13].setText(" ");
		dateLabel[13].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[13]);
		dateLabel[13].setBounds(630, 160, 60, 50);

		dateLabel[14].setText(" ");
		dateLabel[14].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[14]);
		dateLabel[14].setBounds(40, 220, 60, 50);

		dateLabel[15].setText(" ");
		dateLabel[15].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[15]);
		dateLabel[15].setBounds(140, 220, 60, 50);

		dateLabel[16].setText(" ");
		dateLabel[16].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[16]);
		dateLabel[16].setBounds(240, 220, 60, 50);

		dateLabel[17].setText(" ");
		dateLabel[17].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[17]);
		dateLabel[17].setBounds(340, 220, 60, 50);

		dateLabel[18].setText(" ");
		dateLabel[18].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[18]);
		dateLabel[18].setBounds(440, 220, 60, 50);

		dateLabel[19].setText(" ");
		dateLabel[19].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[19]);
		dateLabel[19].setBounds(540, 220, 60, 50);

		dateLabel[20].setText(" ");
		dateLabel[20].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[20]);
		dateLabel[20].setBounds(630, 220, 60, 50);

		dateLabel[21].setText(" ");
		dateLabel[21].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[21]);
		dateLabel[21].setBounds(40, 280, 60, 50);

		dateLabel[22].setText(" ");
		dateLabel[22].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[22]);
		dateLabel[22].setBounds(140, 280, 60, 50);

		dateLabel[23].setText(" ");
		dateLabel[23].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[23]);
		dateLabel[23].setBounds(240, 280, 60, 50);

		dateLabel[24].setText(" ");
		dateLabel[24].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[24]);
		dateLabel[24].setBounds(340, 280, 60, 50);

		dateLabel[25].setText(" ");
		dateLabel[25].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[25]);
		dateLabel[25].setBounds(440, 280, 60, 50);

		dateLabel[26].setText(" ");
		dateLabel[26].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[26]);
		dateLabel[26].setBounds(540, 280, 60, 50);

		dateLabel[27].setText(" ");
		dateLabel[27].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[27]);
		dateLabel[27].setBounds(630, 280, 60, 50);

		dateLabel[28].setText(" ");
		dateLabel[28].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[28]);
		dateLabel[28].setBounds(40, 340, 60, 50);

		dateLabel[29].setText(" ");
		dateLabel[29].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[29]);
		dateLabel[29].setBounds(140, 340, 60, 50);

		dateLabel[30].setText(" ");
		dateLabel[30].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[30]);
		dateLabel[30].setBounds(240, 340, 60, 50);

		dateLabel[31].setText(" ");
		dateLabel[31].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[31]);
		dateLabel[31].setBounds(340, 340, 60, 50);

		dateLabel[32].setText(" ");
		dateLabel[32].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[32]);
		dateLabel[32].setBounds(440, 340, 60, 50);

		dateLabel[33].setText(" ");
		dateLabel[33].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[33]);
		dateLabel[33].setBounds(540, 340, 60, 50);

		dateLabel[34].setText(" ");
		dateLabel[34].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[34]);
		dateLabel[34].setBounds(630, 340, 60, 50);
		// ////////////////////////////////////////////////////////////////////
		dateLabel[35].setText(" ");
		dateLabel[35].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[35]);
		dateLabel[35].setBounds(40, 400, 60, 50);

		dateLabel[36].setText(" ");
		dateLabel[36].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[36]);
		dateLabel[36].setBounds(140, 400, 60, 50);

		dateLabel[37].setText(" ");
		dateLabel[37].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[37]);
		dateLabel[37].setBounds(240, 400, 60, 50);

		dateLabel[38].setText(" ");
		dateLabel[38].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[38]);
		dateLabel[38].setBounds(340, 400, 60, 50);

		dateLabel[39].setText(" ");
		dateLabel[39].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[39]);
		dateLabel[39].setBounds(440, 400, 60, 50);

		dateLabel[40].setText(" ");
		dateLabel[40].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[40]);
		dateLabel[40].setBounds(540, 400, 60, 50);

		dateLabel[41].setText(" ");
		dateLabel[41].setComponentPopupMenu(didulerPopUpmenu);
		add(dateLabel[41]);
		dateLabel[41].setBounds(630, 400, 60, 50);

		satLabel.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		satLabel.setHorizontalAlignment(SwingConstants.CENTER);
		satLabel.setText("Sat");
		add(satLabel);
		satLabel.setBounds(630, 60, 50, 19);

		sunLabel.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		sunLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sunLabel.setText("Sun");
		add(sunLabel);
		sunLabel.setBounds(40, 60, 50, 19);

		monLabel.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		monLabel.setHorizontalAlignment(SwingConstants.CENTER);
		monLabel.setText("Mon");
		add(monLabel);
		monLabel.setBounds(140, 60, 50, 19);

		tueLabel.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		tueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tueLabel.setText("Tue");
		add(tueLabel);
		tueLabel.setBounds(240, 60, 50, 19);

		wedLabel.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		wedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wedLabel.setText("Wed");
		add(wedLabel);
		wedLabel.setBounds(340, 60, 50, 19);

		thurLabel.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		thurLabel.setText("Thur");
		add(thurLabel);
		thurLabel.setBounds(440, 60, 50, 19);

		friLabel.setFont(new java.awt.Font("양재꽃게체M", 1, 18)); // NOI18N
		friLabel.setHorizontalAlignment(SwingConstants.CENTER);
		friLabel.setText("Fri");
		add(friLabel);
		friLabel.setBounds(540, 60, 50, 19);

		upYear_month.addActionListener(updownListener);
		downYear_month.addActionListener(updownListener);
		upMonth_month.addActionListener(updownListener);
		downMonth_month.addActionListener(updownListener);
		addDiduler.addActionListener(monthDidulerListener);
		viewDidulerList.addActionListener(monthDidulerListener);
		
		LinkedList<String> list = new CalendarController().getDateInMonthUI(
				Integer.parseInt(yearLabel_month.getText()),
				Integer.parseInt(monthLabel_month.getText()));

		for (int i = 0; i < list.size(); i++) {
			if (i % 7 == 0)
				dateLabel[i].setForeground(Color.RED);
			else if (i % 7 == 6)
				dateLabel[i].setForeground(Color.BLUE);
			else
				dateLabel[i].setForeground(Color.BLACK);
			dateLabel[i].setText(list.get(i));
			dateLabel[i].addMouseListener(addListener);
		}
		int index = list.indexOf(Calendar.getInstance().get(
				Calendar.DAY_OF_MONTH)
				+ "");
		dateLabel[index].setOpaque(true);
		dateLabel[index].setBackground(Color.cyan);
	}
}
