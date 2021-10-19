package diduler.login;

import  javax.swing.*;

import diduler.mainUI.*;

import java.awt.Color;
import java.awt.event.*;
public class LoginUI extends  JFrame {
	
	private  JButton cancelButton; 
	private  JButton loginButton;
	
	private  JTextField idField;
	private  JPasswordField passwordField;
	
    private  JPanel loginPanel;		
    
   
    public LoginUI() {
        initComponents();
    }

    private void initComponents() {
    	LoginButtonListener loginListener;	
    	loginListener =new LoginButtonListener();
    	
        loginPanel = new  JPanel();
        JLabel jLabel1 = new  JLabel();
        JLabel jLabel2 = new  JLabel();
        JLabel jLabel3 = new  JLabel();
        JLabel jLabel4 = new  JLabel();
        idField = new  JTextField();
        passwordField = new  JPasswordField();
        loginButton = new  JButton();
        cancelButton = new  JButton();
         
        setResizable(false);
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.white);
        setPreferredSize(new java.awt.Dimension(500, 360));
        setLocation(500,300);
        getContentPane().setLayout(null);

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));
        loginPanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("함초롬돋움", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Molang Diduler");
        loginPanel.add(jLabel1);
        jLabel1.setBounds(20, 140, 180, 30);

        
        jLabel2.setIcon(new  ImageIcon("011.png")); // NOI18N
        jLabel2.setText("ㅇㅇ");
        loginPanel.add(jLabel2);
        jLabel2.setBounds(230, 20, 240, 170);

        jLabel3.setFont(new java.awt.Font("함초롬돋움", 1, 14)); // NOI18N
        jLabel3.setText("ID");
        loginPanel.add(jLabel3);
        jLabel3.setBounds(120, 220, 20, 19);

        jLabel4.setFont(new java.awt.Font("함초롬돋움", 1, 14)); // NOI18N
        jLabel4.setText("Password");
        loginPanel.add(jLabel4);
        jLabel4.setBounds(70, 260, 70, 20);
        loginPanel.add(idField);
        idField.setBounds(180, 220, 110, 21);
        loginPanel.add(passwordField);
        passwordField.setBounds(180, 260, 110, 21);

        loginButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
        loginButton.setText("login");
        loginPanel.add(loginButton);
        loginButton.setBounds(300, 290, 80, 25);
        
        loginButton.addActionListener(loginListener);

        cancelButton.setFont(new java.awt.Font("함초롬돋움", 0, 12)); // NOI18N
        cancelButton.setText("cancel");
        loginPanel.add(cancelButton);
        cancelButton.setBounds(400, 290, 80, 25);
        
        cancelButton.addActionListener(loginListener);
        
        getContentPane().add(loginPanel);
        loginPanel.setBounds(0, 0, 500, 330);

        pack();
    }

    private class LoginButtonListener implements ActionListener
    {
    	private LoginController controller;
    	public void LoginButtonListener()
    	{
    		;
    	}
    	public void actionPerformed(ActionEvent e)
		{
    		//loginButton  cancelButton 버튼리스너 두개
    		 
    		if(e.getActionCommand().equals("취소"))
    		{
    			setVisible(false);
    		}
    		
    		else  //이건확인 버튼 눙렀을때 성공시 다이어리 뜨게  실패하면 경고 에러 
    		{
    			char[] chr = passwordField.getPassword();
    			String str = new String();
    			for(int i = 0;i<chr.length;i++)
    			{
    				str += ""+chr[i];
    			}
    			controller = new LoginController(idField.getText(),str);
    			try 
    			{
					String check = controller.connect("127.0.0.1", 9100);
					if(check!=null )
					{
						new MainFrameUI(check).setVisible(true);
						setVisible(false);
					}
				} 
    			catch (Exception ukhe) 
    			{
    				//ukhe.printStackTrace();
				} 
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
				new LoginUI().setVisible(true);
			}
		});

    	

    }
    
}