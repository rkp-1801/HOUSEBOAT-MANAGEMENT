package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class ownerpg extends JFrame {

  private JPanel contentPane;

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
          ownerpg frame = new ownerpg();
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
  public ownerpg() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 775, 440);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JButton addboat = new JButton("Add Boat");
    addboat.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
    addboat.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  boatregistration br = new boatregistration();
    	  br.setVisible(true);
  		dispose();  
      }
    });
    addboat.setBounds(111, 129, 146, 37);
    contentPane.add(addboat);
    
    JButton btnDelete = new JButton("Delete");
    btnDelete.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
    btnDelete.setBounds(430, 129, 146, 37);
    contentPane.add(btnDelete);
    
    JLabel lblNewLabel = new JLabel("Your Boat");
    lblNewLabel.setFont(new Font("Vivaldi", Font.PLAIN, 26));
    lblNewLabel.setBounds(22, 25, 224, 18);
    contentPane.add(lblNewLabel);
    
    JButton btnNewButton = new JButton("Boat Details");
    btnNewButton.addActionListener(new ActionListener() {
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
    btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
    btnNewButton.setBounds(271, 248, 163, 46);
    contentPane.add(btnNewButton);
  }
}