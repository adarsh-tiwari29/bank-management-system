package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3;
    String pin;
    
    Pin(String pin){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screen.width;
        int sh = screen.height;
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(sw, sh, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, sw, sh);
        add(l4);
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        
        
        KeyAdapter onlyNumbers = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Sirf numbers allow honge
                }
            }
        };
        t1.addKeyListener(onlyNumbers);
        t2.addKeyListener(onlyNumbers);
        // ----------------------------------------------------------
        
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);
        
        // --- UI FIX: Shifted Everything UP by 40-50 pixels ---
        l1.setBounds(280,280,400,35);
        l4.add(l1);
        
        l2.setBounds(280,330,150,35);
        l4.add(l2);
        
        t1.setBounds(450,330,180,30);
        l4.add(t1);
        
        l3.setBounds(280,380,200,35);
        l4.add(l3);
        
        t2.setBounds(450,380,180,30);
        l4.add(t2);
        
        // Buttons vertically aligned under the text fields
        b1.setBounds(450,440,180,35);
        l4.add(b1);
        
        b2.setBounds(450,490,180,35);
        l4.add(b2);
        // -----------------------------------------------------
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                
                String npin = t1.getText();
                String rpin = t2.getText();
                
                // Pura validation CHANGE dabane ke baad hi chalega
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return; 
                }
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                    return; 
                }
                
                // --- VALIDATION: EXACTLY 4 DIGITS ---
                if (npin.length() != 4) {
                    JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits (e.g., 1234).");
                    return;
                }
                // ------------------------------------
                
                Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==b2){
                // BACK dabane par sidha peeche, koi error nahi
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}