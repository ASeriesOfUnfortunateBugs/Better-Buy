package Business;
import java.sql.*;

/**
 * Advance System Project
 * Constantaras / Blaine
 */

public class Address {
    private String street, city, state, custID, guestID, zipCode, aptNo;
    private String databaseURL = "jdbc:ucanaccess://C:/WebSysProject.accdb";
//    private String databaseURLEclipse = "jdbc:ucanaccess://C:src/main/WebSysProject.accdb";
    
    public Address() {
        street = "";
        city = "";
        state = "";
        zipCode = "";
        aptNo = "";
        custID = "";
        guestID = "";
    }
    
    public Address(String tstreet, String tcity, String tstate, String tzipCode, String taptNo, String tcustID, String tguestID) {
        street = tstreet;
        city = tcity;
        state = tstate;
        zipCode = tzipCode;
        aptNo = taptNo;
        custID = tcustID;
        guestID = tguestID;
    }
    
    //get and set variables
    public void setStreet(String tstreet) { street = tstreet; }
    public String getStreet() { return street; }
    
    public void setCity(String tcity) { city = tcity; }
    public String getCity() { return city; }
    
    public void setState(String tstate) { state = tstate; }
    public String getState() { return state; }
    
    public void setZipCode(String tzipCode) { zipCode = tzipCode; }
    public String getZipCode() { return zipCode; }
    
    public void setAptNo(String taptNo) { aptNo = taptNo; }
    public String getAptNo() { return aptNo; }
    
    public void setCustID(String tcustID) { custID = tcustID; }
    public String getCustID() { return custID; }
    
    public void setGuestID(String tguestID) { guestID = tguestID; }
    public String getGuestID() { return guestID; }
    
// Select DB //
    
    public void selectDBC(String tcustID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Address where CustID = '" + tcustID + "'");
            rs.next();
            setStreet(rs.getString(1));
            setCity(rs.getString(2));
            setState(rs.getString(3));
            setZipCode(rs.getString(4));
            setAptNo(rs.getString(5));
            setCustID(rs.getString(6));
            setGuestID(rs.getString(7));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void selectDBG(String tguestID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Address where CustID = '" + tguestID + "'");
            rs.next();
            setStreet(rs.getString(1));
            setCity(rs.getString(2));
            setState(rs.getString(3));
            setZipCode(rs.getString(4));
            setAptNo(rs.getString(5));
            setCustID(rs.getString(6));
            setGuestID(rs.getString(7));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    
    public void insertDB(String tstreet, String tcity, String tstate, String tcustID, String tguestID, String tzipCode, String taptNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Address (Street, City, State, ZipCode, AptNo, CustID, GuestID) values ('" + tstreet + "', '" + tcity + "', '" + tstate + "', '" + tzipCode + "', '" + taptNo + "', '" + tcustID + "', '" +tguestID + "')";
            int n1 = stmt.executeUpdate(sql);
            setStreet(tstreet);
            setCity(tcity);
            setState(tstate);
            setZipCode(tzipCode);
            setAptNo(taptNo);
            setCustID(tcustID);
            setGuestID(tguestID);
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
    
    public void updateDBC(String tstreet, String tcity, String tstate, String tzipCode, String taptNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "update Address set Street = '" + tstreet + "', City = '" + tcity + "', State = '" + tstate + "', ZipCode = '" + tzipCode + "', AptNo = '" + taptNo + "' where CustID = '" + custID + "'";
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
    
    public void updateDBG(String tstreet, String tcity, String tstate, String tzipCode, String taptNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "update Address set Street = '" + tstreet + "', City = '" + tcity + "', State = '" + tstate + "', ZipCode = '" + tzipCode + "', AptNo = '" + taptNo + "' where CustID = '" + guestID + "'";
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
    
    public void deleteDBC(String tcustID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Address where CustID = '" + tcustID + "'";
            
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
    
    public void deleteDBG(String tguestID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Address where GuestID = '" + tguestID + "'";
            
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
        System.out.println();
    }
}
