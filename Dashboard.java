
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Dashboard extends JFrame implements ActionListener{
    String username;
     JButton addPersonalDetails,viewhotels,deletepersonalDetails,about,calculators,notepad,payments,viewBookedHotel,destinations,bookhotel,bookpackages,viewpackages,viewPersonalDetails,updatePersonalDetails,checkpackages;
    Dashboard(String username){
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1= new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        p1.add(image);
        image.setBounds(5,0,70,70);
      
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2= new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        
       viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
      viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
       viewPersonalDetails.setMargin(new Insets(0,0,0,50));
      viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails );
        
       deletepersonalDetails = new JButton("Delete Personal Details");
       deletepersonalDetails.setBounds(0,150,300,50);
        deletepersonalDetails.setBackground(new Color(0,0,102));
        deletepersonalDetails.setForeground(Color.WHITE);
        deletepersonalDetails.addActionListener(this);
      deletepersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
       deletepersonalDetails.setMargin(new Insets(0,0,0,40));
       
        p2.add(deletepersonalDetails );
        
         checkpackages = new JButton("Check Package");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,110));
       checkpackages.addActionListener(this);
        p2.add(checkpackages );
        
          bookpackages = new JButton("Book Packages");
        bookpackages.setBounds(0,250,300,50);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.WHITE);
        bookpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackages.setMargin(new Insets(0,0,0,110));
        bookpackages.addActionListener(this);
        p2.add(bookpackages );
        
      viewpackages = new JButton("View Packages");
        viewpackages.setBounds(0,300,300,50);
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.WHITE);
        viewpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
       viewpackages.setMargin(new Insets(0,0,0,110));
       viewpackages.addActionListener(this);
        p2.add(viewpackages );
        
         viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
     viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
       viewhotels.setMargin(new Insets(0,0,0,140));
       viewhotels.addActionListener(this);
        p2.add(viewhotels );
        
      bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0,400,300,50);
       bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.WHITE);
     bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
       bookhotel.setMargin(new Insets(0,0,0,145));
         bookhotel.addActionListener(this);
        p2.add(bookhotel );
        
      viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0,450,300,50);
       viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.WHITE);
     viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
       viewBookedHotel.setMargin(new Insets(0,0,0,70));
        viewBookedHotel.addActionListener(this);
       p2.add(viewBookedHotel );
        
         destinations = new JButton("Destinations");
         destinations.setBounds(0,500,300,45);
        destinations.setBackground(new Color(0,0,102));
         destinations.setForeground(Color.WHITE);
      destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,130));
         destinations.addActionListener(this);
        p2.add( destinations);
        
       payments = new JButton("Payments");
         payments.setBounds(0,545,300,45);
        payments.setBackground(new Color(0,0,102));
         payments.setForeground(Color.WHITE);
      payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,155));
        payments.addActionListener(this);
        p2.add( payments);
        
        calculators = new JButton("Calculators");
       calculators.setBounds(0,590,300,45);
        calculators.setBackground(new Color(0,0,102));
         calculators.setForeground(Color.WHITE);
      calculators.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculators.setMargin(new Insets(0,0,0,150));
       calculators.addActionListener(this);
        p2.add( calculators);
        
         notepad = new JButton("Notepad ");
       notepad.setBounds(0,635,300,50);
        notepad.setBackground(new Color(0,0,102));
         notepad.setForeground(Color.WHITE);
      notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad .setMargin(new Insets(0,0,0,160));
        notepad.addActionListener(this);
        p2.add( notepad );
        
        about= new JButton("About");
       about.setBounds(0,685,300,50);
        about.setBackground(new Color(0,0,102));
         about.setForeground(Color.WHITE);
      about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about .setMargin(new Insets(0,0,0,190));
        about.addActionListener(this);
        p2.add( about );
        
        ImageIcon a1= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image a2=a1.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon a3=new ImageIcon(a2);
        JLabel image2= new JLabel(a3);
        image2.setBounds(0,0,1650,1000);
        add(image2);
        
        JLabel text =new JLabel("Travel and Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        image2.add(text);
        
        
        
        
        
        
        
        

        
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addPersonalDetails){
            new AddCustomer(username);

        }
        else if(ae.getSource()==viewPersonalDetails){
            new ViewCustomer(username);

        }
        else if(ae.getSource()==updatePersonalDetails){
            new UpdateCustomer(username);

        }
         else if(ae.getSource()==checkpackages){
            new CheckPackages();

        }
        else if(ae.getSource()==bookpackages){
            new BookPackages(username);

        }
         else if(ae.getSource()==viewpackages){
            new ViewPackage(username);

        }
        else if(ae.getSource()==viewhotels){
            new CheckHotels();

        }
        else if(ae.getSource()==destinations){
            new Destinations();

        }
         else if(ae.getSource()==bookhotel){
            new BookHotel(username);

        }
        else if(ae.getSource()==viewBookedHotel){
            new ViewBookedHotel(username);

        }
        else if(ae.getSource()==payments){
            new Payment();

        }
        else if(ae.getSource()==calculators){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }

        }
          else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==deletepersonalDetails){
            new DeleteDetails(username);

        }
        else if(ae.getSource()==about){
            new About();

        }
    }
    
    public static void main(String args[]){
         new Dashboard("");
    }
}
