package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7; // Removed b8 as it was unused
    JTextField t1;
    String pin;

    FastCash(String pin) {
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

        l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        // --- UI FIX: Shifted Everything UP by 50 pixels and aligned properly ---
        l1.setBounds(310, 280, 400, 35);
        l3.add(l1);

        b1.setBounds(280, 330, 160, 35);
        l3.add(b1);

        b2.setBounds(460, 330, 160, 35);
        l3.add(b2);

        b3.setBounds(280, 380, 160, 35);
        l3.add(b3);

        b4.setBounds(460, 380, 160, 35);
        l3.add(b4);

        b5.setBounds(280, 430, 160, 35);
        l3.add(b5);

        b6.setBounds(460, 430, 160, 35);
        l3.add(b6);

        b7.setBounds(460, 480, 160, 35); // BACK button shifted up
        l3.add(b7);
        // ----------------------------------------------------------------------

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

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
                return; // Stop execution if back is pressed
            }

            // Extract amount from button text (e.g., "Rs 100" -> "100")
            String amount = ((JButton)ae.getSource()).getText().substring(3); 
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            
            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            Date date = new Date();
            c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
            JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                
            setVisible(false);
            new Transactions(pin).setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}