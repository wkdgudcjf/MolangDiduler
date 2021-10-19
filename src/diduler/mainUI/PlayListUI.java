package diduler.mainUI;

import javax.swing.*;
import javax.swing.table.*;

import diduler.model.bgm.BGMController;


import java.awt.event.*;
import java.io.File;

public class PlayListUI extends JFrame {
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

		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
		private BGMController control  = BGMController.getInstance();
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
		private BGMController control  = BGMController.getInstance();
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				if(control.getPlayingState())
					control.stopPlay();
				control.setNowPlaying(playListUITable.getModel().getValueAt(playListUITable.getSelectedRow(), 0).toString());
				if(control.getListNum()>0)
				{
					//bgmTitleLabel.setText(control.getTitle());
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
