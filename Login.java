package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class FirstPage extends JFrame implements ActionListener
{
    JLabel l1,text,pin,cardno;
    JTextField cardnotextfield;
    JButton signin, clear, signup;
    JPasswordField pintextfield;
    FirstPage()
    {
        setTitle("ONLINE BANKING");
        setLayout(null);
         getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setLocationRelativeTo(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l1=new JLabel(i3);
        l1.setBounds(70,10,100,100);
        add(l1);
        
        text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);
        
        cardno=new JLabel("Card No.");
        cardno.setFont(new Font("Raleway",Font.BOLD, 28));
        cardno.setBounds(120,150,400,30);
        add(cardno);
        
        cardnotextfield=new JTextField();
        cardnotextfield.setBounds(300,150,250,30);
        cardnotextfield.setFont(new Font("Arial", Font.BOLD,14));
        add(cardnotextfield);
        
        pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD, 28));
        pin.setBounds(120,220,400,30);
        add(pin);
        
        pintextfield=new JPasswordField();
        pintextfield.setBounds(300,220,250,30);
        pintextfield.setFont(new Font("Arial", Font.BOLD,14));
        add(pintextfield);
        
        signin=new JButton("SIGN IN");
        signin.setBounds(300, 300, 100, 30);
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430, 300, 90, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String card=cardnotextfield.getText();
        String pinno=pintextfield.getText();
        if(ae.getSource() == signin)
        {
            if(card.equals(""))
            {
                 JOptionPane.showMessageDialog(null, "Card Number is necessary");
                    
            }
             else if(pinno.equals(""))
            {
                JOptionPane.showMessageDialog(null,"PIN is necessary");
            }
            else{
                Conn con=new Conn();
                String query="select * from login where cardnumber = '"+card+"' and pin= '"+pinno+"'";
                try{
                    ResultSet rs=con.s.executeQuery(query);
                    if(rs.next()){
                setVisible(false);
                new Transaction(pinno).setVisible(true);
                }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                    }
                } 
                catch (Exception e)
                {
                    System.out.println(e);
                }
             }
        }
        else if(ae.getSource() == clear)
        {
            cardnotextfield.setText("");
            pintextfield.setText("");
        }
        else if(ae.getSource()==signup)
        {
            
            setVisible(false);
            new Signup().setVisible(true);//calls Signup constructor from SignupOne class
            
        }
    }
}

public class Login{
    
    public static void main(String args[]){
         FirstPage f=new FirstPage();
         f.setVisible(true);
        
    }
}
