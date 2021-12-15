package javaproject;









import java.awt.BorderLayout;
import java.awt.EventQueue;





import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;







import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.TextField;
import java.awt.Label;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JComboBox;





public class Booking extends JFrame {





private JPanel contentPane;
private JTextField textField;
private JTextField textField_1;
private final ButtonGroup buttonGroup = new ButtonGroup();
private JTextField textField_2;





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
Booking frame = new Booking();
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
public Booking() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 905, 759);
contentPane = new JPanel();
contentPane.setBackground(new Color(250, 240, 230));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);



JLabel lblNewLabel = new JLabel("New Booking");
lblNewLabel.setBounds(119, 10, 450, 49);
lblNewLabel.setForeground(Color.RED);
lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 27));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
contentPane.add(lblNewLabel);



JLabel lblNewLabel_1 = new JLabel("Duration");
lblNewLabel_1.setBackground(new Color(240, 240, 240));
lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
lblNewLabel_1.setBounds(36, 129, 120, 37);
contentPane.add(lblNewLabel_1);



JLabel lblNewLabel_2 = new JLabel("Date");
lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 18));
lblNewLabel_2.setBackground(new Color(250, 235, 215));
lblNewLabel_2.setBounds(36, 206, 120, 37);
contentPane.add(lblNewLabel_2);





JLabel lblNewLabel_3 = new JLabel("Passenger Details");
lblNewLabel_3.setBackground(new Color(240, 240, 240));
lblNewLabel_3.setForeground(Color.DARK_GRAY);
lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
lblNewLabel_3.setBounds(41, 492, 218, 30);
contentPane.add(lblNewLabel_3);



JLabel lblNewLabel_6 = new JLabel("Adult (18 & above)");
lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 18));
lblNewLabel_6.setBounds(51, 532, 177, 30);
contentPane.add(lblNewLabel_6);



textField = new JTextField();
textField.setBounds(238, 531, 88, 31);
contentPane.add(textField);
textField.setColumns(10);



JLabel lblNewLabel_7 = new JLabel("Children (<18)");
lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 18));
lblNewLabel_7.setBounds(412, 534, 143, 26);
contentPane.add(lblNewLabel_7);



textField_1 = new JTextField();
textField_1.setBounds(562, 531, 101, 29);
contentPane.add(textField_1);
textField_1.setColumns(10);



JPanel panel = new JPanel();
panel.setBackground(SystemColor.controlHighlight);
panel.setBounds(199, 129, 388, 37);
contentPane.add(panel);



JRadioButton rdbtnNewRadioButton = new JRadioButton("3 hr ");
rdbtnNewRadioButton.setBackground(Color.WHITE);
buttonGroup.add(rdbtnNewRadioButton);
panel.add(rdbtnNewRadioButton);
rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));



JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("6 hr ");
rdbtnNewRadioButton_1.setBackground(Color.WHITE);
buttonGroup.add(rdbtnNewRadioButton_1);
rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
panel.add(rdbtnNewRadioButton_1);



JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Half day");
rdbtnNewRadioButton_2.setBackground(Color.WHITE);
buttonGroup.add(rdbtnNewRadioButton_2);
rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
panel.add(rdbtnNewRadioButton_2);



JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Full day ");
rdbtnNewRadioButton_3.setBackground(Color.WHITE);
buttonGroup.add(rdbtnNewRadioButton_3);
rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
panel.add(rdbtnNewRadioButton_3);



JLabel lblNewLabel_4 = new JLabel("");
panel.add(lblNewLabel_4);
lblNewLabel_4.setBackground(new Color(230, 230, 250));
lblNewLabel_4.setForeground(new Color(255, 228, 181));



