package Business;
import java.sql.*;

/*******************
 * Adv Sys Proj
 * Admin.java
 ******************/

public class Admin {
    
    private String id;
    private String username;
    private String password;
    private String databaseURL = "jdbc:ucanaccess://C:/WebSysProject.accdb";

    public Admin( String id, String username, String password) {

        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Admin() {

        id = "";
        username = "";
        password = "";
    }

    //testing
    public static void main(String arg[]) {
        Admin a = new Admin();
        a.selectDB("admin1");
        a.display();
        
    }
    
// Get Set //

    public void setId( String Id ) { id = Id; }
    public String getId() { return id; }

    public void setUsername( String Username ) { username = Username; }
    public String getUsername() { return username; }

    public void setPassword( String Password ) { password = Password; }
    public String getPassword() { return password; }

// Select DB //
    
    public void selectDB(String tusername) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Admin where UserName = '" + tusername + "'");
            rs.next();
            setId(rs.getString(3));
            setUsername(rs.getString(2));
            setPassword(rs.getString(1));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    
    public void insertDB(String tid, String tusername, String tpassword) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Admin (AdminID, UserName, Password) values (" + tid + ", '" + tusername + "', '" + tpassword + "')";
            int n1 = stmt.executeUpdate(sql);
            setId(tid);
            setUsername(tusername);
            setPassword(tpassword);
            
            if (n1 == 1)
                System.out.println("INSERT Successful!!!");
            else
                System.out.println("INSERT FAILED***********");
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

// Update DB //
    
    public void updateDB(String tusername, String tpassword) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "update Guests set UserName = '" + tusername + "', Password = '" + tpassword + "', where AdminID = " + id;
            int n1 = stmt.executeUpdate(sql);
            if (n1 == 1)
				System.out.println("UPDATE Successful!!!");
            else
                System.out.println("UPDATE FAILED***********");
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Delete DB //
    
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Admin where AdminID = " + id;
            int n1 = stmt.executeUpdate(sql);
            if (n1 == 1)
				System.out.println("DELETE Successful!!!");
            else
                System.out.println("DELETE FAILED***********");
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Display //
    
    public void display() {
        System.out.println("Admin ID: " + id);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

    }
}
