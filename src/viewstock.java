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
public class viewstock  extends JFrame implements ActionListener{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	Vector Columnname= new Vector();
	Vector data= new Vector();
	JPanel panel = new JPanel();
	JButton view =new JButton("Submit");
	Connection con;
	Statement s;
	ResultSet rs1,rs,rs2;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
public viewstock()
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
	
	setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	this.setVisible(true);
	//this.setExtendedState(MAXIMIZED_BOTH);
	
	this.setLayout(null);
	this.setTitle("View Stock");
	add(copyright);
	add(panel);
	add(view);
	this.getContentPane().setBackground(c);
	//copyright.setBounds(45,200,350,30); //panel copyright
	copyright.setBounds(550,680,350,30);
	copyright.setFont(f1);
	Columnname.clear();
	data.clear();
	try
	{
	rs=s.executeQuery("select * from stocks");
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
	this.setBounds(0,0,1366,768);
	this.setResizable(false);
}
	public static void main(String[] args) {
		new viewstock();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
	}

}
