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
public class transaction extends JFrame implements ActionListener
{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel name=new JLabel("Party Name");
	JComboBox name1=new JComboBox();
	JLabel prev=new JLabel("Previous Balance");
	JTextField prev1=new JTextField();
	JLabel paymode=new JLabel("Payment Mode");
	JComboBox paymode1=new JComboBox();
	JLabel current=new JLabel("Order Payment");
	JTextField current1=new JTextField();
	JLabel totalpay=new JLabel("Total Payment");
	JTextField totalpay1=new JTextField();
	JLabel credit=new JLabel("Credit");
	JComboBox credit1=new JComboBox();
	JLabel nprev=new JLabel("New Previous Balance");
	JTextField nprev1=new JTextField();
	JLabel page=new JLabel("Page Number");
	JTextField page1=new JTextField();
	JButton submit=new JButton("Submit");
	JButton submit1=new JButton("Submit");
	JButton pay=new JButton("Recieve Amount");
	JButton undetail =new JButton("Undetail Outstanding Balance");
	JButton find =new JButton("Find Bill");
	JButton home =new JButton("Home");
	JButton logout =new JButton("Logout");
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	Vector Columnname= new Vector();
	Vector data= new Vector();
	JPanel panel = new JPanel();
	Connection con;
	Statement s,s1;
	ResultSet rs1,rs,rs2,rs3,rs4,rs5,rs6;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
public transaction()
{
	this.setIconImage(img.getImage());
	this.getRootPane().setDefaultButton(submit);
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
	this.setTitle("Transaction");
	
	add(copyright);
	add(name);
	add(name1);
	add(prev);
	add(prev1);
	add(paymode);
	add(paymode1);
	add(current);
	add(current1);
	add(totalpay);
	add(totalpay1);
	add(credit);
	add(credit1);
	add(nprev);
	add(nprev1);
	add(page);
	add(page1);
	add(submit);
	add(submit1);
	add(pay);
	add(home);
	add(logout);
	add(undetail);
	add(find);
	
	submit.addActionListener(this);
	submit1.addActionListener(this);
	pay.addActionListener(this);
	home.addActionListener(this);
	logout.addActionListener(this);
    undetail.addActionListener(this);
    find.addActionListener(this);
	
	submit.setFont(f1);
	submit1.setFont(f1);
	logout.setFont(f1);
	pay.setFont(f1);
	home.setFont(f1);
	undetail.setFont(f1);
	find.setFont(f1);
	
	undetail.setBackground(new Color(135,206,250));
	home.setBackground(new Color(135,206,250));
	logout.setBackground(new Color(135,206,250));
	pay.setBackground(new Color(135,206,250));
	submit.setBackground(new Color(135,206,250));
	submit1.setBackground(new Color(135,206,250));
	find.setBackground(new Color(135,206,250));
	
	home.setBounds(0,20,150,50);
	undetail.setBounds(150,20,350,50);
	find.setBounds(500,20,150,50);
	logout.setBounds(650,20,150,50);
	
	name.setBounds(290,100, 150, 50);
	name.setFont(f1);
	name1.setBounds(430, 110,230, 30);
	
	
	submit.setBounds(440, 180,200, 30);
	
	prev.setBounds(235,150, 200, 50);
	prev.setFont(f1);
	prev1.setBounds(430, 160,230, 30);
	prev1.setEditable(false);
	
	paymode.setBounds(258,200, 200, 50);
	paymode.setFont(f1);
	paymode1.setBounds(430, 210,230, 30);
	
	current.setBounds(255,250, 200, 50);
	current.setFont(f1);
	current1.setBounds(430, 260,230, 30);
	current1.setEditable(false);
	
	totalpay.setBounds(260,300, 200, 50);
	totalpay.setFont(f1);
	totalpay1.setBounds(430, 310,230, 30);
	
	submit1.setBounds(440, 380,200, 30);
	
	credit.setBounds(260,350, 200, 50);
	credit.setFont(f1);
	credit1.setBounds(430, 360,230, 30);
	
	nprev.setBounds(190,400, 250, 50);
	nprev.setFont(f1);
	nprev1.setBounds(430, 410,230, 30);
	
	page.setBounds(280,450, 300, 50);
	page.setFont(f1);
	page1.setBounds(430, 460,230, 30);
	
	pay.setBounds(440, 530,200, 30);
	
	prev.setVisible(false);
	prev1.setVisible(false);
	paymode.setVisible(false);
	paymode1.setVisible(false);
	current.setVisible(false);
	current1.setVisible(false);
	totalpay.setVisible(false);
	totalpay1.setVisible(false);
	credit.setVisible(false);
	credit1.setVisible(false);
	submit1.setVisible(false);
	nprev.setVisible(false);
	nprev1.setVisible(false);
	page.setVisible(false);
	page1.setVisible(false);
	pay.setVisible(false);
	
	
	name1.removeAllItems();
	name1.addItem("Select");
	try
	{
	rs1=s.executeQuery("select name  from sales where Transaction='Pending'");
	name1.removeAllItems();
	name1.addItem("Select");
	while(rs1.next())
	{
		if(((DefaultComboBoxModel)name1.getModel()).getIndexOf(rs1.getString(1)) == -1) 
		{
			  name1.addItem(rs1.getString(1) );
		}
	}
	}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null,ex.getMessage());
	}
	paymode1.removeAllItems();
	paymode1.addItem("Select");
	paymode1.addItem("Cash In Hand");
	paymode1.addItem("Cheque");
	
	credit1.removeAllItems();
	credit1.addItem("Select");
	credit1.addItem("Yes");
	credit1.addItem("No");
	
	this.getContentPane().setBackground(c);
	//copyright.setBounds(45,200,350,30); //panel copyright
	copyright.setBounds(550,680,350,30);
	copyright.setFont(f1);
}
	public static void main(String[] args)
	{
new transaction();	

	}

	
	public void actionPerformed(ActionEvent ar) 
	{
		if(ar.getSource()==undetail)
		{
			new undetail();
		}
		if(ar.getSource()==find)
		{
			try{
			     Process p = Runtime.getRuntime().exec("iReport-5.2.0\\bin\\ireport.exe");
			     //C:\\Users\\Anshdeep\\Desktop\\Ganpati Final\\
			 }
			catch(Exception e)
			{
			     e.printStackTrace();
			 }
		}
		if(ar.getSource()==home)
	{
		new adminmain();
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

	if(ar.getSource()==logout)
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
	if(ar.getSource()==pay)
	{
		if(credit1.getSelectedItem()=="Select")
		{
			JOptionPane.showMessageDialog(null,"Please Select Credit");
		}
		else if(page1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Please Enter Page Number");
		}
		else
		{
			try
			{
			
			s.executeUpdate("update party set Previous='"+nprev1.getText()+"'where Customername='"+name1.getSelectedItem()+"'");
			s.executeUpdate("update sales set Transaction='Done' where Name='"+name1.getSelectedItem()+"'");
			JOptionPane.showMessageDialog(null,"Amount Recieved");
			}
			catch(Exception e)
			  {
			 	JOptionPane.showMessageDialog(null,e.getMessage());
			 }
			if(credit1.getSelectedItem()=="Yes")
			{
				float tel=Float.valueOf(totalpay1.getText());
				try
				{
				rs5=s.executeQuery("select Balance from credit where Name='"+name1.getSelectedItem()+"'");
				if(rs5.next())
				{
						tel=tel+Float.valueOf(rs5.getString(1)); 
					s1.executeUpdate("update credit set Balance='"+tel+"'where Name='"+name1.getSelectedItem()+"'");
				}
				else
				{
					rs6=s.executeQuery("select * from party where Customername='"+name1.getSelectedItem()+"'");
					while(rs6.next())
					{
					s1.executeUpdate("insert into credit values('"+name1.getSelectedItem()+"','"+rs6.getString(4)+"','"+rs6.getString(3)+"','"+totalpay1.getText()+"')");
					}
					}
				}
				catch(Exception e)
				  {
				 	JOptionPane.showMessageDialog(null,e.getMessage());
				 }

			}
			if(paymode1.getSelectedItem()=="Cash In Hand")
			{
				try
				{
					float teo=0;
					rs3=s.executeQuery("select balc from balance where a='a'");
					while(rs3.next())
					{
						teo=Float.valueOf(rs3.getString(1))+Float.valueOf(totalpay1.getText());
					}
					
				s.executeUpdate("update balance set balc='"+teo+"'where a='a'");
				}
				catch(Exception e)
				  {
				 	JOptionPane.showMessageDialog(null,e.getMessage());
				 }
			}
			else if(paymode1.getSelectedItem()=="Cheque")
			{
				try
				{
					float teo=0;
					rs3=s.executeQuery("select balb from balance where a='a'");
					while(rs3.next())
					{
						teo=Float.valueOf(rs3.getString(1))+Float.valueOf(totalpay1.getText());
					}
					
				s.executeUpdate("update balance set balb='"+teo+"'where a='a'");
				}
				catch(Exception e)
				  {
				 	JOptionPane.showMessageDialog(null,e.getMessage());
				 }
			}
			prev.setVisible(false);
			prev1.setVisible(false);
			paymode.setVisible(false);
			paymode1.setVisible(false);
			current.setVisible(false);
			current1.setVisible(false);
			totalpay.setVisible(false);
			totalpay1.setVisible(false);
			credit.setVisible(false);
			credit1.setVisible(false);
			submit1.setVisible(false);
			nprev.setVisible(false);
			nprev1.setVisible(false);
			page.setVisible(false);
			page1.setVisible(false);
			pay.setVisible(false);
			name.setVisible(true);
			name1.setVisible(true);
			submit.setVisible(true);
			name1.setEnabled(true);
			name1.removeAllItems();
			name1.addItem("Select");
			try
			{
			rs4=s.executeQuery("select name  from sales where Transaction='Pending'");
			name1.removeAllItems();
			name1.addItem("Select");
			while(rs4.next())
			{
				if(((DefaultComboBoxModel)name1.getModel()).getIndexOf(rs4.getString(1)) == -1) 
				{
					  name1.addItem(rs4.getString(1) );
				}
			}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			this.getRootPane().setDefaultButton(submit);
			
		}
		
	}
	if(ar.getSource()==submit1)
	{
		if(paymode1.getSelectedItem()=="Select")
		{
			JOptionPane.showMessageDialog(null,"Please Select Payment Mode");
		}
		else if(totalpay.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Please Enter Total Payment");
		}
		else
		{
			this.getRootPane().setDefaultButton(pay);
			totalpay1.setEditable(false);
			paymode1.setEnabled(false);
			submit.setVisible(false);
			submit1.setVisible(false);
			pay.setVisible(true);
			nprev.setVisible(true);
			nprev1.setVisible(true);
			credit1.setVisible(true);
			credit.setVisible(true);
			page.setVisible(true);
			page1.setVisible(true);
			nprev1.setEditable(false);
		//	page1.setEditable(false);
			if(Float.valueOf(totalpay1.getText())<Float.valueOf(current1.getText()))
			{
			nprev1.setText(String.valueOf((Float.valueOf(current1.getText())-Float.valueOf(totalpay1.getText()))+Float.valueOf(prev1.getText())));
			}
			else if(Float.valueOf(totalpay1.getText())>Float.valueOf(current1.getText()))
			{
				nprev1.setText(String.valueOf(Float.valueOf(prev1.getText())-(Float.valueOf(totalpay1.getText())-Float.valueOf(current1.getText())))); 
			}
			else
			{
				nprev1.setText(String.valueOf(Float.valueOf(prev1.getText())));
			}
			
		}
	}
    if(ar.getSource()==submit)
    {
	
	if(name1.getSelectedItem()=="Select")
	{
		JOptionPane.showMessageDialog(null,"Please Select Party Name");
	}
	else
	{
		name1.setEnabled(false);
		prev.setVisible(true);
		prev1.setVisible(true);
		paymode.setVisible(true);
		paymode1.setVisible(true);
		current.setVisible(true);
		current1.setVisible(true);
		totalpay.setVisible(true);
		totalpay1.setVisible(true);
		submit.setVisible(false);
		submit1.setVisible(true);
		credit.setVisible(false);
		credit1.setVisible(false);
		nprev.setVisible(false);
		nprev1.setVisible(false);
		page.setVisible(false);
		page1.setVisible(false);
		pay.setVisible(false);
	try
	{
		this.getRootPane().setDefaultButton(submit1);
		float temp=0;
	rs=s.executeQuery("select Previous from party where Customername='"+name1.getSelectedItem()+"'");
	while(rs.next())
	{
		prev1.setText(rs.getString(1));
	}
	rs1=s.executeQuery("select Price from sales where Name='"+name1.getSelectedItem()+"' AND Transaction='Pending'");
	while(rs1.next())
	{
		temp=temp+Float.valueOf(rs1.getString(1));
	}
	current1.setText(String.valueOf(temp));
	totalpay1.setText(String.valueOf(temp+Float.valueOf(prev1.getText())));
	}
	 catch(Exception e)
	  {
	 	JOptionPane.showMessageDialog(null,e.getMessage());
	 }
	
	}
    }
		
	}

}
