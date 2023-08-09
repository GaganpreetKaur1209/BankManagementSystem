package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Signup2 extends JFrame implements ActionListener 
{
    
    JButton next ;
    JComboBox religionbox,categorybox,incomebox,edubox,occupationbox;
    JTextField pno,ano;
    JLabel l3,additionaldetails,religion,category,income,edu,qualification,occupation,panno,aadharno,seniorcitizen,existingacc;
    JRadioButton syes,sno,eayes,eano;
    String formno;
    
    Signup2(String formno)
    {
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setSize(850,800);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l3=new JLabel(i3);
        l3.setBounds(40,0,100,100);
        add(l3);
        
        additionaldetails=new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290,60,400,30);
        add(additionaldetails);
        
        religion=new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100,140,200,30);
        add(religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Others"};
        religionbox=new JComboBox(valReligion);
        religionbox.setBounds(310, 140, 400, 30);
        religionbox.setBackground(Color.white);
        add(religionbox);
        
        category=new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(100,190,200,30);
        add(category);
        
        String valCategory[] = {"General","OBC","SC","ST","Others"};
        categorybox=new JComboBox(valCategory);
        categorybox.setBounds(310, 190, 400, 30);
        categorybox.setBackground(Color.white);
        add(categorybox);
        
        income=new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomebox=new JComboBox(valIncome);
        incomebox.setBounds(310, 240, 400, 30);
        incomebox.setBackground(Color.white);
        add(incomebox);
        
        edu=new JLabel("Educational ");
        edu.setFont(new Font("Raleway", Font.BOLD, 22));
        edu.setBounds(100,290,200,30);
        add(edu);
        
        qualification=new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 22));
        qualification.setBounds(100,320,200,30);
        add(qualification);
        
        String valEdu[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        edubox=new JComboBox(valEdu);
        edubox.setBounds(310, 290, 400, 30);
        edubox.setBackground(Color.white);
        add(edubox);
                
        occupation=new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String valOcc[] = {"Salaried","Self-Employeed","Business","Student","Retired","Others"};
        occupationbox=new JComboBox(valOcc);
        occupationbox.setBounds(310, 390, 400, 30);
        occupationbox.setBackground(Color.white);
        add(occupationbox);
        
        panno=new JLabel("PAN Number: ");
        panno.setFont(new Font("Raleway", Font.BOLD, 22));
        panno.setBounds(100,440,200,30);
        add(panno);
        
        pno=new JTextField();
        pno.setFont(new Font("Raleway", Font.BOLD,14));
        pno.setBounds(310, 440, 400, 30);
        add(pno);
        
        aadharno=new JLabel("Aadhar Number: ");
        aadharno.setFont(new Font("Raleway", Font.BOLD, 22));
        aadharno.setBounds(100,490,200,30);
        add(aadharno);
        
        ano=new JTextField();
        ano.setFont(new Font("Raleway", Font.BOLD,14));
        ano.setBounds(310, 490, 400, 30);
        add(ano);
        
        seniorcitizen=new JLabel("Senior Citizen: ");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 22));
        seniorcitizen.setBounds(100,540,200,30);
        add(seniorcitizen);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(310, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(460, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup sg=new ButtonGroup();
        sg.add(syes);
        sg.add(sno);
        
        existingacc=new JLabel("Existing Account: ");
        existingacc.setFont(new Font("Raleway", Font.BOLD, 22));
        existingacc.setBounds(100,590,200,30);
        add(existingacc);
        
        eayes=new JRadioButton("Yes");
        eayes.setBackground(Color.white);
        eayes.setBounds(310, 590, 100, 30);
        add(eayes);
        
        eano=new JRadioButton("No");
        eano.setBackground(Color.white);
        eano.setBounds(460, 590, 100, 30);
        add(eano);
        
        ButtonGroup ea=new ButtonGroup();
        ea.add(eayes);
        ea.add(eano);
        
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
//String formno=""+random;//long
String sreligion=(String)religionbox.getSelectedItem();
String scategory=(String)categorybox.getSelectedItem();
String sincome=(String)incomebox.getSelectedItem();
String seduqual=(String)edubox.getSelectedItem();
String socc=(String)occupationbox.getSelectedItem();
String spno=panno.getText();
String saadharno=ano.getText();
String ssc=null;
{
    if(syes.isSelected())
    {
        ssc="Yes";
    }
    else if(sno.isSelected())
    {
        ssc="No";
    }
}
String sexistingac=null;
{
    if(eayes.isSelected())
    {
        sexistingac="Yes";
    }
    else if(eano.isSelected())
    {
        sexistingac="No";
    }
}

try{
    if(spno.equals(""))
    {
        JOptionPane.showMessageDialog(null,"PAN Number is necessary");
    }
    else if(sexistingac.equals("")){
        JOptionPane.showMessageDialog(null,"Aadhar Number is necessary");
    }
    else {
        Conn c=new Conn();
        String query="insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seduqual+"','"+socc+"','"+spno+"','"+saadharno+"','"+ssc+"','"+sexistingac+"')"; 
        c.s.executeUpdate(query);
        
        //Signup3 object
        setVisible(false);
        new Signup3(formno).setVisible(true);
    }
    
}
catch(Exception e)
{
    System.out.println(e);
}
}}
public class SignupTwo {
    public static void main(String args[]){
        Signup2 st=new Signup2("");
        st.setVisible(true);
    }
}
