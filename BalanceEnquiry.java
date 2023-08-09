package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Balance_Enquiry extends JFrame implements ActionListener{
    String pinno;
    JLabel l7,text;
    JButton back;
    
    Balance_Enquiry(String pinno)
    {
        this.pinno=pinno;
        setSize(900,900);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage();
        ImageIcon i3=new ImageIcon(i2);
        l7=new JLabel(i3);
        l7.setBounds(0,0,900,900);
        add(l7);
        
        back=new JButton("BACK");
        back.setBounds(365, 535, 150, 30);
        back.setFont(new Font("Raleway", Font.BOLD,16));
        back.addActionListener(this);
        l7.add(back);
    
        Conn c=new Conn();
        int balance=0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinno+"'");
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                     balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(c);
}
        text=new JLabel("Your Current Amount balance is Rs "+balance);
        text.setBounds(170, 300, 400, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.BOLD,14));
        l7.add(text);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
            setVisible(false);
            new Transaction(pinno).setVisible(true);
}}

public class BalanceEnquiry {
    public static void main(String[] args) {
        Balance_Enquiry b=new Balance_Enquiry("");
        b.setVisible(true);
    
    }
}
