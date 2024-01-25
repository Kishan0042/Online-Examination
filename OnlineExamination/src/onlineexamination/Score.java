
package onlineexamination;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel;

public class Score extends JFrame implements ActionListener{
    
    String Firstname;
    String lastname;
     String email ;
    Score(String name,int score){
        
        try{    
            FetchProfileData fp = new FetchProfileData();
            while(fp.rs.next() && email==email)
            {
                 Firstname = fp.rs.getString("FirstName");
                 lastname = fp.rs.getString("lastname");
                 email = fp.rs.getString("email");
            }
           }
            catch(Exception e)
            {
                System.out.println(e);

            }
        
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
         Image i2 =i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,200,300,250);
        add(image);
        
        JLabel heading = new JLabel("Thank you " +Firstname+" "+lastname+" for Online Exam ");
        heading.setBounds(45,30,700,30);
        heading.setFont(new Font("Tahome",Font.PLAIN,26));
        add(heading);
        
        JLabel lblscore = new JLabel("Your Score is " +score);
        lblscore.setBounds(350,200,300,30);
        lblscore.setFont(new Font("Tahome",Font.PLAIN,26));
        add(lblscore);
        
         JButton submit = new JButton("Close");
        submit.setBounds(380,270,120,30);
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        
        
         
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
         new index().setVisible(true);
       
    }
    public static void main(String[] args) {
        new Score("User",0);
    }
}
