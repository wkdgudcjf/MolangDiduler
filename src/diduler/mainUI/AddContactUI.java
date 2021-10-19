package diduler.mainUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.util.*;

public class AddContactUI extends JFrame {
	private JPanel panel1;
	private JTextField nameField;
	private JTextField emailField1;
	private JTextField emailField2;
	private JTextField phoneField1;
	private JTextField phoneField2;
	private JTextField phoneField3;
	private JButton cancelButton;
	private JButton okButton;
	private JComboBox monthComboBox;
	private JComboBox dayComboBox;
	private JComboBox groupComboBox;

	private JTable wholeTable; // 변수명수정
	private JTable defaultTable;
	private JTable friendTable;
	private JTable familyTable;
	private JTable jobTable;

	public AddContactUI(JTable wholeTable, JTable defaultTable,
			JTable friendTable, JTable familyTable, JTable jobTable) {
		this.wholeTable = wholeTable;
		this.defaultTable = defaultTable;
		this.friendTable = friendTable;
		this.familyTable = familyTable;
		this.jobTable = jobTable;
		initComponents();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// 닫히기 전에 필드 초기화해야해
				setVisible(false);
			}
		});
	}

	private void initComponents() {
		ButtonListener listener;
		MonthBoxListener MonthListener;
		MonthListener = new MonthBoxListener();
		listener = new ButtonListener();
		panel1 = new JPanel();
		nameField = new JTextField();
		emailField1 = new JTextField();
		phoneField1 = new JTextField();
		cancelButton = new JButton();
		okButton = new JButton();
		monthComboBox = new JComboBox();
		dayComboBox = new JComboBox();
		emailField2 = new JTextField();
		phoneField2 = new JTextField();
		phoneField3 = new JTextField();
		groupComboBox = new JComboBox();

		JLabel jlName = new JLabel();
		JLabel jlEmail = new JLabel();
		JLabel jlPhone = new JLabel();
		JLabel jlBirth = new JLabel();
		JLabel jlMonth = new JLabel();
		JLabel jlDay = new JLabel();
		JLabel jlGroup = new JLabel();
		JLabel jLabel1 = new JLabel();
		JLabel jLabel2 = new JLabel();
		JLabel jLabel3 = new JLabel();
		JLabel jLabel4 = new JLabel();

		setTitle("인맥 추가");
		setResizable(false);

		panel1.setBackground(new java.awt.Color(255, 255, 255));
		panel1.setPreferredSize(new java.awt.Dimension(320, 350));

		jlName.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlName.setHorizontalAlignment(SwingConstants.RIGHT);
		jlName.setText("이름 :");

		jlEmail.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		jlEmail.setText("이메일 :");

		jlPhone.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		jlPhone.setText("전화번호 :");

		jlBirth.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		jlBirth.setText("생일 :");

		cancelButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		cancelButton.setText("취소");
		cancelButton.addActionListener(listener);

		okButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		okButton.setText("추가");
		okButton.addActionListener(listener);

		monthComboBox.setModel(new DefaultComboBoxModel(new String[] { "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

		monthComboBox.addItemListener(MonthListener);
		for(int i=1; i<=31;i++)
			dayComboBox.addItem(i+"");
		jlMonth.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlMonth.setText("월");

		jlDay.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlDay.setText("일");

		jLabel1.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jLabel1.setText("@");

		jLabel2.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jLabel2.setText("-");

		jLabel3.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jLabel3.setText("-");

		jLabel4.setIcon(new ImageIcon("mo1.png")); // NOI18N

		groupComboBox.setModel(new DefaultComboBoxModel(new String[] { "미지정",
				"친구", "가족", "직장" }));

		jlGroup.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlGroup.setText("그룹 :");

		GroupLayout panel1Layout = new GroupLayout(panel1);
		panel1.setLayout(panel1Layout);
		panel1Layout
				.setHorizontalGroup(panel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												panel1Layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																panel1Layout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addGroup(
																				GroupLayout.Alignment.TRAILING,
																				panel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								jlName,
																								GroupLayout.PREFERRED_SIZE,
																								66,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								nameField,
																								GroupLayout.PREFERRED_SIZE,
																								180,
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				GroupLayout.Alignment.TRAILING,
																				panel1Layout
																						.createSequentialGroup()
																						.addGroup(
																								panel1Layout
																										.createParallelGroup(
																												GroupLayout.Alignment.TRAILING)
																										.addGroup(
																												GroupLayout.Alignment.LEADING,
																												panel1Layout
																														.createSequentialGroup()
																														.addComponent(
																																jlPhone,
																																GroupLayout.PREFERRED_SIZE,
																																66,
																																GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																phoneField1,
																																GroupLayout.PREFERRED_SIZE,
																																50,
																																GroupLayout.PREFERRED_SIZE))
																										.addGroup(
																												panel1Layout
																														.createSequentialGroup()
																														.addComponent(
																																jlEmail,
																																GroupLayout.PREFERRED_SIZE,
																																66,
																																GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																emailField1,
																																GroupLayout.PREFERRED_SIZE,
																																50,
																																GroupLayout.PREFERRED_SIZE)))
																						.addPreferredGap(
																								LayoutStyle.ComponentPlacement.RELATED)
																						.addGroup(
																								panel1Layout
																										.createParallelGroup(
																												GroupLayout.Alignment.LEADING,
																												false)
																										.addGroup(
																												panel1Layout
																														.createSequentialGroup()
																														.addComponent(
																																jLabel1)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																emailField2))
																										.addGroup(
																												panel1Layout
																														.createSequentialGroup()
																														.addComponent(
																																jLabel2)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																phoneField2,
																																GroupLayout.PREFERRED_SIZE,
																																50,
																																GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																jLabel3)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																phoneField3,
																																GroupLayout.PREFERRED_SIZE,
																																50,
																																GroupLayout.PREFERRED_SIZE)))))
														.addGroup(
																panel1Layout
																		.createParallelGroup(
																				GroupLayout.Alignment.TRAILING)
																		.addGroup(
																				panel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								jlGroup)
																						.addGap(18,
																								18,
																								18)
																						.addComponent(
																								groupComboBox,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				panel1Layout
																						.createSequentialGroup()
																						.addGroup(
																								panel1Layout
																										.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jLabel4)
																										.addComponent(
																												jlBirth,
																												GroupLayout.Alignment.TRAILING,
																												GroupLayout.PREFERRED_SIZE,
																												66,
																												GroupLayout.PREFERRED_SIZE))
																						.addGap(18,
																								18,
																								18)
																						.addGroup(
																								panel1Layout
																										.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																										.addGroup(
																												panel1Layout
																														.createSequentialGroup()
																														.addComponent(
																																monthComboBox,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																jlMonth)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.UNRELATED)
																														.addComponent(
																																dayComboBox,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																jlDay))
																										.addGroup(
																												panel1Layout
																														.createSequentialGroup()
																														.addComponent(
																																okButton)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																cancelButton))))))));
		panel1Layout
				.setVerticalGroup(panel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel1Layout
										.createSequentialGroup()
										.addGap(29, 29, 29)
										.addGroup(
												panel1Layout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(jlName)
														.addComponent(
																nameField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												panel1Layout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(jlEmail)
														.addComponent(
																emailField1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel1)
														.addComponent(
																emailField2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												panel1Layout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(jlPhone)
														.addComponent(
																phoneField1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel2)
														.addComponent(
																phoneField2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel3)
														.addComponent(
																phoneField3,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												panel1Layout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(jlBirth)
														.addComponent(
																monthComboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																dayComboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jlMonth)
														.addComponent(jlDay))
										.addGroup(
												panel1Layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																panel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED,
																				40,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel4)
																		.addContainerGap())
														.addGroup(
																panel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(
																				panel1Layout
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								groupComboBox,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jlGroup))
																		.addGap(55,
																				55,
																				55)
																		.addGroup(
																				panel1Layout
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								cancelButton)
																						.addComponent(
																								okButton))
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(panel1,
				GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
				GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(panel1,
				GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
				GroupLayout.PREFERRED_SIZE));

		pack();
	}
	
	// 확인 버튼 리스터
	private class ButtonListener implements ActionListener {
		private ContactController conController = ContactController.getInstance();
		private void setTable()
		{
			ContactController conController = ContactController.getInstance();
			
			while(wholeTable.getModel().getRowCount()>0)
				((DefaultTableModel)wholeTable.getModel()).removeRow(0);
			while(defaultTable.getModel().getRowCount()>0)
				((DefaultTableModel)defaultTable.getModel()).removeRow(0);
			while(friendTable.getModel().getRowCount()>0)
				((DefaultTableModel)friendTable.getModel()).removeRow(0);
			while(familyTable.getModel().getRowCount()>0)
				((DefaultTableModel)familyTable.getModel()).removeRow(0);
			while(jobTable.getModel().getRowCount()>0)
				((DefaultTableModel)jobTable.getModel()).removeRow(0);
			
			DefaultTableModel wholeModel= (DefaultTableModel) wholeTable.getModel();
			DefaultTableModel defaultModel= (DefaultTableModel) defaultTable.getModel();
			DefaultTableModel friendModel= (DefaultTableModel) friendTable.getModel();
			DefaultTableModel familyModel= (DefaultTableModel) familyTable.getModel();
			DefaultTableModel jobModel= (DefaultTableModel) jobTable.getModel();
			
			String arr[] = new String[4];
			LinkedList<String> str;

			str = (LinkedList<String>) conController.getWholeTable();
			for (int i = 0; i < str.size(); i += 4) {
				arr[0] = str.get(i);
				arr[1] = str.get(i + 1);
				arr[2] = str.get(i + 2);
				arr[3] = str.get(i + 3);
				wholeModel.addRow(arr);
			}
			str = (LinkedList<String>) conController.getDefaultTable();
			for (int i = 0; i < str.size(); i += 4) {
				arr[0] = str.get(i);
				arr[1] = str.get(i + 1);
				arr[2] = str.get(i + 2);
				arr[3] = str.get(i + 3);
				defaultModel.addRow(arr);
			}
			str = (LinkedList<String>) conController.getFamilyTable();
			for (int i = 0; i < str.size(); i += 4) {
				arr[0] = str.get(i);
				arr[1] = str.get(i + 1);
				arr[2] = str.get(i + 2);
				arr[3] = str.get(i + 3);
				familyModel.addRow(arr);
			}
			
			str = (LinkedList<String>) conController.getFriendTable();
			for (int i = 0; i < str.size(); i += 4) {
				arr[0] = str.get(i);
				arr[1] = str.get(i + 1);
				arr[2] = str.get(i + 2);
				arr[3] = str.get(i + 3);
				friendModel.addRow(arr);
			}
			str = (LinkedList<String>) conController.getJobTable();
			for (int i = 0; i < str.size(); i += 4) {
				arr[0] = str.get(i);
				arr[1] = str.get(i + 1);
				arr[2] = str.get(i + 2);
				arr[3] = str.get(i + 3);
				jobModel.addRow(arr);
			}
			
		}
		public void actionPerformed(ActionEvent e) {
			if ("추가".equals(e.getActionCommand())) // 확인버튼
			{
				if((nameField.getText().length()==0)||
						(emailField1.getText().length()==0)||
						(emailField2.getText().length()==0)||
						(phoneField1.getText().length()==0)||
						(phoneField2.getText().length()==0)||
						(phoneField3.getText().length()==0))
				{
					JOptionPane.showConfirmDialog(null,"빈 칸을 채워주세요","", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
					return ;
				}
				try {
					Integer.parseInt(phoneField1.getText());
					Integer.parseInt(phoneField2.getText());
					Integer.parseInt(phoneField3.getText());
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null,"전화번호는 숫자만 가능합니다.","", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
					phoneField1.setText("");
					phoneField2.setText("");
					phoneField3.setText("");
					return ;
				}
				conController.addPerson(nameField.getText(), emailField1.getText()+"@"+ emailField2.getText(),
						phoneField1.getText()+"-"+phoneField2.getText()+"-"+phoneField3.getText(), monthComboBox.getSelectedItem()+"월 "+
						(String)dayComboBox.getSelectedItem()+"일", (String)groupComboBox.getSelectedItem());
				
				setTable();
				setVisible(false);
			} else // 취소버튼
			{
				setVisible(false);
			}
		}
	}

	private class MonthBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if ("1".equals(e.getItem())) // 1월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=31;i++)
					dayComboBox.addItem(i+"");

			} else if ("2".equals(e.getItem())) // 2월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=29;i++)
					dayComboBox.addItem(i+"");
			} else if ("3".equals(e.getItem())) // 3월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=31;i++)
					dayComboBox.addItem(i+"");

			} else if ("4".equals(e.getItem())) // 4월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=30;i++)
					dayComboBox.addItem(i+"");

			} else if ("5".equals(e.getItem())) // 5월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=31;i++)
					dayComboBox.addItem(i+"");

			} else if ("6".equals(e.getItem())) // 6월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=30;i++)
					dayComboBox.addItem(i+"");

			} else if ("7".equals(e.getItem())) // 7월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=31;i++)
					dayComboBox.addItem(i+"");

			} else if ("8".equals(e.getItem())) // 8월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=31;i++)
					dayComboBox.addItem(i+"");
			} else if ("9".equals(e.getItem())) // 9월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=30;i++)
					dayComboBox.addItem(i+"");
			} else if ("10".equals(e.getItem())) // 10월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=31;i++)
					dayComboBox.addItem(i+"");
			} else if ("11".equals(e.getItem())) // 11월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=30;i++)
					dayComboBox.addItem(i+"");

			} else if ("12".equals(e.getItem())) // 12월
			{
				dayComboBox.removeAllItems();
				for(int i=1; i<=31;i++)
					dayComboBox.addItem(i+"");
			}
		}
	}

}
