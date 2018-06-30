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
public class sale extends JFrame implements ActionListener
{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel name=new JLabel("Party Name");
	JLabel company=new JLabel("Company Name");
	JLabel item=new JLabel("Item Name");
	JComboBox name1=new JComboBox();
	JComboBox company1=new JComboBox();
	JComboBox item1=new JComboBox();
	JLabel quantity=new JLabel("Quantity");
	JLabel l1=new JLabel("L1");
	JLabel l2=new JLabel("L2");
	JLabel cl1=new JLabel("Chargable L1");
	JLabel cl2=new JLabel("Chargable L2");
	JLabel rate=new JLabel("Rate");
	JTextField l11=new JTextField();
	JTextField l21=new JTextField();
	JTextField cl11=new JTextField();
	JTextField cl21=new JTextField();
	JTextField quantity1=new JTextField();
	JTextField rate1=new JTextField();
	JButton getitemdetails =new JButton("Get Items");
	JButton itemdetails =new JButton("Item Details");
	JButton additem =new JButton("Add Item");
	JButton viewstock=new JButton("View Stock");
	JButton estimate =new JButton("Get Estimate");
	JButton finalize =new JButton("Finalize Order");
	JButton home =new JButton("Home");
	JButton logout =new JButton("Logout");
	JButton newsale =new JButton("New Sale");
	JButton deleteitem =new JButton("Delete Item");
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	Vector Columnname= new Vector();
	Vector data= new Vector();
	JPanel panel = new JPanel();
	Connection con;
	Statement s;
	ResultSet rs1,rs,rs2,rs3;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
public sale()
{
	this.setIconImage(img.getImage());
	this.getRootPane().setDefaultButton(getitemdetails);
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
	
	setDefaultCloseOperation( EXIT_ON_CLOSE );
	this.setVisible(true);
	this.setResizable(false);
	//this.setExtendedState(MAXIMIZED_BOTH);
	this.setBounds(0,0,1366,768);
	this.setLayout(null);
	this.setTitle("Sale / Order");
	try
	{
	s.executeQuery("Truncate orders");
	}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null,ex.getMessage());
	}
	try
	{
	rs=s.executeQuery("select  Customername from party");
	name1.removeAllItems();
	name1.addItem("Select");
	while(rs.next())
	{
		name1.addItem(rs.getString(1));
	}
	}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null,ex.getMessage());
	}
	
	try
	{
	rs1=s.executeQuery("select  Company from stocks");
	company1.removeAllItems();
    company1.addItem("Select");
	while(rs1.next())
	{
		if(((DefaultComboBoxModel)company1.getModel()).getIndexOf(rs1.getString(1)) == -1) 
		{
			  company1.addItem(rs1.getString(1) );
		}
	}
	}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null,ex.getMessage());
	}
	
	add(copyright);
	add(l1);
	add(l2);
	add(cl1);
	add(cl2);
	add(rate);
	add(quantity);
	add(deleteitem);
	add(l11);
	add(l21);
	add(cl11);
	add(cl21);
	add(company1);
	add(name1);
	add(item1);
	add(quantity1);
	add(rate1);
	
	add(name);
	add(company);
	add(item);
	
	add(getitemdetails);
	add(itemdetails);
	add(additem);
	add(estimate);
	add(finalize);
	add(home);
	add(logout);
	add(newsale);
	add(viewstock);
	
	getitemdetails.addActionListener(this);
	itemdetails.addActionListener(this);
	additem.addActionListener(this);
	estimate.addActionListener(this);
	finalize.addActionListener(this);
	home.addActionListener(this);
	logout.addActionListener(this);
	newsale.addActionListener(this);
	viewstock.addActionListener(this);
	deleteitem.addActionListener(this);
	
	home.setFont(f1);
	getitemdetails.setFont(f1);
	itemdetails.setFont(f1);
	additem.setFont(f1);
	estimate.setFont(f1);
	finalize.setFont(f1);
	logout.setFont(f1);
	newsale.setFont(f1);
	viewstock.setFont(f1);
    deleteitem.setFont(f1);
	//submit3.setFont(f1);
	
	home.setBounds(0,20,150,50);
	newsale.setBounds(150,20,150,50);
	viewstock.setBounds(500,20,200,50);
	estimate.setBounds(300,20,200,50);
	deleteitem.setBounds(700,20,200,50);
	logout.setBounds(900,20,200,50);
	
	home.setBackground(new Color(135,206,250));
	additem.setBackground(new Color(135,206,250));
	getitemdetails.setBackground(new Color(135,206,250));
	itemdetails.setBackground(new Color(135,206,250));
	estimate.setBackground(new Color(135,206,250));
	finalize.setBackground(new Color(135,206,250));
	newsale.setBackground(new Color(135,206,250));
    viewstock.setBackground(new Color(135,206,250));
	deleteitem.setBackground(new Color(135,206,250));
	logout.setBackground(new Color(135,206,250));
	
	name.setBounds(290,100, 150, 50);
	name.setFont(f1);
	company.setBounds(250,150, 250, 50);
	company.setFont(f1);
	item.setBounds(300,200, 100, 50);
	item.setFont(f1);
	l1.setBounds(370,250, 200, 50);
    l1.setFont(f1);
    l2.setBounds(370,300, 200, 50);
    l2.setFont(f1);
    cl1.setBounds(700,250, 200, 50);
    cl1.setFont(f1);
    cl2.setBounds(700,300, 200, 50);
    cl2.setFont(f1);
    quantity.setBounds(315,350, 250, 50);
	quantity.setFont(f1);
    rate.setBounds(350,400, 100, 50);
	rate.setFont(f1);

	name1.setBounds(430, 110,230, 30);
	company1.setBounds(430, 160,230, 30);
	item1.setBounds(430, 210,230, 30);
   l11.setBounds(430, 260,230, 30);
   l21.setBounds(430, 310,230, 30);
    cl11.setBounds(860, 260,230, 30);
   cl21.setBounds(860, 310,230, 30);
    quantity1.setBounds(430, 360,230, 30);
	rate1.setBounds(430, 410,230, 30);
 
    item.setVisible(false);
    l1.setVisible(false);
    l2.setVisible(false);
    cl1.setVisible(false);
    cl2.setVisible(false);
    quantity.setVisible(false);
    rate.setVisible(false);
    
    item1.setVisible(false); 
    l11.setVisible(false);
    l21.setVisible(false);
    cl11.setVisible(false);
    cl21.setVisible(false);
    quantity1.setVisible(false);
    rate1.setVisible(false);
    
    itemdetails.setVisible(false);
    additem.setVisible(false);
    
    
	getitemdetails.setBounds(440, 230,200, 30);
	itemdetails.setBounds(440, 260,200, 30);
	additem.setBounds(440, 480,200, 30);
    
	this.getContentPane().setBackground(c);
	//copyright.setBounds(45,200,350,30); //panel copyright
	copyright.setBounds(550,680,350,30);
	copyright.setFont(f1);
	
}
	public static void main(String[] args)
	{
	new sale();	

	}

	
	public void actionPerformed(ActionEvent ar)
	{
		if(ar.getSource()==deleteitem)
		{
			new deleteitem();
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
		if(ar.getSource()==estimate)
		{
			try
			{
			rs3=s.executeQuery("select *from temporder");
			if(rs3.next())
			{
				new estimate();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No Item Added");
			}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
		if(ar.getSource()==viewstock)
		{
			new viewstock();
		}
		if(ar.getSource()==newsale)
		{
			try
			{
			s.executeQuery("Truncate temporder");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			try
			{
			s.executeQuery("Truncate orders");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			 item.setVisible(false);
			    l1.setVisible(false);
			    l2.setVisible(false);
			    cl1.setVisible(false);
			    cl2.setVisible(false);
			    quantity.setVisible(false);
			    rate.setVisible(false);
			    
			    item1.setVisible(false); 
			    l11.setVisible(false);
			    l21.setVisible(false);
			    cl11.setVisible(false);
			    cl21.setVisible(false);
			    quantity1.setVisible(false);
			    rate1.setVisible(false);
			    
			    itemdetails.setVisible(false);
			    additem.setVisible(false);
			    getitemdetails.setVisible(true);
			    company1.setEnabled(true);
			    name1.setEnabled(true);
			    
			    item1.setSelectedItem("Select");
			    name1.setSelectedItem("Select");
		    	company1.setSelectedItem("Select");
		    	l11.setText("");
		    	l21.setText("");
		    	cl11.setText("");
		    	cl21.setText("");
		    	quantity1.setText("");
		    	rate1.setText("");
		    	this.getRootPane().setDefaultButton(getitemdetails);
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
		
		if(ar.getSource()==additem)
		{
			if(name1.getSelectedItem()=="Select")
		      {
			JOptionPane.showMessageDialog(null,"Please Select Party");
		     }
		   else if(company1.getSelectedItem()=="Select")
		    {
			JOptionPane.showMessageDialog(null,"Please Select  Company Name");
		    }
		   else if(item1.getSelectedItem()=="Select")
		    {
			JOptionPane.showMessageDialog(null,"Please Select Item");
		    }
		   else if(l11.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter L1");
		    }
		   else if(l21.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter L2");
		    }
		   else if(cl11.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter Chargable L1");
		    }
		   else if(cl21.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter Chargable L2");
		    }
		   else if(quantity1.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter Quantity");
		    }
		   else if(rate1.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter Rate");
		    }
		    else
		    {
		         try
		         {
		        	 float temp1=Float.valueOf(cl11.getText())*Float.valueOf(cl21.getText());
		        	 float temp2=(float)temp1/(float)144;
		        	 float temp3=(float)temp2*Float.valueOf(rate1.getText());
		        	 float temp4=(float)temp3*Float.valueOf(quantity1.getText());
		        	 float temp5=(float)temp2*Float.valueOf(quantity1.getText());
		    	s.executeUpdate("insert into temporder values('"+item1.getSelectedItem()+"','"+l11.getText()+"','"+l21.getText()+"','"+cl11.getText()+"','"+cl21.getText()+"','"+quantity1.getText()+"','"+rate1.getText()+"','"+temp4+"','"+temp5+"','"+name1.getSelectedItem()+"')");	
		    	JOptionPane.showMessageDialog(null,"Item Added");
		    	item1.setSelectedItem("Select");
		    	company1.setSelectedItem("Select");
		    	l11.setText("");
		    	l21.setText("");
		    	cl11.setText("");
		    	cl21.setText("");
		    	quantity1.setText("");
		    	rate1.setText("");
		    	
		    	item.setVisible(false);
		    	item1.setVisible(false);
		    	l1.setVisible(false);
		    	l11.setVisible(false);
		    	l2.setVisible(false);
		    	l21.setVisible(false);
		    	cl1.setVisible(false);
		    	cl11.setVisible(false);
		    	cl2.setVisible(false);
		    	cl21.setVisible(false);
		    	quantity1.setVisible(false);
		    	rate1.setVisible(false);
		    	quantity.setVisible(false);
		    	rate.setVisible(false);
		    	additem.setVisible(false);
		    	getitemdetails.setVisible(true);
		    	this.getRootPane().setDefaultButton(getitemdetails);
		    	 company1.setEnabled(true);
		    	 name1.setEnabled(true);
		         }
		    	catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}

		    }
		}
		
		if(ar.getSource()==itemdetails)
		{
			if(item1.getSelectedItem()=="Select")
		    {
		    	JOptionPane.showMessageDialog(null,"Please Select Item Name");
		    }
			else
			{
				this.getRootPane().setDefaultButton(additem);
				name1.setEnabled(false);
				 company1.setEnabled(false);
				additem.setVisible(true);
				company1.setVisible(true);
				company.setVisible(true);
				name1.setVisible(true);
				name.setVisible(true);
				 getitemdetails.setVisible(false);
			  	 itemdetails.setVisible(false);
			  	 item.setVisible(true);
			  	l1.setVisible(true);
		  	    l2.setVisible(true);
		  	    cl1.setVisible(true);
		  	    cl2.setVisible(true);
		  	    quantity.setVisible(true);
		  	    rate.setVisible(true);
		  	   item1.setVisible(true); 
		  	    l11.setVisible(true);
		  	    l21.setVisible(true);
		  	    cl11.setVisible(true);
		  	    cl21.setVisible(true);
		  	    quantity1.setVisible(true);
		  	    rate1.setVisible(true);
			}
		}
		
		
  if(ar.getSource()==getitemdetails)
{
	  
	    
	    if(name1.getSelectedItem()=="Select")
	    {
	    	JOptionPane.showMessageDialog(null,"Please Select Party Name");
	    }
	    else if(company1.getSelectedItem()=="Select")
	    {
	    	JOptionPane.showMessageDialog(null,"Please Select Company Name");
	    }
	    else
	    {
	    	this.getRootPane().setDefaultButton(itemdetails);
	      company1.setEnabled(false);
	      name1.setEnabled(false);
	  	  getitemdetails.setVisible(false);
	  	  itemdetails.setVisible(true);
	  	  item.setVisible(true);
	  	    l1.setVisible(false);
	  	    l2.setVisible(false);
	  	    cl1.setVisible(false);
	  	    cl2.setVisible(false);
	  	    quantity.setVisible(false);
	  	    rate.setVisible(false);
	  	    
	  	    item1.setVisible(true); 
	  	    l11.setVisible(false);
	  	    l21.setVisible(false);
	  	    cl11.setVisible(false);
	  	    cl21.setVisible(false);
	  	    quantity1.setVisible(false);
	  	    rate1.setVisible(false);
	    try
		{
		rs2=s.executeQuery("select Item from stocks where Company ='"+company1.getSelectedItem()+"'");
		item1.removeAllItems();
	    item1.addItem("Select");
		while(rs2.next())
		{
			if(((DefaultComboBoxModel)item1.getModel()).getIndexOf(rs2.getString(1)) == -1) 
			{
				  item1.addItem(rs2.getString(1) );
			}
		}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	    }  
}
		
	}

}
