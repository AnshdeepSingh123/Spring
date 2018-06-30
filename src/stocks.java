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
public class stocks extends JFrame implements ActionListener
{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel company=new JLabel("Company Name");
	JLabel itemname=new JLabel("Item Name");
	JLabel itemcode=new JLabel("Item Code");
	JLabel quantity=new JLabel("Quantity");
	JLabel quantity2=new JLabel("Quantity");
	JLabel l1=new JLabel("L1");
	JLabel l2=new JLabel("L2");
	JLabel purchase=new JLabel("Purchase");
	JLabel mm=new JLabel("MM");
	JTextField company1=new JTextField();
	JTextField itemname1=new JTextField();
	JTextField itemcode1=new JTextField();
	JTextField quantity1=new JTextField();
	JTextField quantity21=new JTextField();
	JTextField l11=new JTextField();
	JTextField l21=new JTextField();
	JTextField purchase1=new JTextField();
	JTextField mm1=new JTextField();
	JButton submit =new JButton("Submit");
	JButton submit1 =new JButton("Submit");
	JButton submit2 =new JButton("Submit");
	JButton submit3 =new JButton("Submit");
	JButton add =new JButton("Add Stock");
	JButton view =new JButton("View Stock");
	JButton delete =new JButton("Delete Stock");
	JButton home =new JButton("Home");
	JButton update =new JButton("Update Stock");
	JButton logout =new JButton("Logout");
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
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	public stocks()
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
		this.setTitle("Stocks");
		
		add(copyright);
		add(home);
		add(add);
		add(view);
		add(delete);
		add(logout);
		add(submit);
		add(submit1);
		add(submit3);
		add(update);
		add(j1);
		
		add(company);
		add(itemname);
		add(itemcode);
		add(quantity);
		add(quantity2);
		add(l1);
		add(l2);
		add(purchase);
		add(mm);
		add(company1);
		add(itemname1);
		add(itemcode1);
		add(quantity1);
		add(quantity21);
		add(l11);
		add(l21);
		add(purchase1);
		add(mm1);
		
		company.setBounds(205,100, 150, 50);
		company.setFont(f1);
		itemname.setBounds(250,150, 250, 50);
		itemname.setFont(f1);
		itemcode.setBounds(250,200, 100, 50);
		itemcode.setFont(f1);
	    quantity.setBounds(255,250, 200, 50);
	    quantity.setFont(f1);
	    quantity2.setBounds(255,250, 200, 50);
	    quantity2.setFont(f1);
	    l1.setBounds(315,300, 200, 50);
	    l1.setFont(f1);
	    l2.setBounds(315,350, 150, 50);
		l2.setFont(f1);
		purchase.setBounds(250,400, 250, 50);
		purchase.setFont(f1);
		mm.setBounds(300,450, 100, 50);
		mm.setFont(f1);
		
		company1.setBounds(360, 110,230, 30);
		itemname1.setBounds(360, 160,230, 30);
		itemcode1.setBounds(360, 210,230, 30);
	   quantity1.setBounds(360, 260,230, 30);
	   quantity21.setBounds(380, 260,230, 30);
	    l11.setBounds(360, 310,230, 30);
		l21.setBounds(360, 360,230, 30);
	    purchase1.setBounds(360, 410,230, 30);
	    mm1.setBounds(360, 460,230, 30);
	    
		submit.setBounds(400, 510,100, 30);
		
		submit.addActionListener(this);
		submit1.addActionListener(this);
		submit3.addActionListener(this);
		logout.addActionListener(this);
		home.addActionListener(this);
		add.addActionListener(this);
		view.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		
		home.setBounds(0,20,150,50);
		add.setBounds(150,20,150,50);
		view.setBounds(300,20,150,50);
		delete.setBounds(450,20,200,50);
		update.setBounds(650,20,200,50);
		logout.setBounds(850,20,140,50);
		submit1.setBounds(390, 280,100, 30);
		submit3.setBounds(390, 310,100, 30);
		
