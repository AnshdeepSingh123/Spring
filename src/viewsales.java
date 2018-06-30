import java.awt.event.ActionEvent;
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
public class viewsales extends JFrame implements ActionListener
{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel date=new JLabel("Date");
	JLabel party=new JLabel("Party");
	JButton home =new JButton("Home");
	JButton logout =new JButton("Logout");
	JButton bydate =new JButton("By Date");
	JButton sales =new JButton("Sales");
	JLabel amount=new JLabel("Amount:1234");
	JButton byparty =new JButton("By Party");
	JButton submit =new JButton("Submit");
	JButton submit1 =new JButton("Submit");
	JButton waste =new JButton("Submit");
	JComboBox party1=new JComboBox();
	JTextField date1=new JTextField();
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	Vector Columnname= new Vector();
	Vector data= new Vector();
	JPanel panel = new JPanel();
	Connection con;
	Statement s;
	ResultSet rs1,rs,rs2,rs3,rs4,rs5,rs6,rs7;
	String ws;
	float tr=0;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	public viewsales()
	{
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
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.setVisible(true);
		//this.setExtendedState(MAXIMIZED_BOTH);
		
		this.setLayout(null);
		this.setTitle("View Sales");
		
		add(copyright);
		add(home);
		add(logout);
		add(sales);
		add(bydate);
		add(byparty);
		add(panel);
		add(submit);
		add(submit1);
		add(party);
		add(date);
		add(party1);
		add(date1);
		add(amount);
		
		
		home.addActionListener(this);
		logout.addActionListener(this);
		sales.addActionListener(this);
		bydate.addActionListener(this);
		byparty.addActionListener(this);
		submit.addActionListener(this);
		submit1.addActionListener(this);
		
		home.setFont(f1);
		logout.setFont(f1);
		sales.setFont(f1);
		bydate.setFont(f1);
		byparty.setFont(f1);
		submit1.setFont(f1);
		submit.setFont(f1);
		amount.setFont(f1);
		
		submit.setBounds(1200, 30,100, 30);
		submit1.setBounds(1200, 30,100, 30);
		
		party.setFont(f1);
		date.setFont(f1);
		
		party.setBounds(920, 30,50, 30);
		date.setBounds(920, 30,50, 30);
		
		party1.setBounds(990, 30,200, 30);
		date1.setBounds(990, 30,200, 30);
		amount.setBounds(870, 640,400, 30);
		
		home.setBounds(0,20,150,50);
		sales.setBounds(150,20,150,50);
		bydate.setBounds(300,20,200,50);
		byparty.setBounds(500,20,200,50);
		logout.setBounds(700,20,200,50);
		
		home.setBackground(new Color(135,206,250));
		sales.setBackground(new Color(135,206,250));
		bydate.setBackground(new Color(135,206,250));
		byparty.setBackground(new Color(135,206,250));
		logout.setBackground(new Color(135,206,250));
		submit.setBackground(new Color(135,206,250));
		submit1.setBackground(new Color(135,206,250));
		
		this.getContentPane().setBackground(c);
		//copyright.setBounds(45,200,350,30); //panel copyright
		copyright.setBounds(550,680,350,30);
		copyright.setFont(f1);
		Columnname.clear();
		data.clear();
		try
		{
		rs=s.executeQuery("select * from sales where Transaction='Done'");
		ResultSetMetaData md= rs.getMetaData();
		int columns= md.getColumnCount();
		
		for(int i=1;i<=columns-2;i++)
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
		  pane.setPreferredSize(new Dimension(1100,540));
		  panel.setBounds(10, 80, 1100, 550);
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
		submit.setVisible(false);
		submit1.setVisible(false);
		date.setVisible(false);
		party.setVisible(false);
		party1.setVisible(false);
		date1.setVisible(false);
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
		try
		{
		rs4=s.executeQuery("select Price from sales where Transaction='Done'");
		tr=0;
		while(rs4.next())
		{
			tr=tr+Float.valueOf(rs4.getString(1));
		}
		}
		 catch(Exception e)
	 	 {
			JOptionPane.showMessageDialog(null, e.getMessage());
	 	 }
		amount.setText("Amount : Rs. "+tr);
		date1.setText(ws);
	}
	public static void main(String[] args) {
	
new viewsales();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==home)
		{
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
		if(e.getSource()==submit1)
		{
			
			this.getRootPane().setDefaultButton(submit1);
			if(party1.getSelectedItem()=="Select")
			{
				JOptionPane.showMessageDialog(null,"Please Select Party Name");
			}
			else
			{
			amount.setVisible(true);
			panel.setVisible(true);
			Columnname.clear();
			data.clear();
			try
			{
			rs=s.executeQuery("select *  from sales where Name='"+party1.getSelectedItem()+"'AND Transaction='Done'");
			ResultSetMetaData md= rs.getMetaData();
			int columns= md.getColumnCount();
			
			for(int i=1;i<=columns-2;i++)
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
			  pane.setPreferredSize(new Dimension(1100,540));
			  panel.setBounds(10, 80, 1100, 550);
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
			try
			{
			rs7=s.executeQuery("select Price from sales where Transaction='Done' AND Name='"+party1.getSelectedItem()+"'");
			tr=0;
			while(rs7.next())
			{
				tr=tr+Float.valueOf(rs7.getString(1));
			}
			}
			 catch(Exception er)
		 	 {
				JOptionPane.showMessageDialog(null, er.getMessage());
		 	 }
			amount.setText("Amount : Rs. "+tr);
			try
			{
			rs2=s.executeQuery("select Name from sales where Transaction='Done'");
			party1.removeAllItems();
	        party1.addItem("Select");
			while(rs2.next())
			{
				if(((DefaultComboBoxModel)party1.getModel()).getIndexOf(rs2.getString(1)) == -1) 
				{
					 party1.addItem(rs2.getString(1) );
				}
			}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			}
		}
		if(e.getSource()==byparty)
		{
			amount.setVisible(false);
			this.getRootPane().setDefaultButton(submit1);
			panel.setVisible(false);
			submit.setVisible(false);
			date.setVisible(false);
			date1.setVisible(false);
			submit1.setVisible(true);
			party1.setVisible(true);
			party.setVisible(true);
			try
			{
			rs2=s.executeQuery("select Name from sales where Transaction='Done'");
			party1.removeAllItems();
	        party1.addItem("Select");
			while(rs2.next())
			{
				if(((DefaultComboBoxModel)party1.getModel()).getIndexOf(rs2.getString(1)) == -1) 
				{
					 party1.addItem(rs2.getString(1) );
				}
			}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
		if(e.getSource()==submit)
		{
			this.getRootPane().setDefaultButton(submit);
			amount.setVisible(true);
			panel.setVisible(true);
			Columnname.clear();
			data.clear();
			try
			{
			rs=s.executeQuery("select *  from sales where Date='"+date1.getText()+"'AND Transaction='Done'");
			ResultSetMetaData md= rs.getMetaData();
			int columns= md.getColumnCount();
			
			for(int i=1;i<=columns-2;i++)
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
			  pane.setPreferredSize(new Dimension(1100,540));
			  panel.setBounds(10, 80, 1100, 550);
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
			try
			{
			rs6=s.executeQuery("select Price from sales where Transaction='Done' AND Date='"+date1.getText()+"'");
			tr=0;
			while(rs6.next())
			{
				tr=tr+Float.valueOf(rs6.getString(1));
			}
			}
			 catch(Exception er)
		 	 {
				JOptionPane.showMessageDialog(null, er.getMessage());
		 	 }
			amount.setText("Amount : Rs. "+tr);
		}
	if(e.getSource()==bydate)
	{
		amount.setVisible(false);
		this.getRootPane().setDefaultButton(submit);
		submit.setVisible(true);
		date.setVisible(true);
		date1.setVisible(true);
		submit1.setVisible(false);
		party1.setVisible(false);
		party.setVisible(false);
		panel.setVisible(false);
		date1.setText("");
		date1.setText(ws);
	}
	if(e.getSource()==sales)
	{
		this.getRootPane().setDefaultButton(waste);
		amount.setVisible(true);
		submit.setVisible(false);
		submit1.setVisible(false);
		date.setVisible(false);
		party.setVisible(false);
		party1.setVisible(false);
		date1.setVisible(false);
		panel.setVisible(true);
		Columnname.clear();
		data.clear();
		try
		{
		rs=s.executeQuery("select * from sales where Transaction='Done'");
		ResultSetMetaData md= rs.getMetaData();
		int columns= md.getColumnCount();
		
		for(int i=1;i<=columns-2;i++)
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
		  pane.setPreferredSize(new Dimension(1100,540));
		  panel.setBounds(10, 80, 1100, 550);
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
		try
		{
		rs5=s.executeQuery("select Price from sales where Transaction='Done'");
		tr=0;
		while(rs5.next())
		{
			tr=tr+Float.valueOf(rs5.getString(1));
		}
		}
		 catch(Exception er)
	 	 {
			JOptionPane.showMessageDialog(null, er.getMessage());
	 	 }
		amount.setText("Amount : Rs. "+tr);
	}
		
	}

}
