package Business;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Advance System Project
 * Constantaras / Blaine
 */

public class Order {
    private int quantity;
    private String orderNo, productNo, custID, status;
    private String databaseURL = "jdbc:ucanaccess://C:/WebSysProject.accdb";
    public ArrayList<Order> olist = new ArrayList<>();
//    public OrderList olist = new OrderList();
    
    public Order() {
        orderNo = "";
        custID = "";
        productNo = "";
        quantity = 0;
        status = "";
    }
    
    public Order(String torderNo, String tcustID, String tproductNo, int tquantity, String tstatus) {
        orderNo = torderNo;
        custID = tcustID;
        productNo = tproductNo;
        quantity = tquantity;
        status = tstatus;
    }
    
    //testing
    public static void main(String arg[]) {
        Order o = new Order();
//        //o.selectDB("1");
        o.getOrders();
//        //o.display();
    	
//    	Order order = new Order();
//    	Order order1 = new Order();
//    	order.selectDB("O123");
//    	order1.selectDB("O125");
    }
    
    //get and set variables
    public void setOrderNo(String torderNo) { orderNo = torderNo;}
    public String getOrderNo() { return orderNo; }
    
    public void setCustID(String tcustID) { custID = tcustID; }
    public String getCustID() { return custID; }
    
    public void setProductNo(String tproductNo) { productNo = tproductNo; }
    public String getProductNo() { return productNo;}
    
    public void setQuantity(int tquantity) { quantity = tquantity; }
    public int getQuantity() { return quantity; }
    
    public void setStatus(String tstatus) { status = tstatus; }
    public String getStatus() { return status; }
    
// Get Orders //
    public void getOrders() {
        String on;
        Order o1;
        
        try {
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select OrderNo from Orders where Status <> 'Picked up'");
   
            while (rs.next()) {
                
                on = rs.getString(1);
                System.out.println(on);
                o1 = new Order();
                o1.selectDB(on);
                olist.add(o1); // Modified addOrder() to add(); made olist an instance of ArrayList<> � Elijah A
                o1.display();
            }
            con.close();
        }
        catch(Exception e) {
            System.out.println("...Error in getOrders Method");
        }
    }
    
    
// Select DB //
    
    public void selectDB(String tOrderNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Orders where OrderNo = '" + tOrderNo + "'");
            rs.next();
            setOrderNo(rs.getString(1));
            setCustID(rs.getString(2));
            setProductNo(rs.getString(3));
            setQuantity(rs.getInt(4));
            setStatus(rs.getString(5));
                    
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    /*
     * Coded by: Elijah A
     * Selects data in "Orders" table by ProductNo
     */
    public void selectDBbyProdNo(String productNo) {
    	this.productNo = productNo;
    	
    	try {
    		// Load drivers
    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet result;
            result = stmt.executeQuery("Select * from Orders where ProductNo = '" + getProductNo() + "'"); // SQL query initialisation + execution
            result.next();
            
            // Stores results in setter methods
            setOrderNo(result.getString("OrderNo"));
            setCustID(result.getString("CustID"));
            setQuantity(result.getInt("Quantity"));
            setStatus(result.getString("Status"));
            
            // Closes connection
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
    
// Insert DB //
    // I do not know how to insert because of the foreign key I think?
    //
    public void insertDB(String orderNo, String custID, String productNo, int quantity, String status) {
    	// Initialise variables by Jah
    	this.orderNo = orderNo;
    	this.custID = custID;
    	this.productNo = productNo;
    	this.quantity = quantity;
    	this.status = status;
    	
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = String.format("insert into Orders (OrderNo, CustID, ProductNo, Quantity, Status) "
            		+ "values ('%s', '%s', '%s', %s, '%s')", getOrderNo(), getCustID(), getProductNo(), getQuantity(), getStatus());
            
            int n1 = stmt.executeUpdate(sql);
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
    
    public void updateDB(String tcustID, String tproductNo, int tquantity, String tstatus) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "update Orders set CustID = '" + tcustID + "', ProductNo = '" + tproductNo + "', Quantity = " + tquantity + ", Status = '" + tstatus + "' where OrderNo = " + orderNo;            
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
    
    public void deleteDB(String torderNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Orders where OrderNo = " + torderNo;
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
        System.out.println("Order Number  : " + orderNo);
        System.out.println("Customer ID   : " + custID);
        System.out.println("Product Number: " + productNo);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Status        : " + status);
    }
}
