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
public class estimate extends JFrame implements ActionListener
{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel amount=new JLabel();
	JLabel deldate=new JLabel("Delivery Date");
	JTextField deldate1=new JTextField();
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	Vector Columnname= new Vector();
	Vector data= new Vector();
	JPanel panel = new JPanel();
	JButton finalize =new JButton("Finalize Sale");
	float temp=0;
	String ws;
	Connection con;
	Statement s,sq,s2,sq1,s1;
	ResultSet rs1,rs,rs2,rs3,rs4,rs5,rs6;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
public estimate()
{
	this.setIconImage(img.getImage());
	this.getRootPane().setDefaultButton(finalize);
	try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganpati","root","root");
	s=con.createStatement();
	s2=con.createStatement();
	sq=con.createStatement();
	sq1=con.createStatement();
	s1=con.createStatement();
    }
    catch(Exception e)
    {
    	JOptionPane.showMessageDialog(null,e.getMessage());
    }
	
	
	setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	this.setVisible(true);
	//this.setExtendedState(MAXIMIZED_BOTH);
	
	this.setLayout(null);
	this.setTitle("Estimate");
	add(copyright);
	add(panel);
	add(finalize);
	add(amount);
	add(deldate);
	add(deldate1);
	this.getContentPane().setBackground(c);
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
	//copyright.setBounds(45,200,350,30); //panel copyright
	copyright.setBounds(550,680,350,30);
	copyright.setFont(f1);
	deldate.setBounds(700,640,150,30);
	deldate.setFont(f1);
	deldate1.setBounds(830,640,100,30);
	deldate1.setText(ws);
	amount.setBounds(950,640,350,30);
	amount.setFont(f1);
	finalize.setBounds(450,640,200,30);
	finalize.setFont(f1);
	finalize.setBackground(new Color(135,206,250));
	finalize.addActionListener(this);
	Columnname.clear();
	data.clear();
	try
	{
	rs=s.executeQuery("select * from temporder");
	ResultSetMetaData md= rs.getMetaData();
	int columns= md.getColumnCount();
	
	for(int i=1;i<=columns-1;i++)
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
	  pane.setPreferredSize(new Dimension(1100,590));
	  panel.setBounds(30, 30, 1100, 600);
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
	this.setBounds(0,30,1366,768);
	this.setResizable(false);
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
		rs1=s.executeQuery("select * from temporder");
		while(rs1.next())
		{
			temp=temp+Float.valueOf(rs1.getString(8));
		}
       amount.setText("Amount : "+temp);
	}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null,ex.getMessage());
	}
}
	public static void main(String[] args)
	{
		new estimate();

	}

	public void actionPerformed(ActionEvent ar) 
	{
	if(ar.getSource()==finalize)
	{
		int qs=0;
		try
		{
		rs2=s.executeQuery("select number from page where num='a'");
		while(rs2.next())
		{
			qs=Integer.parseInt(rs2.getString(1));
		}
		
		}
		 catch(Exception e)
		  {
		 	JOptionPane.showMessageDialog(null,e.getMessage());
		 }
		try
		{
		sq.executeUpdate("update page set number='"+(qs+1)+"'where num='a'");
		}
		catch(Exception e)
		  {
		 	JOptionPane.showMessageDialog(null,e.getMessage());
		 }
		try
		{
			int u=0;
			rs6=s1.executeQuery("select Quantity from temporder");
			while(rs6.next())
			{
				u=u+Integer.parseInt(rs6.getString(1));
			}
			rs3=s.executeQuery("select * from temporder");
			while(rs3.next())
			{
				sq.executeUpdate("insert into sales values('"+rs3.getString(10)+"','"+rs3.getString(1)+"','"+rs3.getString(2)+"','"+rs3.getString(3)+"','"+rs3.getString(4)+"','"+rs3.getString(5)+"','"+rs3.getString(6)+"','"+rs3.getString(7)+"','"+rs3.getString(8)+"','"+ws+"','"+"Pending"+"','"+"Processing"+"')");	
				String lk=rs3.getString(2)+'*'+rs3.getString(3) ;
				for(int d=1;d<=Integer.parseInt(rs3.getString(6));d++)
				{
				sq1.executeUpdate("insert into orders values('"+(qs+1)+"','"+rs3.getString(10)+"','"+deldate1.getText()+"','"+u+"','"+rs3.getString(1)+"','"+lk+"','"+rs3.getString(6)+"')");	
				}
				}
			
			try
			{
			     Process p = Runtime.getRuntime().exec("iReport-5.2.0\\bin\\ireport.exe");
			     //C:\\Users\\Anshdeep\\Desktop\\Ganpati Final\\
			 }
			catch(Exception e)
			{
			     e.printStackTrace();
			 }
			try
			{
			s.executeQuery("Truncate temporder");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			JOptionPane.showMessageDialog(null,"Please Go To View Orders Review This Order");
			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
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
