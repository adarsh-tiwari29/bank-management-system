package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    
    Withdrawl(String pin){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screen.width;
        int sh = screen.height;
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(sw, sh, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, sw, sh);
        add(l3);
        
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        // --- NAYA LOGIC: TYPE HOTE HI ALPHABETS KO BLOCK KARNA ---
        t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Agar type kiya gaya character number nahi hai, toh use block kar do
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ye function galat key ko screen par aane hi nahi dega
                }
            }
        });
        // ----------------------------------------------------------
        
        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        // --- UI FIX: Shifted Everything UP to avoid overlap ---
        l1.setBounds(290, 280, 400, 25);
        l3.add(l1);
        
        l2.setBounds(290, 320, 400, 25);
        l3.add(l2);
        
        t1.setBounds(290, 360, 320, 30);
        l3.add(t1);
        
        b1.setBounds(470, 420, 140, 35); // Right-aligned with textfield
        l3.add(b1);
        
        b2.setBounds(470, 470, 140, 35); // Right-aligned with textfield
        l3.add(b2);
        // ------------------------------------------------------
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
                    return; // Execution stops here
                }
                
                // --- MAXIMUM LIMIT CHECK ---
                if (Integer.parseInt(amount) > 10000) {
                    JOptionPane.showMessageDialog(null, "Maximum withdrawal limit is Rs. 10,000 per transaction.");
                    return; // Execution stops here
                }
                // --------------------------------------------
                
                Conn c1 = new Conn();
                
                ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   }else{
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
                }
                if(balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pin).setVisible(true);
                
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
}