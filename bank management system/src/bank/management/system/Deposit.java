package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    
    Deposit(String pin){
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
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
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
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        // --- UI FIX: Shifted Everything UP and aligned properly ---
        l1.setBounds(290, 290, 400, 35);
        l3.add(l1);
        
        t1.setBounds(290, 340, 320, 30);
        l3.add(t1);
        
        b1.setBounds(470, 400, 140, 35); // Shifted up and right-aligned
        l3.add(b1);
        
        b2.setBounds(470, 450, 140, 35); // Shifted up and right-aligned
        l3.add(b2);
        // -----------------------------------------------------------
        
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
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                    return; // execution yahan rokne ke liye
                }
                
                // --- VALIDATION: ONLY NUMBERS ALLOWED (Backend safety) ---
                if (!amount.matches("^[0-9]+$")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount (Numbers only).");
                    return;
                }
                // --------------------------------------------
                
                else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}