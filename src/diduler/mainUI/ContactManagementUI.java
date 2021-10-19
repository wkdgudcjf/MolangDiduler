package diduler.mainUI;

import javax.swing.*;
import javax.swing.table.*;

import diduler.model.PersonInfo;

import java.awt.event.*;
import java.util.*;

public class ContactManagementUI extends JPanel {
	private JButton addButton; // 추가
	private JButton modifyButton; // 수정
	private JButton searchButton; // 검색
	private JButton deleteButton; // 삭제

	private JTabbedPane connectionSubPanel;

	private JPanel wholeTab; // 전체탭
	private JPanel defaultTab; // 미지정탭
	private JPanel familyTab; // 가족탭
	private JPanel friendTab; // 친구탭
	private JPanel jobTab; // 직장탭

	// 테이블 마우스 리스너
	private JTable wholeTable; // 변수명수정
	private JTable defaultTable;
	private JTable friendTable;
	private JTable familyTable;
	private JTable jobTable;

	private JRadioButton nameRadioBox;
	private JRadioButton emailRadioBox;
	private JRadioButton phoneRadioBox;
	private JRadioButton birthRadioBox;

	private JTextField searchField;
	private ButtonGroup searchTarget;

	
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
	public void setVisible(boolean b) {
		super.setVisible(b);
		searchField.setText("");
		nameRadioBox.setSelected(true);
		connectionSubPanel.setSelectedIndex(0);
		setTable();
	}
	

	public ContactManagementUI() {
		initComponents();
	}

	private void initComponents() {
		ContactButtonListener contactButtonListener;
		ContactTableListener contactTableListener;

		searchTarget = new ButtonGroup();
		connectionSubPanel = new JTabbedPane();
		wholeTab = new JPanel();
		JScrollPane jScrollPane1 = new JScrollPane();
		wholeTable = new JTable();
		wholeTable.setColumnSelectionAllowed(false);
		searchField = new JTextField();
		searchButton = new JButton();

		nameRadioBox = new JRadioButton();
		emailRadioBox = new JRadioButton();
		phoneRadioBox = new JRadioButton();
		birthRadioBox = new JRadioButton();

		defaultTab = new JPanel();
		JScrollPane jScrollPane2 = new JScrollPane();
		defaultTable = new JTable();
		defaultTable.setColumnSelectionAllowed(false);
		friendTab = new JPanel();
		JScrollPane jScrollPane3 = new JScrollPane();
		friendTable = new JTable();
		friendTable.setColumnSelectionAllowed(false);
		familyTab = new JPanel();
		JScrollPane jScrollPane4 = new JScrollPane();
		familyTable = new JTable();
		familyTable.setColumnSelectionAllowed(false);
		jobTab = new JPanel();
		JScrollPane jScrollPane5 = new JScrollPane();
		jobTable = new JTable();
		jobTable.setColumnSelectionAllowed(false);
		addButton = new JButton();
		modifyButton = new JButton();
		deleteButton = new JButton();

		contactButtonListener = new ContactButtonListener();
		contactTableListener = new ContactTableListener();

		// 테이블마다 마우스 리스너 add
		wholeTable.addMouseListener(contactTableListener);
		defaultTable.addMouseListener(contactTableListener);
		friendTable.addMouseListener(contactTableListener);
		familyTable.addMouseListener(contactTableListener);
		jobTable.addMouseListener(contactTableListener);

		defaultTab.setBackground(new java.awt.Color(255, 255, 255));
		defaultTab.setBorder(BorderFactory.createTitledBorder(""));
		defaultTab.setFont(new java.awt.Font("함초롬돋움", 0, 12));

		friendTab.setBackground(new java.awt.Color(255, 255, 255));
		friendTab.setBorder(BorderFactory.createTitledBorder(""));
		friendTab.setFont(new java.awt.Font("함초롬돋움", 0, 12));

		familyTab.setBackground(new java.awt.Color(255, 255, 255));
		familyTab.setBorder(BorderFactory.createTitledBorder(""));
		familyTab.setFont(new java.awt.Font("함초롬돋움", 0, 12));

		jobTab.setBackground(new java.awt.Color(255, 255, 255));
		jobTab.setBorder(BorderFactory.createTitledBorder(""));
		jobTab.setFont(new java.awt.Font("함초롬돋움", 0, 12));

		connectionSubPanel.setBackground(new java.awt.Color(255, 255, 255));
		connectionSubPanel.setBorder(BorderFactory.createTitledBorder(""));
		connectionSubPanel.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		connectionSubPanel.addMouseListener(contactTableListener);

		wholeTab.setBackground(new java.awt.Color(255, 255, 255));

		this.setBackground(new java.awt.Color(255, 255, 255));

		wholeTable.setModel
		(
				new DefaultTableModel(new Object[][] {},
				new String[] { "이름", "이메일", "전화번호", "생일" }) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		}
		);
		jScrollPane1.setViewportView(wholeTable);

