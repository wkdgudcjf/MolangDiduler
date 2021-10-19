package diduler.mainUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileInputUI extends JFrame implements ActionListener {

	private JFileChooser jFileChooser1= new JFileChooser();
	private int check;
	private File selected[]=null;
	private String filter="";
	
	public FileInputUI(String filter) {
		this.filter  =filter;
		initComponents();
	}
	
	public File[] getSelected()
	{
		return selected;
	}
	public void actionPerformed(ActionEvent e) {

		if (check== JFileChooser.APPROVE_OPTION) {
			selected = jFileChooser1.getSelectedFiles();
		}

	}

	private void initComponents() {


		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jFileChooser1.setMultiSelectionEnabled(true);
		jFileChooser1.setCurrentDirectory(new java.io.File("C:\\"));
		jFileChooser1.setFont(new java.awt.Font("«‘√ ∑“µ∏øÚ", 0, 12)); // NOI18N
		jFileChooser1.setFileFilter(new FileNameExtensionFilter(filter, filter));
		jFileChooser1.addActionListener(this);
		check = jFileChooser1.showOpenDialog(this);
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jFileChooser1,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jFileChooser1,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>


}
