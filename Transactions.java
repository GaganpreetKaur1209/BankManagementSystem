package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Transaction extends JFrame implements ActionListener
{
    JLabel l5, desc;
    JButton deposit,withdrawl, fastcash, ministat, pinchange, balance,exit;
    String pinno;
    Transaction( String pinno)
    {
        this.pinno=pinno;
        setSize(900,900);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l5=new JLabel(i3);
        l5.setBounds(0, 0, 900, 900);
        add(l5);
        
        desc=new JLabel("Please Select Your Transaction");
        desc.setForeground(Color.white);
        desc.setBounds(210, 300, 700, 35);
        desc.setFont(new Font("Raleway", Font.BOLD, 16));
        l5.add(desc);
        
        deposit=new JButton("DEPOSIT");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        l5.add(deposit);
        
        withdrawl=new JButton("CASH WITHDRWAL");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        l5.add(withdrawl);
        
        fastcash=new JButton("FAST CASH");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        l5.add(fastcash);
        
        ministat=new JButton("MINI STATEMENT");
        ministat.setBounds(355, 450, 150, 30);
        ministat.addActionListener(this);
        l5.add(ministat);
        
        pinchange=new JButton("PIN CHANGE");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        l5.add(pinchange);
        
        balance=new JButton("BALANCE ENQUIRY");
        balance.setBounds(355, 485, 150, 30);
        balance.addActionListener(this);
        l5.add(balance);
        
        exit=new JButton("EXIT");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        l5.add(exit);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new DepositMoney(pinno).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new WithdrawlMoney(pinno).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new Fast_cash(pinno).setVisible(true);
        }
        else if(ae.getSource()==ministat)
        {
            setVisible(false);
            new MiniStatements(pinno).setVisible(true);
        }
        else if(ae.getSource()==pinchange)
        {
            setVisible(false);
            new Pin_change(pinno).setVisible(true);
        }
        else if(ae.getSource()==balance)
        {
            new Balance_Enquiry(pinno).setVisible(true);
        }
    }
}
public class Transactions {
    public static void main(String[] args) {
        Transaction t=new Transaction("");
        t.setVisible(true);
    }
}
