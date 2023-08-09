package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

class MiniStatements extends JFrame {
    JLabel mini, bank,card, balance;
    String pinno;
    MiniStatements(String pinno)
    {
        this.pinno=pinno;
        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);
        getContentPane().setBackground(Color.white);
     
        mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        bank=new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        card=new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        balance=new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
                
try{
    Conn c=new Conn();
    ResultSet rs=c.s.executeQuery("select * from login where pin = '"+pinno+"'");
    while(rs.next()){
        card.setText("Card Number: " +rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
    }
}
catch(Exception e)
{
    System.out.println(e);
}
try{
    Conn conn=new Conn();
    int bal=0;
    ResultSet r=conn.s.executeQuery("select * from bank where pin = '"+pinno+"'");
    while(r.next())
    {
        mini.setText(mini.getText() + "<html>" + r.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + r.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ r.getString("amount") + "<br><br><html>");
        if(r.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(r.getString("amount"));
                }
                else{
                     bal-=Integer.parseInt(r.getString("amount"));
                }
    }
    balance.setText("Your current account balance is Rs "+bal);
}
catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

public class MiniStatement {
    public static void main(String[] args) {
        MiniStatements m=new MiniStatements("");
        m.setVisible(true);
    }
}
