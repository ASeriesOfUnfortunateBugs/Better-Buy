package Business;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Advance System Project
 * Constantaras / Blaine
 */

public class Billing {
    private String guestID, custID, expDate, cardNo;
    private int shippingNo, cvv;
    private String databaseURL = "jdbc:ucanaccess://C:/WebSysProject.accdb";
    
    public Billing() {
        guestID = "";
        custID = "";
        shippingNo = 0;
        cardNo = "";
        cvv = 0;
        expDate = "";
    }
    
    public Billing(String tguestID, String tcustID, int tshippingNo, String tcardNo, int tcvv, String texpDate) {
        guestID = tguestID;
        custID = tcustID;
        shippingNo = tshippingNo;
        cardNo = tcardNo;
        cvv = tcvv;
        expDate = texpDate;
    }
    
    //testing
    public static void main(String arg[]) {
        Billing b = new Billing();
        b.insertDB(123, "123", "", "1111111111111111", 0, "10-01-2020");
        b.display();
    }
    
    //get and set variables
    public void setGuestID(String tguestID) { guestID = tguestID; }
    public String getGuestID() { return guestID; }
    
    public void setCustID(String tcustID) { custID = tcustID; }
    public String getCustID() { return custID; }
    
    public void setShippingNo(int tshippingNo) { shippingNo = tshippingNo; }
    public int getShippingNo() { return shippingNo; }
    
    public void setCardNo(String tcardNo) { cardNo = tcardNo; }
    public String getCardNo() { return cardNo; }
    
    public void setCVV(int tcvv) { cvv = tcvv; }
    public int getCVV() { return cvv; }
    
    public void setExpDate(String texpDate) { expDate = texpDate; }
    public String getExpDate() { return expDate; }
 
// Select DB //
    //need to find which one is correct
    public void selectDB(int tshippingNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Billing where ShippingNo = " + tshippingNo);
            rs.next();
            setShippingNo(rs.getInt(1));
            setCustID(rs.getString(2));
            setGuestID(rs.getString(3));
            setCardNo(rs.getString(4));
            setCVV(rs.getInt(5));
            setExpDate(rs.getString(6));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    //dont know how to get the credit card number to fit
    public void insertDB(int tshippingNo, String tcustID, String tguestID, String tcardNo, int tcvv, String texpDate) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Billing (ShippingNo, CustID, GuestID, CreditCardNo, CVV, ExpDate) values (" + tshippingNo + ", '" + tcustID + "', '" + tguestID + "', " + tcardNo + ", " + tcvv + ", '" + texpDate + "')";
            int n1 = stmt.executeUpdate(sql);
            setShippingNo(tshippingNo);
            setCustID(tcustID);
            setGuestID(tguestID);
            setCardNo(tcardNo);
            setCVV(tcvv);
            setExpDate(texpDate);
            
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
    
    public void updateDB(String tcustID, String tguestID, String tcardNo, int tcvv, String texpDate) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "update Billing set CustID = '" + tcustID + "', GuestID = '" + tguestID + "', CreditCardNo = '" + tcardNo + "', CVV = " + tcvv + ", ExpDate = '" + texpDate + "' where ShippingNo = " + shippingNo;
            int n1 = stmt.executeUpdate(sql);
            setCustID(tcustID);
            setGuestID(tguestID);
            setCardNo(tcardNo);
            setCVV(tcvv);
            setExpDate(texpDate);
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
    
    public void deleteDB(int tshippingNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Billing where ShippingNo = " + tshippingNo;
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
        System.out.println("Shipping Number: " + shippingNo);
        System.out.println("Customer ID: " + custID);
        System.out.println("Guest ID: " + guestID);
        System.out.println("Credit Card Number: " + cardNo);
        System.out.println("CVV: " + cvv);
        System.out.println("Expire Date: " + expDate);
    }
}
