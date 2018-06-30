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
public class vieworder extends JFrame implements ActionListener
{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel state=new JLabel("State");
	JLabel name=new JLabel("Name");
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	JButton update=new JButton("Update State");
	JButton home =new JButton("Home");
	JButton logout =new JButton("Logout");
	JComboBox state1=new JComboBox();
	JComboBox name1=new JComboBox();
	Vector Columnname= new Vector();
	Vector data= new Vector();
	JPanel panel = new JPanel();
	float temp=0;
	String ws;
	Connection con;
	Statement s,sq;
	ResultSet rs1,rs,rs2,rs3,rs4;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	public vieworder()
	{
		this.setIconImage(img.getImage());
		this.getRootPane().setDefaultButton(update);
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
		this.setTitle("View Orders");
		add(copyright);
		add(panel);
		add(state);
		add(state1);
		add(name);
		add(name1);
		add(update);
		add(home);
		add(logout);
		
		state.setBounds(350,580,350,30);
		state.setFont(f1);
		name.setBounds(700,580,350,30);
		name.setFont(f1);
		update.setBounds(650,640,200,30);
		state1.setBounds(450,580,200,30);
		name1.setBounds(800,580,200,30);
		update.setFont(f1);
		update.setBackground(new Color(135,206,250));
		update.addActionListener(this);
		home.setFont(f1);
		home.setBackground(new Color(135,206,250));
		home.addActionListener(this);
		logout.setFont(f1);
		logout.setBackground(new Color(135,206,250));
		logout.addActionListener(this);
		
		home.setBounds(0,20,150,40);
		logout.setBounds(150,20,150,40);
		
		this.getContentPane().setBackground(c);
		//copyright.setBounds(45,200,350,30); //panel copyright
		copyright.setBounds(550,680,350,30);
		copyright.setFont(f1);
		Columnname.clear();
		data.clear();
		try
		{
		rs=s.executeQuery("select * from sales where State='Processing'");
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
		state1.removeAllItems();
		state1.addItem("Select");
		state1.addItem("Processing");
		state1.addItem("Ready To Dispatch");
		
		name1.removeAllItems();
		name1.addItem("Select");
		try
		{
		rs1=s.executeQuery("select name  from sales where State='Processing'");
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
	}
	public static void main(String[] args) 
	{
		
new vieworder();
	}


	public void actionPerformed(ActionEvent ar) 
	{
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
		if(ar.getSource()==update)
		{
			 if(state1.getSelectedItem()=="Select")
			{
				JOptionPane.showMessageDialog(null,"Select State");
			}
			 else if(name1.getSelectedItem()=="Select")
			{
				JOptionPane.showMessageDialog(null,"Select Name");
			}
			
			else
			{
			try
			{
		s.executeUpdate("update sales set State='"+state1.getSelectedItem()+"'where Name='"+name1.getSelectedItem()+"'AND state='Processing'");
		    }
			 catch(Exception e)
			  {
			 	JOptionPane.showMessageDialog(null,e.getMessage());
			 }
			state1.removeAllItems();
			state1.addItem("Select");
			state1.addItem("Processing");
			state1.addItem("Ready To Dispatch");
			
			name1.removeAllItems();
			name1.addItem("Select");
			try
			{
			rs1=s.executeQuery("select name  from sales where State='Processing'");
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
			Columnname.clear();
			data.clear();
			try
			{
			rs=s.executeQuery("select * from sales where State='Processing'");
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
			 }
		
		
	   }

 }
}