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
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.*;
import java.util.*;
public class dispatch  extends JFrame implements ActionListener
{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel name=new JLabel("Name");
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	JButton dis=new JButton("Dispatch");
	//JButton find=new JButton("Find Items");
	JButton home =new JButton("Home");
	JButton logout =new JButton("Logout");
	JButton generate =new JButton("Generate Bill");
	JComboBox name1=new JComboBox();
	//JComboBox item1=new JComboBox();
	Vector Columnname= new Vector();
	Vector data= new Vector();
	JPanel panel = new JPanel();
	float temp=0;
	int p=0, o=0;
	int sr=0;
	String ws;
	Connection con;
	Statement s,sq,s1,s2,s3,s4;
	ResultSet rs1,rs,rs2,rs3,rs4,rs5,rsn,rsn1,rsn2,rsn3;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	public dispatch()
	{
		this.setIconImage(img.getImage());
		this.getRootPane().setDefaultButton(dis);
		try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganpati","root","root");
		s=con.createStatement();
		s1=con.createStatement();
		sq=con.createStatement();
		s2=con.createStatement();
		s3=con.createStatement();
		s4=con.createStatement();
	    }
	    catch(Exception e)
	    {
	    	JOptionPane.showMessageDialog(null,e.getMessage());
	    }
		try
		{
			rsn=s1.executeQuery("select Billno  from tempbill");
			while(rsn.next())
			{
				p=Integer.parseInt(rsn.getString(1));
			}
			o=p+1;
		}
		catch(Exception e)
		  {
		 	JOptionPane.showMessageDialog(null,e.getMessage());
		 }
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.setVisible(true);
		//this.setExtendedState(MAXIMIZED_BOTH);
		
		this.setLayout(null);
		this.setTitle("Dispatch");
		add(copyright);
		add(name);
		//add(item);
		//add(item1);
		add(name1);
		add(panel);
		add(dis);
		//add(find);
		add(home);
		add(logout);
		add(generate);
		//add(l1);
	//	add(l2);
		//add(l11);
		//add(l21);
		
		
		name.setBounds(350,580,350,30);
		name.setFont(f1);
		//item.setBounds(700,580,350,30);
		//item.setFont(f1);
	//	l1.setBounds(1050,580,50,30);
		//l1.setFont(f1);
	//	l2.setBounds(1200,580,50,30);
	//	l2.setFont(f1);
     //	l21.setBounds(1250,580,50,30);
	//	l11.setBounds(1100,580,50,30);
	    //find.setBounds(450,640,200,30);
		dis.setBounds(450,640,200,30);
		generate.setBounds(1100,640,200,30);
		name1.setBounds(450,580,200,30);
	  //  item1.setBounds(800,580,200,30);
		
		home.setBounds(0,20,150,40);
		logout.setBounds(150,20,150,40);
		
		dis.setFont(f1);
	//	find.setFont(f1);
		generate.setFont(f1);
		dis.setBackground(new Color(135,206,250));
		dis.addActionListener(this);
		generate.setBackground(new Color(135,206,250));
		generate.addActionListener(this);
		//find.setBackground(new Color(135,206,250));
		//find.addActionListener(this);
		home.setFont(f1);
		home.setBackground(new Color(135,206,250));
		home.addActionListener(this);
		logout.setFont(f1);
		logout.setBackground(new Color(135,206,250));
		logout.addActionListener(this);
	
