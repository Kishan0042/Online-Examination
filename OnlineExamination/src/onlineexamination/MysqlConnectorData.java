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
class createTable
{

     java.sql.Statement statement;
    public createTable() {
        
         try{
        
             jdbcConnectror jd = new jdbcConnectror();
           
            String s = "create table registration(username varchar(50),password varchar(50),mobile varchar(50))";
             statement = jd.con.createStatement();
              statement.executeUpdate(s);
         
              System.out.println("create table");
              jd.con.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    
}


class login
{
    PreparedStatement pst;
    
    public login()
    {
        
        try{
           jdbcConnectror jd = new jdbcConnectror();
            String s = "select*from registration where username=? and password=?";
             pst=jd.con.prepareStatement(s);
             
            
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    
}
class Registrer
{
     PreparedStatement pst;
     Connection con;
    public Registrer()
    {
        try{
          jdbcConnectror jd = new jdbcConnectror();
            String query="insert into registration values(?,?,?)";
             pst=jd.con.prepareStatement(query);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    
}
class updatePasswordUser
{
    PreparedStatement ps;
 
    public updatePasswordUser()
    {
        try{
             jdbcConnectror jd = new jdbcConnectror();
              String query="update registration set password=?  where mobile=? ";
             ps = jd.con.prepareStatement(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    
}
class FetchLoginData
{
    PreparedStatement ps;
    ResultSet rs;
    public FetchLoginData()
    {
        try{
             jdbcConnectror jd = new jdbcConnectror();
              String query="select * from registration ";
             ps = jd.con.prepareStatement(query);
              rs = ps.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    
}
public class MysqlConnectorData {
    
    public static void main(String[] args) {
        
       

        jdbcConnectror jc = new jdbcConnectror();
        createTable c = new createTable(); 
        createProfileTable p=new createProfileTable();
        
    }
   
}
