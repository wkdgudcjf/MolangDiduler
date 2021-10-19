
package diduler.mainUI;

import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

//import com.sun.java.swing.plaf.windows.TMSchema.Control;

public class ViewDidulerUI extends JFrame {

	private JRadioButton allRadioButton;
	private JButton cancelButton;
	private JButton deleteButton;
	private JCheckBox diaryCheckBox;
	private JComboBox endDay;
	private JComboBox endMonth;
	private JComboBox endYear;
	private JButton modifyButton;
	private JRadioButton monthRadioButton;
	private JPanel panel1;
	private JPanel panel2;
	private JRadioButton periodRadioButton;
	private JCheckBox scheduleCheckBox;
	private JButton searchButton;
	private JTextField searchField;
	private JComboBox searchObject;
	private ButtonGroup searchScope;
	private JComboBox startDay;
	private JComboBox startMonth;
	private JComboBox startYear;
	private JTable jTable;
	
	
	public ViewDidulerUI() {
		initComponents();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				//이전에 텍스트필드 초기화 필요함
				setVisible(false);
			}
		});
		allRadioButton.setSelected(true);
		diaryCheckBox.setSelected(true);
		scheduleCheckBox.setSelected(true);
		
	}

	private void initComponents() {
		
		JLabel jLabel2;
		JLabel jlDay1;
		JLabel jlDay2;
		JLabel jlMonth1;
		JLabel jlMonth2;
		JLabel jlSearch;
		JLabel jlTarget;
		JLabel jlTitlt;
		JLabel jlYear1;
		JLabel jlYear2;
		JScrollPane jspPane;

		searchScope = new ButtonGroup();
		panel1 = new JPanel();
		jlSearch = new JLabel();
		allRadioButton = new JRadioButton();
		monthRadioButton = new JRadioButton();
		periodRadioButton = new JRadioButton();
		jlTarget = new JLabel();
		diaryCheckBox = new JCheckBox();
		scheduleCheckBox = new JCheckBox();
		panel2 = new JPanel();
		startYear = new JComboBox();
		startMonth = new JComboBox();
		startDay = new JComboBox();
		jlTitlt = new JLabel();
		jlYear1 = new JLabel();
		jlMonth1 = new JLabel();
		jlDay1 = new JLabel();
		endMonth = new JComboBox();
		jlYear2 = new JLabel();
		endDay = new JComboBox();
		jlDay2 = new JLabel();
		endYear = new JComboBox();
		jlMonth2 = new JLabel();
		searchObject = new JComboBox();
		searchField = new JTextField();
		searchButton = new JButton();
		jspPane = new JScrollPane();
		jTable = new JTable();
		cancelButton = new JButton();
		modifyButton = new JButton();
		deleteButton = new JButton();
		jLabel2 = new JLabel();

		setTitle("다이쥴러 보기");
		setPreferredSize(new java.awt.Dimension(500, 480));
		setResizable(false);

		panel1.setBackground(new java.awt.Color(255, 255, 255));
		panel1.setPreferredSize(new java.awt.Dimension(500, 480));
		panel1.setLayout(null);

		jlSearch.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		jlSearch.setText("검색범위 : ");
		panel1.add(jlSearch);
		jlSearch.setBounds(22, 19, 60, 16);

		searchScope.add(allRadioButton);
		allRadioButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		allRadioButton.setText("전체");
		panel1.add(allRadioButton);
		allRadioButton.setBounds(100, 15, 49, 25);

		searchScope.add(monthRadioButton);
		monthRadioButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		monthRadioButton.setText("최근한달");
		panel1.add(monthRadioButton);
		monthRadioButton.setBounds(167, 15, 73, 25);

		searchScope.add(periodRadioButton);
		periodRadioButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		periodRadioButton.setText("기간선택");
		panel1.add(periodRadioButton);
		periodRadioButton.setBounds(258, 15, 73, 25);

		jlTarget.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlTarget.setHorizontalAlignment(SwingConstants.RIGHT);
		jlTarget.setText("검색대상 : ");
		panel1.add(jlTarget);
		jlTarget.setBounds(22, 62, 60, 16);

		diaryCheckBox.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		diaryCheckBox.setText("일기");
		panel1.add(diaryCheckBox);
		diaryCheckBox.setBounds(100, 58, 49, 25);

		scheduleCheckBox.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		scheduleCheckBox.setText("일정");
		panel1.add(scheduleCheckBox);
		scheduleCheckBox.setBounds(167, 58, 49, 25);

		panel2.setBackground(new java.awt.Color(255, 255, 255));
		panel2.setPreferredSize(new java.awt.Dimension(440, 42));

		jlTitlt.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlTitlt.setText("~");

		jlYear1.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlYear1.setText("년");

		jlMonth1.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlMonth1.setText("월");

		jlDay1.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlDay1.setText("일");

		jlYear2.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlYear2.setText("년");


		jlDay2.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlDay2.setText("일");

		jlMonth2.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jlMonth2.setText("월");

		GroupLayout panel2Layout = new GroupLayout(panel2);
		panel2.setLayout(panel2Layout);
		panel2Layout.setHorizontalGroup(panel2Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(
						panel2Layout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(startYear,
										GroupLayout.PREFERRED_SIZE, 66,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jlYear1)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(startMonth,
										GroupLayout.PREFERRED_SIZE, 48,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jlMonth1)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(startDay,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jlDay1)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jlTitlt)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(endYear,
										GroupLayout.PREFERRED_SIZE, 66,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jlYear2)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(endMonth,
										GroupLayout.PREFERRED_SIZE, 48,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jlMonth2)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(endDay,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jlDay2)
								.addContainerGap(47, Short.MAX_VALUE)));
		panel2Layout
				.setVerticalGroup(panel2Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												panel2Layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																panel2Layout
																		.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				endYear,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				endMonth,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				endDay,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jlYear2)
																		.addComponent(
																				jlMonth2)
																		.addComponent(
																				jlDay2))
														.addGroup(
																panel2Layout
																		.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				startYear,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				startMonth,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				startDay,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jlTitlt)
																		.addComponent(
																				jlYear1)
																		.addComponent(
																				jlMonth1)
																		.addComponent(
																				jlDay1)))
										.addContainerGap(11, Short.MAX_VALUE)));

		panel1.add(panel2);
		panel2.setBounds(0, 93, 500, 42);
		panel2.setVisible(false);

		searchObject.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		searchObject.setModel(new DefaultComboBoxModel(new String[] { "제목",
				"제목+내용" }));
		panel1.add(searchObject);
		searchObject.setBounds(22, 142, 88, 22);
		panel1.add(searchField);
		searchField.setBounds(117, 143, 285, 21);

		searchButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		searchButton.setText("검색");
		panel1.add(searchButton);
		searchButton.setBounds(409, 141, 57, 25);

		jspPane.setPreferredSize(new java.awt.Dimension(455, 400));

		jTable.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jTable.setModel(new DefaultTableModel(new Object[][] {
				 }, new String[] {
				"제목", "작성날짜", "공개범위" }) {
			
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
			
		});
		jspPane.setViewportView(jTable);

		panel1.add(jspPane);
		jspPane.setBounds(22, 176, 440, 203);

		cancelButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		cancelButton.setText("취소");
		panel1.add(cancelButton);
		cancelButton.setBounds(405, 397, 57, 25);

		modifyButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		modifyButton.setText("수정");
		panel1.add(modifyButton);
		modifyButton.setBounds(330, 397, 57, 25);

		deleteButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		deleteButton.setText("삭제");
		panel1.add(deleteButton);
		deleteButton.setBounds(255, 397, 57, 25);

		jLabel2.setIcon(new ImageIcon("mo2.png")); // NOI18N
		panel1.add(jLabel2);
		jLabel2.setBounds(350, 10, 56, 73);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 20, Short.MAX_VALUE)));
		setLocation(500, 200);
		pack();	
		
		//이로운		
		scheduleSetting();
		DidulerButtonListener didulerListener = new DidulerButtonListener();
		RadioButtonListener radioListener = new RadioButtonListener();
		TableListener tablelistener = new TableListener();
		ComboBoxListener comboBoxListener = new ComboBoxListener();
		
		jTable.addMouseListener(tablelistener);
		allRadioButton.addActionListener(radioListener);
		monthRadioButton.addActionListener(radioListener);
		periodRadioButton.addActionListener(radioListener);
		searchButton.addActionListener(didulerListener);		
		cancelButton.addActionListener(didulerListener);
		modifyButton.addActionListener(didulerListener);
		deleteButton.addActionListener(didulerListener);
		startYear.addActionListener(comboBoxListener);
		startMonth.addActionListener(comboBoxListener);
		endYear.addActionListener(comboBoxListener);
		endMonth.addActionListener(comboBoxListener);
	}
	
	
	/**
	 * 스케줄
	 */
	public void scheduleSetting()
	{		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day);
		int lastDay = calendar.getActualMaximum(Calendar.DATE);
		
		for(int cnt=year-10; cnt<=year+10; cnt++)
		{
			startYear.addItem(Integer.toString(cnt));
			endYear.addItem(Integer.toString(cnt));			
		}
		startYear.setSelectedItem(Integer.toString(year));
		endYear.setSelectedItem(Integer.toString(year));
		
		for(int cnt=1; cnt<=12; cnt++)
		{
			startMonth.addItem(Integer.toString(cnt));
			endMonth.addItem(Integer.toString(cnt));
		}
		startMonth.setSelectedItem(Integer.toString(month));
		endMonth.setSelectedItem(Integer.toString(month));
		
		
		for(int cnt=1; cnt<=lastDay; cnt++)
		{
			startDay.addItem(Integer.toString(cnt));
			endDay.addItem(Integer.toString(cnt));
		}
		startDay.setSelectedItem(Integer.toString(day));
		endDay.setSelectedItem(Integer.toString(day));		
	}	
	public void setVisible(boolean b)
	{
		super.setVisible(b);
		allRadioButton.setSelected(true);
		diaryCheckBox.setSelected(true);
		scheduleCheckBox.setSelected(true);
		setTable();
	}
	private void setTable()
	{

		ScheduleController control = ScheduleController.getInstance();
		List<String[]> list = control.read();
		String[] arr = new String[3];
		DefaultTableModel model = (DefaultTableModel)jTable.getModel();
		
		while(model.getRowCount()>0)
			model.removeRow(0);
		
		for (int cnt = 0; cnt < list.size(); cnt++) 
		{
			arr[0] = list.get(cnt)[0];
			arr[1] = list.get(cnt)[1];
			arr[2] = list.get(cnt)[2];
			
			model.addRow(arr);
		}
        DiaryController controll=DiaryController.getInstance();
		
		list = controll.getTableValueList();
				
		int size = list.size();
						
		for (int cnt = 0; cnt < size; cnt++) 
		{
			arr[0] = list.get(cnt)[0];
			arr[1] = list.get(cnt)[1];
			arr[2] = list.get(cnt)[2];
			
			model.addRow(arr);
		}
	}
	private class ComboBoxListener implements ActionListener	// 콤보박스
	{		
		public ComboBoxListener()
		{
			
		}
		public int getMaxDay(JComboBox yearCombo, JComboBox monthCombo)
		{
			Calendar calendar = Calendar.getInstance();
			int year = Integer.parseInt((String)yearCombo.getSelectedItem());
			int month = Integer.parseInt((String)monthCombo.getSelectedItem());
			calendar.set(year, month-1, 1);
			
			return calendar.getActualMaximum(Calendar.DATE);			
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == (JComboBox)startYear || e.getSource() == (JComboBox)startMonth)
			{
				//시작 년, 월 콤보박스
				int maxDay = getMaxDay(startYear, startMonth);
				startDay.removeAllItems();
				for(int cnt=1; cnt<=maxDay; cnt++)
				{
					startDay.addItem(Integer.toString(cnt));
				}
			}
			else if(e.getSource() == (JComboBox)endYear || e.getSource() == (JComboBox)endMonth)
			{
				//끝 년, 월 콤보박스
				int maxDay = getMaxDay(endYear, endMonth);
				endDay.removeAllItems();
				for(int cnt=1; cnt<=maxDay; cnt++)
				{
					endDay.addItem(Integer.toString(cnt));
				}
			}
		}
	}
	// 테이블 리스너
	private class TableListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) //더블클릭하였을시 
			{
				if((jTable.getSelectedRowCount()==1)&&(diaryCheckBox.isSelected())&&(scheduleCheckBox.isSelected()))  //하나의 행만 선택하고 다이어리 박스와 체크박스가 체그되었을 경우
				{
					if(jTable.getSelectedRow()<ScheduleController.getInstance().getScheduleManagement().getScheduleList().getDidulerListNum()) //선택된 행이 
					{
						List<String> list =ScheduleController.getInstance().get(jTable.getSelectedRow());
						ViewScheduleUI viewSchedule = new ViewScheduleUI(jTable, jTable.getSelectedRow(), list.get(0), list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8), list.get(9),list.get(10));
						viewSchedule.setVisible(true);

					}
					else //더블 클릭시 이미지 
					{
						
						int row=jTable.getSelectedRow()-ScheduleController.getInstance().getScheduleManagement().getScheduleList().getDidulerListNum();	//선택된 행에서 스케줄만큼을 빼고 
		
						List<String> list =DiaryController.getInstance().get(row);
						Image bk=null; //임시
						try {
							if(list.get(2)!=null)
								bk = ImageIO.read(new File(list.get(2))); //파일을 생성 

						} catch (IOException ie) {
						}
						ViewDiaryUI viewDiaryui=new ViewDiaryUI(list.get(0),list.get(1),bk,list.get(3),row,ScheduleController.getInstance().getScheduleManagement().getScheduleList().getDidulerListNum(),jTable);
						viewDiaryui.setVisible(true);
					
					}
					
					
				}
				//일정만 체크 하였을 경우 
				else if((jTable.getSelectedRowCount()==1)&&(!diaryCheckBox.isSelected())&&(scheduleCheckBox.isSelected()))  
				{
					int row=jTable.getSelectedRow();
					List<String> list =ScheduleController.getInstance().get(jTable.getSelectedRow());
					ViewScheduleUI viewSchedule = new ViewScheduleUI(jTable, jTable.getSelectedRow(), list.get(0), list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8), list.get(9),list.get(10));
					viewSchedule.setVisible(true);
					
				}
				//하나만 선택되고 
				else if((jTable.getSelectedRowCount()==1)&&(diaryCheckBox.isSelected())&&(!scheduleCheckBox.isSelected()))  
				{
					int row=jTable.getSelectedRow();	//선택된 행에서 스케줄만큼을 빼고 
					List<String> list =DiaryController.getInstance().get(jTable.getSelectedRow());
					Image bk=null; //임시
					try {
						if(list.get(2)!=null)
							bk = ImageIO.read(new File(list.get(2))); //파일을 생성 

					} catch (IOException ie) {
					}
					ViewDiaryUI viewDiaryui=new ViewDiaryUI(list.get(0),list.get(1),bk,list.get(3),row,jTable,null);
					viewDiaryui.setVisible(true);
				
				}
				
			}
		}
	}
	// 라디오 버튼 리스너
	private class RadioButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "기간선택") {
				panel2.setVisible(true);
			} else {
				panel2.setVisible(false);
			}
		}
	}
	
	//버튼 리스너
	private class DidulerButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==searchButton)  //검색버튼 눌렀을 경우 
			{
				if((allRadioButton.isSelected())&&(diaryCheckBox.isSelected())&&(scheduleCheckBox.isSelected())) //전체기간검색+일정+일기
					setTable();  
				else if((allRadioButton.isSelected())&&(!diaryCheckBox.isSelected())&&(scheduleCheckBox.isSelected())) //전체기간검색+스케줄
				{
					ScheduleController control = ScheduleController.getInstance(); 
					List<String[]> list = control.read();
					String[] arr = new String[3];
					DefaultTableModel model = (DefaultTableModel)jTable.getModel();
					
					while(model.getRowCount()>0)
						model.removeRow(0);
					
					for (int cnt = 0; cnt < list.size(); cnt++) 
					{
						arr[0] = list.get(cnt)[0];
						arr[1] = list.get(cnt)[1];
						arr[2] = list.get(cnt)[2];
						
						model.addRow(arr);
					}

				}
				
				
				
				
				else if((allRadioButton.isSelected())&&(diaryCheckBox.isSelected())&&(!scheduleCheckBox.isSelected()))//전체기간검색+일기
				{
					DiaryController controll=DiaryController.getInstance();
					
					List<String[]> list = controll.getTableValueList();
					String[] arr = new String[3];
					DefaultTableModel model = (DefaultTableModel)jTable.getModel();
					int size = list.size();
					while(model.getRowCount()>0)
						model.removeRow(0);
					for (int cnt = 0; cnt < size; cnt++) 
					{
						arr[0] = list.get(cnt)[0];
						arr[1] = list.get(cnt)[1];
						arr[2] = list.get(cnt)[2];
						
						model.addRow(arr);
					}
				
					
				
				}
			}
			else if(e.getSource()==deleteButton)   //삭제버튼 눌렀을시 
			{
				//ScheduleController.getInstance().getScheduleManagement().getDidulerList().getDidulerListNum();
				int row[] = jTable.getSelectedRows();
				
					if(row.length == 0) //선택된거 없을 때 
						return;
				
				DefaultTableModel model = (DefaultTableModel) jTable.getModel();
			//	System.out.println("row"+row[0]);
				for(int i=row.length-1; i>=0; i--)
				{
					if(row[i]+1>ScheduleController.getInstance().getScheduleManagement().getDidulerList().getDidulerListNum())
					{		
						model.removeRow(row[i]);
						DiaryController.getInstance().removeDiary(row[i]-ScheduleController.getInstance().getScheduleManagement().getDidulerList().getDidulerListNum());

					}
					else
					{
					model.removeRow(row[i]);
					ScheduleController.getInstance().remove(row[i]);
					}
				}
				
				
			}
			else if(e.getSource()==modifyButton) //수정버튼 눌렀을때 
			{
				if(jTable.getSelectedRowCount()==1)
				{
					if(jTable.getSelectedRow()+1>ScheduleController.getInstance().getScheduleManagement().getDidulerList().getDidulerListNum())//다이어리 수정시
					{
						
						int row=(jTable.getSelectedRow())-ScheduleController.getInstance().getScheduleManagement().getDidulerList().getDidulerListNum();
						
						List<String> list =DiaryController.getInstance().get(row);
						Image bk=null; //임시
						try {
							if(list.get(2)!=null)
								bk = ImageIO.read(new File(list.get(2))); //파일을 생성 

						} catch (IOException ie) {
						}
						ViewDiaryUI viewDiaryui=new ViewDiaryUI(list.get(0),list.get(1),bk,list.get(3),row,jTable,null);
						viewDiaryui.modifyVersion();
						//viewDiaryui.setEditMode();
						viewDiaryui.setVisible(true);
						
					}
					
					else{
					List<String> list =ScheduleController.getInstance().get(jTable.getSelectedRow());
					ViewScheduleUI viewSchedule = new ViewScheduleUI(jTable, jTable.getSelectedRow(), list.get(0), list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8), list.get(9),list.get(10));
					viewSchedule.setEditMode();
					viewSchedule.setVisible(true);
					}
				
				
				}
				
			}
			else if(e.getSource()==cancelButton)
			{
				setVisible(false);
			}
		}
	}
	

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ViewDidulerUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ViewDidulerUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ViewDidulerUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ViewDidulerUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ViewDidulerUI().setVisible(true);
			}
		});
	}
}
