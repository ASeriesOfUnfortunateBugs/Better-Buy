package Business;
import java.sql.*;

/**
 * Advance System Project
 * Constantaras / Blaine
 */
public class Guest extends Person{
    private String guestID;
    private int orderNo;
    private String databaseURL = "jdbc:ucanaccess://C:/WebSysProject.accdb";
    
    public Guest() {
        guestID = "";
        orderNo = 0;
    }
    
    public Guest(String tguestID, int torderNo) {
        guestID = tguestID;
        orderNo = torderNo;
    }
    
    //testing
    public static void main(String arg[]) {
        Guest g = new Guest();
        g.createID();
        g.createOrderNo();
    }
    
    //get and set variables
    public void setGuestID(String tguestID) { guestID = tguestID; }
    public String getGuestID() { return guestID; }
    
    public void setOrderNo(int torderNo) { orderNo = torderNo; }
    public int getOrderNo() { return orderNo; }
    
// Create Guest ID //
    
    public void createID() {
        int x;
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select GuestID from Guests");
            
            while(rs.next()) {
                setGuestID(rs.getString(1));
            }
            
            if (guestID.isEmpty()) {
                x = 1;
            }
            else {
                guestID = guestID.replaceAll("[^0-9]", "");
                x = Integer.parseInt(guestID);
                x++;
            }
            
            guestID = "G" + Integer.toString(x);
            System.out.println("id = " + guestID);
            con.close();
        }
        catch (Exception e) {
            System.out.println("Error in Create Guest Id ...");
        }
    }
    
// Create Order Number //

    public void createOrderNo() {
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select OrderNo from Guests");
            
            while(rs.next()) {
                setOrderNo(rs.getInt(2));
            }
            orderNo ++;
            System.out.println("Order Number = " + orderNo);
            
            con.close();
        }
        catch (Exception e) {
            System.out.println("Error in Create Order Number ...");
        }
    }
    
// Select DB //
    
    public void selectDBG(String tguestID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Guests where GuestID = '" + tguestID + "'");
            rs.next();
            setGuestID(rs.getString(1));
            setOrderNo(rs.getInt(2));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    
    public void insertDBG(String tguestID, int torderNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Guests (GuestID, OrderNo) values ('" + tguestID + "', " + torderNo + ")";
            int n1 = stmt.executeUpdate(sql);
            setGuestID(tguestID);
            setOrderNo(torderNo);
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
    //the only thing I can think to update is the order number if we even need to update it
    public void updateDBG(String tguestID, int torderNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "update Guests set OrderNo = " + torderNo + "where GuestID = '" + tguestID + "'";
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
    
    public void deleteDBG() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Guests where GuestID = '" + guestID + "'";
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
    
    public void displayG() {
        System.out.println("Guest ID    : " + guestID);
        System.out.println("Order Number: " + orderNo);
    }
}
