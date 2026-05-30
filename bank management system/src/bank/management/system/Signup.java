package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Signup extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b, prev; 
    JDateChooser dateChooser;
    
    // --- ADDED THIS TO REMEMBER PAGE 2 ---
    Signup2 page2; 
    
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);
    
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int sw = screen.width;
    int sh = screen.height;

    int centerX = sw / 2;
    int centerY = sh / 2;
    
    Signup(){
        
        setTitle("NEW ACCOUNT APPLICATION FORM");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(centerX - 400, centerY - 350, 100, 100);
        add(l11);
        
        l1 = new JLabel("APPLICATION FORM NO. "+first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        
        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l4 = new JLabel("Father's Name:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l5 = new JLabel("Date of Birth:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l6 = new JLabel("Gender:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l7 = new JLabel("Email Address:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l8 = new JLabel("Marital Status:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l9 = new JLabel("Address:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l10 = new JLabel("City:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l11 = new JLabel("Pin Code:");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l12 = new JLabel("State:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        
        prev = new JButton("Previous");
        prev.setFont(new Font("Raleway", Font.BOLD, 14));
        prev.setBackground(Color.BLACK);
        prev.setForeground(Color.WHITE);
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        
        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        
        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);
        
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        groupstatus.add(r5);
        
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(137, 337, 200, 29);
        add(dateChooser);
        
        setLayout(null);
        l1.setBounds(centerX - 200, centerY - 340, 600, 40);
        add(l1);
        
        l2.setBounds(centerX - 100, centerY - 290, 600, 30);
        add(l2);
        
        l3.setBounds(centerX - 400, centerY - 230,200,30);
        add(l3);
        
        t1.setBounds(centerX - 150, centerY - 230,400,30);
        add(t1);
        
        l4.setBounds(centerX - 400, centerY - 180,200,30);
        add(l4);
        
        t2.setBounds(centerX - 150, centerY - 180,400,30);
        add(t2);
        
        l5.setBounds(centerX - 400, centerY - 130,200,30);
        add(l5);
        
        dateChooser.setBounds(centerX - 150, centerY - 130,400,30);
        
        l6.setBounds(centerX - 400, centerY - 80,200,30);
        add(l6);
        
        r1.setBounds(centerX - 150, centerY - 80,60,30);
        add(r1);
        
        r2.setBounds(centerX - 40, centerY - 80,90,30);
        add(r2);
        
        l7.setBounds(centerX - 400, centerY - 30,200,30);
        add(l7);
        
        t3.setBounds(centerX - 150, centerY - 30,400,30);
        add(t3);
        
        l8.setBounds(centerX - 400, centerY + 20,200,30);
        add(l8);
        
        r3.setBounds(centerX - 150, centerY + 20,100,30);
        add(r3);
        
        r4.setBounds(centerX - 40, centerY + 20,100,30);
        add(r4);
        
        r5.setBounds(centerX + 70, centerY + 20,100,30);
        add(r5);
        
        l9.setBounds(centerX - 400, centerY + 70,200,30);
        add(l9);
        
        t4.setBounds(centerX - 150, centerY + 70,400,30);
        add(t4);
        
        l10.setBounds(centerX - 400, centerY + 120,200,30);
        add(l10);
        
        t5.setBounds(centerX - 150, centerY + 120,400,30);
        add(t5);
        
        l11.setBounds(centerX - 400, centerY + 170,200,30);
        add(l11);
        
        t6.setBounds(centerX - 150, centerY + 170,400,30);
        add(t6);
        
        l12.setBounds(centerX - 400, centerY + 220,200,30);
        add(l12);
        
        t7.setBounds(centerX - 150, centerY + 220,400,30);
        add(t7);
        
        prev.setBounds(centerX + 80, centerY + 270, 100, 35);
        add(prev);
        
        b.setBounds(centerX + 200, centerY + 270, 100, 35);
        add(b);
        
        prev.addActionListener(this); 
        b.addActionListener(this); 
        
        getContentPane().setBackground(Color.WHITE);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == prev){
            setVisible(false);
            new Login().setVisible(true); 
            return;
        }
        
        String formno = first;
        String name = t1.getText();
        String fname = t2.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){ 
            gender = "Male";
        }else if(r2.isSelected()){ 
            gender = "Female";
        }
            
        String email = t3.getText();
        String marital = null;
        if(r3.isSelected()){ 
            marital = "Married";
        }else if(r4.isSelected()){ 
            marital = "Unmarried";
        }else if(r5.isSelected()){ 
            marital = "Other";
        }
            
        String address = t4.getText();
        String city = t5.getText();
        String pincode = t6.getText();
        String state = t7.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required.");
                return;
            } else if (!name.matches("[a-zA-Z\\s]+")) {
                JOptionPane.showMessageDialog(null, "Name can only contain alphabets and spaces.");
                return;
            }

            if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name is required.");
                return;
            } else if (!fname.matches("[a-zA-Z\\s]+")) {
                JOptionPane.showMessageDialog(null, "Father's Name can only contain alphabets and spaces.");
                return;
            }

            java.util.Date dobDate = dateChooser.getDate();
            if (dobDate == null) {
                JOptionPane.showMessageDialog(null, "Date of Birth is required.");
                return;
            }
            
            Calendar calDOB = Calendar.getInstance();
            calDOB.setTime(dobDate);
            Calendar calToday = Calendar.getInstance();
            int age = calToday.get(Calendar.YEAR) - calDOB.get(Calendar.YEAR);
            if (calToday.get(Calendar.DAY_OF_YEAR) < calDOB.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }
            if (age < 18) {
                JOptionPane.showMessageDialog(null, "You must be at least 18 years old to open an account.");
                return;
            }

            if(gender == null){
                JOptionPane.showMessageDialog(null, "Please select a Gender.");
                return;
            }

            if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email Address is required.");
                return;
            } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]+$")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Email Address.");
                return;
            }

            if(marital == null){
                JOptionPane.showMessageDialog(null, "Please select a Marital Status.");
                return;
            }

            if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is required.");
                return;
            } else if (!address.matches("^[a-zA-Z0-9\\s,.-/]+$")) {
                JOptionPane.showMessageDialog(null, "Address contains invalid characters.");
                return;
            }

            if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City is required.");
                return;
            } else if (!city.matches("^[a-zA-Z\\s]+$")) {
                JOptionPane.showMessageDialog(null, "City can only contain alphabets and spaces.");
                return;
            }

            if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is required.");
                return;
            } else if (!state.matches("^[a-zA-Z\\s]+$")) {
                JOptionPane.showMessageDialog(null, "State can only contain alphabets and spaces.");
                return;
            }

            if(pincode.equals("")){
                JOptionPane.showMessageDialog(null, "Pin Code is required.");
                return;
            } else if (!pincode.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Pin Code can only contain numbers.");
                return;
            }
            
            Conn c1 = new Conn();
            String deleteQuery = "DELETE FROM signup WHERE formno = '"+formno+"'";
            c1.s.executeUpdate(deleteQuery);
            
            String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
            c1.s.executeUpdate(q1);
            
            // --- FIX FOR DATA PERSISTENCE ON NEXT BUTTON ---
            if (page2 == null) {
                page2 = new Signup2(formno, this); // Create only if it doesn't exist
            }
            page2.setVisible(true); 
            setVisible(false);
            
        }catch(Exception e){
             e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}