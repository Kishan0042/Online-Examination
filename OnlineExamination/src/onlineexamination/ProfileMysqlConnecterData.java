package onlineexamination;


import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Statement.*;

class jdbcConnectror{

    Connection con;
    public jdbcConnectror() {
        
         try{
         Class.forName("com.mysql.cj.jdbc.Driver");
             con =DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","123456");
        
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    
    
    
}
class createProfileTable
{

     java.sql.Statement statement;
     
    public createProfileTable() {
        
         try{
        
             jdbcConnectror jd = new jdbcConnectror();
           
            String s = "create table profile(FirstName varchar(50),lastName varchar(50),email varchar(50))";
             statement = jd.con.createStatement();
              statement.executeUpdate(s);
         
              System.out.println("create table succesfuly");
              jd.con.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    
}

class ProfileData
{
     PreparedStatement pst;
     Connection con;
    public ProfileData()
    {
        try{
          jdbcConnectror jd = new jdbcConnectror();
            String query="insert into profile values(?,?,?)";
             pst=jd.con.prepareStatement(query);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    
}

class updateProfileUser
{
    PreparedStatement ps;
 
    public updateProfileUser()
    {
        try{
             jdbcConnectror jd = new jdbcConnectror();
              String query="update profile set Firstname=?, lastname=? where email=? ";
             ps = jd.con.prepareStatement(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    
}

class FetchProfileData
{
    PreparedStatement ps;
    ResultSet rs;
    public FetchProfileData()
    {
        try{
             jdbcConnectror jd = new jdbcConnectror();
              String query="select * from profile ";
             ps = jd.con.prepareStatement(query);
              rs = ps.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    
}



public class ProfileMysqlConnecterData {
    
    public static void main(String[] args) {
        
        ProfileData pd = new ProfileData();
        
        ProfileMysqlConnecterData p = new ProfileMysqlConnecterData();
        
    }
    
}
