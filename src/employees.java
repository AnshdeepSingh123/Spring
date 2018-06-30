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
public class employees extends JFrame implements ActionListener
{
	JLabel copyright=new JLabel("Copyright © SahibLabs");
	JLabel name=new JLabel("Employee Name");
	JLabel salary=new JLabel("Salary");
	JTextField name1=new JTextField();
	JTextField salary1=new JTextField();
	JButton submit =new JButton("Submit");
	JButton submit1 =new JButton("Submit");
	JButton submit2 =new JButton("Submit");
	JButton add =new JButton("Add Employee");
	JButton update =new JButton("Update Salary");
	JButton delete =new JButton("Delete Employee");
	JButton back =new JButton("Back");
	JComboBox j1=new JComboBox();
	Color c=new Color(250,250,250);
	Font f=new Font("Arial",Font.PLAIN,28)	;
	Font f1=new Font("Arial",Font.BOLD,20);
	Font f2=new Font("Arial",Font.BOLD,80);
	String time1;
	String time2;
	String time3;
	String time4;
	Vector Columnname= new Vector();
	Vector data= new Vector();
	JPanel panel = new JPanel();
	Connection con;
	Statement s;
	ResultSet rs1,rs,rs2;
	ImageIcon img = new ImageIcon("C:\\C.jpg");
public employees()
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
	this.setTitle("Employees");
	
	copyright.setBounds(550,680,350,30);
	copyright.setFont(f1);
	
	add(copyright);
	add(name);
	add(salary);
	
	add(name1);
	add(salary1);
	
	add(add);
	add(delete);
	add(update);
	add(back);
	add(submit);
	add(submit1);
	add(submit2);
	add(j1);
	
	submit.setBounds(420, 210,100, 30);
	submit1.setBounds(420, 210,100, 30);
	submit2.setBounds(420, 210,100, 30);
	
	submit.addActionListener(this);
	submit1.addActionListener(this);
	submit2.addActionListener(this);
	back.addActionListener(this);
    add.addActionListener(this);
	delete.addActionListener(this);
	update.addActionListener(this);
	
	back.setBounds(0,20,150,50);
	add.setBounds(150,20,200,50);
	delete.setBounds(350,20,200,50);
	update.setBounds(550,20,210,50);
	
	back.setFont(f1);
	add.setFont(f1);
	update.setFont(f1);
	delete.setFont(f1);
	submit.setFont(f1);
	submit1.setFont(f1);
	submit2.setFont(f1);
	
	back.setBackground(new Color(135,206,250));
	add.setBackground(new Color(135,206,250));
	delete.setBackground(new Color(135,206,250));
	update.setBackground(new Color(135,206,250));
	submit.setBackground(new Color(135,206,250));
	submit1.setBackground(new Color(135,206,250));
	submit2.setBackground(new Color(135,206,250));
	
	name.setBounds(205,100, 280, 50);
	name.setFont(f1);
	salary.setBounds(290,150, 250, 50);
	salary.setFont(f1);
	
	name1.setBounds(380, 110,230, 30);
	salary1.setBounds(380, 160,230, 30);
	
	this.getContentPane().setBackground(c);
	panel.setVisible(false);
	j1.setVisible(false);
	submit1.setVisible(false);
	submit2.setVisible(false);
}
	public static void main(String[] args) 
	{
	
new employees();
	}

	
	public void actionPerformed(ActionEvent ar) 
	{
		if(ar.getSource()==add)
		{
			this.getRootPane().setDefaultButton(submit);
			name.setVisible(true);
			salary.setVisible(true);
			name1.setVisible(true);
			salary1.setVisible(true);
			submit.setVisible(true);
			j1.setVisible(false);
			submit1.setVisible(false);
			submit2.setVisible(false);
		}
	    if(ar.getSource()==update)
	    {
	    	this.getRootPane().setDefaultButton(submit2);
			j1.setBounds(380, 100,300, 40);
			j1.setVisible(true);
			submit1.setVisible(false);
			submit2.setVisible(true);
			name.setVisible(false);
			salary.setVisible(true);
			name1.setVisible(false);
			salary1.setVisible(true);
			submit.setVisible(false);
			j1.removeAllItems();
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
		if(ar.getSource()==delete)
		{
			this.getRootPane().setDefaultButton(submit1);
			j1.setBounds(350, 150,300, 40);
			j1.setVisible(true);
			submit1.setVisible(true);
			submit2.setVisible(false);
			name.setVisible(false);
			salary.setVisible(false);
			name1.setVisible(false);
			salary1.setVisible(false);
			submit.setVisible(false);
			j1.removeAllItems();
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
		if(ar.getSource()==submit1)
		{
			try
			{
		    s.executeUpdate("DELETE from employees where name='"+j1.getSelectedItem()+"'");
		    JOptionPane.showMessageDialog(null,"Employee Deleted");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage());	
			}
			try
			{
			rs=s.executeQuery("select  name from employees");
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
		if(ar.getSource()==submit2)
		{
			if(salary1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter new Salary");
			}
			else
			{
			try
			{
				 float temp1=Float.valueOf(salary1.getText())/Float.valueOf(43800);
		s.executeUpdate("update employees set salary='"+salary1.getText()+"'where name='"+j1.getSelectedItem()+"'");
		s.executeUpdate("update employees set salarymi='"+temp1+"'where name='"+j1.getSelectedItem()+"'");
		    }
			 catch(Exception e)
			  {
			 	JOptionPane.showMessageDialog(null,e.getMessage());
			 }
		     salary1.setText("");
			JOptionPane.showMessageDialog(null,"Salary Updated");
			}
		}
		if(ar.getSource()==back)
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
		if(ar.getSource()==submit)
		{
			if(name1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Name");
			}
			else if(salary1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Salary");
			}
			else
			{
			try
			{
			 float temp=Float.valueOf(salary1.getText())/Float.valueOf(43800);
			s.executeUpdate("insert into employees values('"+name1.getText()+"','"+salary1.getText()+"','"+0+"','"+temp+"')");
			JOptionPane.showMessageDialog(null,"Employee Added");
	  		name1.setText("");
	  	    salary1.setText("");
			}
			 catch(Exception e)
			  {
			 	JOptionPane.showMessageDialog(null,e.getMessage());
			 }
			}
		}
		
	}

}
