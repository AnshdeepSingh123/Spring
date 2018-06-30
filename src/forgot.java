import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class forgot extends JFrame implements ActionListener 
{
	JLabel name=new JLabel("Name");
	JLabel password=new JLabel("Enter New Password");
	JLabel sec=new JLabel("Enter Your Favourite Dish");
	JTextField email1=new JTextField();
	JTextField sec1=new JTextField();
	JPasswordField password1=new JPasswordField();
	JButton submit=new JButton("Submit");
	JButton submit1=new JButton("Submit");
	JButton login=new JButton("Login");
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	Connection con;
	Statement s;
	ResultSet rs1;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	public forgot()
	{
		this.setIconImage(img.getImage());
		this.getRootPane().setDefaultButton(submit);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.setIconImage(img.getImage());
		try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganpati","root","root");
		s=con.createStatement();
	    }
	    catch(Exception e)
	    {
	    	JOptionPane.showMessageDialog(null,e.getMessage());
	    }
		this.setVisible(true);
		//setExtendedState(MAXIMIZED_BOTH);
		this.setBounds(0,0,1366,768);
		this.setLayout(null);
		this.setTitle("Forgot Password");
		add(name);
		add(password);
		add(email1);
		add(password1);
		add(submit);
		add(submit1);
		add(copyright);
		add(sec);
		add(sec1);
		add(login);
		this.getContentPane().setBackground(c);
		name.setBounds(450,250, 100, 50);
		name.setFont(f);
		email1.setBounds(580,260,200, 30);
		password.setBounds(270,300, 300, 50);
		password.setFont(f);
		password1.setBounds(580,310,200,30);
		submit1.setBounds(580,410, 150, 30);
		sec.setBounds(210,350, 340, 50);
		sec.setFont(f);
		sec1.setBounds(580,360,200,30);
	    submit.setBounds(580,380, 150, 30);
	    submit1.setFont(f1);
	    submit.setFont(f1);
	    submit1.setVisible(false);
	    password.setVisible(false);
	    password1.setVisible(false);
	    sec.setVisible(false);
	    sec1.setVisible(false);
	    copyright.setBounds(550,680,350,30);
		copyright.setFont(f1);
		login.setBounds(1200,70,100,50);
		login.setFont(f1);
		 login.setBackground(new Color(135,206,250));
		 submit.setBackground(new Color(135,206,250));
		 submit1.setBackground(new Color(135,206,250));
	   submit.addActionListener(this);
	   submit1.addActionListener(this);
	   login.addActionListener(this);
	}
	
	
	public static void main(String[] args)
	{
	new forgot();
	}
	public void actionPerformed(ActionEvent ar)
	{
		if(ar.getSource()==login)
		{
			new login();
			try
			{
			s.close();
			con.close();
			}
			catch(Exception e)
			  {
			 	JOptionPane.showMessageDialog(null,e.getMessage());
			 }
			this.dispose();
		}
		if(ar.getSource()==submit1)
		{
			try
			{
				rs1=s.executeQuery("select username,password,security from login");
			 if(rs1.next())
		      {
				 if(password1.getText().isEmpty())
				 {
					 JOptionPane.showMessageDialog(null,"Enter Your Password");
				 }
				 else if(sec1.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter Your Answer");
				}
			else if(!sec1.getText().equals(rs1.getString(3)))
			  {
				JOptionPane.showMessageDialog(null,"Wrong Answer");
			  }
			 else
			  {
			 	s.executeUpdate("update login set password='"+password1.getText()+"' where username='"+email1.getText()+"'");
			 	JOptionPane.showMessageDialog(null,"Password Changed");
			 	new login();
			 this.dispose();	
			  }
			}
		  }
			catch(Exception e)
		    {
		    	JOptionPane.showMessageDialog(null,e.getMessage());
		    }
		}
		if(ar.getSource()==submit)
		{
			
			try
			{
				if(email1.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter your Name");
				}
				else
				{
				rs1=s.executeQuery("select username,password,security from login where username='"+email1.getText()+"'");
				if(rs1.next())
				{
				   if(!email1.getText().equals(rs1.getString(1)))
				   {
					JOptionPane.showMessageDialog(null,"Name Does not Exits");
				   }
				   else
				   {
					this.getRootPane().setDefaultButton(submit1);
					submit.setVisible(false);
					sec.setVisible(true);
					sec1.setVisible(true);
					password.setVisible(true);
					password1.setVisible(true);
					submit1.setVisible(true);
				   }
				}
			 }
			}
			 catch(Exception e)
		    {
		    	JOptionPane.showMessageDialog(null,e.getMessage());
		    }
		}
	}

}
