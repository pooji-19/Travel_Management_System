
package travel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class AddCustomer extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphonenumber;
    JRadioButton rmale,rfemale,rother;
    JButton Add,Back;
    AddCustomer(String username){
         setBounds(450,200,850,550);
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         
         JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(30,50,150,25);
         add(lblusername);
         
          labelusername = new JLabel();
         labelusername.setBounds(220,50,150,25);
         add(labelusername);
         
         JLabel lbid = new JLabel("Id");
        lbid.setBounds(30,90,150,25);
         add(lbid);
         
         comboid = new JComboBox(new String[] {"Passport","Aadhar Card","Pan Card","Ration Card"});
         comboid.setBounds(220,90,150,25);
         comboid.setBackground(Color.WHITE);
         add(comboid);
         
         JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30,130,150,25);
         add(lbnumber);
         
         tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
         add(tfnumber);
         
         
        JLabel lblname = new JLabel("Name");
         lblname.setBounds(30,170,150,25);
         add(lblname);
         
          labelname = new JLabel();
         labelname.setBounds(220,170,150,25);
         add(labelname);
         
          JLabel lblgender = new JLabel("Gender");
         lblgender.setBounds(30,210,150,25);
         add(lblgender);
         
         rmale=new JRadioButton("Male");
         rmale.setBounds(220,210,70,25);
         rmale.setBackground(Color.WHITE);
         add(rmale);
         
         rfemale=new JRadioButton("Female");
         rfemale.setBounds(300,210,70,25);
         rfemale.setBackground(Color.WHITE);
         add(rfemale);
         
         rother=new JRadioButton("Other");
         rother.setBounds(380,210,70,25);
         rother.setBackground(Color.WHITE);
         add(rother);
         
         ButtonGroup bg=new ButtonGroup();
         bg.add(rmale);
         bg.add(rfemale);
         bg.add(rother);
         
         JLabel lbcountry = new JLabel("Country");
        lbcountry.setBounds(30,250,150,25);
         add(lbcountry);
         
         tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
         add(tfcountry);
         
         JLabel lbaddress= new JLabel("Address");
        lbaddress.setBounds(30,290,150,25);
         add(lbaddress);
         
         tfaddress= new JTextField();
        tfaddress.setBounds(220,290,150,25);
         add(tfaddress);
         
         JLabel lbemail= new JLabel("Email");
       lbemail.setBounds(30,370,150,25);
         add(lbemail);
         
         tfemail= new JTextField();
        tfemail.setBounds(220,370,150,25);
         add( tfemail);
         
            JLabel lbphonenumber= new JLabel("Phone Number");
       lbphonenumber.setBounds(30,330,150,25);
         add(lbphonenumber);
         
         tfphonenumber= new JTextField();
        tfphonenumber.setBounds(220,330,150,25);
         add(  tfphonenumber);
         
         Add=new JButton("Add");
         Add.setBackground(Color.BLACK);
         Add.setForeground(Color.WHITE);
         Add.setBounds(70,430,100,25);
         Add.addActionListener(this);
         add(Add);
         
        Back=new JButton("Back");
        Back.setBackground(Color.BLACK);
         Back.setForeground(Color.WHITE);
         Back.setBounds(220,430,100,25);
         Back.addActionListener(this);
         add(Back);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
         Image i2= i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(400,40,450,420);
         add(image);
         
         try{
             conn c = new conn();
             ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
             while(rs.next()){
                 labelusername.setText(rs.getString("username"));
                 labelname.setText(rs.getString("name"));
             }
         }
         catch(Exception e){
             e.printStackTrace();
         }
         setVisible(true);
         
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Back){
            setVisible(false);
//            new DashBoard();
        }
        else if(ae.getSource()==Add){
            String username=labelusername.getText();
            String id=(String)comboid.getSelectedItem();
             String number=tfnumber.getText();
              String name=labelname.getText();
              String gender=null;
              if(rmale.isSelected()){
                  gender="Male";
              }
              else if(rfemale.isSelected()){
                  gender="Female";
              }
              else{
                  gender="Other";
              }
               String country=tfcountry.getText();
               String address=tfaddress.getText();
               String phone=tfphonenumber.getText();
                String email =tfemail.getText();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"ID should not be empty");
                return;
            }
             if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"Gender should not be empty");
                return;
            }
              if(country.equals("")){
                JOptionPane.showMessageDialog(null,"Country should not be empty");
                return;
            }
               if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address should not be empty");
                return;
            }
                 if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email should not be empty");
                return;
            }
                     if(phone.equals("")){
                JOptionPane.showMessageDialog(null,"Phonenumber should not be empty");
                return;
            }                 
                     
                     try{
                         conn c = new conn();
                         String query="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                         c.s.executeUpdate(query);
                         JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                         setVisible(false);
                                
                         
                     }
                     catch(Exception e){
                         e.printStackTrace();
                     }
        }
        
    }
    public static void main(String args[]){
         new AddCustomer("");
    }
   
}
