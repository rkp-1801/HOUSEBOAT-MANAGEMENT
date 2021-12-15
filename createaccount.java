package javaproject;




import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;



public class createaccount extends JFrame {



private JPanel contentPane;
private JTextField us_name;
private JTextField ph_1;
private JTextField ph_2;
private final ButtonGroup buttonGroup = new ButtonGroup();
private JTextField f_name;
private JTextField l_name;
private JPasswordField passwordField_1;
private JTextField email;



/**
* Launch the application.
*/
public static void main(String[] args) {
String jdbcURL = "jdbc:postgresql://localhost:5432/houseboat";
String username = "postgres";
String password = "Rkp@1801";

try {
Connection connection = DriverManager.getConnection(jdbcURL, username, password);

System.out.print("Connected");
}
catch(SQLException e) {
System.out.println("Error in connection");
e.printStackTrace();
}
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
createaccount frame = new createaccount();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}



/**
* Create the frame.
*/
public createaccount() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 1248, 767);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("Register");
lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 39));
lblNewLabel.setBounds(461, 42, 193, 43);
contentPane.add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("Username");
lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
lblNewLabel_1.setBounds(91, 119, 160, 33);
contentPane.add(lblNewLabel_1);

JLabel lblNewLabel_1_1 = new JLabel("Password");
lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
lblNewLabel_1_1.setBounds(91, 308, 138, 33);
contentPane.add(lblNewLabel_1_1);

JLabel lblNewLabel_1_2 = new JLabel("Phone.No");
lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
lblNewLabel_1_2.setBounds(91, 400, 127, 33);
contentPane.add(lblNewLabel_1_2);

JLabel lblNewLabel_1_3 = new JLabel("Email");
lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
lblNewLabel_1_3.setBounds(91, 509, 108, 33);
contentPane.add(lblNewLabel_1_3);

us_name = new JTextField();
us_name.setBounds(261, 119, 223, 33);
contentPane.add(us_name);
us_name.setColumns(10);

ph_1 = new JTextField();
ph_1.setColumns(10);
ph_1.setBounds(255, 400, 223, 33);
contentPane.add(ph_1);

ph_2 = new JTextField();
ph_2.setColumns(10);
ph_2.setBounds(777, 400, 223, 33);
contentPane.add(ph_2);

JButton createbtn = new JButton("CREATE");
createbtn.setForeground(Color.BLACK);
createbtn.setBackground(Color.LIGHT_GRAY);
createbtn.setFont(new Font("Verdana", Font.BOLD, 18));
createbtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	
	try {
		
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/houseboat","postgres","Rkp@1801");
		String sql1 = "insert into login( username,first_name,last_name,password,phone_no_1,phone_no_2,email) values(?,?,?,?,?,?,?)";
	PreparedStatement pst=connection.prepareStatement(sql1);
	
	pst.setString(1, us_name.getText());
	pst.setString(2, f_name.getText());
	pst.setString(3, l_name.getText());
	pst.setString(4, passwordField_1.getText());
	pst.setString(5, ph_1.getText());
	pst.setString(6, ph_2.getText());
	pst.setString(7, email.getText());
	

	ResultSet rs1 = pst.executeQuery();
	
	rs1.close();
	pst.close();
	connection.close();
	
	}
	catch(Exception e1)
	{
		JOptionPane.showMessageDialog(null, e1);
		System.out.println("unknown error");
	}
}
});
createbtn.setBounds(456, 670, 133, 33);
contentPane.add(createbtn);

JRadioButton customerbtn = new JRadioButton("Customer");
customerbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
buttonGroup.add(customerbtn);
customerbtn.setBounds(340, 576, 103, 21);
contentPane.add(customerbtn);

JRadioButton ownerbtn = new JRadioButton("Owner");
ownerbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
buttonGroup.add(ownerbtn);
ownerbtn.setBounds(610, 576, 103, 21);
contentPane.add(ownerbtn);

JButton returnbtn = new JButton(" Return");
returnbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
returnbtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
loginpage logpg = new loginpage();
logpg.setVisible(true);
dispose();
}
});
returnbtn.setBounds(1067, 656, 95, 33);
contentPane.add(returnbtn);

JLabel lblNewLabel_2 = new JLabel("First Name");
lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
lblNewLabel_2.setBounds(96, 208, 122, 33);
contentPane.add(lblNewLabel_2);

JLabel lblNewLabel_2_1 = new JLabel("Last Name");
lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
lblNewLabel_2_1.setBounds(610, 208, 122, 33);
contentPane.add(lblNewLabel_2_1);

f_name = new JTextField();
f_name.setBounds(255, 208, 223, 33);
contentPane.add(f_name);
f_name.setColumns(10);

l_name = new JTextField();
l_name.setColumns(10);
l_name.setBounds(777, 208, 223, 33);
contentPane.add(l_name);

passwordField_1 = new JPasswordField();
passwordField_1.setBounds(255, 308, 225, 33);
contentPane.add(passwordField_1);

JLabel lblNewLabel_1_2_1 = new JLabel("Phone.No");
lblNewLabel_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
lblNewLabel_1_2_1.setBounds(610, 400, 127, 33);
contentPane.add(lblNewLabel_1_2_1);

email = new JTextField();
email.setColumns(10);
email.setBounds(255, 509, 223, 33);
contentPane.add(email);
}
}