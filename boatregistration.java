package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class boatregistration extends JFrame {

  private JPanel contentPane;
  private JTextField u_name;
  private JTextField boat_id;
  private JTextField model;
  private JTextField fare;
  private JTextField rooms;
  private JTextField max_capacity;

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
          boatregistration frame = new boatregistration();
          frame.setResizable(false);
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
  public boatregistration() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 790);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Boat Registration");
    lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 30));
    lblNewLabel.setBounds(231, 68, 324, 40);
    contentPane.add(lblNewLabel);
    
    JLabel lblNewLabel_1 = new JLabel("Username");
    lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1.setBounds(125, 217, 129, 40);
    contentPane.add(lblNewLabel_1);
    
    JLabel lblNewLabel_1_1 = new JLabel("Boat ID");
    lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1_1.setBounds(125, 267, 129, 40);
    contentPane.add(lblNewLabel_1_1);
    
    JLabel lblNewLabel_1_2 = new JLabel("Model ");
    lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1_2.setBounds(125, 317, 129, 40);
    contentPane.add(lblNewLabel_1_2);
    
    JLabel lblNewLabel_1_3 = new JLabel("Fare");
    lblNewLabel_1_3.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1_3.setBounds(125, 367, 129, 40);
    contentPane.add(lblNewLabel_1_3);
    
    u_name = new JTextField();
    u_name.setBounds(280, 217, 288, 34);
    contentPane.add(u_name);
    u_name.setColumns(10);
    
    boat_id = new JTextField();
    boat_id.setColumns(10);
    boat_id.setBounds(280, 267, 288, 34);
    contentPane.add(boat_id);
    
    model = new JTextField();
    model.setColumns(10);
    model.setBounds(280, 317, 288, 34);
    contentPane.add(model);
    
    fare = new JTextField();
    fare.setColumns(10);
    fare.setBounds(280, 367, 143, 34);
    contentPane.add(fare);
    
    JLabel lblNewLabel_1_3_1 = new JLabel("Rooms");
    lblNewLabel_1_3_1.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1_3_1.setBounds(125, 417, 129, 40);
    contentPane.add(lblNewLabel_1_3_1);
    
    JLabel lblNewLabel_1_3_2 = new JLabel("Max Capacity\r\n");
    lblNewLabel_1_3_2.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1_3_2.setBounds(470, 417, 129, 40);
    contentPane.add(lblNewLabel_1_3_2);
    
    rooms = new JTextField();
    rooms.setColumns(10);
    rooms.setBounds(280, 423, 143, 34);
    contentPane.add(rooms);


max_capacity = new JTextField();
    max_capacity.setColumns(10);
    max_capacity.setBounds(609, 417, 143, 34);
    contentPane.add(max_capacity);
    
    JButton reg_boat = new JButton("Register Boat");
    reg_boat.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		try {
    			
    			Class.forName("org.postgresql.Driver");
    			
    			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/houseboat","postgres","Rkp@1801");
    			String sql1 = "insert into boat_registration(max_capacity,rooms,fare,model,boat_id,username) values(?,?,?,?,?,?)";
    		PreparedStatement pst=connection.prepareStatement(sql1);
    		
    		pst.setString(1, max_capacity.getText());
    		pst.setString(2, rooms.getText());
    		pst.setString(3, fare.getText());
    		pst.setString(4, model.getText());
    		pst.setString(5, boat_id.getText());
    		pst.setString(6, u_name.getText());
    		
    		

    		int rs1 = pst.executeUpdate();
    		JOptionPane.showMessageDialog(null,"values updated");
    		ownerpg ownerspage = new ownerpg();
			ownerspage.setVisible(true);
			dispose();
    		//return rs1;
    		//rs1.close();
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
    reg_boat.setFont(new Font("Verdana", Font.PLAIN, 19));
    reg_boat.setBounds(312, 561, 186, 40);
    contentPane.add(reg_boat);
    
    JMenuBar menuBar = new JMenuBar();
    menuBar.setBounds(32, 79, 101, 22);
    contentPane.add(menuBar);
    
    JMenu mnNewMenu = new JMenu("Model");
    mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    menuBar.add(mnNewMenu);
    
    JMenuItem mntmNewMenuItem = new JMenuItem("house boat");
    mnNewMenu.add(mntmNewMenuItem);
    
    JMenuItem mntmNewMenuItem_1 = new JMenuItem("Speed boat");
    mnNewMenu.add(mntmNewMenuItem_1);
    
    JMenuItem mntmNewMenuItem_2 = new JMenuItem("Shikkara");
    mnNewMenu.add(mntmNewMenuItem_2);
    
    JMenuItem mntmNewMenuItem_3 = new JMenuItem("premium house boat");
    mnNewMenu.add(mntmNewMenuItem_3);
    
    JMenuItem mntmNewMenuItem_4 = new JMenuItem("Deluxe House boat");
    mnNewMenu.add(mntmNewMenuItem_4);
    
  }
}