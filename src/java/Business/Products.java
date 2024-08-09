package Business;
import java.sql.*;

/*******************
 * Adv Sys Proj
 * Products.java
 ******************/

public class Products {
    
    private String prodno;
    private String prodname;
    private String proddesc;
    private int catID;
    private int quantity;
    private double price;
    private String prodimg;
    private String databaseURL = "jdbc:ucanaccess://C:/WebSysProject.accdb";

    public Products(String prodno, String prodname, String proddesc, int catID,  int quantity, double price, String prodimg) {

        this.prodno = prodno;
        this.prodname = prodname;
        this.proddesc = proddesc;
        this.catID = catID;
        this.quantity = quantity;
        this.price = price;
        this.prodimg = prodimg;
    }

    public Products() {

        prodno = "";
        prodname = "";
        proddesc = "";
        catID = 0;
        quantity = 0;
        price = 0;
        prodimg = "";
    }

    //testing
    public static void main(String arg[]) {
        Products p = new Products();
        p.selectDB("DVD48512");
    }
    
// Get, Set //

    public void setProdno( String Prodno ) { prodno = Prodno; }
    public String getProdno() { return prodno; }

    public void setProdname( String Prodname ) { prodname = Prodname; }
    public String getProdname() { return prodname; }

    public void setProddesc( String Proddesc ) { proddesc = Proddesc; }
    public String getProddesc() { return proddesc; }

    public void setCatID(int CatID) { catID = CatID;}
    public int getCatID() { return catID; }
    
    public void setQuantity( int Quantity ) { quantity = Quantity; }
    public int getQuantity() { return quantity; }

    public void setPrice( double Price ) { price = Price; }
    public double getPrice() { return price; }

    public void setProdimg( String Prodimg ) { prodimg = Prodimg; }
    public String getProdimg() { return prodimg; }

// Select DB //
    
    public void selectDB(String tprodno) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Products where ProductNo = '" + tprodno + "'");
            rs.next();
            setProdno(rs.getString(1));
            setProdname(rs.getString(2));
            setProddesc(rs.getString(3));
            setCatID(rs.getInt(7));
            setQuantity(rs.getInt(4));
            setPrice(rs.getDouble(5));
            setProdimg(rs.getString(6));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    
    public void insertDB(String tprodno, String tprodname, String tproddesc, int tcatID, int tquantity, double tprice, String tprodimg) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Products (ProductNo, ProductName, ProductDesc, CategoryID, Quantity, Price, ProductImg) values ('" + tprodno + "', '" + tprodname + "', '" + tproddesc + "', " + tcatID + ", " + tquantity + ", " + tprice + ", '" + tprodimg + "')";
            int n1 = stmt.executeUpdate(sql);
            setProdno(tprodno);
            setProdname(tprodname);
            setProddesc(tproddesc);
            setCatID(tcatID);
            setQuantity(tquantity);
            setPrice(tprice);
            setProdimg(tprodimg);
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
    
    public void updateDB(String tprodname, String tproddesc, int tcatID, int tquantity, double tprice, String tprodimg) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "update Products set ProductName = '" + tprodname + "', ProductDesc = '" + tproddesc + "', CategoryID = " + tcatID + ", Quantity = " + tquantity + ", Price = " + tprice + ", Productimg = '" + tprodimg + "' where ProductNo = '" + prodno + "'";
            int n1 = stmt.executeUpdate(sql);
            setProdname(tprodname);
            setProddesc(tproddesc);
            setCatID(tcatID);
            setQuantity(tquantity);
            setPrice(tprice);
            setProdimg(tprodimg);
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
    
    public void deleteDB(String tprodno) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Products where ProductNo = '" + tprodno + "'";
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
        System.out.println("Product Number: " + prodno);
        System.out.println("Product Name: " + prodname);
        System.out.println("Product Desc: " + proddesc);
        System.out.println("Category ID: " + catID);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        System.out.println("Product Img: " + prodimg);
    }

}
