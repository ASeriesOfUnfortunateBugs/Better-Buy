package Business;
import java.sql.*;
import java.util.ArrayList;

/**
 * Advance System Project
 * Constantaras / Blaine
 */
public class Customer extends Person {
    private String custID, username, password, email;
    private String databaseURL = "jdbc:ucanaccess://C:/WebSysProject.accdb";
    ArrayList<Address> custAddy = new ArrayList<>();
    ArrayList<Billing> custBilling = new ArrayList<>();
    ArrayList<Order> oArray = new ArrayList<>();
    ArrayList<Products> prodInfo = new ArrayList<>();
    
    public Customer() {
        custID = "";
        username = "";
        password = "";
        email = "";
    }
    
    public Customer(String tcustID, String tusername, String tpassword, String temail) {
        custID = tcustID;
        username = tusername;
        password = tpassword;
        email = temail;
    }
    
    //testing
    public static void main(String arg[]) {
//        Customer c1 = new Customer();
//        c1.selectDBC(null);
//        
//        Order order;
//        Products product;
//       
//        
//        for (int i = 0; i < c1.oArray.size(); i++) {
//			order = c1.oArray.get(i);
//			product = c1.prodInfo.get(i);
//			
//			
//			System.out.println(order.getOrderNo());
//			System.out.println(product.getProdname());
//			System.out.println();
//		}
    }

    
    //get and set variables
    public void setCustID(String tcustID) { custID = tcustID; }
    public String getCustID() { return custID; }
    
    public void setUsername(String tusername) { username = tusername; }
    public String getUsername() { return username; }
    
    public void setPassword(String tpassword) { password = tpassword; }
    public String getPassword() { return password; }
    
    public void setEmail(String temail) { email = temail; }
    public String getEmail() { return email; }

// Create Customer ID //
    
    public void createID() {
        int x;
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select CustID from Customers");
            
            while(rs.next()) {
                setCustID(rs.getString(1));
            }
            
            if (custID.isEmpty()) {
                x = 1;
            }
            else {
                custID = custID.replaceAll("[^0-9]", "");
                x = Integer.parseInt(custID);
                x++;
            }
            
            custID = "C" + Integer.toString(x);
            System.out.println("id = " + custID);
            con.close();  
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

// Select DB //
    
	public void selectDBC(String tusername) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con = DriverManager.getConnection(databaseURL);
			Statement stmt = con.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select * from Customers where UserName = '" + tusername + "'");
			rs.next();
			setCustID(rs.getString(2));
			setUsername(rs.getString(1));
			setPassword(rs.getString(3));
			setEmail(rs.getString(4));
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		// Invoke getOrders method (Jah)
		//getOrders();
		//getProductInfo();
	}
    
// Insert DB //
    
    public void insertDBC(String tcustID, String tusername, String tpassword, String temail) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Customers (CustID, UserName, Password, Email) values ('" + tcustID + "', '" + tusername + "', '" + tpassword + "', '" + temail + "')";
            int n1 = stmt.executeUpdate(sql);
            
            if (n1 == 1)
                System.out.println("INSERT Successful!!!");
            else
                System.out.println("INSERT FAILED***********");
            
            setCustID(tcustID);
            setUsername(tusername);
            setPassword(tpassword);
            setEmail(temail);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

// Update DB //
    
    public void updateDBC(String tusername, String tpassword, String temail) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "update Customers set UserName = '" + tusername + "', Password = '" + tpassword + "', Email = '" + temail + "' where CustID = '" + custID + "'";
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
    
    public void deleteDBC() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Customers where CustID = '" + custID + "'";
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
    
    public void displayC() {
        System.out.println("Customer ID: " + custID);
        System.out.println("Username   : " + username);
        System.out.println("Password   : " + password);
        System.out.println("Email      : " + email);
    }
    
    /*
     * Coded by: Elijah A
     * Used to collect customers address
     */
    protected void getAddress() {
    	try {
	    	// Load JDBC driver
	    	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	    	
	    	// Connect to database
	    	Connection con = DriverManager.getConnection(databaseURL);
	    	
	    	// Create and execute SQL query
	    	Statement stmt = con.createStatement();
	    	String sql = "select * from Address where CustID = '" + getCustID() + "'";
	    	ResultSet result = stmt.executeQuery(sql);
	    	
	    	String custID;
	    	Address addy;
	    	while (result.next()) {
	    		custID = result.getString("CustID");
	    		addy = new Address();
	    		addy.selectDBC(custID);
	    		custAddy.add(addy);
	    	}
		}
		catch (Exception e) {
			e.printStackTrace();
		}    	
    }

    // Gets all the orders of a customer regardless of status; coded by Elijah 
    protected void getOrders() {
        try {
            // Establishes connection to database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);

            // Create and excute SQL query
            Statement stmt = con.createStatement();
            String sql = "select * from Orders where CustID = '" + getCustID() + "'";
            ResultSet result = stmt.executeQuery(sql);

            // Initialising variables
            String prodNo;
            Order order;

            // Checks for orders and adds to custOrdList
            while (result.next()) {
                prodNo = result.getString("ProductNo");
                order = new Order();
                order.selectDBbyProdNo(prodNo);
                oArray.add(order);
            }

        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    /*
     * Coded by: Elijah A
     * Used to collect product info for selected order
     */
    protected void getProductInfo() {
    	try {
	    	// Load JDBC driver
	    	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	    	
	    	// Connect to database
	    	Connection con = DriverManager.getConnection(databaseURL);
	    	
	    	// Create and execute SQL query
	    	Statement stmt = con.createStatement();
	    	String sql = "select * from Orders where CustID = '" + getCustID() + "'";
	    	ResultSet result = stmt.executeQuery(sql);
	    	
	    	String prodNo;
	    	Products prod;
	    	while (result.next()) {
	    		prodNo = result.getString("ProductNo");
	    		prod = new Products();
	    		prod.selectDB(prodNo);
	    		prodInfo.add(prod);
	    	}
		}
		catch (Exception e) {
			e.printStackTrace();
		}    	
    }
}
