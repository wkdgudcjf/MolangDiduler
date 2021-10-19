package diduler.mainUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import diduler.model.diary.Diary;

public class ViewDiaryUI extends JFrame {

	private JButton cancelButton;
	private JButton checkButton;
	private JTextArea diaryContent;
	private JLabel diaryImage;
	private JPanel diaryPanel;
	private JButton image;
	private JPanel imagePanel;
	private JComboBox jComboBox1;
	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private JButton removeButton;
	private JLabel titleLabel;
	private JTextField titleTextField;
	private JButton updateButton;
	private int index;
	private int scheduleIndex;
	private JTable jTable;
	private String[] date;

	public ViewDiaryUI(String title, String content, Image imageLocation,
			String isPublic, int index, JTable jTable, String[] date) {
		this.jTable = jTable;
		scheduleIndex = -1;
		initComponents();
		this.date = date;
		this.index = index;
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});

		if (isPublic.equals("true"))
			this.jComboBox1.setSelectedItem("����");
		else
			this.jComboBox1.setSelectedItem("�����");

		titleTextField.setText(title);
		diaryContent.setText(content);

		if (imageLocation != null)// �̹����� �ִ� ���̾�� ���
		{
			imageLocation = imageLocation.getScaledInstance(
					image.getWidth() - 20, image.getHeight() - 5,
					imageLocation.SCALE_SMOOTH);
			image.setIcon(new ImageIcon(imageLocation));
		} else // �̹����� ���� ���̾ �ϰ��
		{
			image.setText("�̹��� ����");
		}

	}

	public ViewDiaryUI(String title, String content, Image imageLocation,
			String isPublic, int index, int scheduleIndex, JTable jTable) {
		date=null;
		this.jTable = jTable;
		initComponents();
		this.index = index;
		this.scheduleIndex = scheduleIndex;
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});

		if (isPublic.equals("true"))
			this.jComboBox1.setSelectedItem("����");
		else
			this.jComboBox1.setSelectedItem("�����");

		titleTextField.setText(title);
		diaryContent.setText(content);

		if (imageLocation != null)// �̹����� �ִ� ���̾�� ���
		{
			imageLocation = imageLocation.getScaledInstance(
					image.getWidth() - 20, image.getHeight() - 5,
					imageLocation.SCALE_SMOOTH);
			image.setIcon(new ImageIcon(imageLocation));
		} else // �̹����� ���� ���̾ �ϰ��
		{
			image.setText("�̹��� ����");
		}

	}

	public void setVisible(boolean b) {
		super.setVisible(b);
	}

	private void initComponents() {

		DiaryButtonListener diaryListener;

		setLocation(400, 90);
		diaryPanel = new JPanel();
		imagePanel = new JPanel();
		diaryImage = new JLabel();

		titleTextField = new JTextField();
		titleLabel = new JLabel();
		jComboBox1 = new JComboBox();
		jLabel1 = new JLabel();
		jScrollPane1 = new JScrollPane();
		diaryContent = new JTextArea();
		checkButton = new JButton();
		updateButton = new JButton();
		cancelButton = new JButton();
		removeButton = new JButton();
		setResizable(false);
		image = new JButton();

		image.setBounds(20, 10, 340, 210);

		diaryListener = new DiaryButtonListener();
		// titleTextField.setText(title);

		// diaryContent.setText(content);

		setTitle("���̾ �ڼ������� ");
		setPreferredSize(new java.awt.Dimension(400, 650));

		diaryPanel.setBackground(new java.awt.Color(255, 255, 255));
		diaryPanel.setPreferredSize(new java.awt.Dimension(400, 650));

		imagePanel.setBackground(new java.awt.Color(247, 231, 195));
		imagePanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		imagePanel.setPreferredSize(new java.awt.Dimension(372, 361));

		diaryImage.setIcon(new ImageIcon("�׸�7.png")); // NOI18N

		titleTextField.setEnabled(false);

		titleLabel.setText("����");

		jComboBox1.setModel(new DefaultComboBoxModel(
				new String[] { "����", "�����" }));
		jComboBox1.setEnabled(false);

		jLabel1.setText("�������� ");

		GroupLayout imagePanelLayout = new GroupLayout(imagePanel);
		imagePanel.setLayout(imagePanelLayout);
		imagePanelLayout
				.setHorizontalGroup(imagePanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(image, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								imagePanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(diaryImage)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												imagePanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																imagePanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				titleLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				titleTextField))
														.addGroup(
																imagePanelLayout
																		.createSequentialGroup()
																		.addGap(0,
																				160,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel1,
																				GroupLayout.PREFERRED_SIZE,
																				61,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jComboBox1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(2, 2, 2)));
		imagePanelLayout
				.setVerticalGroup(imagePanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								imagePanelLayout
										.createSequentialGroup()
										.addGroup(
												imagePanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																imagePanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				diaryImage)
																		.addGap(27,
																				27,
																				27))
														.addGroup(
																imagePanelLayout
																		.createSequentialGroup()
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				imagePanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								titleTextField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								titleLabel))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(
																				imagePanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jComboBox1,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel1))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)))
										.addComponent(image,
												GroupLayout.PREFERRED_SIZE,
												244, Short.MAX_VALUE)));

		diaryContent.setEditable(false);
		jScrollPane1.setViewportView(diaryContent);

		checkButton.setText("Ȯ   ��");
		checkButton.addActionListener(diaryListener);

		updateButton.setText("��  ��");
		updateButton.addActionListener(diaryListener);

		cancelButton.setText("��  ��");
		cancelButton.addActionListener(diaryListener);

		removeButton.setText("��  ��");
		removeButton.addActionListener(diaryListener);

		image.setBorderPainted(false);
		image.setBackground(Color.black);
		// image.setEnabled(false);
		// image.set
		GroupLayout diaryPanelLayout = new GroupLayout(diaryPanel);
		diaryPanel.setLayout(diaryPanelLayout);
		// diaryPanel.setLayout(null);
		diaryPanelLayout
				.setHorizontalGroup(diaryPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								diaryPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												diaryPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																imagePanel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																diaryPanelLayout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addGroup(
																				diaryPanelLayout
																						.createSequentialGroup()
																						.addGap(10,
																								10,
																								10)
																						.addComponent(
																								checkButton,
																								GroupLayout.PREFERRED_SIZE,
																								75,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								LayoutStyle.ComponentPlacement.UNRELATED)
																						.addComponent(
																								updateButton,
																								GroupLayout.PREFERRED_SIZE,
																								73,
																								GroupLayout.PREFERRED_SIZE)
																						.addGap(18,
																								18,
																								18)
																						.addComponent(
																								removeButton,
																								GroupLayout.PREFERRED_SIZE,
																								73,
																								GroupLayout.PREFERRED_SIZE)
																						.addGap(18,
																								18,
																								18)
																						.addComponent(
																								cancelButton,
																								GroupLayout.PREFERRED_SIZE,
																								75,
																								GroupLayout.PREFERRED_SIZE))
																		.addComponent(
																				jScrollPane1,
																				GroupLayout.PREFERRED_SIZE,
																				368,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(16, Short.MAX_VALUE)));
		diaryPanelLayout.setVerticalGroup(diaryPanelLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				diaryPanelLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(imagePanel, GroupLayout.PREFERRED_SIZE,
								326, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
								223, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								diaryPanelLayout
										.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
										.addComponent(checkButton)
										.addComponent(updateButton)
										.addComponent(cancelButton)
										.addComponent(removeButton))
						.addGap(53, 53, 53)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(diaryPanel,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(diaryPanel,
				GroupLayout.PREFERRED_SIZE, 610, GroupLayout.PREFERRED_SIZE));
		// System.out.println(image.getWidth());

		/*
		 * if(imageLocation!=null)//�̹����� �ִ� ���̾�� ��� {
		 * imageLocation=imageLocation.getScaledInstance(image.getWidth()+5,
		 * image.getHeight()+5,imageLocation.SCALE_SMOOTH); image.setIcon(new
		 * ImageIcon(imageLocation)); } else //�̹����� ���� ���̾ �ϰ�� {
		 * image.setText("�̹��� ����"); }
		 */
		pack();
	}

	public void modifyVersion() {
		titleTextField.setEnabled(true); // ��������
		diaryContent.setEditable(true);
		jComboBox1.setEnabled(true);

	}

	private class DiaryButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// Ȯ�� ��� ���� ���� ��ư �װ��� ���� ������
			DiaryController cnt = DiaryController.getInstance();

			if (e.getActionCommand().equals("��  ��")) // ��ҹ�ư ��������
			{
				setVisible(false);
			}

			else if (e.getSource() == checkButton) // �̰�Ȯ�� ��ư �������� ������
			{

				String obj = (String) jComboBox1.getSelectedItem();
				boolean isPublic;
				if (obj.equals("����"))
					isPublic = true;
				else
					isPublic = false;
				cnt.modify(index, titleTextField.getText(),
						diaryContent.getText(), isPublic);
				if (date != null) {

					DefaultTableModel model = (DefaultTableModel) jTable
							.getModel();
					List<String[]> list = cnt.searchTodayDiary(date[0],
							date[1], date[2]);
					String[] arr = new String[3];
					int size = list.size();

					while (model.getRowCount() > 0)
						model.removeRow(0);

					for (int i = 0; i < size; i++) {
						arr[0] = list.get(i)[0];
						arr[1] = list.get(i)[1];
						arr[2] = list.get(i)[2];

						model.addRow(arr);
					}
					date=null;

				} else {
					List<String[]> list1 = ScheduleController.getInstance()
							.read();
					String[] arr1 = new String[3];
					int size = list1.size();
					DefaultTableModel model = (DefaultTableModel) jTable
							.getModel();

					while (model.getRowCount() > 0)
						model.removeRow(0);

					for (int i = 0; i < size; i++) {
						arr1[0] = list1.get(i)[0];
						arr1[1] = list1.get(i)[1];
						arr1[2] = list1.get(i)[2];

						model.addRow(arr1);
					}

					List<String[]> list = cnt.getTableValueList();
					String[] arr = new String[3];
					size = list.size();

					for (int i = 0; i < size; i++) {
						arr[0] = list.get(i)[0];
						arr[1] = list.get(i)[1];
						arr[2] = list.get(i)[2];

						model.addRow(arr);
					}
				}

				setVisible(false);

			}

			else if (e.getActionCommand().equals("��  ��")) // �̰�Ȯ�� ��ư �������� ������
			{
				modifyVersion();
			}

			else // ���� ��ư�϶�
			{
				cnt.removeDiary(index);
				DefaultTableModel model = (DefaultTableModel) jTable.getModel();
				model.removeRow(index + scheduleIndex);
				setVisible(false);
			}

		}
	}

}
