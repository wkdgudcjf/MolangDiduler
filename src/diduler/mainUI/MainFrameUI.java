package diduler.mainUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.*;

import diduler.login.LogoutController;
import diduler.model.backup.DiaryBackUp;
import diduler.model.backup.PersonBackUp;
import diduler.model.backup.ScheduleBackUp;
import diduler.model.bgm.BGMController;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainFrameUI extends JFrame {

	private class MenuPanel extends JPanel {
		private JMenuItem exportMenu;
		private JMenuItem importMenu;

		private JPopupMenu backUpPopUpMenu;

		private JSlider transParencySlider;

		private JButton mainImage; // 메뉴
		private JLabel bgmTitleLabel;

		private PlayListUI playFrame = new PlayListUI();
		private JButton bgmListButton;
		private JButton bgmPauseButton;
		private JButton bgmPlayButton;
		private JButton bgmStopButton;
		private JButton calendarButton;
		private JButton connectionsButton;
		private JLabel messageLabel; // 메뉴

		public MenuPanel() {
			BackUpButtonListener backupListener = new BackUpButtonListener();
			MainImageButtonListener imageListener = new MainImageButtonListener();
			BgmButtonListener bgmlistener = new BgmButtonListener();
			MenuButtonListener menuListener = new MenuButtonListener();
			transParencySlider = new JSlider(0,100,100);
			JLabel watermarkLabel;
			JButton backUpButton;
			backUpButton = new JButton();
			backUpButton.setForeground(Color.WHITE);
			backUpButton.setFocusable(false);
			messageLabel = new JLabel();
			backUpPopUpMenu = new JPopupMenu();
			importMenu = new JMenuItem();
			exportMenu = new JMenuItem();
			watermarkLabel = new JLabel();
			imageListener = new MainImageButtonListener();
			bgmlistener = new BgmButtonListener();
			menuListener = new MenuButtonListener();
			calendarButton = new JButton();
			connectionsButton = new JButton();
			bgmTitleLabel = new JLabel();
			bgmListButton = new JButton();
			bgmPlayButton = new JButton();
			bgmStopButton = new JButton();
			bgmPauseButton = new JButton();
			mainImage = new JButton();
			setBackground(new java.awt.Color(255, 255, 255));
			setLayout(null);
			importMenu.setText("가져오기");
			backUpPopUpMenu.add(importMenu);

			importMenu.addActionListener(backupListener);
			exportMenu.addActionListener(backupListener);
			exportMenu.setText("내보내기");
			exportMenu.setComponentPopupMenu(backUpPopUpMenu);
			backUpPopUpMenu.add(exportMenu);
			mainImage.setBackground(new java.awt.Color(255, 255, 255));
			mainImage.setBounds(20, 10, 160, 110);
			try {
				Image image = ImageIO.read(new File("import\\mainimage.jpg")); 
				Image image2 = image.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), image.SCALE_SMOOTH);
				
				ImageIcon icon = new ImageIcon(image2);
				mainImage.setIcon(icon);	
				
			} catch (Exception e) {
			}
			add(mainImage);
			
			backUpButton.setFont(new java.awt.Font("굴림체", 1, 14)); // NOI18N
			backUpButton.setForeground(new java.awt.Color(0, 51, 255));
			backUpButton.setIcon(new ImageIcon("backup2.PNG")); // NOI18N
			backUpButton.setComponentPopupMenu(backUpPopUpMenu);
			add(backUpButton);
			backUpButton.setBounds(0, 270, 160, 50);

			messageLabel.setFont(new java.awt.Font("함초롬돋움", 1, 14)); // NOI18N
			messageLabel.setText("홍승연님 환영합니다^^");
			add(messageLabel);
			messageLabel.setBounds(20, 130, 160, 20);

			calendarButton.setBackground(new java.awt.Color(255, 255, 255));
			calendarButton.setFont(new java.awt.Font("굴림체", 1, 18)); // NOI18N
			calendarButton.setForeground(new java.awt.Color(0, 51, 255));
			calendarButton.setIcon(new ImageIcon("calendar2.PNG")); // NOI18N
			calendarButton.setBorder(null);
			calendarButton.setBorderPainted(false);
			calendarButton.setHorizontalAlignment(SwingConstants.RIGHT);
			calendarButton.setMaximumSize(new java.awt.Dimension(210, 71));
			calendarButton.setPreferredSize(new java.awt.Dimension(200, 71));
			add(calendarButton);
			calendarButton.setBounds(0, 180, 200, 40);

			connectionsButton.setFont(new java.awt.Font("굴림체", 1, 14)); // NOI18N
			connectionsButton.setForeground(new java.awt.Color(0, 51, 255));
			connectionsButton.setIcon(new ImageIcon("connection8.PNG")); // NOI18N
			connectionsButton.setBorder(null);
			connectionsButton.setHorizontalAlignment(SwingConstants.RIGHT);
			add(connectionsButton);
			connectionsButton.setBounds(0, 230, 239, 40);

			bgmTitleLabel.setBackground(new java.awt.Color(255, 102, 204));
			bgmTitleLabel.setFont(new java.awt.Font("함초롬돋움", 1, 12)); // NOI18N
			bgmTitleLabel.setText("노래제목");
			bgmTitleLabel.setBorder(BorderFactory
					.createLineBorder(new java.awt.Color(0, 0, 0)));
			add(bgmTitleLabel);
			bgmTitleLabel.setBounds(10, 370, 150, 20);

			bgmListButton.setText("..");
			bgmListButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
			add(bgmListButton);
			bgmListButton.setBounds(170, 370, 15, 20);

			bgmPlayButton.setIcon(new ImageIcon("재생.PNG")); // NOI18N
			bgmPlayButton.setToolTipText("");
			bgmPlayButton.setBorder(null);

			add(bgmPlayButton);
			bgmPlayButton.setBounds(30, 400, 30, 30);

			bgmStopButton.setIcon(new ImageIcon("중지.PNG")); // NOI18N
			bgmStopButton.setBorder(null);
			add(bgmStopButton);
			bgmStopButton.setBounds(150, 400, 30, 30);

			bgmPauseButton.setIcon(new ImageIcon("일시정지.PNG")); // NOI18N
			bgmPauseButton.setToolTipText("");
			bgmPauseButton.setBorder(null);
			add(bgmPauseButton);
			bgmPauseButton.setBounds(90, 400, 31, 30);

			watermarkLabel.setFont(new java.awt.Font("함초롬돋움", 1, 12)); // NOI18N
			watermarkLabel.setText("Transparency(투명도)");
			add(watermarkLabel);
			watermarkLabel.setBounds(40, 450, 140, 16);
			add(transParencySlider);
			transParencySlider.setBounds(20, 470, 170, 23);
			/*transParencySlider.addChangeListener(new ChangeListener() {
				
				public void stateChanged(ChangeEvent e) {
					if(transParencySlider.getValue()>28)
					{
						setOpacity((float)transParencySlider.getValue()/100F);
						subFrame.setOpacity((float)transParencySlider.getValue()/100F);
					}
				}
			});*/
			
			bgmListButton.addActionListener(bgmlistener);
			bgmPlayButton.addActionListener(bgmlistener);
			bgmPauseButton.addActionListener(bgmlistener);
			bgmStopButton.addActionListener(bgmlistener);
			backupListener = new BackUpButtonListener();
			connectionsButton.addActionListener(menuListener);
			calendarButton.addActionListener(menuListener);
			mainImage.addActionListener(imageListener);
		}
		public void setMessage(String name)
		{
			messageLabel.setText(name+"님 환영합니다.");
		}
		private class PlayListUI extends JFrame {
			private JButton addButton;
			private JButton deleteButton;
			private JPanel panel1;
			private JTable playListUITable;
			
			public PlayListUI() {
				initComponents();
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e)
					{
						setVisible(false);
					}
				});
			}

			private void initComponents() {
				PlayListButtonListener buttonListener;
				JLabel jLabel1 = new JLabel();
				setLocation(500, 200);
				panel1 = new JPanel();
				JScrollPane jspPlayListUI = new JScrollPane();
				
				addButton = new JButton();
				deleteButton = new JButton();
				buttonListener = new PlayListButtonListener();

				setTitle("Play List");
				setBackground(new java.awt.Color(255, 255, 255));
				setResizable(false);

				panel1.setBackground(new java.awt.Color(255, 255, 255));
				panel1.setPreferredSize(new java.awt.Dimension(350, 300));

				jspPlayListUI.setPreferredSize(new java.awt.Dimension(350, 275));

				
				DefaultTableModel model = new DefaultTableModel(new String[] { "노래제목" }, 0)
				{
					public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				};
				playListUITable = new JTable(model);
				playListUITable.setBorder(BorderFactory.createEtchedBorder());
				playListUITable.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
				playListUITable.setCellSelectionEnabled(true);
				playListUITable.getTableHeader().setResizingAllowed(false);
				playListUITable.getTableHeader().setReorderingAllowed(false);
				playListUITable.addMouseListener(new TableListener());
				jspPlayListUI.setViewportView(playListUITable);

				addButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
				addButton.setText("추가");
				addButton.addActionListener(buttonListener);


				deleteButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
				deleteButton.setText("삭제");
				deleteButton.addActionListener(buttonListener);

				jLabel1.setIcon(new ImageIcon("mo3.png")); // NOI18N

				GroupLayout panel1Layout = new GroupLayout(panel1);
				panel1.setLayout(panel1Layout);
				panel1Layout
						.setHorizontalGroup(panel1Layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(
										panel1Layout
												.createSequentialGroup()
												.addGroup(
														panel1Layout
																.createParallelGroup(
																		GroupLayout.Alignment.LEADING)
																.addGroup(
																		panel1Layout
																				.createSequentialGroup()
																				.addGap(44,
																						44,
																						44)
																				.addComponent(
																						jLabel1)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED,
																						35,
																						Short.MAX_VALUE)
																				.addComponent(
																						addButton)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						deleteButton))
																.addGroup(
																		panel1Layout
																				.createSequentialGroup()
																				.addContainerGap()
																				.addComponent(
																						jspPlayListUI,
																						GroupLayout.PREFERRED_SIZE,
																						0,
																						Short.MAX_VALUE)))
												.addContainerGap()));
				panel1Layout
						.setVerticalGroup(panel1Layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(
										panel1Layout
												.createSequentialGroup()
												.addContainerGap()
												.addComponent(jspPlayListUI,
														GroupLayout.PREFERRED_SIZE,
														188, GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addGroup(
														panel1Layout
																.createParallelGroup(
																		GroupLayout.Alignment.LEADING)
																.addGroup(
																		panel1Layout
																				.createParallelGroup(
																						GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						deleteButton)
																				.addComponent(
																						addButton))
																.addComponent(jLabel1))
												.addContainerGap(
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)));

				GroupLayout layout = new GroupLayout(getContentPane());
				getContentPane().setLayout(layout);
				layout.setHorizontalGroup(layout.createParallelGroup(
						GroupLayout.Alignment.LEADING).addComponent(panel1,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
				layout.setVerticalGroup(layout.createParallelGroup(
						GroupLayout.Alignment.LEADING).addComponent(panel1,
						GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE));

				pack();
			}

			// 추가버튼 리스너
			private class PlayListButtonListener implements ActionListener {
				private BGMController control = BGMController.getInstance();
				public void actionPerformed(ActionEvent e) {
					if ("추가".equals(e.getActionCommand())) // 확인버튼
					{
						File[] location = new FileInputUI("wav").getSelected();
						if(location!=null)
						{
							for(int i=0; i<location.length; i++)
							{
								((DefaultTableModel)playListUITable.getModel()).addRow(new String[]{location[i].getName()});
								control.addBGM(location[i].getName(), location[i].getAbsolutePath());						
							}
						}
					}
					else 
					{
						
						int sel[] = playListUITable.getSelectedRows();
						for(int i=sel.length-1; i>=0; i--)
							((DefaultTableModel)playListUITable.getModel()).removeRow(sel[i]);
						
					}
				}
			}
			// 더블클릭 리스너
			private class TableListener extends MouseAdapter {
				private BGMController control = BGMController.getInstance();
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						if(control.getPlayingState())
						{
							control.stopPlay();
						}
						control.setNowPlaying(playListUITable.getModel().getValueAt(playListUITable.getSelectedRow(), 0).toString());
						if(control.getListNum()>0)
						{
							menuPanel.bgmTitleLabel.setText(control.getTitle());
							if(control.getState()==Thread.State.NEW)
								control.start();
							else
							{
								control.resume();
							}
						}
					}
				}
			}

		}
		
		private class BgmButtonListener implements ActionListener {
			private BGMController control  = BGMController.getInstance();
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == bgmListButton)
				{
					playFrame.setVisible(true);
				}
				else if(e.getSource()==bgmPauseButton)
				{
					if(control.getState()!=Thread.State.NEW)
						control.pausePlay();
				}
				else if(e.getSource()==bgmPlayButton)
				{
					if(control.getListNum()>0)
					{
						bgmTitleLabel.setText(control.getTitle());
						if(control.getState()==Thread.State.NEW)
							control.start();
						else
						{
							control.resume();
						}
					}
				}
				else if(e.getSource() ==bgmStopButton)
				{
					if(control.getPlayingState())
						control.stopPlay();
				}
			}
		}
		private class MainImageButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				File[] file = new FileInputUI("jpg").getSelected();
				try {
					if(file!=null)
					{
						Image image = ImageIO.read(file[0]); 
						Image image2 = image.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), image.SCALE_SMOOTH);
						
						ImageIcon icon = new ImageIcon(image2);
						mainImage.setIcon(icon);	
						
						try {
							File output = new File("import\\mainimage.jpg");
							BufferedInputStream input = new BufferedInputStream(new FileInputStream(file[0]));
							BufferedOutputStream outputS = new BufferedOutputStream(new FileOutputStream(output));

							int c;
							while ((c = input.read()) != -1)
								outputS.write(c);
							input.close();
							outputS.close();
						} catch (Exception e1) {
							// TODO: handle exception
						}
						
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		private class MenuButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if ((e.getSource() == connectionsButton)) {
					calendarPanel.setVisible(false);
					conPanel.setVisible(true);
				} else {
					calendarPanel.setVisible(true);
					conPanel.setVisible(false);
				}
			}
		}
		private class BackUpButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("가져오기"))
				{
					PersonBackUp.importPerson();
					ScheduleBackUp.importSchedule();
					DiaryBackUp.importDiary();
				}
				else if(e.getActionCommand().equals("내보내기"))
				{
					PersonBackUp.exportPerson();
					ScheduleBackUp.exportSchedule();
					DiaryBackUp.exportDiary();
				}
			}
		}
	}

	private class SubFrame extends JFrame {
		
		private JButton jButton1;
		private JButton jButton2;

		public SubFrame() {
			initComponents();
		}

		private void initComponents() {

			jButton1 = new JButton();
			jButton2 = new JButton();
			setBackground(new java.awt.Color(255, 255, 255));
			setUndecorated(true);
			setPreferredSize(new java.awt.Dimension(30, 70));
			getContentPane().setLayout(null);

			jButton1.setBackground(new java.awt.Color(255, 255, 255));
			jButton1.setText("X");
			jButton1.setBorder(null);
			jButton1.addActionListener(null);
			getContentPane().add(jButton1);
			jButton1.setBounds(0, 0, 31, 35);
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						new LogoutController().connect("127.0.0.1", 9001);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				/*
					PersonBackUp.exportPerson();
					ScheduleBackUp.exportSchedule();
					DiaryBackUp.exportDiary();
				*/
					System.exit(0);
				}
			});

			jButton2.setBackground(new java.awt.Color(255, 255, 255));
			jButton2.setText("ㅡ");
			jButton2.setActionCommand("ㅡ");
			jButton2.setBorder(null);
			getContentPane().add(jButton2);
			jButton2.setBounds(0, 35, 31, 35);
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setState(JFrame.ICONIFIED);
					Frame frame[] =getFrames();
					for(int i=0; i<frame.length;i++)
					{
						if(frame[i].getClass().getName().equals("diduler.mainUI.MainFrameUI"))
						{
							frame[i].setState(Frame.ICONIFIED);
							break;
						}
					}
				}
			});
			pack();
		}
	}

	private ContactManagementUI conPanel;

	private WeekCalendarUI weekPanel = new WeekCalendarUI();
	private JPanel mainPanel;
	private MenuPanel menuPanel = new MenuPanel();
	private MonthCalendarUI monthPanel = new MonthCalendarUI();
	private DayCalendarUI dayPanel = new DayCalendarUI();
	private JPanel calendarPanel;
	private JPanel calendarSubPanel;
	private SubFrame subFrame = new SubFrame();
	private JTabbedPane calendarSubSubPanel;

	public MainFrameUI() {
		/*
		PersonBackUp.importPerson();
		ScheduleBackUp.importSchedule();
		DiaryBackUp.importDiary();
		*/
		this.setUndecorated(true);
		initComponents();
		calendarSubSubPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
			}
		});
	}
	public MainFrameUI(String message) {
		/*
		PersonBackUp.importPerson();
		ScheduleBackUp.importSchedule();
		DiaryBackUp.importDiary();
		*/
		this.setUndecorated(true);
		initComponents();
		calendarSubSubPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
			}
		});
		menuPanel.setMessage(message);
	}
	private void initComponents() {
		conPanel = new ContactManagementUI();

		mainPanel = new JPanel();

		calendarPanel = new JPanel();
		calendarSubPanel = new JPanel();
		calendarSubSubPanel = new JTabbedPane();

		setResizable(false);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(1000, 600));
		getContentPane().setLayout(null);

		mainPanel.setBackground(new java.awt.Color(255, 255, 255));
		mainPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
		mainPanel.setLayout(null);

		mainPanel.add(menuPanel);
		menuPanel.setBounds(20, 20, 230, 510);

		calendarPanel.setBackground(new java.awt.Color(255, 255, 255));
		calendarPanel.setLayout(null);

		calendarSubPanel.setBackground(new java.awt.Color(255, 255, 255));
		calendarSubPanel.setLayout(null);

		calendarSubSubPanel.addTab("Month", new ImageIcon("몰랑이1.png"),
				monthPanel); // NOI18N

		calendarSubSubPanel
				.addTab("Week", new ImageIcon("몰랑이1.png"), weekPanel); // NOI18N

		calendarSubSubPanel.addTab("Day", new ImageIcon("몰랑이1.png"), dayPanel); // NOI18N

		calendarSubPanel.add(calendarSubSubPanel);
		calendarSubSubPanel.setBounds(10, 10, 720, 600);
		mainPanel.add(conPanel);
		conPanel.setBounds(240, 20, 750, 490);
		calendarPanel.add(calendarSubPanel);
		calendarSubPanel.setBounds(12, 10, 740, 600);

		mainPanel.add(calendarPanel);
		calendarPanel.setBounds(240, 20, 750, 600);
		conPanel.setVisible(false);
		calendarPanel.setVisible(true);
		getContentPane().add(mainPanel);
		mainPanel.setBounds(0, 0, 1000, 600);

		subFrame.setLocation(1000, 50);
		subFrame.setVisible(true);
		pack();
		
		addWindowListener(new WindowAdapter() {
			public void windowDeiconified(WindowEvent e)
			{
				subFrame.setState(JFrame.NORMAL);
			}
		});
	}

	public static void main(String args[]) {
		// new MainFrameUI().setVisible(true);

		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrameUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrameUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrameUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrameUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrameUI().setVisible(true);
			}
		});

	}
}