		this.getContentPane().setBackground(c);
		//copyright.setBounds(45,200,350,30); //panel copyright
		copyright.setBounds(550,680,350,30);
		copyright.setFont(f1);
		try
	 	 {
	 		 String months[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
	 		 String d[]={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	 		 GregorianCalendar g=new GregorianCalendar();
	 		 ws=d[g.get(Calendar.DATE)]+"/"+months[g.get(Calendar.MONTH)]+"/"+g.get(Calendar.YEAR);
		 }
	 	 catch(Exception e)
	 	 {
			JOptionPane.showMessageDialog(null, e.getMessage());
	 	 }
		Columnname.clear();
		data.clear();
		try
		{
		rs=s.executeQuery("select * from sales where State='Ready To Dispatch' AND Transaction='Done'");
		ResultSetMetaData md= rs.getMetaData();
		int columns= md.getColumnCount();
		
		for(int i=1;i<=columns;i++)
		{
			Columnname.addElement(md.getColumnName(i));
		}
		while(rs.next())
		{
			Vector row= new Vector(columns);
			data.addElement(row);
			
			for(int i=1;i<=columns;i++)
			{
				row.addElement(rs.getObject(i));
			}
		}
		JTable table = new JTable(data,Columnname);
		table.setEnabled(false);
		TableColumn col;
		for( int i=0; i< table.getColumnCount();i++)
		{
			col=table.getColumnModel().getColumn(i);
			col.setMinWidth(30);
			table.setRowHeight(30);
		}
		  JTableHeader header = table.getTableHeader();
		  header.setBackground(Color.WHITE);
		  JScrollPane pane = new JScrollPane(table);
		  pane.setPreferredSize(new Dimension(1100,510));
		  panel.setBounds(30, 60, 1100, 520);
		  table.setPreferredScrollableViewportSize(table.getPreferredSize());
		  table.setFillsViewportHeight(true);
		  pane.getViewport().setBackground(Color.WHITE);
		  panel.add(pane);
		  panel.setBackground(Color.white);
		  //setExtendedState(MAXIMIZED_BOTH);
		  getContentPane().setBackground(Color.white);
		  //setVisible(true);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		this.setBounds(0,0,1366,768);
		this.setResizable(false);
		
		name1.removeAllItems();
		name1.addItem("Select");
		try
		{
		rs1=s.executeQuery("select name  from sales where State='Ready To Dispatch' AND Transaction='Done'");
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
		//dis.setVisible(false);
		//item.setVisible(false);
		//item1.setVisible(false);
	   generate.setVisible(false);
		//l1.setVisible(false);
		//l2.setVisible(false);
		//l11.setVisible(false);
		//l21.setVisible(false);
		
	}
	public static void main(String[] args) 
	{
new dispatch();
	}


	public void actionPerformed(ActionEvent ar) 
	{
		
		if(ar.getSource()==generate)
		{
			try{
			     Process p = Runtime.getRuntime().exec("iReport-5.2.0\\bin\\ireport.exe");
			     //C:\\Users\\Anshdeep\\Desktop\\Ganpati Final\\
			 }
			catch(Exception e)
			{
			     e.printStackTrace();
			 }
			
			
			try
			{
				rsn=s1.executeQuery("select Billno  from tempbill");
				while(rsn.next())
				{
					p=Integer.parseInt(rsn.getString(1));
				}
				s1.executeUpdate("update current set bno='"+p+"'");
				o=p+1;
				
			}
				catch(Exception e)
				  {
				 	JOptionPane.showMessageDialog(null,e.getMessage());
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
		
		if(ar.getSource()==dis)
		{
			 if(name1.getSelectedItem()=="Select")
				{
					JOptionPane.showMessageDialog(null,"Select Item Name");
				}	
				else
				{
				try
				{
					this.rsn1 = this.sq.executeQuery("select *  from party where Customername='" + this.name1.getSelectedItem() + "'");
					 this.rsn3 = this.s4.executeQuery("select * from sales where Name='" + this.name1.getSelectedItem() + "' AND State='Ready To Dispatch'");
					if(rsn1.next())
					{
						while(rsn3.next())
						{
						 this.s2.executeUpdate("insert into tempbill values('" + this.o + "','" + this.rsn1.getString(1) + "','" + this.rsn1.getString(2) + "','" + this.rsn1.getString(3) + "','" + this.rsn1.getString(4) + "','" + this.rsn1.getString(5) + "','" + this.rsn3.getString(2) + "','" + this.rsn3.getString(7) + "','" + (Float.valueOf(this.rsn3.getString(5)).floatValue() * Float.valueOf(this.rsn3.getString(6)).floatValue() / Float.valueOf(144.0F).floatValue())*Integer.parseInt(rsn3.getString(7)) + "','" + this.rsn3.getString(8) + "','" + this.rsn3.getString(9)+ "','" + this.ws + "')");
				       	}
					}
			s.executeUpdate("update sales set State='Dispatched' where Name='"+name1.getSelectedItem()+"'");
			
			    }
				 catch(Exception e)
				  {
				 	JOptionPane.showMessageDialog(null,e.getMessage());
				 }
				name1.removeAllItems();
				name1.addItem("Select");
				try
				{
				rs1=s.executeQuery("select name  from sales where State='Ready To Dispatch' AND Transaction='Done'");
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
				//dis.setVisible(false);
				//item.setVisible(false);
				//item1.setVisible(false);
				//find.setVisible(true);
				name1.setEnabled(true);
				//l1.setVisible(false);
				//l2.setVisible(false);
				//l11.setVisible(false);
				//l21.setVisible(false);
				generate.setVisible(true);
			//	this.getRootPane().setDefaultButton(find);
				}
					Columnname.clear();
					data.clear();
					try
					{
					rs5=s.executeQuery("select * from sales where State='Ready To Dispatch' AND Transaction='Done'");
					ResultSetMetaData md= rs5.getMetaData();
					int columns= md.getColumnCount();
					
					for(int i=1;i<=columns;i++)
					{
						Columnname.addElement(md.getColumnName(i));
					}
					while(rs5.next())
					{
						Vector row= new Vector(columns);
						data.addElement(row);
						
						for(int i=1;i<=columns;i++)
						{
							row.addElement(rs5.getObject(i));
						}
					}
					JTable table = new JTable(data,Columnname);
					table.setEnabled(false);
					TableColumn col;
					for( int i=0; i< table.getColumnCount();i++)
					{
						col=table.getColumnModel().getColumn(i);
						col.setMinWidth(30);
						table.setRowHeight(30);
					}
					  JTableHeader header = table.getTableHeader();
					  header.setBackground(Color.WHITE);
					  JScrollPane pane = new JScrollPane(table);
					  pane.setPreferredSize(new Dimension(1100,510));
					  panel.setBounds(30, 60, 1100, 520);
					  table.setPreferredScrollableViewportSize(table.getPreferredSize());
					  table.setFillsViewportHeight(true);
					  pane.getViewport().setBackground(Color.WHITE);
					  panel.add(pane);
					  panel.setBackground(Color.white);
					  //setExtendedState(MAXIMIZED_BOTH);
					  getContentPane().setBackground(Color.white);
				}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,ex.getMessage());
					}
					
				
		}
	
	}
		
	}


