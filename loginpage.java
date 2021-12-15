package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class loginpage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField user_name;
	private JPasswordField passwordField;

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
					loginpage frame = new loginpage();
					frame.setResizable(false);
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
	public loginpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BACKWATER TRIPS");
		lblNewLabel.setBackground(new Color(255, 228, 196));
		lblNewLabel.setForeground(new Color(0, 206, 209));
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 32));
		lblNewLabel.setBounds(174, 33, 346, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("USER NAME");
		lblNewLabel_2.setBackground(new Color(0, 0, 205));
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Baskerville Old Face", Font.ITALIC, 17));
		lblNewLabel_2.setBounds(127, 200, 186, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("PASSWORD");
		lblNewLabel_2_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Baskerville Old Face", Font.ITALIC, 17));
		lblNewLabel_2_1.setBounds(127, 260, 186, 50);
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBounds(228, 186, 85, -16);
		contentPane.add(textField);
		textField.setColumns(10);
		
		user_name = new JTextField();
		user_name.setBackground(new Color(245, 245, 220));
		user_name.setBounds(294, 205, 226, 36);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setBackground(new Color(245, 245, 220));
		passwordField.setBounds(295, 268, 225, 36);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login\r\n");
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Class.forName("org.postgresql.Driver");
					
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/houseboat","postgres","Rkp@1801");
					String sql1 = "SELECT * FROM login where  username = ? and password = ? ";
					String sql2 = "SELECT authority from login where username = ?";
					
					

					
				PreparedStatement pst=connection.prepareStatement(sql1);
				PreparedStatement pst1 = connection.prepareStatement(sql2);
			
				
				pst.setString(1, user_name.getText());
				pst.setString(2, passwordField.getText());
				pst1.setString(1, user_name.getText());
						
				ResultSet rs = pst.executeQuery();
				ResultSet rs1 = pst1.executeQuery();
				
				
				
				// select authority from login where userid = ?;
				
				int count = 0;
				while(rs.next()) {
					
					count = count + 1;
				};
					if(count == 1)
					{
						
						if(rs1.next()) {
							
							System.out.print("Name of the Employee: "+rs1.getString("authority")+", ");
							String str1 = rs1.getString("authority");
						JOptionPane.showMessageDialog(null, "Password and username is correct");
						if(str1 == "customer") {
						customerdetails customerpage = new customerdetails();
						customerpage.setVisible(true);
						System.out.println("customer");
						dispose();
						}
						 if(str1 == "owner") {
							 //btnNewButton.addActionListener(new ActionListener() {};
							ownerpg ownerspage = new ownerpg();
							ownerspage.setVisible(true);
							dispose();
						}
						 if(str1=="admin") {
							Admin adminpage = new Admin();
							adminpage.setVisible(true);
							
							}
						}
						
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "redundancy detected");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Incorrect credentials");
					}
				
				rs.close();
			   
				pst.close();
				pst1.close();
				connection.close();	
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					System.out.println("unknown error");
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Swis721 BlkEx BT", Font.PLAIN, 17));
		btnNewButton.setBounds(228, 338, 128, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Account");
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createaccount accpage = new createaccount();
				accpage.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Swis721 Ex BT", Font.BOLD, 13));
		btnNewButton_1.setBounds(406, 417, 165, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\RKP\\3rd Sem\\Eclipse\\javaproject\\boatlogo.jpg"));
		lblNewLabel_1.setBounds(0, 12, 170, 123);
		contentPane.add(lblNewLabel_1);
	}

}
