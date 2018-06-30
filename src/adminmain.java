import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
public class adminmain extends JFrame implements ActionListener{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel welcome=new JLabel("Welcome to Ganpati Glass House");
	JButton stocks =new JButton("Stocks");
	JButton banking =new JButton("Banking");
	JButton saleorder =new JButton("Sale/Order");
	JButton vieworder =new JButton("View Orders");
	JButton addparty =new JButton("Add Party");
	JButton dispatch =new JButton("Dispatch");
	JButton transaction =new JButton("Transaction");
	JButton viewsales =new JButton("View Sales");     
	JButton attendence =new JButton("Attendence");
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	Connection con;
	Statement s;
	ResultSet rs,rs1;
	public adminmain()
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
			this.setBounds(0,0,1366,768);
			this.setLayout(null);
			this.setTitle("Ganapati Glass House");
			this.add(copyright);
			this.setResizable(false);
			this.getContentPane().setBackground(c);
			//copyright.setBounds(45,200,350,30); //panel copyright
			copyright.setBounds(550,680,350,30);
			copyright.setFont(f1);
			welcome.setFont(f2);
		   add(banking);
		   add(attendence);
		   add(stocks);
		   add(vieworder);
		   add(saleorder);
		   add(viewsales);
		   add(dispatch);
		   add(transaction);
		   add(addparty);
		   add(welcome);
		   welcome.setBounds(30,250,1300,200);
		   banking.setBounds(150,20,150,50);
		   attendence.setBounds(300,20,150,50);
		   stocks.setBounds(450,20,150,50);
		   saleorder.setBounds(600,20,150,50);
		   vieworder.setBounds(750,20,150,50);
		   transaction.setBounds(900,20,150,50);
		   dispatch.setBounds(1050,20,150,50);
		   viewsales.setBounds(1200,20,150,50);
		   addparty.setBounds(0,20,150,50);
		   banking.setBackground(new Color(135,206,250));
		   attendence.setBackground(new Color(135,206,250));
		   stocks.setBackground(new Color(135,206,250));
		   dispatch.setBackground(new Color(135,206,250));
		   transaction.setBackground(new Color(135,206,250));
		   addparty.setBackground(new Color(135,206,250));
		   vieworder.setBackground(new Color(135,206,250));
		   viewsales.setBackground(new Color(135,206,250));
		   saleorder.setBackground(new Color(135,206,250));
		   banking.addActionListener(this);
		   attendence.addActionListener(this);
		   stocks.addActionListener(this);
		   vieworder.addActionListener(this);
		   saleorder.addActionListener(this);
		   viewsales.addActionListener(this);
		   transaction.addActionListener(this);
		   addparty.addActionListener(this);
		   dispatch.addActionListener(this);
		   banking.setFont(f1);
		   attendence.setFont(f1);
		   stocks.setFont(f1);
		   vieworder.setFont(f1);
		   saleorder.setFont(f1);
		   viewsales.setFont(f1);
		   transaction.setFont(f1);
		   addparty.setFont(f1);
		   dispatch.setFont(f1);
		   try
		    {
			   rs=s.executeQuery("select Name from currentlogin");
				if(rs.next())
				{
					if(!rs.getString(1).equals("Rishi"))
					{
						attendence.setVisible(false);
						stocks.setVisible(false);
						transaction.setVisible(false);
						banking.setVisible(false);
						vieworder.setVisible(false);
						viewsales.setVisible(false);
					}
				}
		    }
		    catch(Exception e)
		    {
		    	JOptionPane.showMessageDialog(null,e.getMessage());
		    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new adminmain();
	}

	@Override
	public void actionPerformed(ActionEvent ar) {
		// TODO Auto-generated method stub
		if(ar.getSource()==addparty)
		{
			new addparty();
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
		if(ar.getSource()==stocks)
		{
			new stocks();
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
		if(ar.getSource()==attendence)
		{
			new attendence();
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
		if(ar.getSource()==saleorder)
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
		if(ar.getSource()==vieworder)
		{
			new vieworder();
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
		if(ar.getSource()==banking)
		{
			new banking();
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
		if(ar.getSource()==transaction)
		{
			new transaction();
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
		
		if(ar.getSource()==viewsales)
		{
			new viewsales();
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
		if(ar.getSource()==dispatch)
		{
			new dispatch();
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