		searchButton.setText("검색");
		searchButton.addActionListener(contactButtonListener);

		nameRadioBox.setBackground(new java.awt.Color(255, 255, 255));
		searchTarget.add(nameRadioBox);
		nameRadioBox.setSelected(true);
		nameRadioBox.setText("이름");

		emailRadioBox.setBackground(new java.awt.Color(255, 255, 255));
		searchTarget.add(emailRadioBox);
		emailRadioBox.setText("이메일");

		phoneRadioBox.setBackground(new java.awt.Color(255, 255, 255));
		searchTarget.add(phoneRadioBox);
		phoneRadioBox.setText("전화번호");

		birthRadioBox.setBackground(new java.awt.Color(255, 255, 255));
		searchTarget.add(birthRadioBox);
		birthRadioBox.setText("생일");

		GroupLayout wholeTabLayout = new GroupLayout(wholeTab);
		wholeTab.setLayout(wholeTabLayout);
		wholeTabLayout
				.setHorizontalGroup(wholeTabLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE,
								704, Short.MAX_VALUE)
						.addGroup(
								wholeTabLayout
										.createSequentialGroup()
										.addGap(178, 178, 178)
										.addComponent(searchField,
												GroupLayout.PREFERRED_SIZE,
												129, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(searchButton)
										.addGap(26, 26, 26)
										.addComponent(nameRadioBox)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(emailRadioBox)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(phoneRadioBox)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(birthRadioBox)
										.addContainerGap()));
		wholeTabLayout.setVerticalGroup(wholeTabLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				wholeTabLayout
						.createSequentialGroup()
						.addGap(0, 6, Short.MAX_VALUE)
						.addGroup(
								wholeTabLayout
										.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
										.addComponent(searchField,
												GroupLayout.PREFERRED_SIZE, 21,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(searchButton)
										.addComponent(nameRadioBox)
										.addComponent(emailRadioBox)
										.addComponent(phoneRadioBox)
										.addComponent(birthRadioBox))
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
								279, GroupLayout.PREFERRED_SIZE)));

		connectionSubPanel.addTab("전체", wholeTab);

		defaultTable.setModel(
				new DefaultTableModel(new Object[][] {},
				new String[] { "이름", "이메일", "전화번호", "생일" }) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		}
		);
		jScrollPane2.setViewportView(defaultTable);

		GroupLayout defaultTabLayout = new GroupLayout(defaultTab);
		defaultTab.setLayout(defaultTabLayout);
		defaultTabLayout.setHorizontalGroup(defaultTabLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 704,
						Short.MAX_VALUE));

		defaultTabLayout.setVerticalGroup(defaultTabLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(jScrollPane2,
				GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE));

		connectionSubPanel.addTab("미지정", defaultTab);

		friendTable.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		friendTable.setModel(
				new DefaultTableModel(new Object[][] {},
				new String[] { "이름", "이메일", "전화번호", "생일" }) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		}
		);
		jScrollPane3.setViewportView(friendTable);

		GroupLayout friendTabLayout = new GroupLayout(friendTab);
		friendTab.setLayout(friendTabLayout);
		friendTabLayout.setHorizontalGroup(friendTabLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(jScrollPane3,
				GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE));
		friendTabLayout.setVerticalGroup(friendTabLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(jScrollPane3,
				GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 318,
				Short.MAX_VALUE));

		connectionSubPanel.addTab("친구", friendTab);

		familyTab.setName("가족"); // NOI18N

		familyTable.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		familyTable.setModel(
				new DefaultTableModel(new Object[][] {},
				new String[] { "이름", "이메일", "전화번호", "생일" }) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		}
		);
		jScrollPane4.setViewportView(familyTable);

		GroupLayout familyTabLayout = new GroupLayout(familyTab);
		familyTab.setLayout(familyTabLayout);
		familyTabLayout.setHorizontalGroup(familyTabLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(jScrollPane4,
				GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE));
		familyTabLayout.setVerticalGroup(familyTabLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(jScrollPane4,
				GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 318,
				Short.MAX_VALUE));

		connectionSubPanel.addTab("가족", familyTab);

		jobTable.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jobTable.setModel(
				new DefaultTableModel(new Object[][] {},
				new String[] { "이름", "이메일", "전화번호", "생일" }) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		}
		);
		jScrollPane5.setViewportView(jobTable);

		GroupLayout jobTabLayout = new GroupLayout(jobTab);
		jobTab.setLayout(jobTabLayout);
		jobTabLayout.setHorizontalGroup(jobTabLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(jScrollPane5,
				GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE));
		jobTabLayout.setVerticalGroup(jobTabLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(jScrollPane5,
				GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 318,
				Short.MAX_VALUE));

		connectionSubPanel.addTab("직장", jobTab);

		addButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		addButton.setText("추가");
		addButton.addActionListener(contactButtonListener);

		modifyButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		modifyButton.setText("수정");
		modifyButton.addActionListener(contactButtonListener);

		deleteButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		deleteButton.setText("삭제");
		deleteButton.addActionListener(contactButtonListener);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(275,
																		275,
																		275)
																.addComponent(
																		addButton)
																.addGap(18, 18,
																		18)
																.addComponent(
																		modifyButton)
																.addGap(18, 18,
																		18)
																.addComponent(
																		deleteButton))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(20, 20,
																		20)
																.addComponent(
																		connectionSubPanel,
																		GroupLayout.PREFERRED_SIZE,
																		713,
																		GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(23, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(60, 60, 60)
								.addComponent(connectionSubPanel,
										GroupLayout.PREFERRED_SIZE, 353,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(addButton)
												.addComponent(modifyButton)
												.addComponent(deleteButton))
								.addContainerGap(72, Short.MAX_VALUE)));
	}

	private class ContactButtonListener implements ActionListener {
		private ContactController conController = ContactController
				.getInstance();
		private AddContactUI addContactUI;
		private ModifyContactUI modifyContactUI;

		private DefaultTableModel wholeModel;
		private DefaultTableModel defaultModel;
		private DefaultTableModel friendModel;
		private DefaultTableModel familyModel;
		private DefaultTableModel jobModel;

		public void actionPerformed(ActionEvent e) {
			// 버튼리스너 3개 추가 수정 삭제
			if (e.getActionCommand().equals("추가")) {
				wholeTable.clearSelection();
				defaultTable.clearSelection();
				friendTable.clearSelection();
				familyTable.clearSelection();
				jobTable.clearSelection();
				addContactUI = new AddContactUI(wholeTable, defaultTable,
						friendTable, familyTable, jobTable);
				addContactUI.setVisible(true);
			} else if (e.getActionCommand().equals("수정")) // 이건확인 버튼 눙렀을때 성공시
															// 다이어리
			{
				String str[] = new String[5];
				if (wholeTable.getSelectedRowCount() == 1
						|| defaultTable.getSelectedRowCount() == 1
						|| friendTable.getSelectedRowCount() == 1
						|| familyTable.getSelectedRowCount() == 1
						|| jobTable.getSelectedRowCount() == 1) {
					if (wholeTable.getSelectedRowCount() == 1) {
						str[0] = (String) wholeTable.getValueAt(
								wholeTable.getSelectedRow(), 0);
						str[1] = (String) wholeTable.getValueAt(
								wholeTable.getSelectedRow(), 1);
						str[2] = (String) wholeTable.getValueAt(
								wholeTable.getSelectedRow(), 2);
						str[3] = (String) wholeTable.getValueAt(
								wholeTable.getSelectedRow(), 3);
						str[4] = conController.confirmGroup(str[0], str[2]);
					} else if (defaultTable.getSelectedRowCount() == 1) {
						str[0] = (String) defaultTable.getValueAt(
								defaultTable.getSelectedRow(), 0);
						str[1] = (String) defaultTable.getValueAt(
								defaultTable.getSelectedRow(), 1);
						str[2] = (String) defaultTable.getValueAt(
								defaultTable.getSelectedRow(), 2);
						str[3] = (String) defaultTable.getValueAt(
								defaultTable.getSelectedRow(), 3);
						str[4] = "미지정";
					} else if (friendTable.getSelectedRowCount() == 1) {
						str[0] = (String) friendTable.getValueAt(
								friendTable.getSelectedRow(), 0);
						str[1] = (String) friendTable.getValueAt(
								friendTable.getSelectedRow(), 1);
						str[2] = (String) friendTable.getValueAt(
								friendTable.getSelectedRow(), 2);
						str[3] = (String) friendTable.getValueAt(
								friendTable.getSelectedRow(), 3);
						str[4] = "친구";
					} else if (familyTable.getSelectedRowCount() == 1) {
						str[0] = (String) familyTable.getValueAt(
								familyTable.getSelectedRow(), 0);
						str[1] = (String) familyTable.getValueAt(
								familyTable.getSelectedRow(), 1);
						str[2] = (String) familyTable.getValueAt(
								familyTable.getSelectedRow(), 2);
						str[3] = (String) familyTable.getValueAt(
								familyTable.getSelectedRow(), 3);
						str[4] = "가족";
					} else if (jobTable.getSelectedRowCount() == 1) {
						str[0] = (String) jobTable.getValueAt(
								jobTable.getSelectedRow(), 0);
						str[1] = (String) jobTable.getValueAt(
								jobTable.getSelectedRow(), 1);
						str[2] = (String) jobTable.getValueAt(
								jobTable.getSelectedRow(), 2);
						str[3] = (String) jobTable.getValueAt(
								jobTable.getSelectedRow(), 3);
						str[4] = "직장";
					}
					modifyContactUI = new ModifyContactUI(str, wholeTable,
							defaultTable, friendTable, familyTable, jobTable);
					modifyContactUI.setVisible(true);
				} else {
					;
				}
			} else if (e.getActionCommand().equals("검색")) {
				wholeModel = (DefaultTableModel) wholeTable.getModel();
				defaultModel = (DefaultTableModel) defaultTable.getModel();
				friendModel = (DefaultTableModel) friendTable.getModel();
				familyModel = (DefaultTableModel) familyTable.getModel();
				jobModel = (DefaultTableModel) jobTable.getModel();

				while (wholeTable.getModel().getRowCount() > 0)
					((DefaultTableModel) wholeTable.getModel()).removeRow(0);

				if (searchField.getText().equals("")) {
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
				} else {
					if (nameRadioBox.isSelected()) {
						String arr[] = new String[4];
						LinkedList<String> str = (LinkedList<String>) conController
								.search(PersonInfo.NAME, searchField.getText());

						for (int i = 0; i < str.size(); i += 4) {
							arr[0] = str.get(i);
							arr[1] = str.get(i + 1);
							arr[2] = str.get(i + 2);
							arr[3] = str.get(i + 3);
							wholeModel.addRow(arr);
						}
					} else if (emailRadioBox.isSelected()) {
						String arr[] = new String[4];
						LinkedList<String> str = (LinkedList<String>) conController
								.search(PersonInfo.EMAIL, searchField.getText());

						for (int i = 0; i < str.size(); i += 4) {
							arr[0] = str.get(i);
							arr[1] = str.get(i + 1);
							arr[2] = str.get(i + 2);
							arr[3] = str.get(i + 3);
							wholeModel.addRow(arr);
						}
					} else if (phoneRadioBox.isSelected()) {
						String arr[] = new String[4];
						LinkedList<String> str = (LinkedList<String>) conController
								.search(PersonInfo.PHONE, searchField.getText());

						for (int i = 0; i < str.size(); i += 4) {
							arr[0] = str.get(i);
							arr[1] = str.get(i + 1);
							arr[2] = str.get(i + 2);
							arr[3] = str.get(i + 3);
							wholeModel.addRow(arr);
						}
					} else {
						String arr[] = new String[4];
						LinkedList<String> str = (LinkedList<String>) conController
								.search(PersonInfo.BIRTHDAY,
										searchField.getText());

						for (int i = 0; i < str.size(); i += 4) {
							arr[0] = str.get(i);
							arr[1] = str.get(i + 1);
							arr[2] = str.get(i + 2);
							arr[3] = str.get(i + 3);
							wholeModel.addRow(arr);
						}
					}
				}
			} else // 삭제
			{
				wholeModel = (DefaultTableModel) wholeTable.getModel();
				defaultModel = (DefaultTableModel) defaultTable.getModel();
				friendModel = (DefaultTableModel) friendTable.getModel();
				familyModel = (DefaultTableModel) familyTable.getModel();
				jobModel = (DefaultTableModel) jobTable.getModel();
				List<String> list;
				LinkedList<String> str;
				String arr[];
				if (wholeTable.getSelectedRowCount() >= 1) {
					arr = new String[4];
					list = new LinkedList<String>();
					int num[] = wholeTable.getSelectedRows();
					for (int i = 0; i < num.length; i++) {
						list.add((String) wholeTable.getValueAt(num[i], 0));
						list.add((String) wholeTable.getValueAt(num[i], 1));
						list.add((String) wholeTable.getValueAt(num[i], 2));
						list.add((String) wholeTable.getValueAt(num[i], 3));
					}
					conController.remove(list);
				} else if (defaultTable.getSelectedRowCount() >= 1) {
					arr = new String[4];
					list = new LinkedList<String>();
					int num[] = defaultTable.getSelectedRows();
					for (int i = 0; i < num.length; i++) {
						list.add((String) defaultTable.getValueAt(num[i], 0));
						list.add((String) defaultTable.getValueAt(num[i], 1));
						list.add((String) defaultTable.getValueAt(num[i], 2));
						list.add((String) defaultTable.getValueAt(num[i], 3));
					}
					conController.remove(list);
					} else if (friendTable.getSelectedRowCount() >= 1) {
					
					arr = new String[4];
					list = new LinkedList<String>();
					int num[] = friendTable.getSelectedRows();
					for (int i = 0; i < num.length; i++) {
						list.add((String) friendTable.getValueAt(num[i], 0));
						list.add((String) friendTable.getValueAt(num[i], 1));
						list.add((String) friendTable.getValueAt(num[i], 2));
						list.add((String) friendTable.getValueAt(num[i], 3));
					}
					conController.remove(list);
					} else if (familyTable.getSelectedRowCount() >= 1) {
					arr = new String[4];
					list = new LinkedList<String>();
					int num[] = familyTable.getSelectedRows();
					for (int i = 0; i < num.length; i++) {
						list.add((String) familyTable.getValueAt(num[i], 0));
						list.add((String) familyTable.getValueAt(num[i], 1));
						list.add((String) familyTable.getValueAt(num[i], 2));
						list.add((String) familyTable.getValueAt(num[i], 3));
					}
					conController.remove(list);
					} else if (jobTable.getSelectedRowCount() >= 1) {
					arr = new String[4];
					list = new LinkedList<String>();
					int num[] = jobTable.getSelectedRows();
					for (int i = 0; i < num.length; i++) {
						list.add((String) jobTable.getValueAt(num[i], 0));
						list.add((String) jobTable.getValueAt(num[i], 1));
						list.add((String) jobTable.getValueAt(num[i], 2));
						list.add((String) jobTable.getValueAt(num[i], 3));
					}
					conController.remove(list);
				} else {
					;
				}
				setTable();
			}
		}
	}

	private class ContactTableListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 1 && e.getSource() == connectionSubPanel) {
				wholeTable.getUpdateSelectionOnSort();
				defaultTable.getUpdateSelectionOnSort();
				friendTable.getUpdateSelectionOnSort();
				familyTable.getUpdateSelectionOnSort();
				jobTable.getUpdateSelectionOnSort();

				wholeTable.clearSelection();
				defaultTable.clearSelection();
				friendTable.clearSelection();
				familyTable.clearSelection();
				jobTable.clearSelection();
			}
		}
	}

}
