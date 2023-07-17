
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    JTextField stextfield,ntextfield,ptextfield ,   answert;
    Choice security;
    Signup(){
         setSize(800,400);
        setLocation(350,200);
        JPanel p1= new JPanel();
         setLayout(null);
        p1.setBackground(new Color(131,193,233));
        p1.setLayout(null);
        p1.setBounds(0,0,400,400);
        add(p1);
        
        JLabel susername=new JLabel("Username");
        susername.setBounds(50,20,125,25);
        susername.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(susername);
        stextfield = new JTextField();
        stextfield.setBorder(BorderFactory.createEmptyBorder());
        stextfield.setBounds(190,20,180,25);
        p1.add(stextfield);
        
        JLabel sname=new JLabel("Name");
        sname.setBounds(50,60,125,25);
        sname.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(sname);
         ntextfield = new JTextField();
        ntextfield.setBorder(BorderFactory.createEmptyBorder());
        ntextfield.setBounds(190,60,180,25);
        p1.add(ntextfield);
        
        JLabel spassword=new JLabel("Password");
        spassword.setBounds(50,100,125,25);
        spassword.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(spassword);
         ptextfield = new JTextField();
        ptextfield.setBorder(BorderFactory.createEmptyBorder());
        ptextfield.setBounds(190,100,180,25);
        p1.add(ptextfield);
        
        JLabel text = new JLabel("Security Question");
        text.setBounds(50,140,125,25);
        text.setFont(new Font("Tahoma",Font.BOLD,13));
        p1.add(text);
       security = new Choice();
        security.add("Who is your BestFriend");
        security.add("What is your Petname");
        security.add("Your Favourite actor");
        security.add("Your lucky Number");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        
        JLabel answer = new  JLabel("Answer");
        answer.setBounds(50,175,125,25);
        answer.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(answer);
         answert = new JTextField();
        answert.setBorder(BorderFactory.createEmptyBorder());
        answert.setBounds(190,175,180,25);
        p1.add(answert);
        
        create = new JButton("Create");
        create.setBounds(80,240,100,25);
        create.setBorder(BorderFactory.createEmptyBorder());
        create.setForeground(new Color(131,193,233));
        create.setBackground(Color.WHITE);
        create.addActionListener(this);
        p1.add(create);
        
        
        back = new JButton("Back");
        back.setBounds(220,240,100,25);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(131,193,233));
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
    Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image =new JLabel(i3);
    image.setBounds(100,70,200,200);
    JPanel p2=new JPanel();
    p2.setLayout(null);
    p2.setBounds(400,30,450,300);
     p2.add(image);
    add(p2);
    setVisible(true);

    
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            String username=stextfield.getText();
            String name=ntextfield.getText();
            String password=ptextfield.getText();
            String question=security.getSelectedItem();
            String answer=answert.getText();
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name should not be empty");
                return;
            }
            if(username.equals("")){
                JOptionPane.showMessageDialog(null,"UserName should not be empty");
                return;
            }
            if(password.equals("")){
                JOptionPane.showMessageDialog(null,"Password should not be empty");
                return;
            }
     
            if(answer.equals("")){
                JOptionPane.showMessageDialog(null,"Answer should not be empty");
                return;
            }
            String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
             try{
                 conn c =new conn();
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Account created successfully");
                 setVisible(false);
                 new Login();
             }
             catch(Exception e){
                 e.printStackTrace();
             }
            
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
     
    public static void main(String args[]){
        Signup su = new Signup();
    }
    
}
