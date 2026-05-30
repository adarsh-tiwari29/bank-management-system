package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b, prev; 
    JRadioButton r1,r2,r3,r4;
    JTextField t1,t2;
    JComboBox c1,c2,c3,c4,c5;
    String formno;
    Signup page1; 
    
    // --- ADDED THIS TO REMEMBER PAGE 3 ---
    Signup3 page3; 
    
    Signup2(String formno, Signup page1){ 
        
        this.page1 = page1; 
        this.formno = formno;
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screen.width;
        int sh = screen.height;

        int centerX = sw / 2;
        int centerY = sh / 2;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(centerX - 350, centerY - 350, 100, 100);
        add(l14);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        l1 = new JLabel("Page 2: Additonal Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("Educational");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l11 = new JLabel("Qualification:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l6 = new JLabel("Occupation:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l7 = new JLabel("PAN Number:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("Aadhar Number:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l9 = new JLabel("Senior Citizen:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));
        
        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));
        
        prev = new JButton("Previous");
        prev.setFont(new Font("Raleway", Font.BOLD, 14));
        prev.setBackground(Color.BLACK);
        prev.setForeground(Color.WHITE);
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        
        ButtonGroup groupSenior = new ButtonGroup();
        groupSenior.add(r1);
        groupSenior.add(r2);
        
        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r3);
        groupAccount.add(r4);
        
        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        c1 = new JComboBox(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String category[] = {"General","OBC","SC","ST","Other"};
        c2 = new JComboBox(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c3 = new JComboBox(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c5 = new JComboBox(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
       
        setLayout(null);
        
        
        l12.setBounds(centerX + 340, centerY - 350, 100, 30);
        add(l12);
        
        l13.setBounds(centerX + 360, centerY - 350, 80, 30);
        add(l13);
        
        l1.setBounds(centerX - 80, centerY - 330, 400, 40);
        add(l1);
        
        l2.setBounds(centerX - 350, centerY - 260, 200, 30);
        add(l2);
        
        c1.setBounds(centerX - 100, centerY - 260, 320, 30);
        add(c1);
        
        l3.setBounds(centerX - 350, centerY - 210, 200, 30);
        add(l3);
        
        c2.setBounds(centerX - 100, centerY - 210, 320, 30);
        add(c2);
        
        l4.setBounds(centerX - 350, centerY - 160, 200, 30);
        add(l4);
        
        c3.setBounds(centerX - 100, centerY - 160, 320, 30);
        add(c3);
        
        l5.setBounds(centerX - 350, centerY - 110, 200, 30);
        add(l5);
        
        c4.setBounds(centerX - 100, centerY - 110, 320, 30);
        add(c4);
        
        
        l11.setBounds(centerX + 240, centerY - 350, 100, 30);
        add(l11);
        
        l6.setBounds(centerX - 350, centerY - 60, 200, 30);
        add(l6);
        
        c5.setBounds(centerX - 100, centerY - 60, 320, 30);
        add(c5);
        
        l7.setBounds(centerX - 350, centerY - 10, 200, 30);
        add(l7);
        
        t1.setBounds(centerX - 100, centerY - 10, 320, 30);
        add(t1);
        
        l8.setBounds(centerX - 350, centerY + 40, 200, 30);
        add(l8);
        
        t2.setBounds(centerX - 100, centerY + 40, 320, 30);
        add(t2);
        
        l9.setBounds(centerX - 350, centerY + 90, 200, 30);
        add(l9);
        
        r1.setBounds(centerX - 100, centerY + 90, 80, 30);
        add(r1);
        
        r2.setBounds(centerX, centerY + 90, 80, 30);
        add(r2);
        
        l10.setBounds(centerX - 350, centerY + 140, 200, 30);
        add(l10);
        
        r3.setBounds(centerX - 100, centerY + 140, 80, 30);
        add(r3);
        
        r4.setBounds(centerX, centerY + 140, 80, 30);
        add(r4);
        
        prev.setBounds(centerX + 80, centerY + 220, 100, 35);
        add(prev);
        
        b.setBounds(centerX + 200, centerY + 220, 100, 35);
        add(b);
        
        prev.addActionListener(this); 
        b.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == prev) {
            if (page1 != null) {
                page1.setVisible(true); 
            }
            setVisible(false);
            return; 
        }
        
        String religion = (String)c1.getSelectedItem(); 
        String category = (String)c2.getSelectedItem();
        String income = (String)c3.getSelectedItem();
        String education = (String)c4.getSelectedItem();
        String occupation = (String)c5.getSelectedItem();
        
        String pan = t1.getText();
        String aadhar = t2.getText();
        
        String scitizen = "";
        if(r1.isSelected()){ 
            scitizen = "Yes";
        }
        else if(r2.isSelected()){ 
            scitizen = "No";
        }
            
        String eaccount = "";
        if(r3.isSelected()){ 
            eaccount = "Yes";
        }else if(r4.isSelected()){ 
            eaccount = "No";
        }
        
        try{
            if(pan.equals("") || aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else if (!pan.matches("^[A-Z]{5}[0-9]{4}[A-Z]{1}$")) { // <-- Changed a-zA-Z to A-Z
                JOptionPane.showMessageDialog(null, "Please enter a valid PAN Number in CAPITAL letters (e.g., ABCDE1234F).");
            } else if (!aadhar.matches("^[0-9]{12}$")) {
                JOptionPane.showMessageDialog(null, "Aadhar Number must contain exactly 12 digits.");
            } else {
                
                Conn c1 = new Conn();
                String deleteQuery2 = "DELETE FROM signup2 WHERE formno = '"+formno+"'";
                c1.s.executeUpdate(deleteQuery2);
                
                String q1 = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c1.s.executeUpdate(q1);
                
                // --- FIX FOR DATA PERSISTENCE ON NEXT BUTTON ---
                if (page3 == null) {
                    page3 = new Signup3(formno, this); // Create only if it doesn't exist
                }
                page3.setVisible(true);
                setVisible(false);
            }
            
        }catch(Exception ex){
             ex.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Signup2("", null).setVisible(true);
    }
}