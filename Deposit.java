package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class DepositMoney extends JFrame implements ActionListener{
    JLabel l6, text;
    JTextField texttf;
    JButton deposit, back;
    String pinno;
        DepositMoney(String pinno)
        {
            this.pinno=pinno;
            setSize(900,900);
            setLocationRelativeTo(null);
            setLayout(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //    setUndecorated(false);
        
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            l6=new JLabel(i3);
            l6.setBounds(0, 0, 900, 900);
            add(l6);
        
            text=new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT");
            text.setForeground(Color.white);
            text.setFont(new Font("Raleway",Font.BOLD,15));
            text.setBounds(160, 300, 700,35);
            l6.add(text);
        
            texttf=new JTextField();
            texttf.setBounds(170, 350, 320, 25);
            texttf.setFont(new Font("Raleway", Font.BOLD,22));
            l6.add(texttf);
        
            deposit=new JButton("DEPOSIT");
            deposit.setBounds(355,485,150,30);
            deposit.addActionListener(this);
            l6.add(deposit);
            
            back=new JButton("BACK");
            back.setBounds(355,520,150,30);
            back.addActionListener(this);
            l6.add(back);
        }    
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==deposit)
            {
                String number=texttf.getText();
                Date date=new Date();
                if(number.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
                }
                else{
                     try{
                    Conn c=new Conn();
                    String query="insert into bank values('"+pinno+"','"+date+"','Deposit','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+ " deposited successfully.");
                    setVisible(false);
                    new Transaction(pinno).setVisible(true);
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
                }
            }
            else if(ae.getSource()==back)
            {
                setVisible(false);
                new Transaction(pinno).setVisible(true);
            }
        }
}
public class Deposit {
    public static void main(String[] args) {
       DepositMoney dm=new DepositMoney("");
       dm.setVisible(true);
    }
}
