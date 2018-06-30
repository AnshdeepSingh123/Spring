import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.*;
import java.util.*;
public class banking extends JFrame implements ActionListener
{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel cashinhand=new JLabel("Cash In Hand Balance");
	JLabel bankbal=new JLabel("Bank Balance");
	JLabel enter=new JLabel("Enter Amount");
	JTextField enter1=new JTextField();
	JLabel amount=new JLabel("Amount:1234");
	JButton cashinhand1=new JButton("Cash In Hand");
	JButton bankbal1=new JButton("Bank Balance");
	JTextField update=new JTextField();
	JButton update1=new JButton("Update");
	JButton waste=new JButton("Bank Balance");
	JButton transfer=new JButton("Transfer");
	JButton transfer1=new JButton("Transfer");
	JButton home =new JButton("Home");
	JButton logout =new JButton("Logout");
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	float t=0,y=0,z=0,i;
	Connection con;
	Statement s,s1;
	ResultSet rs1,rs,rs2,rs3,rs4,rs5,rs6;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
public banking()
{
	this.setIconImage(img.getImage());
	try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganpati","root","root");
	s=con.createStatement();
	s1=con.createStatement();
    }
    catch(Exception e)
    {
    	JOptionPane.showMessageDialog(null,e.getMessage());
    }
	
	setDefaultCloseOperation( EXIT_ON_CLOSE );
	this.setVisible(true);
	this.setResizable(false);
	//this.setExtendedState(MAXIMIZED_BOTH);
	this.setBounds(0,0,1366,768);
	this.setLayout(null);
	this.setTitle("Banking");
	add(cashinhand);
	add(copyright);
	add(bankbal);	
	add(enter);
	add(enter1);
	add(cashinhand1);
	add(bankbal1);
	add(transfer);
	add(home);
	add(logout);
	add(transfer1);
	add(amount);
	add(update);
	add(update1);
	
	
	transfer1.addActionListener(this);
	transfer.addActionListener(this);
	bankbal1.addActionListener(this);
	cashinhand1.addActionListener(this);
	update1.addActionListener(this);
	home.addActionListener(this);
	logout.addActionListener(this);
	
	transfer.setFont(f1);
	transfer1.setFont(f1);
	logout.setFont(f1);
	bankbal1.setFont(f1);
    cashinhand1.setFont(f1);
	home.setFont(f1);
    update1.setFont(f1);
	
	home.setBackground(new Color(135,206,250));
	logout.setBackground(new Color(135,206,250));
	cashinhand1.setBackground(new Color(135,206,250));
	update1.setBackground(new Color(135,206,250));
	bankbal1.setBackground(new Color(135,206,250));
	transfer.setBackground(new Color(135,206,250));
	//transfer1.setBackground(new Color(135,206,250));
	
	home.setBounds(0,20,150,50);
	bankbal1.setBounds(350,20,200,50);
	cashinhand1.setBounds(150,20,200,50);
	transfer.setBounds(550,20,150,50);
	
	//home.setBounds(0,20,150,50);
	logout.setBounds(700,20,150,50);
	
	amount.setFont(f1);
	amount.setBounds(450, 340,1000, 30);
	
	transfer1.setFont(f1);
    transfer1.setBounds(450, 340,150, 30);
    update1.setFont(f1);
    update1.setBounds(450, 440,150, 30);
    
    enter.setFont(f1);
    enter.setBounds(305, 280,150, 30);
    
    enter1.setBounds(450, 280,150, 30);
    update.setBounds(450, 380,150, 30);
	
	cashinhand.setFont(f);
	cashinhand.setBounds(420, 280,300, 30);
	
	bankbal.setFont(f);
	bankbal.setBounds(445, 280,300, 30);

