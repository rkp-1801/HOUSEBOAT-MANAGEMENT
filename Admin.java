package javaproject;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Admin extends JFrame {

  private JPanel cust_details;

  /*
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
          Admin frame = new Admin();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /*
   * Create the frame.
   */
  public Admin() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 940, 751);
    cust_details = new JPanel();
    cust_details.setForeground(Color.WHITE);
    cust_details.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(cust_details);
    cust_details.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("ADMIN PANEL");
    lblNewLabel.setBounds(347, 49, 231, 72);
    lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
    cust_details.add(lblNewLabel);
    
    JButton btnNewButton = new JButton("UPDATE");
    btnNewButton.setBounds(398, 608, 130, 45);
    btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    cust_details.add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("Boat Owner Details");
    btnNewButton_1.setForeground(Color.BLACK);
    btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 28));
    btnNewButton_1.setBackground(Color.WHITE);
    btnNewButton_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		try {
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/houseboat","postgres","Rkp@1801");
				String query = "SELECT * FROM boat_registration";
				  
				  java.sql.Statement stm = connection.createStatement();
				  ResultSet res = stm.executeQuery(query);
				
				  String columns[] = { "username", "boat_id", "model" };
				  String data[][] = new String[8][3];
				
				  int i = 0;
				  while (res.next()) {
				    String id = res.getString("username");
				    String nom = res.getString("boat_id");
				    String model = res.getString("model");
				    data[i][0] = id + "";
				    data[i][1] = nom;
				    data[i][2] = model;
				    i++;
				  }
				
				  DefaultTableModel model = new DefaultTableModel(data, columns);
				  JTable table = new JTable(model);
				  table.setShowGrid(true);
				  table.setShowVerticalLines(true);
				  JScrollPane pane = new JScrollPane(table);
				  JFrame f = new JFrame("Populate JTable from Database");
				  JPanel panel = new JPanel();
				  panel.add(pane);
				  f.getContentPane().add(panel);
				  f.setSize(500, 250);
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
    btnNewButton_1.setBounds(287, 174, 352, 77);
    cust_details.add(btnNewButton_1);
    
    JButton boat_det = new JButton("Customer Details");
    boat_det.setFont(new Font("Tahoma", Font.BOLD, 34));
    boat_det.setBackground(Color.WHITE);
    boat_det.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		try {
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/houseboat","postgres","Rkp@1801");
				String query = "SELECT * FROM login where authority = 'customer'";
				  
				  java.sql.Statement stm = connection.createStatement();
				  ResultSet res = stm.executeQuery(query);
				
				  String columns[] = { "username", "first_name", "last_name","phone_no_1","email" };
				  String data[][] = new String[8][5];
				
				  int i = 0;
				  while (res.next()) {
				    String id = res.getString("username");
				    String f_name = res.getString("first_name");
				    String l_name = res.getString("last_name");
				    String phone_no_1 = res.getString("phone_no_1");
				    String email = res.getString("email");
				    data[i][0] = id + "";
				    data[i][1] = f_name;
				    data[i][2] = l_name;
				    data[i][3] = phone_no_1;
				    data[i][4] = email;
				    
				    i++;
				  }
				
				  DefaultTableModel model = new DefaultTableModel(data, columns);
				  JTable table = new JTable(model);
				  table.setShowGrid(true);
				  table.setShowVerticalLines(true);
				  JScrollPane pane = new JScrollPane(table);
				  JFrame f = new JFrame("Populate JTable from Database");
				  JPanel panel = new JPanel();
				  panel.add(pane);
				  f.getContentPane().add(panel);
				  f.setSize(500, 250);
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
    boat_det.setBounds(287, 389, 352, 77);
    cust_details.add(boat_det);
  }
}