
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Payment extends JFrame implements ActionListener{
    JButton back,pay;
    Payment(){
        setBounds(500,200,800,600);
        setLayout(null);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);
        setVisible(true);
        
         back=new JButton("Back");
        back.setBounds(670,500,80,40);
        back.addActionListener(this);
        image.add(back);
        
         pay=new JButton("Pay");
        pay.setBounds(570,500,80,40);
        pay.addActionListener(this);
        image.add(pay);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            
        }
        else if(ae.getSource()==pay){
            setVisible(false);
            new Paytm();
        }
    }
       
    public static void main(String args[]){
        new Payment();
    }
}
