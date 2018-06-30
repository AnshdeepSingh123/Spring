import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
public class addparty extends JFrame implements ActionListener{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel salutation=new JLabel("Salutation");
	JLabel customername=new JLabel("Customer Name");
	JLabel address=new JLabel("Address");
	JLabel mobile=new JLabel("Mobile Number");
	JLabel gst=new JLabel("GST Number");
	JButton submit =new JButton("Submit");
	JButton submit1 =new JButton("Submit");
	JButton submit2 =new JButton("Submit");
	JButton add =new JButton("Add party");
	JButton view =new JButton("View Party");
	JButton delete =new JButton("Delete Party");
	JButton home =new JButton("Home");
	JButton logout =new JButton("Logout");
	JTextField customername1=new JTextField();
	JTextField gst1=new JTextField();
	JTextField mobile1=new JTextField();
	TextArea address1=new TextArea();
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
	ResultSet rs1,rs;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	public addparty()
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
		this.setTitle("Add Party");
		this.add(copyright);
		add(home);
		add(add);
		add(view);
		add(delete);
		add(logout);
		add(submit);
		add(submit1);
		add(salutation);
		add(customername);
		add(address);
		add(mobile);
		add(j1);
		add(mobile1);
		add(customername1);
		add(address1);
		add(gst);
		add(gst1);
		submit.setBackground(new Color(135,206,250));
		submit1.setBackground(new Color(135,206,250));
		submit.addActionListener(this);
		submit1.addActionListener(this);
		logout.addActionListener(this);
		home.addActionListener(this);
		add.addActionListener(this);
		view.addActionListener(this);
		delete.addActionListener(this);
		logout.setBounds(600,20,140,50);
		logout.setFont(f1);
		logout.setBackground(new Color(135,206,250));
		home.setBounds(0,20,150,50);
		add.setBounds(150,20,150,50);
		view.setBounds(300,20,150,50);
		delete.setBounds(450,20,150,50);
		home.setFont(f1);
		add.setFont(f1);
		view.setFont(f1);
		delete.setFont(f1);
		
		home.setBackground(new Color(135,206,250));
		add.setBackground(new Color(135,206,250));
		view.setBackground(new Color(135,206,250));
		delete.setBackground(new Color(135,206,250));
		salutation.setBounds(205,100, 150, 50);
		salutation.setFont(f1);
		customername.setBounds(150,150, 250, 50);
		customername.setFont(f1);
		address.setBounds(220,200, 100, 50);
		address.setFont(f1);
		mobile.setBounds(160,300, 200, 50);
		mobile.setFont(f1);
		gst.setBounds(177,350, 200, 50);
		gst.setFont(f1);
		
		j1.setBounds(320, 110,230, 40);
		j1.setFont(f);
		 j1.addItem("Ms.");
			j1.addItem("Mr.");
			j1.addItem("Mrs.");
		customername1.setBounds(320, 160,230, 30);
		address1.setBounds(320, 200,230, 100);
		mobile1.setBounds(320, 310,230, 30);
		gst1.setBounds(320, 350,230, 30);
		submit.setBounds(370, 390,100, 30);
		submit.setFont(f1);
		submit1.setBounds(370, 230,100, 30);
		submit1.setFont(f1);
		submit1.setVisible(false);
		this.getContentPane().setBackground(c);
		//copyright.setBounds(45,200,350,30); //panel copyright
		copyright.setBounds(550,680,350,30);
		copyright.setFont(f1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new addparty();
	}

	@Override
	public void actionPerformed(ActionEvent ar) {
		// TODO Auto-generated method stub
		if(ar.getSource()==submit1)
		{
			try
			{
		    s.executeUpdate("DELETE from party where customername='"+j1.getSelectedItem()+"'");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage());	
			}
			try
			{
			rs=s.executeQuery("select  customername from party");
			j1.removeAllItems();
			while(rs.next())
			{
				j1.addItem(rs.getString(1));
			}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
		if(ar.getSource()==delete)
		{
			this.getRootPane().setDefaultButton(submit1);
			j1.setBounds(320, 160,300, 40);
			salutation.setVisible(false);
			j1.setVisible(true);
			address.setVisible(false);
			address1.setVisible(false);
			mobile.setVisible(false);
			mobile1.setVisible(false);
		    submit.setVisible(false);
		    submit1.setVisible(true);
		    customername.setVisible(true);
		    customername1.setVisible(false);
		    gst.setVisible(false);
		    gst1.setVisible(false);
			panel.setVisible(false);
			try
			{
			rs=s.executeQuery("select  customername from party");
			j1.removeAllItems();
			while(rs.next())
			{
				j1.addItem(rs.getString(1));
			}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
		if(ar.getSource()==add)
		{
			this.getRootPane().setDefaultButton(submit);
			j1.setBounds(320, 110,230, 40);
			salutation.setVisible(true);
			j1.setVisible(true);
			address.setVisible(true);
			address1.setVisible(true);
			mobile.setVisible(true);
			mobile1.setVisible(true);
		    submit.setVisible(true);
		    customername.setVisible(true);
		    customername1.setVisible(true);
		    gst1.setVisible(true);
		    gst.setVisible(true);
		    panel.setVisible(false);
		    submit1.setVisible(false);
		    j1.removeAllItems();
		    j1.addItem("Ms.");
			j1.addItem("Mr.");
			j1.addItem("Mrs.");
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
		if(ar.getSource()==view)
		{
			this.getRootPane().setDefaultButton(submit2);
			salutation.setVisible(false);
			j1.setVisible(false);
			address.setVisible(false);
			address1.setVisible(false);
			mobile.setVisible(false);
			mobile1.setVisible(false);
		    submit.setVisible(false);
		    customername.setVisible(false);
		    customername1.setVisible(false);
		    gst.setVisible(false);
		    gst1.setVisible(false);
			panel.setVisible(true);
		    submit1.setVisible(false);
			  Columnname.clear();
				data.clear();
				try
				{
				rs1=s.executeQuery("select * from party");
				ResultSetMetaData md= rs1.getMetaData();
				int columns= md.getColumnCount();
				
				for(int i=1;i<=columns-1;i++)
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
		if(ar.getSource()==submit)
		{
			if(customername1.getText().isEmpty())
		      {
			JOptionPane.showMessageDialog(null,"Enter Customer Name");
		     }
		   else if(address1.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter Address");
		    }
		   else if(mobile1.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter Mobile Number");
		    }
		    else
		    {
		     	try
			    {
			s.executeUpdate("insert into party values('"+j1.getSelectedItem()+"','"+customername1.getText()+"','"+address1.getText()+"','"+mobile1.getText()+"','"+gst1.getText()+"','"+0+"','No')");	
  		JOptionPane.showMessageDialog(null,"Party Added");
  		customername1.setText("");
  		mobile1.setText("");
  		address1.setText("");
  		gst1.setText("");
			   }
  		  catch(Exception e)
			  {
			 	JOptionPane.showMessageDialog(null,e.getMessage());
			 }
		     	j1.removeAllItems();
		     	j1.addItem("Ms.");
				j1.addItem("Mr.");
				j1.addItem("Mrs.");
		    }
		}
	}

}
