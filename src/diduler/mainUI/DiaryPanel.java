package diduler.mainUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.*;

public class DiaryPanel extends JPanel {
	private JButton jButton1;
	private JTextField jTextField1;
	
	
	private class ButtonListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			
		}
	}
	
	public void setjTextField1(String str) {
		this.jTextField1.setText(str);
	}
	
	public String getjTextField1() {
		return jTextField1.getText();
	}
	public void init()
	{
		jTextField1.setText("");
	}
	
	
	public DiaryPanel() {
		initComponents();
	}

	private void initComponents() {
		ButtonListener buttonListener = new ButtonListener();
		jButton1 = new JButton();
		jTextField1 = new JTextField();
		jTextField1.setText(null);
		ActionListener imageListener=new ImageButtonListener();

		setLayout(null);

		jButton1.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		jButton1.setText("이미지 첨부");
		jButton1.setToolTipText("");
		add(jButton1);
		jButton1.setBounds(250, 30, 110, 30);
		//jButton1.addMouseListener(buttonListener);
		jButton1.addActionListener(imageListener);  
		

		jTextField1.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
		add(jTextField1);
		jTextField1.setEditable(false);
		jTextField1.setBounds(30, 30, 200, 30);
	}


	private class ImageButtonListener implements ActionListener
	{		
		private FileInputUI fileInput;
		//이미지 첨부 버튼을 넣었을 때
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==jButton1) //이미지첨부 버튼일때
			{
				fileInput=new FileInputUI("JPG");//JPG파일만 첨부가능
				File[] files = fileInput.getSelected();
				if(files.length>0)
				{
					
					jTextField1.setText(files[0].toString());
				}
				
			}
			
			
			
		}
	}

}