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
public class deleteitem extends JFrame implements ActionListener{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel l1=new JLabel("L1");
	JLabel l2=new JLabel("L2");
	JLabel quantity=new JLabel("Quantity");
	JLabel rate=new JLabel("Rate");
	JTextField l11=new JTextField();
	JTextField l21=new JTextField();
	JTextField quantity1=new JTextField();
	JTextField rate1=new JTextField();
	JButton submit =new JButton("Submit");
	JButton back =new JButton("Back");
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	Vector Columnname= new Vector();
	Vector data= new Vector();
	JPanel panel = new JPanel();
	Connection con;
	Statement s,s1;
	ResultSet rs1,rs,rs2,rs3;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	public deleteitem()
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
		this.setTitle("Sale / Order");
		add(copyright);
		add(l1);
		add(l2);
		add(rate);
		add(quantity);
		add(back);
		add(l11);
		add(l21);
		add(quantity1);
		add(rate1);
		add(submit);
		add(back);
		submit.addActionListener(this);
		back.addActionListener(this);
		submit.setFont(f1);
		back.setFont(f1);
		submit.setBackground(new Color(135,206,250));
		back.setBackground(new Color(135,206,250));
		l1.setBounds(370,100, 200, 50);
	    l1.setFont(f1);
	    l2.setBounds(370,150, 200, 50);
	    l2.setFont(f1);
	    quantity.setBounds(315,200, 250, 50);
		quantity.setFont(f1);
	    rate.setBounds(350,250, 100, 50);
		rate.setFont(f1);
		l11.setBounds(430, 110,230, 30);
		l21.setBounds(430, 160,230, 30);
		quantity1.setBounds(430, 210,230, 30);
		rate1.setBounds(430, 260,230, 30);
		submit.setBounds(490, 310,100, 30);
		this.getContentPane().setBackground(c);
		//copyright.setBounds(45,200,350,30); //panel copyright
		copyright.setBounds(550,680,350,30);
		copyright.setFont(f1);
	 back.setBounds(0,20,100,50);
	}
	public static void main(String[] args)
	{
	new deleteitem();	
	}
	@Override
	public void actionPerformed(ActionEvent ar) 
	{
		
		if(ar.getSource()==back)
		{
			new sale();
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
		if(ar.getSource()==submit)
		{
			try
			{
				if(l11.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter L1");
				}
				else if(l21.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter L2");
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
				rs=s.executeQuery("select * from temporder where L1 ='"+l11.getText()+"' AND L2='"+l21.getText()+"'AND Quantity='"+quantity1.getText()+"'AND Rate='"+rate1.getText()+"'");
			if(rs.next())
			{
				 s1.executeUpdate("DELETE from temporder where L1 ='"+l11.getText()+"' AND L2='"+l21.getText()+"'AND Quantity='"+quantity1.getText()+"'AND Rate='"+rate1.getText()+"'");
			l11.setText("");
			l21.setText("");
			quantity1.setText("");
			rate1.setText("");
			JOptionPane.showMessageDialog(null,"Item Deleted");
			}
			else
			{
				l11.setText("");
				l21.setText("");
				quantity1.setText("");
				rate1.setText("");
				JOptionPane.showMessageDialog(null,"Item Not Found");
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
