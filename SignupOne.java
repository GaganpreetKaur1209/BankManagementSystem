package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

class Signup extends JFrame implements ActionListener
{
    long random;
    JButton next ;
    JTextField nametextfield, fnametextfield, emailaddtextfield, addtextfield, citytextfield, pincodetextfield, statetextfield;
    JLabel l2,formno, personaldetails, name, fname, dob, gender, emailadd, mstatus, add, city, pincode, state;
    JDateChooser dateChooser;
    JRadioButton male,female, married, unmarried, others; 
    Signup()
    {
        setTitle("NEW ACCOUNT APPLICATION FORM");
        setSize(850,800);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
        Random ran=new Random();
        random=(Math.abs((ran.nextLong()%9000L)+1000L));
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l2=new JLabel(i3);
        l2.setBounds(40,0,100,100);
        add(l2);
        
        formno=new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        personaldetails=new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);
        
        name=new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100,140,200,30);
        add(name);
        
        nametextfield=new JTextField();
        nametextfield.setFont(new Font("Raleway", Font.BOLD,14));
        nametextfield.setBounds(310, 140, 400, 30);
        add(nametextfield);
        
        fname=new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnametextfield=new JTextField();
        fnametextfield.setFont(new Font("Raleway", Font.BOLD,14));
        fnametextfield.setBounds(310, 190, 400, 30);
        add(fnametextfield);
        
        dob=new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(310,240,400,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
        
        gender=new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(310,290,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(460,290,100,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
                
        emailadd=new JLabel("Email Address: ");
        emailadd.setFont(new Font("Raleway", Font.BOLD, 22));
        emailadd.setBounds(100,340,200,30);
        add(emailadd);
        
        emailaddtextfield=new JTextField();
        emailaddtextfield.setFont(new Font("Raleway", Font.BOLD,14));
        emailaddtextfield.setBounds(310, 340, 400, 30);
        add(emailaddtextfield);
        
        mstatus=new JLabel("Marital Status: ");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 22));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);
        
        married=new JRadioButton("Married");
        married.setBounds(310, 390, 100, 30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(460, 390, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        others=new JRadioButton("Others");
        others.setBounds(610, 390, 100, 30);
        others.setBackground(Color.white);
        add(others);
        
        ButtonGroup maritalstatusgroup=new ButtonGroup();
        maritalstatusgroup.add(married);
        maritalstatusgroup.add(unmarried);
        maritalstatusgroup.add(others);
        
        add=new JLabel("Address: ");
        add.setFont(new Font("Raleway", Font.BOLD, 22));
        add.setBounds(100,440,200,30);
        add(add);
        
        addtextfield=new JTextField();
        addtextfield.setFont(new Font("Raleway", Font.BOLD,14));
        addtextfield.setBounds(310, 440, 400, 30);
        add(addtextfield);
        
        city=new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100,490,200,30);
        add(city);
        
        citytextfield=new JTextField();
        citytextfield.setFont(new Font("Raleway", Font.BOLD,14));
        citytextfield.setBounds(310, 490, 400, 30);
        add(citytextfield);
        
        pincode=new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100,540,200,30);
        add(pincode);
        
        pincodetextfield=new JTextField();
        pincodetextfield.setFont(new Font("Raleway", Font.BOLD,14));
        pincodetextfield.setBounds(310, 540, 400, 30);
        add(pincodetextfield);
        
        state=new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100,590,200,30);
        add(state);
        
        statetextfield=new JTextField();
        statetextfield.setFont(new Font("Raleway", Font.BOLD,14));
        statetextfield.setBounds(310, 590, 400, 30);
        add(statetextfield);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
    }

@Override
public void actionPerformed(ActionEvent ae){
String formno=""+random;//long
String name=nametextfield.getText();
String fname=fnametextfield.getText();
String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
String gender=null;
if(male.isSelected())
{
    gender="Male";
}
else if(female.isSelected())
{
    gender="Female";
}
String emailadd=emailaddtextfield.getText();
String maritalstatus=null;
if(married.isSelected())
{
    maritalstatus="Married";
}
else if(unmarried.isSelected())
{
    maritalstatus="Unmarried";
}
else if(others.isSelected()){
    maritalstatus="Others";
}
String address=addtextfield.getText();
String city=citytextfield.getText();
String pincode=pincodetextfield.getText();
String state=statetextfield.getText();

try{
    if(name.equals(""))
    {
        JOptionPane.showMessageDialog(null,"Name is necessary");
    }
    else if(fname.equals("")){
        JOptionPane.showMessageDialog(null,"Father,s name is necessary");
    }
    else if(dob.equals("")){
        JOptionPane.showMessageDialog(null,"Date of birth is necessary");
    }
    else if(gender.equals("")){
        JOptionPane.showMessageDialog(null,"Gender is necessary");
    }
    else if(emailadd.equals("")){
        JOptionPane.showMessageDialog(null,"Email address is necessary");
    }
    else if(maritalstatus.equals("")){
        JOptionPane.showMessageDialog(null,"Marital Status is necessary");
    }
    else if(address.equals("")){
        JOptionPane.showMessageDialog(null,"Address is necessary");
    }
    else if(city.equals("")){
        JOptionPane.showMessageDialog(null,"City is necessary");
    }
     else if(pincode.equals("")){
        JOptionPane.showMessageDialog(null,"Pincode is necessary");
    }
    else {
        Conn c=new Conn();
        String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+emailadd+"','"+maritalstatus+"','"+address+"','"+city+"','"+pincode+"','"+state+"')"; 
        c.s.executeUpdate(query);
        setVisible(false);
        new Signup2(formno).setVisible(true);
    }
    
}
catch(Exception e)
{
    System.out.println(e);
}
}}
public class SignupOne {
    public static void main(String args[]){
        Signup s=new Signup();
        s.setVisible(true);
    }
}