JButton btnNewButton = new JButton("Make Payment");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
//String value1 =(String)comboBox1.getSelectedItem();
//String value2 =(String)comboBox1.getSelectedItem();



}
});
btnNewButton.setBackground(Color.PINK);
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton.setForeground(Color.BLACK);
btnNewButton.setBounds(326, 625, 193, 36);
contentPane.add(btnNewButton);
JPanel panel_1 = new JPanel();
panel_1.setBounds(36, 360, 533, 41);
contentPane.add(panel_1);
JCheckBox chckbxNewCheckBox = new JCheckBox("Beverages ");
chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 18));
panel_1.add(chckbxNewCheckBox);
JCheckBox chckbxNewCheckBox_1 = new JCheckBox("DJ Party ");
chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD, 18));
panel_1.add(chckbxNewCheckBox_1);
JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Fishing ");
chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.BOLD, 18));
panel_1.add(chckbxNewCheckBox_2);
JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("Game Night");
chckbxNewCheckBox_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
panel_1.add(chckbxNewCheckBox_2_1);
JLabel lblNewLabel_5 = new JLabel("Entertainments");
lblNewLabel_5.setForeground(new Color(0, 0, 0));
lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
lblNewLabel_5.setBounds(36, 320, 168, 30);
contentPane.add(lblNewLabel_5);
JDateChooser dateChooser = new JDateChooser();
dateChooser.setBounds(199, 206, 182, 30);
contentPane.add(dateChooser);
JComboBox comboBox1 = new JComboBox();
comboBox1.setFont(new Font("Tahoma", Font.BOLD, 16));
comboBox1.addItem("Speed Boat");
comboBox1.addItem("Shikkara Boat");
comboBox1.addItem("Premium HouseBoat");
comboBox1.addItem("Deluxe HouseBoat");



comboBox1.setBounds(199, 78, 143, 30);
contentPane.add(comboBox1);
textField_2 = new JTextField();
textField_2.setBounds(401, 81, 168, 30);
contentPane.add(textField_2);
textField_2.setColumns(10);
JComboBox comboBox2 = new JComboBox();
comboBox2.setFont(new Font("Tahoma", Font.BOLD, 16));
comboBox2.addItem("Veg.");
comboBox2.addItem("Non Veg.");
comboBox2.addItem("Both");
comboBox2.setBounds(199, 278, 114, 30);
contentPane.add(comboBox2);
JLabel lblNewLabel_8 = new JLabel("Model");
lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_8.setBounds(36, 78, 99, 30);
contentPane.add(lblNewLabel_8);
JLabel lblNewLabel_9 = new JLabel("Food Menu");
lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_9.setBounds(36, 278, 120, 32);
contentPane.add(lblNewLabel_9);
JPanel panel_2 = new JPanel();
panel_2.setBackground(SystemColor.controlHighlight);
panel_2.setBounds(36, 426, 193, 37);
contentPane.add(panel_2);
JRadioButton rdbtnAc = new JRadioButton("AC ");
rdbtnAc.setFont(new Font("Tahoma", Font.BOLD, 15));
rdbtnAc.setBackground(Color.WHITE);
panel_2.add(rdbtnAc);
JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("NON AC ");
rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
rdbtnNewRadioButton_1_1.setBackground(Color.WHITE);
panel_2.add(rdbtnNewRadioButton_1_1);
JLabel lblNewLabel_4_1 = new JLabel("");
lblNewLabel_4_1.setForeground(new Color(255, 228, 181));
lblNewLabel_4_1.setBackground(new Color(230, 230, 250));
panel_2.add(lblNewLabel_4_1);
}





private static void addPopup(Component component, final JPopupMenu popup) {
component.addMouseListener(new MouseAdapter() {
public void mousePressed(MouseEvent e) {
if (e.isPopupTrigger()) {
showMenu(e);
}
}
public void mouseReleased(MouseEvent e) {
if (e.isPopupTrigger()) {
showMenu(e);
}
}
private void showMenu(MouseEvent e) {
popup.show(e.getComponent(), e.getX(), e.getY());
}
});
}
}