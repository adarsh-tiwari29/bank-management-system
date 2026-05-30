package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;
import java.util.Properties;

// Email bhejne ke liye in packages ki zaroorat hoti hai (JavaMail API JAR file add karni hogi)
import javax.mail.*;
import javax.mail.internet.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
 
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int sw = screen.width;
    int sh = screen.height;
    int centerX = sw / 2;
    int centerY = sh / 2;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(centerX - 300, centerY - 220, 100, 100);
        add(l11);
        
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(centerX - 150, centerY - 200, 400, 40);
        l1.setHorizontalAlignment(JLabel.CENTER);

        add(l1);
        
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(centerX - 300, centerY - 120, 150, 30);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(centerX - 120, centerY - 120, 250, 30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(centerX - 300, centerY - 70, 150, 30);
        add(l3);
        
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(centerX - 120, centerY - 70, 250, 30);
        add(pf2);
                
        b1 = new JButton("LOG IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN IN");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(centerX - 120, centerY, 100, 35);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(centerX + 30, centerY, 100, 35);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(centerX - 120, centerY + 50, 250, 35);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    // --- Helper Method to Send OTP Email ---
    public boolean sendOTP(String toEmail, String otp) {
        // YAHAN APNI DETAILS DAALEIN
        final String fromEmail = "(your email_id)"; 
        final String password = "(your google password)"; 

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "465"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Your ATM Login OTP");
            message.setText("Welcome to the Bank.\n\nYour One Time Password (OTP) for Login is: " + otp + "\n\nPlease do not share this OTP with anyone.");

            Transport.send(message);
            return true; // Email sent successfully
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; // Email failed
        }
    }

    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                Conn c1 = new Conn();
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                
                // 1. Verify Card and PIN
                String q  = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet rs = c1.s.executeQuery(q);
                
                if(rs.next()){
                    String formno = rs.getString("formno"); // login table se formno fetch kiya
                    
                    // 2. formno ka use karke signup table se email fetch karein
                    String emailQuery = "select email from signup where formno = '"+formno+"'";
                    ResultSet rsEmail = c1.s.executeQuery(emailQuery);
                    
                    if(rsEmail.next()){
                        String userEmail = rsEmail.getString("email");
                        
                        // 3. 6-digit random OTP generate karein
                        Random rnd = new Random();
                        int otpNumber = 100000 + rnd.nextInt(900000); 
                        String otpStr = String.valueOf(otpNumber);
                        
                        // User ko wait message show karein (kyunki email send hone me 2-3 sec lagte hain)
                        JOptionPane.showMessageDialog(null, "Verifying details... Sending OTP to your registered email.");
                        
                        // 4. Email Send Karein
                        boolean emailSent = sendOTP(userEmail, otpStr);
                        
                        if(emailSent){
                            // 5. User se OTP input lein
                            String enteredOTP = JOptionPane.showInputDialog(null, "OTP sent to " + userEmail + "\n\nEnter the 6-digit OTP:");
                            
                            if(enteredOTP != null && enteredOTP.equals(otpStr)){
                                // OTP Match ho gaya! Login successful
                                setVisible(false);
                                new Transactions(pin, cardno).setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid OTP! Access Denied.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error sending OTP. Please check your internet connection or Email Configuration.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No registered email found for this account.");
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }
}