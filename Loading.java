
package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    Loading(String username){
        this.username=username;
        t=new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Travel And Management Application");
        text.setForeground(Color.BLACK);
        text.setBounds(50,20,600,40);
        text.setFont(new Font("Raleway",Font.BOLD,32));
        add(text);
        
         bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        setVisible(true);
        
        JLabel loading=new JLabel("Loading, please wait ... ");
         loading.setForeground(Color.RED);
        loading.setBounds(210,140,200,30);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add( loading);
        t.start();
        
         JLabel lblusername=new JLabel("Welcome Amma ");
         lblusername.setForeground(Color.BLACK);
        lblusername.setBounds(50,310,400,40);
        lblusername.setFont(new Font("Raleway",Font.BOLD,15));
        add( lblusername);
        
        
        
    }
    public void run(){
        try{
            for(int i=0;i<=101;i++){
                int m=bar.getMaximum();//100
                int value=bar.getValue();
                if(value<m){
                    bar.setValue(bar.getValue()+i);
                }
                else{
                    i=101;
                    setVisible(false);
                    new Dashboard(username).setVisible(true);
                }
                Thread.sleep(50);
            }  
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String args[]){
        new Loading("").setVisible((true));
    }
}
