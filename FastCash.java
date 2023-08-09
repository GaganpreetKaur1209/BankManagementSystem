package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

class Fast_cash extends JFrame implements ActionListener
{
    JLabel l6, heading;
    JButton hundred, fivehundred, thousand, twothousand, fivethousand, tenthousand, back;
    String pinno;
    Fast_cash(String pinno)
    {
        this.pinno=pinno;
        setSize(900,900);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l6=new JLabel(i3);
        l6.setBounds(0, 0, 900, 900);
        add(l6);
        
        heading=new JLabel("SELECT WITHDRAWAL AMOUNT");
        heading.setForeground(Color.white);
        heading.setBounds(210, 300, 700, 35);
        heading.setFont(new Font("Raleway", Font.BOLD, 16));
        l6.add(heading);
        
        hundred=new JButton("Rs 100");
        hundred.setBounds(170, 415, 150, 30);
        hundred.addActionListener(this);
        l6.add(hundred);
        
        fivehundred=new JButton("Rs 500");
        fivehundred.setBounds(355, 415, 150, 30);
        fivehundred.addActionListener(this);
        l6.add(fivehundred);
        
        thousand=new JButton("Rs 1000");
        thousand.setBounds(170, 450, 150, 30);
        thousand.addActionListener(this);
        l6.add(thousand);
        
        twothousand=new JButton("Rs 2000");
        twothousand.setBounds(355, 450, 150, 30);
        twothousand.addActionListener(this);
        l6.add(twothousand);
        
        fivethousand=new JButton("Rs 5000");
        fivethousand.setBounds(170, 485, 150, 30);
        fivethousand.addActionListener(this);
        l6.add(fivethousand);
        
        tenthousand=new JButton("Rs 10000");
        tenthousand.setBounds(355, 485, 150, 30);
        tenthousand.addActionListener(this);
        l6.add(tenthousand);
        
        back=new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        l6.add(back);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }
        else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                     balance-=Integer.parseInt(rs.getString("amount"));   
                    }
                }
                if(ae.getSource()!=back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinno+"','"+date+"' , 'Withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+ " Debited Successfully.");
                
                setVisible(false);
                new Transaction(pinno).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
public class FastCash {
    public static void main(String[] args) {
        Fast_cash f=new Fast_cash("");
        f.setVisible(true);
    }
}
