package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Signup3 extends JFrame implements ActionListener{

    JLabel l4,accdetails, acctype, card, no, pin, pno, carddetail, pindetail,service;
    JRadioButton sa, fda, ca, rda;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    
    Signup3(String formno)
    {
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setSize(850,820);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l4=new JLabel(i3);
        l4.setBounds(180, 10, 100, 100);
        add(l4);
        
        accdetails=new JLabel("Page 3: Account Details");
        accdetails.setBounds(290, 50, 400, 30);
        accdetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(accdetails);
        
        acctype=new JLabel("Account Type:");
        acctype.setBounds(100,140,200,30);
        acctype.setFont(new Font("Raleway",Font.BOLD,18));
        add(acctype);
        
        sa=new JRadioButton("Saving Account");
        sa.setBounds(100,180,150,20);
        sa.setBackground(Color.white);
        sa.setFont(new Font("Raleway",Font.BOLD,16));
        add(sa);
        
        fda=new JRadioButton("Fixed Deposit Account");
        fda.setBounds(400,180,200,20);
        fda.setBackground(Color.white);
        fda.setFont(new Font("Raleway",Font.BOLD,16));
        add(fda);
        
        rda=new JRadioButton("Recurring Deposit Account");
        rda.setBounds(100,220,250,20);
        rda.setBackground(Color.white);
        rda.setFont(new Font("Raleway",Font.BOLD,16));
        add(rda);
        
        ca=new JRadioButton("Current Account");
        ca.setBounds(400,220,150,20);
        ca.setBackground(Color.white);
        ca.setFont(new Font("Raleway",Font.BOLD,16));
        add(ca);
        
        ButtonGroup at=new ButtonGroup();
        at.add(sa);
        at.add(fda);
        at.add(rda);
        at.add(ca);
        
        card=new JLabel("Card Number:");
        card.setBounds(100,300,200,30);
        card.setFont(new Font("Raleway",Font.BOLD,22));
        add(card);
        
        no=new JLabel("XXXX-XXXX-XXXX-4184");
        no.setBounds(330,300,300,30);
        no.setFont(new Font("Raleway",Font.BOLD,22));
        add(no);
        
        carddetail=new JLabel("Your 16 Digit Card Number:");
        carddetail.setBounds(100,330,300,20);
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        add(carddetail);
        
        pin=new JLabel("PIN:");
        pin.setBounds(100,370,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        add(pin);
        
        pindetail=new JLabel("Your 4 Digit Card Password:");
        pindetail.setBounds(100,400,200,20);
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        add(pindetail);
        
        pno=new JLabel("XXXX");
        pno.setBounds(330,370,300,30);
        pno.setFont(new Font("Raleway",Font.BOLD,22));
        add(pno);
        
        service=new JLabel("Services Required:");
        service.setBounds(100,450,300,30);
        service.setFont(new Font("Raleway",Font.BOLD,22));
        add(service);
        
        c1=new JCheckBox("ATM Card");
        c1.setBounds(100,500,200,30);
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBounds(350,500,200,30);
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(100,550,200,30);
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        add(c3);
        
        c4=new JCheckBox("EMAIL Alerts");
        c4.setBounds(350,550,200,30);
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBounds(100,600,200,30);
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBounds(350,600,200,30);
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        add(c6);
        
        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBounds(100,650,600,30);
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(220,700,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,700,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accounttype=null;
            {
            if(sa.isSelected())
            {
                accounttype="Savings Account";
            }
            else if(fda.isSelected())
            {
                accounttype="Fixed Deposit Account";
            }
            else if(ca.isSelected())
            {
                accounttype="Current Account";
            }
            else if(rda.isSelected())
            {
                accounttype="Recurring Deposit Account";
            }
            }
            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinno=""+Math.abs((random.nextLong()%9000L)+1000L);
            String facility="";
            if(c1.isSelected())
            {
                facility=facility+"ATM Card";
            }
            else if(c2.isSelected())
            {
                facility=facility+"Internet Banking";
            }
            else if(c3.isSelected())
            {
                facility=facility+"Mobile Banking";
            }
            else if(c4.isSelected())
            {
                facility=facility+"EMAIL Alerts";
            }
            else if(c5.isSelected())
            {
                facility=facility+"Cheque Book";
            }
            else if(c6.isSelected())
            {
                facility=facility+"E-Statement";
            }
            try{
                if(accounttype.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Accout Type is necessary");
                }
                else{
                    Conn conn=new Conn();
                    String query1="insert into Signup3 values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinno+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinno+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n Pin: "+pinno);
                    
                    setVisible(false);
                    new DepositMoney(pinno).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new FirstPage().setVisible(true);
        }
    }
    
}
public class SignupThree {
    public static void main(String[] args) {
        Signup3 signup=new Signup3("");
        signup.setVisible(true);
    }
}
