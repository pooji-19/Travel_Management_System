
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton fpassword,login,signup;
    JTextField tfusername,tfpassword;
    Login(){
        setSize(800,400);
        setLocation(350,200);
        JPanel p1= new JPanel();
          setLayout(null);
        p1.setBackground(new Color(131,193,233));
        p1.setLayout(null);
        p1.setBounds(0,0,400,400);
        add(p1);
        getContentPane().setBackground(Color.WHITE);
        
  ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/1login.png"));
  Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image =new JLabel(i3);
    image.setBounds(100,100,200,200);
    p1.add(image);
    JPanel p2=new JPanel();
    p2.setLayout(null);
    p2.setBounds(400,30,450,300);
    add(p2);
    
    JLabel lusername =new JLabel("Username");
    lusername.setBounds(60,20,100,25);
    lusername.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
    p2.add(lusername);
    tfusername = new JTextField();
    tfusername.setBounds(60,60,280,25);
    tfusername.setBorder(BorderFactory.createEmptyBorder());
    p2.add(tfusername);
     
    JLabel password =new JLabel("Password");
    password.setBounds(60,120,100,25);
    password.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
    p2.add(password);
   tfpassword = new JTextField();
    tfpassword.setBounds(60,160,280,25);
    tfpassword.setBorder(BorderFactory.createEmptyBorder());
    p2.add(tfpassword);
    
     login = new JButton("Login");
      login.addActionListener(this);
    login.setBounds(60,210,90,30);
    login.setBorder(new LineBorder(new Color(131,193,233)));
    login.setForeground(Color.WHITE);
    login.setBackground(new Color(131,193,233));
    login.setFont(new Font("SANS_SERIF",Font.BOLD,15));
    p2.add(login);
   
    signup = new JButton("Signup");
     signup.addActionListener(this);
     signup.setBounds(220,210,90,30);
     signup.setBorder(new LineBorder(new Color(131,193,233)));
     signup.setForeground(Color.WHITE);
     signup.setBackground(new Color(131,193,233));
     signup.setFont(new Font("SANS_SERIF",Font.BOLD,15));
    p2.add( signup);
   
    fpassword = new JButton("Forgot Password");
    fpassword.addActionListener(this);
     fpassword.setBounds(80,260,210,30);
    fpassword.setBorder(new LineBorder(new Color(131,193,233)));
    fpassword.setForeground(Color.WHITE);
    fpassword.setBackground(new Color(131,193,233));
    fpassword.setFont(new Font("SANS_SERIF",Font.BOLD,15));
    p2.add(fpassword);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
           if(ae.getSource()==fpassword){
               try{
                setVisible(false);
                new ForgotPassword();
                }
           catch(Exception e){
            e.printStackTrace();}
        }
        else if(ae.getSource()==login){
            try{
                String pass=tfpassword.getText();
                String username=tfusername.getText();
             String query="select *from account where username='"+username+"' AND password='"+pass+"'";
             conn c = new conn();
             ResultSet rs =c.s.executeQuery(query);
             if(rs.next()){
                 setVisible(false);
                 new Loading(username);
             }
             else{
                 JOptionPane.showMessageDialog(null,"Incorrect username or password");
             }
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }
    }
        public static void main(String args[]){
            new Login().setVisible(true);
    }
    
}
