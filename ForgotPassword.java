
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgotPassword extends JFrame implements ActionListener{
    JTextField utextfield,tfname,tfanswer,tfquestion,tfpassword;
    JButton search,retrieve,back;
    ForgotPassword(){
        setBounds(350,200,850,380);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JLabel tfusername = new JLabel("Username");
        tfusername.setFont(new Font("Tahoma",Font.BOLD,14));
        tfusername.setBounds(40,20,100,25);
        p1.add(tfusername);
         utextfield = new JTextField();
        utextfield.setBounds(220,20,150,25);
       utextfield.setBorder(BorderFactory.createEmptyBorder());
        p1.add(utextfield);
         
      search = new JButton("Search");
        search.setBounds(380,20,100,25);
        search.setBackground(Color.gray);
        search.addActionListener(this);
        search.setForeground(Color.WHITE);
        p1.add(search);
        
       JLabel name = new JLabel("Name");
       name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setBounds(40,60,100,25);
        p1.add(name);
         tfname = new JTextField();
        tfname.setBounds(220,60,150,25);
       tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel question = new JLabel("Security Question");
       question.setFont(new Font("Tahoma",Font.BOLD,14));
        question.setBounds(40,100,150,25);
        p1.add(question);
          tfquestion= new JTextField();
       tfquestion.setBounds(220,100,150,25);
       tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
         JLabel answer = new JLabel("Answer");
       answer.setFont(new Font("Tahoma",Font.BOLD,14));
       answer.setBounds(40,140,100,25);
        p1.add(answer);
          tfanswer= new JTextField();
       tfanswer.setBounds(220,140,150,25);
       tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
         retrieve = new JButton("Retrieve");
         retrieve.addActionListener(this);
        retrieve.setBounds(380,140,100,25);
      retrieve.setBackground(Color.gray);
        retrieve.setForeground(Color.WHITE);
        p1.add(retrieve);
        
        JLabel password = new JLabel("Password");
       password.setFont(new Font("Tahoma",Font.BOLD,14));
       password.setBounds(40,180,100,25);
        p1.add(password);
          tfpassword= new JTextField();
tfpassword.setBounds(220,180,150,25);
     tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(190,230,100,25);
     back.setBackground(Color.gray);
     back.setForeground(Color.WHITE);
        p1.add(back);
        
        
        
        
        
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Login();  
        }
        else if(ae.getSource()==retrieve){
             try{
               String query="select * from account where username='"+utextfield.getText()+"'  AND answer='"+tfanswer.getText()+"'";
//               String query1="update " 
               conn c= new conn();
               ResultSet rs= c.s.executeQuery(query);
               while(rs.next()){
                   tfpassword.setText(rs.getString("password"));

               }
             }
            catch(Exception e){
                e.printStackTrace();
            }
            
            
        }
        else if(ae.getSource()==search){
            try{
               String query="select * from account where username='"+utextfield.getText()+"'";
                conn c= new conn();
               ResultSet rs= c.s.executeQuery(query);
               while(rs.next()){
                   tfname.setText(rs.getString("name"));
                   tfquestion.setText(rs.getString("security"));
               }
             }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
    public static void main(String args[]){
        new ForgotPassword();
    }
}
