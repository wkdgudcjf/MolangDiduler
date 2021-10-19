package diduler.mainUI;

import diduler.model.CalendarSize;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class AddDidulerUI extends JFrame {
	private JCheckBox alarmCheck;

	private ButtonGroup buttonGroup1;
	private JRadioButton diaryButton;
	private JRadioButton scheduleButton;
	private JButton cancelButton;
	private JButton checkButton;
	private JTextArea content;
	private JPanel schedulePanel;
	private DiaryPanel diaryPanel;
	private JTextField titleTextfield;

	private JComboBox endDayCombo;
	private JComboBox endMonCombo;
	private JComboBox endYearCombo;
	private JComboBox isPublicCombo;
	private JComboBox priorityCombo;
	private JComboBox popupCombo;
	private JComboBox alarmbellCombo;
	private JComboBox startDayCombo;
	private JComboBox startMonCombo;
	private JComboBox startYearCombo;

	private String[] date;

	public AddDidulerUI() {
		initComponents();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				scheduleSetting();
			}
		});
	}

	public void scheduleSetting() {
		titleTextfield.setText("");
		content.setText("");
		isPublicCombo.setSelectedIndex(0);
		priorityCombo.setSelectedIndex(0);
		diaryPanel.init();

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

	private void initComponents() {
		JScrollPane ContentScroll;
		JLabel alarmbellLabel;
		JLabel isPublic;
		JPanel jPanel1;
		JLabel popupLable;
		JLabel termLabel2;
		JLabel titleImage;
		JLabel titleLable;
		JLabel priorityLable;
		priorityLable = new JLabel();
		priorityCombo = new JComboBox();
		buttonGroup1 = new ButtonGroup();
		jPanel1 = new JPanel();
		titleLable = new JLabel();
		titleTextfield = new JTextField();
		ContentScroll = new JScrollPane();
		content = new JTextArea();
		isPublicCombo = new JComboBox();
		isPublic = new JLabel();
		diaryButton = new JRadioButton();
		scheduleButton = new JRadioButton();
		schedulePanel = new JPanel();
		startYearCombo = new JComboBox();
		startMonCombo = new JComboBox();
		startDayCombo = new JComboBox();
		termLabel2 = new JLabel();
		endYearCombo = new JComboBox();
		endMonCombo = new JComboBox();
		endDayCombo = new JComboBox();
		alarmCheck = new JCheckBox();
		popupCombo = new JComboBox();
		popupLable = new JLabel();
		alarmbellLabel = new JLabel();
		alarmbellCombo = new JComboBox();
		checkButton = new JButton();
		cancelButton = new JButton();
		titleImage = new JLabel();

		// setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("�����췯 �߰�");
		setName("�����ٷ�"); // NOI18N
		setResizable(false);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setName("�����ٷ��߰�"); // NOI18N
		jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
		jPanel1.setLayout(null);

		titleLable.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		titleLable.setText("��  ��:");
		jPanel1.add(titleLable);
		titleLable.setBounds(69, 31, 45, 26);

		titleTextfield.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		jPanel1.add(titleTextfield);
		titleTextfield.setBounds(119, 31, 284, 26);

		content.setColumns(20);
		content.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		content.setRows(5);
		ContentScroll.setViewportView(content);

		jPanel1.add(ContentScroll);
		ContentScroll.setBounds(12, 102, 391, 304);

		isPublicCombo.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		isPublicCombo.setModel(new DefaultComboBoxModel(new String[] { "��  ��",
				"�����" }));
		jPanel1.add(isPublicCombo);
		isPublicCombo.setBounds(89, 412, 80, 22);

		isPublic.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		isPublic.setText("���� ���� :");
		jPanel1.add(isPublic);
		isPublic.setBounds(24, 412, 60, 23);

		buttonGroup1.add(diaryButton);
		diaryButton.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		diaryButton.setText("���̾");
		jPanel1.add(diaryButton);
		diaryButton.setBounds(251, 411, 152, 25);

		buttonGroup1.add(scheduleButton);
		scheduleButton.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		scheduleButton.setSelected(true);
		scheduleButton.setText("�� ��");
		jPanel1.add(scheduleButton);
		scheduleButton.setBounds(184, 411, 63, 25);

		schedulePanel.setLayout(null);

		startYearCombo.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		schedulePanel.add(startYearCombo);
		startYearCombo.setBounds(10, 10, 70, 22);

		startMonCombo.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		schedulePanel.add(startMonCombo);
		startMonCombo.setBounds(80, 10, 50, 22);

		startDayCombo.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		schedulePanel.add(startDayCombo);
		startDayCombo.setBounds(130, 10, 50, 22);

		termLabel2.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		termLabel2.setText("~");
		schedulePanel.add(termLabel2);
		termLabel2.setBounds(190, 10, 10, 16);

		endYearCombo.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		endYearCombo.setPreferredSize(new java.awt.Dimension(55, 22));
		schedulePanel.add(endYearCombo);
		endYearCombo.setBounds(210, 10, 70, 22);

		endMonCombo.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		endMonCombo.setPreferredSize(new java.awt.Dimension(41, 22));
		schedulePanel.add(endMonCombo);
		endMonCombo.setBounds(280, 10, 50, 22);

		endDayCombo.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		endDayCombo.setPreferredSize(new java.awt.Dimension(41, 22));
		schedulePanel.add(endDayCombo);
		endDayCombo.setBounds(330, 10, 50, 22);

		priorityLable.setText("�߿䵵 : ");
		schedulePanel.add(priorityLable);
		priorityLable.setBounds(22, 40, 70, 15);

		priorityCombo.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "����", "�߿�" }));
		schedulePanel.add(priorityCombo);
		priorityCombo.setBounds(70, 37, 70, 20);

		alarmCheck.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		alarmCheck.setText("��   ��");
		schedulePanel.add(alarmCheck);
		alarmCheck.setBounds(20, 60, 61, 25);

		popupCombo.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		popupCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"�� ��", "�� ��" }));
		schedulePanel.add(popupCombo);
		popupCombo.setBounds(140, 61, 70, 22);

		popupLable.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		popupLable.setText("�� �� :");
		schedulePanel.add(popupLable);
		popupLable.setBounds(100, 62, 36, 20);

		alarmbellLabel.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		alarmbellLabel.setText("�� �� ��:");
		schedulePanel.add(alarmbellLabel);
		alarmbellLabel.setBounds(220, 62, 56, 20);

		alarmbellCombo.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		alarmbellCombo.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "�� ��", "�� ��" }));
		schedulePanel.add(alarmbellCombo);
		alarmbellCombo.setBounds(280, 61, 70, 22);

		jPanel1.add(schedulePanel);
		schedulePanel.setBounds(12, 452, 391, 96);
		diaryPanel = new DiaryPanel();
		diaryPanel.setBounds(12, 452, 391, 96);
		add(diaryPanel);
		diaryPanel.setVisible(false);
		schedulePanel.setVisible(true);
		checkButton.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		checkButton.setText("Ȯ ��");
		jPanel1.add(checkButton);
		checkButton.setBounds(117, 554, 70, 25);

		cancelButton.setFont(new java.awt.Font("���ʷҵ���", 0, 12)); // NOI18N
		cancelButton.setText("�� ��");
		jPanel1.add(cancelButton);
		cancelButton.setBounds(205, 554, 70, 25);

		titleImage.setIcon(new ImageIcon("�׸�4.png")); // NOI18N
		jPanel1.add(titleImage);
		titleImage.setBounds(12, 10, 50, 59);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 415,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 586,
								Short.MAX_VALUE).addContainerGap()));

		// �̷ο� ������
		scheduleSetting();
		ComboBoxListener comboBoxListener = new ComboBoxListener();
		RadioButtonListener radioButtonListener = new RadioButtonListener();

		startYearCombo.addActionListener(comboBoxListener);
		startMonCombo.addActionListener(comboBoxListener);
		endYearCombo.addActionListener(comboBoxListener);
		endMonCombo.addActionListener(comboBoxListener);

		diaryButton.addActionListener(radioButtonListener);
		scheduleButton.addActionListener(radioButtonListener);

		CheckButtonListener checkButtonListener = new CheckButtonListener();
		checkButton.addActionListener(checkButtonListener);
		cancelButton.addActionListener(checkButtonListener);

		pack();
	}

	private class RadioButtonListener implements ActionListener // �������� ���̾����
	{
		public RadioButtonListener() {
		}

		public void actionPerformed(ActionEvent evt) {
			if ("�� ��".equals(evt.getActionCommand())) // ������ư
			{
				diaryPanel.setVisible(false);
				schedulePanel.setVisible(true);
			} else if ("���̾".equals(evt.getActionCommand()))// ���̾��ư
			{
				schedulePanel.setVisible(false);
				diaryPanel.setVisible(true);
			}
		}
	}

	private class ComboBoxListener implements ActionListener // �޺��ڽ�
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
				// ���� ��, �� �޺��ڽ�
				int maxDay = getMaxDay(startYearCombo, startMonCombo);
				startDayCombo.removeAllItems();
				for (int cnt = 1; cnt <= maxDay; cnt++) {
					startDayCombo.addItem(Integer.toString(cnt));
				}
			} else if (e.getSource() == (JComboBox) endYearCombo
					|| e.getSource() == (JComboBox) endMonCombo) {
				// �� ��, �� �޺��ڽ�
				int maxDay = getMaxDay(endYearCombo, endMonCombo);
				endDayCombo.removeAllItems();
				for (int cnt = 1; cnt <= maxDay; cnt++) {
					endDayCombo.addItem(Integer.toString(cnt));
				}
			}
		}
	}

	private class CheckButtonListener implements ActionListener // �߰����� �������
	{
		public CheckButtonListener() {
		}

		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == checkButton) // Ȯ�ι�ư
			{
				if (scheduleButton.isSelected()) // ������ üũ�Ǿ�������
				{
					String begin = startYearCombo.getSelectedItem().toString()
							+ startMonCombo.getSelectedItem().toString()
							+ startDayCombo.getSelectedItem().toString();
					String end = endYearCombo.getSelectedItem().toString()
							+ endMonCombo.getSelectedItem().toString()
							+ endDayCombo.getSelectedItem().toString();

					SimpleDateFormat formatter = new SimpleDateFormat(
							"yyyyMMdd");
					try {
						Date beginDate = formatter.parse(begin);
						Date endDate = formatter.parse(end);

						if (beginDate.compareTo(endDate) <= 0) // �Ⱓ �˻�
						{
							String title = titleTextfield.getText();
							String str = content.getText();
							boolean priority;
							boolean isPublic;

							if (title.equals(""))
								title = new String("�������");
							if (str.equals(""))
								str = new String("�������");

							if (priorityCombo.getSelectedItem().toString() == "�߿�") // �߿䵵
							{
								priority = true;
							} else {
								priority = false;
							}

							if (isPublicCombo.getSelectedItem().toString() == "��  ��") // ��������
							{
								isPublic = true;
							} else {
								isPublic = false;
							}
							ScheduleController.getInstance()
									.addSchedule(title, str, priority,
											isPublic, beginDate, endDate);
							setVisible(false);
							scheduleSetting();
						} else {
							JOptionPane.showMessageDialog(null, "�Ⱓ ���� ����!",
									"���", JOptionPane.ERROR_MESSAGE);
						}
					} catch (ParseException pe) {
					}
				} else {
					DiaryController didulerCnt = DiaryController.getInstance();
					String titleStr = titleTextfield.getText();
					String contentStr = content.getText();
					String image;

					String selectedPublic = (String) isPublicCombo
							.getSelectedItem();

					boolean isPublic;

					if (selectedPublic.equals("��  ��"))
						isPublic = true;
					else
						isPublic = false;

					if (titleStr != null && contentStr != null) // ����� ������ �����
																// �Է� �Ǿ�����
					{

						if (diaryPanel.getjTextField1().equals("")) {
							if (date != null) {
								didulerCnt.addDiary(titleStr, contentStr,
										isPublic, date);
								date = null;
							} else
								didulerCnt.addDiary(titleStr, contentStr,
										isPublic);
							content.setText(null);
							titleTextfield.setText(null);

						}

						else {
							image = diaryPanel.getjTextField1();
							try {
								
								File imagefile = new File(image);
								
								File output = new File("image//"+imagefile.getName());
								FileInputStream input = new FileInputStream(
										imagefile);
								FileOutputStream outputS = new FileOutputStream(
										output);

								int c;

								while ((c = input.read()) != -1)
									outputS.write(c);
								input.close();
								outputS.close();
								
								image = "image//"+imagefile.getName();
							} catch (Exception e) {
								// TODO: handle exception
							}
							if (date != null) {
								didulerCnt.addDiary(titleStr, contentStr,
										image, isPublic, date); // �̹��� ���� ����
								date = null;
							} else
								didulerCnt.addDiary(titleStr, contentStr,
										image, isPublic); // �̹��� ���� ����

							content.setText(null);
							titleTextfield.setText(null);

						

						}

						diaryPanel.setjTextField1(null);
						setVisible(false);

					} else if (titleStr == null && contentStr != null) {
						JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
					} else {
						JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
					}

				}
			} else // ��ҹ�ư
			{
				setVisible(false);
				scheduleSetting();
			}
		}
	}

	public void setVisible(boolean b, String[] date) {
		super.setVisible(b);
		this.date = date;
	}

}
