import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.*;
import java.awt.print.*;
import javax.swing.*;


public class login extends JFrame implements ActionListener
{
	JLabel email=new JLabel("Username");
	JLabel password=new JLabel("Password");
	JTextField email1=new JTextField();
	JPasswordField password1=new JPasswordField();
	JButton login=new JButton("Login");
	JButton forgot=new JButton("Forgot Password");
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel welcome=new JLabel("Login");
	ImageIcon img = new ImageIcon("C:\\C.jpg");
	//JPanel panel=new JPanel();
    Date date ;
    Date date1=null;
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	Color c=new Color(250,250,250);
	GregorianCalendar time=new GregorianCalendar();
	JLabel l=new JLabel();
	String design,fq;
	JButton b=new JButton("Click to Continue");
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	Connection con;
	Statement s;
	ResultSet rs,rs1;
public login()
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
    	JOptionPane.showMessageDialog(null,"No Internet Connection ! Or Weak Internet Connection");
    	fq="No";
    }
	      try
	       {

		rs1=s.executeQuery("select *  from licence");
		while(rs1.next())
		{
			date1=fmt.parse(rs1.getString(1));
		}
        date=	fmt.parse(fmt.format(new Date() ));
		
		if (date.compareTo(date1) > 0)
		{
			JOptionPane.showMessageDialog(null,"Your Licence has been expired. Kindly renew it.");
	    }
		else
		{
		
	this.getRootPane().setDefaultButton(login);
			
	    setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.setVisible(true);
		//this.setExtendedState(MAXIMIZED_BOTH);
		this.setBounds(0,0,1366,768);
		this.setLayout(null);
		if(fq=="No")
		{
			this.dispose();
		}
		this.setTitle("Login");
		this.add(email);
		this.add(password);
		add(email1);
		add(password1);
		add(login);
		add(forgot);
		//panel.add(copyright);
		add(copyright);
		add(welcome);
		add(l);
		add(b);
		b.setVisible(false);
		b.addActionListener(this);
		l.setBounds(500, 240, 400, 100);
		b.setBounds(1100, 570, 200, 30);
		//add(panel);
		//panel.setLayout(null);
		//panel.setBounds(1000,10, 620, 900);
		//panel.setBackground(Color.blue);
		email.setBounds(450,250, 150, 50);
		email.setFont(f);
		password.setBounds(450,300, 150, 50);
		password.setFont(f);
		email1.setBounds(600,260,200, 30);
		password1.setBounds(600,310, 200, 30);
		this.getContentPane().setBackground(c);
		//copyright.setBounds(45,200,350,30); //panel copyright
		copyright.setBounds(550,680,350,30);
		copyright.setFont(f1);
	    login.setBounds(450,380, 150, 30);
	    forgot.setBounds(650,380, 200, 30);
	    login.setFont(f1);
	    forgot.setFont(f1);
	    welcome.setBounds(580,80,1500,100);
	    welcome.setFont(f2);
	    b.setFont(f1);
	    login.setBackground(new Color(135,206,250));
	    b.setBackground(new Color(135,206,250));
	    forgot.setBackground(new Color(135,206,250));
	    login.addActionListener(this);
	    forgot.addActionListener(this);
		}
	}
		 catch(Exception e)
		    {
		    	//JOptionPane.showMessageDialog(null,e.getMessage());
		    }
}
	
	 

	public static void main(String[] args)
	{
	
new login();
	}


	    
	    
	
	public void actionPerformed(ActionEvent ar)
	{
		/*if(ar.getSource()==forgot)
		{
			Toolkit tkp = this.getToolkit();
		    PrintJob pjp = tkp.getPrintJob(this, null, null);
		    Graphics g = pjp.getGraphics();
		    panel.print(g);
		    g.dispose();
		    pjp.end();
		}*/
		
		if(ar.getSource()==b)
		{
			try
			{
				s.executeUpdate("update currentlogin set Name='"+email1.getText()+"'");
				con.close();
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
			new adminmain();
			
			this.dispose();
			
		}
	if(ar.getSource()==forgot)
		{
			new forgot();
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
		if(ar.getSource()==login)
		{
			try{
				rs=s.executeQuery("Select * from login where username='"+email1.getText()+"'");
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(null,"Invalid UserName");
				}
				else if(!rs.getString(2).equals(password1.getText()))
				{
					JOptionPane.showMessageDialog(null,"Wrong Password");
				}
				else
				{
					
					this.getRootPane().setDefaultButton(b);
					email1.setVisible(false);
					password1.setVisible(false);
					email.setVisible(false);
					password.setVisible(false);
					login.setVisible(false);
					forgot.setVisible(false);
					welcome.setVisible(false);
				    b.setVisible(true);
				    int hour=time.get(Calendar.HOUR_OF_DAY);
						
						if(hour<12)
						{
							l.setText("GOOD MORNING "+email1.getText().toUpperCase());
							l.setFont(f);
							l.setForeground(Color.blue);
							
					
						}
							else if(hour<17 && !(hour==12))
							{
								l.setText("GOOD AFTERNOON "+email1.getText().toUpperCase());
								l.setFont(f);
								l.setForeground(Color.yellow);
								
							
							}
							else if(hour==12)
							{
								l.setText("GOOD NOON "+email1.getText().toUpperCase());
								l.setFont(f);
								l.setForeground(Color.orange);
								
							
							}
							else
							{
							
								l.setText("GOOD EVENING "+email1.getText().toUpperCase());
								l.setFont(f);
								l.setForeground(Color.blue);
							
							
							}	
					
					
				}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
	    }



	}
}
