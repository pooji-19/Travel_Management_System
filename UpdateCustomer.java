
package travel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class UpdateCustomer extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphonenumber,tfgender,tfid;
    JRadioButton rmale,rfemale,rother;
    JButton Add,Back;
    UpdateCustomer(String username){
         setBounds(500,200,850,550);
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         
         JLabel text=new JLabel("UPDATE CUSTOMER DETAILS");
         text.setBounds(50,0,300,25);
         text.setFont(new Font("Tahoma",Font.PLAIN,20));
         add(text);
         
         JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(30,50,150,25);
         add(lblusername);
         
          labelusername = new JLabel();
         labelusername.setBounds(220,50,150,25);
         add(labelusername);
         
         JLabel lbid = new JLabel("Id");
        lbid.setBounds(30,90,150,25);
         add(lbid); 
         
         tfid = new JTextField();
        tfid.setBounds(220,90,150,25);
         add(tfid);
         
          JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30,130,150,25);
         add(lbnumber); 
         
         tfnumber= new JTextField();
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
         
          tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
         add(tfgender);
         
         
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
         
         Add=new JButton("Update");
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
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
         Image i2= i1.getImage().getScaledInstance(320,700,Image.SCALE_SMOOTH);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(400,50,450,700);
         add(image);
         
         try{
             conn c = new conn();
             String s1="S";
             ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
             while(rs.next()){
                 labelusername.setText(rs.getString("username"));
                 labelname.setText(rs.getString("name"));
                 tfid.setText(rs.getString("id"));
                  tfnumber.setText(rs.getString("number"));
                   tfgender.setText(rs.getString("gender"));
                    tfphonenumber.setText(rs.getString("phonenumber"));
                     tfemail.setText(rs.getString("email"));
                      tfaddress.setText(rs.getString("address"));
                       tfcountry.setText(rs.getString("country"));
                    
                    
                  
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
            String id=tfid.getText();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender=tfgender.getText();
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphonenumber.getText();
            String email =tfemail.getText();
                     try{
                         conn c = new conn();
                         String query="update customer set username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phonenumber='"+phone+"',email='"+email+"'";
                         c.s.executeUpdate(query);
                         JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
                         setVisible(false);
                                
                         
                     }
                     catch(Exception e){
                         e.printStackTrace();
                     }
        }
        
    }
    public static void main(String args[]){
         new UpdateCustomer("Amma");
    }
   
}
