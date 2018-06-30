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

public class attendence extends JFrame implements ActionListener{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel amount=new JLabel();
	JLabel start=new JLabel("Start Time");
	JLabel lunchin=new JLabel("Lunch In Time");
	JLabel lunchout=new JLabel("Lunch Out Time");
	JLabel end=new JLabel("End Time");
	JTextField start1=new JTextField();
	JTextField lunchin1=new JTextField();
	JTextField lunchout1=new JTextField();
	JTextField end1=new JTextField();
	JButton add =new JButton("Mark Attendence");
	JButton view =new JButton("View Attendence");
	JButton delete =new JButton("Pay Salary");
	JButton employees =new JButton("Employees");
	JButton home =new JButton("Home");
	JButton logout =new JButton("Logout");
	JButton submit =new JButton("Submit");
	JButton submit1 =new JButton("Submit");
	JButton submit2 =new JButton("Submit");
	JButton submit3 =new JButton("Submit");
	JComboBox j1=new JComboBox();
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
	String ws;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	public attendence()
	{
		this.setIconImage(img.getImage());
		this.getRootPane().setDefaultButton(submit);
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
		this.setTitle("Attendence");
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
		add(copyright);
		add(amount);
		add(home);
		add(add);
		add(view);
		add(delete);
		add(logout);
		add(employees);
		add(submit);
		add(submit1);
		add(j1);
		
		add(start);
		add(lunchin);
		add(lunchout);
		add(end);
		
		add(start1);
		add(lunchin1);
		add(lunchout1);
		add(end1);
		
		amount.setBounds(450,230, 200, 50);
		amount.setFont(f1);
		
		start.setFont(f1);
		lunchin.setFont(f1);
		lunchout.setFont(f1);
		end.setFont(f1);
		
		j1.setBounds(30, 285,300, 40);
		
		submit.setBounds(520, 410,100, 30);
		submit1.setBounds(540, 320,100, 30);
		//submit2.setBounds(420, 210,100, 30);
		
		start.setBounds(375,201, 200, 50);
		lunchin.setBounds(550,200, 200, 50);
		lunchout.setBounds(750,200, 200, 50);
		end.setBounds(950,200, 200, 50);
		
		start1.setBounds(375,280, 100, 50);
		lunchin1.setBounds(550,280, 100, 50);
		lunchout1.setBounds(750,280, 100, 50);
		end1.setBounds(950,280, 100, 50);
		
		submit.addActionListener(this);
		submit1.addActionListener(this);
		logout.addActionListener(this);
		home.addActionListener(this);
		add.addActionListener(this);
		view.addActionListener(this);
		delete.addActionListener(this);
		employees.addActionListener(this);
		
		home.setBounds(0,20,150,50);
		add.setBounds(150,20,200,50);
		view.setBounds(350,20,200,50);
		delete.setBounds(550,20,210,50);
		employees.setBounds(760,20,210,50);
		logout.setBounds(960,20,140,50);
		
		home.setFont(f1);
		add.setFont(f1);
		view.setFont(f1);
		delete.setFont(f1);
		logout.setFont(f1);
		employees.setFont(f1);
		submit.setFont(f1);
		submit1.setFont(f1);
		submit2.setFont(f1);
		
		home.setBackground(new Color(135,206,250));
		add.setBackground(new Color(135,206,250));
		view.setBackground(new Color(135,206,250));
		delete.setBackground(new Color(135,206,250));
		submit.setBackground(new Color(135,206,250));
		submit1.setBackground(new Color(135,206,250));
		logout.setBackground(new Color(135,206,250));
	    employees.setBackground(new Color(135,206,250));
	    
		this.getContentPane().setBackground(c);
		//copyright.setBounds(45,200,350,30); //panel copyright
		copyright.setBounds(550,680,350,30);
		copyright.setFont(f1);
		panel.setVisible(false);
		submit1.setVisible(false);
		amount.setVisible(false);
		j1.removeAllItems();
		j1.addItem("Select");
		try
		{
		rs=s.executeQuery("select name from employees");
		while(rs.next())
		{
			j1.addItem(rs.getString(1));
		}
		}
		 catch(Exception e)
		  {
		 	JOptionPane.showMessageDialog(null,e.getMessage());
		 }

	}
	public static void main(String[] args) {

new attendence();
	}


