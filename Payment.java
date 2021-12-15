package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String jdbcURL = "jdbc:postgresql://localhost:5432/lab_6";
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
					Payment frame = new Payment();
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
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAYMENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(402, 57, 238, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Mode of Payment");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(115, 164, 191, 51);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(391, 174, 613, 41);
		contentPane.add(panel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("CREDIT CARD");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonGroup.add(rdbtnNewRadioButton);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("DEBIT CARD");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("UPI");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonGroup.add(rdbtnNewRadioButton_2);
		panel.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(115, 260, 185, 41);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		
			
			
		
		passwordField.setEchoChar('*');
		passwordField.setBounds(391, 271, 349, 25);
		contentPane.add(passwordField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I'M NOT A ROBOT");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxNewCheckBox.setBounds(678, 335, 185, 51);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("PAY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.postgresql.Driver");
					
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/houseboat","postgres","Rkp@1801");
					
					String sql = "SELECT password from login where password=?";
					
					

					
							PreparedStatement pst=connection.prepareStatement(sql);
													
							pst.setString(1,passwordField.getText());
							
						
							ResultSet rs = pst.executeQuery();
							
							int count = 0;
							while(rs.next()) {
								
								count = count + 1;
							};
								if(count == 1)
								{
									
									JOptionPane.showMessageDialog(null, "Password is correct");
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
							
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				customerdetails accpage = new customerdetails();
				accpage.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(555, 444, 197, 72);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("TOTAL PRICE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/houseboat","postgres","Rkp@1801");
					String query = "SELECT * FROM boat_registration";
					  
					  java.sql.Statement stm = connection.createStatement();
					  ResultSet res = stm.executeQuery(query);
					
					  String columns[] = { "username","total price" };
					  String data[][] = new String[2][2];
					
					  int i = 0;
					  while (res.next()) {
					    String id = res.getString("username");					    
					    String fare = res.getString("fare");
					    data[i][0] = id + "";
					    data[i][1] = fare;
					    //data[i][2] = model;
					    //data[i][3] = nom;
					    i++;
					  }
					
					  DefaultTableModel model = new DefaultTableModel(data, columns);
					  JTable table = new JTable(model);
					  table.setShowGrid(true);
					  table.setShowVerticalLines(true);
					  JScrollPane pane = new JScrollPane(table);
					  JFrame f = new JFrame("Payable Amount");
					  JPanel panel = new JPanel();
					  panel.add(pane);
					  f.getContentPane().add(panel);
					  f.setSize(500, 100);
					  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					  f.setVisible(true);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(203, 447, 185, 68);
		contentPane.add(btnNewButton_1);
	}
}