		home.setFont(f1);
		add.setFont(f1);
		view.setFont(f1);
		delete.setFont(f1);
		update.setFont(f1);
		logout.setFont(f1);
		submit.setFont(f1);
		submit1.setFont(f1);
		submit3.setFont(f1);
		
		home.setBackground(new Color(135,206,250));
		add.setBackground(new Color(135,206,250));
		view.setBackground(new Color(135,206,250));
		delete.setBackground(new Color(135,206,250));
		update.setBackground(new Color(135,206,250));
		submit.setBackground(new Color(135,206,250));
		submit1.setBackground(new Color(135,206,250));
		submit3.setBackground(new Color(135,206,250));
		logout.setBackground(new Color(135,206,250));
		
		this.getContentPane().setBackground(c);
		//copyright.setBounds(45,200,350,30); //panel copyright
		copyright.setBounds(550,680,350,30);
		copyright.setFont(f1);
		panel.setVisible(false);
		submit1.setVisible(false);
		submit3.setVisible(false);
		quantity2.setVisible(false);
		quantity21.setVisible(false);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new stocks();
	}

	@Override
	public void actionPerformed(ActionEvent ar)
	{
		if(ar.getSource()==submit3)
		{
			if(quantity21.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter new quantity");
			}
			else
			{
			try
			{
				rs3=s.executeQuery("select  Price from stocks where Item_Code='"+j1.getSelectedItem()+"'");
				if(rs3.next())
				{
					s.executeUpdate("update stocks set Stock_Price='"+Float.valueOf(quantity21.getText())*Float.valueOf(rs3.getString(1))+"'where Item_Code='"+j1.getSelectedItem()+"'");
				}
		s.executeUpdate("update stocks set Quantity='"+quantity21.getText()+"'where Item_Code='"+j1.getSelectedItem()+"'");
		    }
			 catch(Exception e)
			  {
			 	JOptionPane.showMessageDialog(null,e.getMessage());
			 }
			
			quantity21.setText("");
			JOptionPane.showMessageDialog(null,"Stock Updated");
			}
		}
		if(ar.getSource()==update)
		{
			this.getRootPane().setDefaultButton(submit3);
			j1.setBounds(380, 200,300, 40);
			j1.setVisible(true);
			company.setVisible(false);
			company1.setVisible(false);
			itemcode.setVisible(true);
			itemcode1.setVisible(false);
			itemname.setVisible(false);
			itemname1.setVisible(false);
		    submit.setVisible(false);
		    l1.setVisible(false);
		    l11.setVisible(false);
		    l2.setVisible(false);
			l21.setVisible(false);
		    purchase.setVisible(false);
		    purchase1.setVisible(false);
		    quantity.setVisible(false);
		    quantity1.setVisible(false);
		    mm.setVisible(false);
		    mm1.setVisible(false);
			panel.setVisible(false);
		    submit1.setVisible(false);
		    submit3.setVisible(true);
		    quantity2.setVisible(true);
			quantity21.setVisible(true);
			try
			{
			rs=s.executeQuery("select  Item_Code from stocks");
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
		if(ar.getSource()==submit1)
		{
			try
			{
		    s.executeUpdate("DELETE from stocks where Item_Code='"+j1.getSelectedItem()+"'");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage());	
			}
			try
			{
			rs=s.executeQuery("select  Item_code from stocks");
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
			j1.setBounds(380, 200,300, 40);
			j1.setVisible(true);
			company.setVisible(false);
			company1.setVisible(false);
			itemcode.setVisible(true);
			itemcode1.setVisible(false);
			itemname.setVisible(false);
			itemname1.setVisible(false);
		    submit.setVisible(false);
		    l1.setVisible(false);
		    l11.setVisible(false);
		    l2.setVisible(false);
			l21.setVisible(false);
		    purchase.setVisible(false);
		    purchase1.setVisible(false);
		    quantity.setVisible(false);
		    quantity1.setVisible(false);
		    mm.setVisible(false);
		    mm1.setVisible(false);
			panel.setVisible(false);
		    submit1.setVisible(true);
		    submit3.setVisible(false);
		    quantity2.setVisible(false);
			quantity21.setVisible(false);
			try
			{
			rs=s.executeQuery("select  Item_Code from stocks");
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
			this.getRootPane().setDefaultButton(submit);
			company.setVisible(true);
			company1.setVisible(true);
			itemcode.setVisible(true);
			itemcode1.setVisible(true);
			itemname.setVisible(true);
			itemname1.setVisible(true);
		    submit.setVisible(true);
		    l1.setVisible(true);
		    l11.setVisible(true);
		    l2.setVisible(true);
			l21.setVisible(true);
		    purchase.setVisible(true);
		    purchase1.setVisible(true);
		    quantity.setVisible(true);
		    quantity1.setVisible(true);
		    mm.setVisible(true);
		    mm1.setVisible(true);
			panel.setVisible(false);
		    submit1.setVisible(false);
			j1.setVisible(false);
			submit3.setVisible(false);
			quantity2.setVisible(false);
			quantity21.setVisible(false);
		}
		if(ar.getSource()==view)
		{
			this.getRootPane().setDefaultButton(submit2);
			j1.setVisible(false);
			company.setVisible(false);
			company1.setVisible(false);
			itemcode.setVisible(false);
			itemcode1.setVisible(false);
			itemname.setVisible(false);
			itemname1.setVisible(false);
		    submit.setVisible(false);
		    l1.setVisible(false);
		    l11.setVisible(false);
		    l2.setVisible(false);
			l21.setVisible(false);
		    purchase.setVisible(false);
		    purchase1.setVisible(false);
		    quantity.setVisible(false);
		    quantity1.setVisible(false);
		    mm.setVisible(false);
		    mm1.setVisible(false);
			panel.setVisible(true);
		    submit1.setVisible(false);
		    submit3.setVisible(false);
		    quantity2.setVisible(false);
			quantity21.setVisible(false);
			Columnname.clear();
			data.clear();
			try
			{
			rs1=s.executeQuery("select * from stocks");
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
		if(ar.getSource()==submit)
		{
			if(company1.getText().isEmpty())
		      {
			JOptionPane.showMessageDialog(null,"Enter Company Name");
		     }
		   else if(itemname1.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter Item Name");
		    }
		   else if(itemcode1.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter Item Code");
		    }
		   else if(quantity1.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter Quantity");
		    }
		   else if(l11.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter L1");
		    }
		   else if(l21.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter L2");
		    }
		   else if(purchase1.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter Purchase Price");
		    }
		   else if(mm1.getText().isEmpty())
		    {
			JOptionPane.showMessageDialog(null,"Enter MM");
		    }
		    else
		    {
		     	try
			    {
		     		float temp=Float.valueOf(purchase1.getText())*Float.valueOf(mm1.getText());
		     		float temp1=(float)temp/(float)10.764;
		     		float temp2=(float)temp1*(float)0.18;
		     		float temp3=(float)temp1+(float)temp2;
		     		float temp4=Float.valueOf(l11.getText())*Float.valueOf(l21.getText());
		     		float temp5=(float)temp4/(float)144;
		     		float temp6=(float)temp5*Float.valueOf(quantity1.getText());
		     		float temp7=(float)temp6*temp3;
		s.executeUpdate("insert into stocks values('"+itemcode1.getText()+"','"+itemname1.getText()+"','"+company1.getText()+"','"+quantity1.getText()+"','"+l11.getText()+"','"+l21.getText()+"','"+purchase1.getText()+"','"+mm1.getText()+"','"+temp3+"','"+temp7+"')");	
  		JOptionPane.showMessageDialog(null,"Stock Added");
  		company1.setText("");
  	    itemname1.setText("");
  		itemcode1.setText("");
  		quantity1.setText("");
  		l11.setText("");
  	    l21.setText("");
  		purchase1.setText("");
  		mm1.setText("");
			   }
  		  catch(Exception e)
			  {
			 	JOptionPane.showMessageDialog(null,e.getMessage());
			 }
		     	
		    }
		}

	}

}
