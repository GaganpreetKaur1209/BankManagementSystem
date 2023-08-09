package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Pin_change extends JFrame implements ActionListener{
    
    JLabel l6,text, newpin, reenternewpin;
    JPasswordField newpintf, reenternewpintf;
    JButton change,back;
    String pinno;
    Pin_change(String pinno)
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
        l6=new JLabel(i3);
        l6.setBounds(0,0,900,900);
        add(l6);
        
        text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(240, 250, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.BOLD,14));
        l6.add(text);
        
        newpin=new JLabel("New PIN:");
        newpin.setBounds(150, 290, 700, 35);
        newpin.setForeground(Color.white);
        newpin.setFont(new Font("Raleway", Font.BOLD,14));
        l6.add(newpin);
        
        newpintf=new JPasswordField();
        newpintf.setBounds(320, 295, 175, 25);
        newpintf.setFont(new Font("Raleway", Font.BOLD,14));
        l6.add(newpintf);
                
        reenternewpin=new JLabel("Re-Enter New PIN:");
        reenternewpin.setBounds(150, 330, 700, 35);
        reenternewpin.setForeground(Color.white);
        reenternewpin.setFont(new Font("Raleway", Font.BOLD,16));
        l6.add(reenternewpin);
        
        reenternewpintf=new JPasswordField();
        reenternewpintf.setBounds(320, 335, 175, 25);
        reenternewpintf.setFont(new Font("Raleway", Font.BOLD,14));
        l6.add(reenternewpintf);
        
        change=new JButton("CHANGE");
        change.setBounds(365, 495, 150, 30);
        change.setFont(new Font("Raleway", Font.BOLD,16));
        change.addActionListener(this);
        l6.add(change);
        
        back=new JButton("BACK");
        back.setBounds(365, 535, 150, 30);
        back.setFont(new Font("Raleway", Font.BOLD,16));
        back.addActionListener(this);
        l6.add(back);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String npin=newpintf.getText();
        String repin=reenternewpintf.getText();
        if(ae.getSource().equals(change))
        {
            try{
            if(!npin.equals(repin))
            {
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if(npin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter New PIN");
                return;
            }
            if(repin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Re-enter New PIN");
                return;
            }
            Conn c=new Conn();
            String query1= "update bank set pin = '"+repin+"' where pin= '"+pinno+"'";
            String query2= "update login set pin = '"+repin+"' where pin= '"+pinno+"'";
            String query3= "update signup3 set PIN_Number = '"+repin+"' where PIN_Number= '"+pinno+"'";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
           JOptionPane.showMessageDialog(null, "PIN changed successfully");
           
           setVisible(false);
           new Transaction(repin).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource().equals(back))
        {
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }
    }
}
public class PinChange {
    public static void main(String[] args) {
        Pin_change p=new Pin_change("");
        p.setVisible(true);
    }
}
