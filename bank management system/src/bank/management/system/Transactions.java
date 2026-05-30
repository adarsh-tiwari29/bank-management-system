package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel l1, welcomeLabel;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin, cardnumber;
    
    Transactions(String pin){
        this(pin, ""); 
    }

    Transactions(String pin, String cardnumber){
        this.pin = pin;
        this.cardnumber = cardnumber;
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screen.width;
        int sh = screen.height;
        
        // --- DYNAMIC SCALING RATIOS ---
        // Ye ratios image ke stretch hone par bhi buttons ko sahi jagah lock rakhenge
        int xLeft = (int) (sw * (280.0 / 1366.0));
        int xRight = (int) (sw * (460.0 / 1366.0));
        int y1 = (int) (sh * (330.0 / 768.0));
        int y2 = (int) (sh * (380.0 / 768.0));
        int y3 = (int) (sh * (430.0 / 768.0));
        int y4 = (int) (sh * (480.0 / 768.0));
        int bw = (int) (sw * (160.0 / 1366.0));
        int bh = (int) (sh * (35.0 / 768.0));
        // ------------------------------
        
        // Image ko wapas Full Screen Stretch kar diya hai
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(sw, sh, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, sw, sh);
        add(l2);
        
        // Fetch User Name
        String userName = "";
        try {
            Conn c = new Conn();
            String query = "";
            
            if(cardnumber != null && !cardnumber.equals("")){
                query = "select s.name from signup s join login l on s.formno = l.formno where l.cardnumber = '"+cardnumber+"'";
            } else {
                query = "select s.name from signup s join login l on s.formno = l.formno where l.pin = '"+pin+"'";
            }
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()) {
                userName = rs.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Welcome Label
        if(userName.equals("")){
            welcomeLabel = new JLabel("Welcome User");
        } else {
            welcomeLabel = new JLabel("Welcome " + userName);
        }
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setFont(new Font("System", Font.BOLD, 28)); 
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");
        
        setLayout(null);
        
        // Dynamic Label Bounds
        int labelWidth = (int) (sw * (340.0 / 1366.0));
        welcomeLabel.setBounds(xLeft, (int)(sh * (230.0 / 768.0)), labelWidth, bh); 
        l2.add(welcomeLabel);
        
        l1.setBounds(xLeft, (int)(sh * (280.0 / 768.0)), labelWidth, bh);
        l2.add(l1);
        
        // Dynamic Button Bounds
        b1.setBounds(xLeft, y1, bw, bh);
        l2.add(b1);
        
        b2.setBounds(xRight, y1, bw, bh);
        l2.add(b2);
        
        b3.setBounds(xLeft, y2, bw, bh);
        l2.add(b3);
        
        b4.setBounds(xRight, y2, bw, bh);
        l2.add(b4);
        
        b5.setBounds(xLeft, y3, bw, bh);
        l2.add(b5);
        
        b6.setBounds(xRight, y3, bw, bh);
        l2.add(b6);
        
        b7.setBounds(xRight, y4, bw, bh);
        l2.add(b7);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()==b3){ 
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()==b4){ 
            new MiniStatement(pin).setVisible(true);
        }else if(ae.getSource()==b5){ 
            setVisible(false);
            new Pin(pin).setVisible(true);
        }else if(ae.getSource()==b6){ 
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()==b7){ 
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new Transactions("","").setVisible(true);
    }
}