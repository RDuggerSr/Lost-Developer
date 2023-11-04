/********************************************************************
 * Name: Rodney Dugger Sr
 * Date: 11/04/23
 * Assignment: CIS319 Week 5 - Course Project
 * 
 * This is the interface between the Product Class and the SQLite database 
 * to handle all interactions with the Product class with the
 * database, including creating the table if it doesn't exist and all
 * CRUD (Create, Read Update, Delete) operations on the Product table.
 * Note that the interactions are all done using standard SQL syntax
 * that is then executed by the SQLite JDBC library.
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDb {
    
    public static boolean createTable(Connection conn) {
        //SQL statement for creating a new table
        String sql =
            "CREATE TABLE IF NOT EXISTS Products (\n"
            + "    ID integer PRIMARY KEY\n"
            + "    ,ProdID varchar(50)\n"
            + "    ,ProdName varchar(50)";
            /* + "    ,ProductDiscription varchar(50)\n"
            + "    ,ShipFromAddress varchar(50)\n"
            + "    ,LayOverAddress varchar(50)\n"
            + "    ,ShipToAddress varchar(50)\n"; */

        System.out.println(sql);

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void addProduct(Connection conn, Product p) {
        String sql =
            "INSERT INTO Products(ProdID, ProdName, ProdDescription) VALUES(?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, p.ProdID);
            pst.setString(2, p.ProdName);
            pst.setString(3, p.ProdDescription);
           /*  pst.setString(4, b.ShipFromAddress);
            pst.setString(5, b.LayOverAddress);
            pst.setString(6, b.ShipToAddress); */
            pst.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateProduct(Connection conn, Product p) {
        String sql = 
        "UPDATE Products SET ProdID=?, ProdName=?, ProdDescription =?, WHERE id =?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, p.ProdID);
            pst.setString(2, p.ProdName);
            pst.setString(3, p.ProdDescription);
           /*  pst.setString(4, b.ShipFromAddress);
            pst.setString(5, b.LayOverAddress);
            pst.setString(6, b.ShipToAddress); */
            pst.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteProduct(Connection conn, int id) {
        String sql = "DELETE from Products WHERE ID=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Product> getAllProducts(Connection conn) {
        ArrayList<Product> products = new ArrayList<Product>();
        String sql = "SELECT * FROM Products";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Product p = new Product(
                    rs.getInt("ID"), 
                    rs.getString("ProdID"),
                    rs.getString("ProdName"), 
                    rs.getString("ProdDescription"));
                    /* rs.getString("ShipFromAddress"), 
                    rs.getString("LayOverAddress"), 
                    rs.getString("ShipToAddress")); */
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    public static Product getProduct(Connection conn, int id) {
        Product p = new Product();
        String sql = "SELECT * FROM Products WHERE ID=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p.ID = rs.getInt("ID");
                p.ProdID = rs.getString("ProdID");
                p.ProdName = rs.getString("ProdName");
                p.ProdDescription = rs.getString("ProdDescription");
               /*  b.ShipFromAddress = rs.getString("ShipFroAddress");
                b.LayOverAddress = rs.getString("LayOverAddress");
                b.ShipToAddress = rs.getString("ShipToAddress"); */
            } else {
                p.ID = id;
                p.ProdID = "Not";
                p.ProdName = "Not";
                p.ProdDescription = "Not";
               /*  b.ShipFromAddress = "Not";
                b.LayOverAddress = "Not";
                b.ShipToAddress = "Not";  */
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return p;
    }
}


