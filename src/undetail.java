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
public class undetail  extends JFrame implements ActionListener
{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	JLabel amount=new JLabel("Amount");
	JLabel party=new JLabel("Party");
	JComboBox party1=new JComboBox();
	JTextField amount1=new JTextField();
	JButton submit=new JButton("Submit");
	Vector Columnname= new Vector();
	Vector data= new Vector();
	JPanel panel = new JPanel();
	JButton view =new JButton("Submit");
	Connection con;
	Statement s,st;
	ResultSet rs1,rs,rs2;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	public undetail()
	{
		this.getRootPane().setDefaultButton(submit);
		this.setIconImage(img.getImage());
		try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganpati","root","root");
		s=con.createStatement();
		st=con.createStatement();
	    }
	    catch(Exception e)
	    {
	    	JOptionPane.showMessageDialog(null,e.getMessage());
	    }
		
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		this.setVisible(true);
		//this.setExtendedState(MAXIMIZED_BOTH);
		
		this.setLayout(null);
		this.setTitle("Undetail Outstanding Balance");
		add(copyright);
		add(panel);
		add(view);
		add(submit);
		add(amount);
		add(party);
		add(amount1);
		add(party1);
		submit.setBounds(570,650,200,30);
		submit.setFont(f1);
		submit.setBackground(new Color(135,206,250));
		submit.addActionListener(this);
		
		amount.setBounds(700,600,150,30);
		amount.setFont(f1);
		amount1.setBounds(790,600,90,30);
		
		party.setBounds(400,600,150,30);
		party.setFont(f1);
		party1.setBounds(470,600,200,30);
		
	  
	    
	    try
		{
		rs1=s.executeQuery("select  Name from credit");
		party1.removeAllItems();
		party1.addItem("Select");
		while(rs1.next())
		{
			if(((DefaultComboBoxModel)party1.getModel()).getIndexOf(rs1.getString(1)) == -1) 
			{
				  party1.addItem(rs1.getString(1) );
			}
		}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		
		//amount1.setText(ws);
		
		this.getContentPane().setBackground(c);
		//copyright.setBounds(45,200,350,30); //panel copyright
		copyright.setBounds(550,680,350,30);
		copyright.setFont(f1);
		Columnname.clear();
		data.clear();
		try
		{
		rs=s.executeQuery("select * from credit");
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
		  pane.setPreferredSize(new Dimension(1100,540));
		  panel.setBounds(30, 30, 1100, 550);
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
	
	public static void main(String[] args) 
	{
	new undetail();

	}

	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==submit)
		{
			if(party1.getSelectedItem()=="Select")
			{
				JOptionPane.showMessageDialog(null,"Select Party Name");
			}
			else if(amount1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Amount");
			}
			else
			{
				try
				{
				rs2=s.executeQuery("select Balance from credit where Name ='"+party1.getSelectedItem()+"'");
				{
					if(rs2.next())
					{
						if(rs2.getString(1).equals(amount1.getText()))
						{
							 st.executeUpdate("DELETE from credit where name='"+party1.getSelectedItem()+"'");
							 
						}
						else
						{
						String s=String.valueOf(Float.valueOf(rs2.getString(1))-Float.valueOf(amount1.getText()));
						st.executeUpdate("update credit set Balance='"+s+"'where Name='"+party1.getSelectedItem()+"'");
						}
					}
					rs1=s.executeQuery("select  Name from credit");
					party1.removeAllItems();
					party1.addItem("Select");
					amount1.setText("");
					while(rs1.next())
					{
						if(((DefaultComboBoxModel)party1.getModel()).getIndexOf(rs1.getString(1)) == -1) 
						{
							  party1.addItem(rs1.getString(1) );
						}
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
				rs=s.executeQuery("select * from credit");
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
				  pane.setPreferredSize(new Dimension(1100,540));
				  panel.setBounds(30, 30, 1100, 550);
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