	public void actionPerformed(ActionEvent ar)
	{
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
		if(ar.getSource()==add)
		{
			j1.setBounds(30, 285,300, 40);
			this.getRootPane().setDefaultButton(submit);
			j1.setVisible(true);
			start.setVisible(true);
			lunchin.setVisible(true);
			lunchout.setVisible(true);
			end.setVisible(true);
			start1.setVisible(true);
			lunchin1.setVisible(true);
			lunchout1.setVisible(true);
			end1.setVisible(true);
			submit.setVisible(true);
			submit1.setVisible(false);
			panel.setVisible(false);
			amount.setVisible(false);
		}
		if(ar.getSource()==view)
		{
			this.getRootPane().setDefaultButton(submit2);
			j1.setVisible(false);
			start.setVisible(false);
			lunchin.setVisible(false);
			lunchout.setVisible(false);
			end.setVisible(false);
			start1.setVisible(false);
			lunchin1.setVisible(false);
			lunchout1.setVisible(false);
			end1.setVisible(false);
			submit.setVisible(false);
			submit1.setVisible(false);
			panel.setVisible(true);
			amount.setVisible(false);
			Columnname.clear();
			data.clear();
			try
			{
			rs1=s.executeQuery("select * from attendence");
			ResultSetMetaData md= rs1.getMetaData();
			int columns= md.getColumnCount();
			
			for(int i=1;i<=columns;i++)
			{
				Columnname.addElement(md.getColumnName(i));
			}
			while(rs1.next())
			{
				Vector row= new Vector(columns);
				data.addElement(row);
				
				for(int i=1;i<=columns;i++)
				{
					row.addElement(rs1.getObject(i));
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
			  pane.setPreferredSize(new Dimension(1100,590));
			  panel.setBounds(10, 80, 1100, 600);
			  table.setPreferredScrollableViewportSize(table.getPreferredSize());
			  table.setFillsViewportHeight(true);
			  pane.getViewport().setBackground(Color.WHITE);
			  panel.add(pane);
			  add(panel);
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
		if(ar.getSource()==delete)
		{
			this.getRootPane().setDefaultButton(submit1);
			j1.setBounds(450, 150,300, 40);
			j1.setVisible(true);
			start.setVisible(false);
			lunchin.setVisible(false);
			lunchout.setVisible(false);
			end.setVisible(false);
			start1.setVisible(false);
			lunchin1.setVisible(false);
			lunchout1.setVisible(false);
			end1.setVisible(false);
			submit.setVisible(false);
			submit1.setVisible(true);
			panel.setVisible(false);
			amount.setVisible(true);
		}
		if(ar.getSource()==submit)
		{
			if(j1.getSelectedItem()=="Select")
			{
				JOptionPane.showMessageDialog(null,"Please Select Employee Name");
			}
		else if(start1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Start Time");
			}
			else if(lunchin1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Lunch In Time");
			}
			else if(lunchout1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Lunch Out Time");
			}
			else if(end1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter End Time");
			}
			else
			{
			try
			{
			String t1=start1.getText();
			String  t2= lunchin1.getText();
			String  t3= lunchout1.getText();
			String  t4= end1.getText();

			SimpleDateFormat format = new SimpleDateFormat("HHmm");
			Date date1 = format.parse(t1);
			Date date2 = format.parse(t2);
			Date date3 = format.parse(t3);
			Date date4= format.parse(t4);
			long d1 = date2.getTime() - date1.getTime();
			long d2 = date4.getTime() - date3.getTime();
			long d3 = date3.getTime() - date2.getTime();
			long m=d1+d2;
			long minutes1 = TimeUnit.MILLISECONDS.toMinutes(d3);
			long minutes2 = TimeUnit.MILLISECONDS.toMinutes(m);
			int cot=0;
			try
			{
			rs1=s.executeQuery("select wtime from employees where name ='"+j1.getSelectedItem()+"'");
			while(rs1.next()){
			cot=Integer.parseInt(rs1.getObject(1).toString())+(int)minutes2;
			}
			s.executeUpdate("insert into attendence values('"+j1.getSelectedItem()+"','"+start1.getText()+"','"+lunchin1.getText()+"','"+lunchout1.getText()+"','"+end1.getText()+"','"+ws+"')");
			s.executeUpdate("update employees set wtime='"+cot+"'where name='"+j1.getSelectedItem()+"'");
			JOptionPane.showMessageDialog(null,"Attendence marked");
	  		start1.setText("");
	  	    lunchin1.setText("");
	  	    lunchout1.setText("");
	  	    end1.setText("");
			}
			 catch(Exception e)
			  {
			 	JOptionPane.showMessageDialog(null,e.getMessage());
			 }
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			}
		}
		if(ar.getSource()==submit1)
		{
			if(j1.getSelectedItem()=="Select")
			{
				JOptionPane.showMessageDialog(null,"Please Select Employee");
			}
			else
			{
			float cott=0;
			float cott1=0;
			float cott2=0;
			try
			{
			rs2=s.executeQuery("select wtime from employees where name ='"+j1.getSelectedItem()+"'");
			while(rs2.next())
			{
			cott=Float.valueOf((rs2.getObject(1).toString()));
			}
			rs3=s.executeQuery("select salarymi from employees where name ='"+j1.getSelectedItem()+"'");
			while(rs3.next())
			{
			cott1=Float.valueOf((rs3.getObject(1).toString()));
			}
			cott2=cott1*cott;
			amount.setText("Amount : "+cott2);
			s.executeUpdate("update employees set wtime='"+0+"'where name='"+j1.getSelectedItem()+"'");
			s.executeUpdate("insert into salary values('"+j1.getSelectedItem()+"','"+cott2+"','"+ws+"')");
			JOptionPane.showMessageDialog(null,"Salary Paid");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			j1.removeAllItems();
			j1.addItem("Select");
			try
			{
			rs=s.executeQuery("select name from employees");
			while(rs.next())
			{
				j1.addItem(rs.getString(1));
			}
			}
			 catch(Exception e)
			  {
			 	JOptionPane.showMessageDialog(null,e.getMessage());
			 }
			}

		}
					if(ar.getSource()==employees)
		{
			new employees();
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
	}
	}