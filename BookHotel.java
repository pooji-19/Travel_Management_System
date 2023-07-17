
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookHotel extends JFrame implements ActionListener{
    String username ;
    JTextField tfpersons,tfdays;
  Choice chotel,cac,cfood;
  JLabel labelusername,labelid,labelnumber,labelprice,labelphone ;
  JButton checkprice,bookpackage,back;
      
    BookHotel( String username){
        setBounds(350,200,1100,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        this.username=username;
        JLabel text=new JLabel("BOOK HOTEL");
        text.setBounds(150,10,200,50);
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
        
        JLabel lblhotel= new JLabel("Select Hotel");
       lblhotel.setBounds(40,110,200,20);
         lblhotel.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblhotel);
        
        chotel=new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);
        
        try{
           conn c = new conn();
           ResultSet rs= c.s.executeQuery("select * from hotel");
           while(rs.next()){
              chotel.add(rs.getString("name"));  
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
         JLabel lblpersons = new JLabel("Total Persons");
         lblpersons .setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpersons .setBounds(40,150,150,25);
        add(lblpersons );
        
        tfpersons=new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No. of Days");
         lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldays.setBounds(40,190,150,25);
        add(lbldays);
        
        tfdays=new JTextField("1");
        tfdays.setBounds(250,190,200,25);
        add(tfdays);
        
          JLabel lblac = new JLabel("AC/Non-AC");
         lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblac.setBounds(40,230,150,25);
        add(lblac);
        
        cac=new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,20);
        add(cac);
        
         JLabel lbfood = new JLabel("Food Included");
        lbfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbfood.setBounds(40,270,150,25);
        add(lbfood);
        
        cfood=new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);
        
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,310,150,20);
         lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        
        labelid = new JLabel();
        labelid .setBounds(250,310,200,25);
        add(labelid );
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnumber.setBounds(40,350,150,25);
        add(lblnumber);
        
       labelnumber = new JLabel();
       labelnumber.setBounds(250,350,150,25);
        add(labelnumber );
        
         JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,390,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        
        labelphone = new JLabel();
        labelphone.setBounds(250,390,200,25);
        add(labelphone );
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotal.setBounds(40,430,150,25);
        add(lbltotal);
        
        labelprice = new JLabel();
       labelprice.setBounds(250,430,150,25);
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
        checkprice.setBounds(60,470,120,25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.addActionListener(this);
        add(checkprice);
        
         bookpackage=new JButton("Book Hotel");
       bookpackage.setBounds(200,470,120,25);
        bookpackage.setBackground(Color.BLACK);
       bookpackage.setForeground(Color.WHITE);
       bookpackage.addActionListener(this);
        add(bookpackage);
        
        back=new JButton("Back");
       back.setBounds(340,470,120,25);
        back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(500,50,600,300);
        add(image);
        
        
        
        
         setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String pack=chotel.getSelectedItem();
           
            try{
             conn c= new conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name ='"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int  cost= Integer.parseInt(rs.getString("costperperson"));
                    int  food= Integer.parseInt(rs.getString("foodincluded"));
                    int  ac= Integer.parseInt(rs.getString("acroom"));
                int persons =Integer.parseInt(tfpersons.getText());
                int days =Integer.parseInt(tfdays.getText());
                
                String acselected=cac.getSelectedItem();
                String foodselected=cfood.getSelectedItem();
                if(persons*days>0){
                    int total=0;
                    total+=acselected.equals("AC") ? ac:0;
                    total+=foodselected.equals("Yes") ? food:0;
                    total+=cost;
                    total=total*persons*days;
                    labelprice.setText("Rs "+total);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please enter a valid number");
                    return;
                }
                }
                
       
            }
            catch(Exception e )
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==bookpackage){
            try{
                conn c= new conn();
               c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel booked successfully");
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
        new BookHotel("");
    }
}
