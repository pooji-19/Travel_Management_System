
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookPackages extends JFrame implements ActionListener{
    String username ;
    JTextField tfpersons;
  Choice cpackage;
  JLabel labelusername,labelid,labelnumber,labelprice,labelphone ;
  JButton checkprice,bookpackage,back;
      
    BookPackages( String username){
        this.username=username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,180,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(250,70,200,25);
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelusername);
        
         JLabel lblpackage= new JLabel("Select Package");
       lblpackage.setBounds(40,110,200,20);
         lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        
        
        
        cpackage=new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,150,20);
        add(cpackage);
        
         JLabel lblpersons = new JLabel("Total Persons");
         lblpersons .setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpersons .setBounds(40,150,150,25);
        add(lblpersons );
        
     tfpersons=new JTextField("1");
        tfpersons.setBounds(250,150,150,25);
        add(tfpersons);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,190,150,20);
         lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        
        labelid = new JLabel();
        labelid .setBounds(250,190,200,25);
        add(labelid );
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnumber.setBounds(40,230,150,25);
        add(lblnumber);
        
       labelnumber = new JLabel();
       labelnumber.setBounds(250,230,150,25);
        add(labelnumber );
        
         JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        
        labelphone = new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone );
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotal.setBounds(40,310,150,25);
        add(lbltotal);
        
        labelprice = new JLabel();
       labelprice.setBounds(250,310,150,25);
        add(labelprice );
        
        try{
            conn conn= new conn();
            String query="select *from customer where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phonenumber")); 
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        checkprice=new JButton("Check Price");
        checkprice.setBounds(60,380,120,25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.addActionListener(this);
        add(checkprice);
        
         bookpackage=new JButton("Book Package");
       bookpackage.setBounds(200,380,120,25);
        bookpackage.setBackground(Color.BLACK);
       bookpackage.setForeground(Color.WHITE);
       bookpackage.addActionListener(this);
        add(bookpackage);
        
        back=new JButton("Back");
       back.setBounds(340,380,120,25);
        back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);
        
        
        
        
         setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String pack=cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package")){
                cost+=18000;
            }
           else if(pack.equals("Silver Package")){
                cost+=25000;
            }
            else if(pack.equals("Bronze Package")){
                cost+=32000;
            }
            int persons=Integer.parseInt(tfpersons.getText());
            cost*=persons;
            labelprice.setText("Rs "+cost);
        }
        else if(ae.getSource()==bookpackage){
            try{
                conn c= new conn();
               c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package booked successfully");
                setVisible(false);
            
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==back){
            setVisible(false);
            
        }
    }
    public static void main(String args[]){
        new BookPackages("");
    }
}