	bankbal.setVisible(false);
	try
	{
		rs=s.executeQuery("select balc from balance");
		while(rs.next())
		{
			t=Float.valueOf(rs.getString(1));
		}
	}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null,ex.getMessage());
	}
	amount.setText("Amount : Rs. "+t);
	this.getContentPane().setBackground(c);
	transfer1.setVisible(false);
	enter.setVisible(false);
	enter1.setVisible(false);
	update1.setVisible(false);
	update.setVisible(false);
	//copyright.setBounds(45,200,350,30); //panel copyright
	copyright.setBounds(550,680,350,30);
	copyright.setFont(f1);
}
	public static void main(String[] args) 
	{
		
new banking();
	}


	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==update1)
		{
			this.getRootPane().setDefaultButton(update1);
			if(update.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter New Bank Balance");
			}
			else
			{
			try
			{
			s.executeUpdate("update balance set balb='"+update.getText()+"'where a='a'");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			try
			{
				rs=s.executeQuery("select balb from balance");
				while(rs.next())
				{
					t=Float.valueOf(rs.getString(1));
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			amount.setText("Amount : Rs. "+t);
			update.setText("");
			}
		}
		if(e.getSource()==transfer1)
		{
			this.getRootPane().setDefaultButton(transfer1);
			try
			{
				rs5=s.executeQuery("select balc from balance");
				while(rs5.next())
				{
					t=Float.valueOf(rs5.getString(1));
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			if(enter1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Amount");
			}
			else if(Float.valueOf(enter1.getText())>t)
			{
				JOptionPane.showMessageDialog(null,"Enter Valid Amount");
			}
			else
			{
			try
			{
				rs3=s.executeQuery("select balc from balance");
				while(rs3.next())
				{
					t=Float.valueOf(rs3.getString(1));
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			try
			{
				rs4=s.executeQuery("select balb from balance");
				while(rs4.next())
				{
					i=Float.valueOf(rs4.getString(1));
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			y=t-Float.valueOf(enter1.getText());
			z=i+Float.valueOf(enter1.getText());
			try
			{
			s.executeUpdate("update balance set balc='"+y+"'where a='a'");
			s.executeUpdate("update balance set balb='"+z+"'where a='a'");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			enter1.setText("");
			JOptionPane.showMessageDialog(null,"Account Updated");
			}
		}
		if(e.getSource()==home)
		{
			this.getRootPane().setDefaultButton(waste);
			new adminmain();
			try
			{
			s.close();
			con.close();
			}
			catch(Exception ez)
			  {
			 	JOptionPane.showMessageDialog(null,ez.getMessage());
			 }
			this.dispose();
		}

		if(e.getSource()==logout)
		{
			this.getRootPane().setDefaultButton(waste);
			new login();
			try
			{
			s.close();
			con.close();
			}
			catch(Exception ez)
			  {
			 	JOptionPane.showMessageDialog(null,ez.getMessage());
			 }
			this.dispose();
		}
		if(e.getSource()==transfer)
		{
			this.getRootPane().setDefaultButton(transfer1);

			bankbal.setVisible(false);
			cashinhand.setVisible(false);
			transfer1.setVisible(true);
			enter.setVisible(true);
			enter1.setVisible(true);
			amount.setVisible(false);
			update.setVisible(false);
			update1.setVisible(false);
		}
		if(e.getSource()==bankbal1)
		{
			this.getRootPane().setDefaultButton(update1);
			bankbal.setVisible(true);
			cashinhand.setVisible(false);
			transfer1.setVisible(false);
			enter.setVisible(false);
			enter1.setVisible(false);
			amount.setVisible(true);
			update.setVisible(true);
			update1.setVisible(true);
			try
			{
				rs=s.executeQuery("select balb from balance");
				while(rs.next())
				{
					t=Float.valueOf(rs.getString(1));
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			amount.setText("Amount : Rs. "+t);

		}
	if(e.getSource()==cashinhand1)
	{
		this.getRootPane().setDefaultButton(waste);
		bankbal.setVisible(false);
		cashinhand.setVisible(true);
		transfer1.setVisible(false);
		enter.setVisible(false);
		enter1.setVisible(false);
		amount.setVisible(true);
		update.setVisible(false);
		update1.setVisible(false);
		try
		{
			rs=s.executeQuery("select balc from balance");
			while(rs.next())
			{
				t=Float.valueOf(rs.getString(1));
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		amount.setText("Amount : Rs. "+t);

	}
		
	}

}
