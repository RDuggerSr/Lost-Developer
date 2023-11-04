/********************************************************************
* Name: Rodney Dugger Sr
 * Date: 11/04/23
 * Assignment: CIS319 Week 5 - Course Project
 * 
 * Class to handle all interactions with the Persons table in the
 * database, including creating the table if it doesn't exist and all
 * CRUD (Create, Read Update, Delete) operations on the Persons table.
 * Note that the interactions are all done using standard SQL syntax
 * that is then executed by the SQLite JDBC library.
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BoatShippingCoDb {
    
    public static boolean createTable(Connection conn) {
        //SQL statement for creating a new table
        String sql =
            "CREATE TABLE IF NOT EXISTS BoatShippingCos (\n"
            + "    ID integer PRIMARY KEY\n"
            + "    ,ProdID varchar(50)\n"
            + "    ,ProdName varchar(50)\n"
            + "    ,ProductDiscription varchar(50)";
            /* + "    ,ShipFromAddress varchar(50)\n"
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

    public static void addBoatShippingCo(Connection conn, BoatShippingCo b) {
        String sql =
            "INSERT INTO BoatShippingCos(ProdID, ProdName, ProdDescription) VALUES(?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, b.ProdID);
            pst.setString(2, b.ProdName);
            pst.setString(3, b.ProdDescription);
            /* pst.setString(4, b.ShipFromAddress);
            pst.setString(5, b.LayOverAddress);
            pst.setString(6, b.ShipToAddress); */
            pst.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateBoatShippingCo(Connection conn, BoatShippingCo b) {
        String sql = 
        "UPDATE BoatShippingCos SET ProdID=?, ProdName=?, ProdDescription =?, WHERE id =?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, b.ProdID);
            pst.setString(2, b.ProdName);
            pst.setString(3, b.ProdDescription);
           /*  pst.setString(4, b.ShipFromAddress);
            pst.setString(5, b.LayOverAddress);
            pst.setString(6, b.ShipToAddress); */
            pst.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteBoatShippingCo(Connection conn, int id) {
        String sql = "DELETE from BoatShippingCos WHERE ID=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<BoatShippingCo> getAllBoatShippingCos(Connection conn) {
        ArrayList<BoatShippingCo> boatShippingCos = new ArrayList<BoatShippingCo>();
        String sql = "SELECT * FROM BoatShippingCos";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                BoatShippingCo b = new BoatShippingCo(
                    rs.getInt("ID"), 
                    rs.getString("ProdID"),
                    rs.getString("ProdName"), 
                    rs.getString("ProdDescription"));
                   /*  rs.getString("ShipFromAddress"), 
                    rs.getString("LayOverAddress"), 
                    rs.getString("ShipToAddress")); */
                boatShippingCos.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return boatShippingCos;
    }

    public static BoatShippingCo getBoatShippingCo(Connection conn, int id) {
        BoatShippingCo b = new BoatShippingCo();
        String sql = "SELECT * FROM BoatShippingCos WHERE ID=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                b.ID = rs.getInt("ID");
                b.ProdID = rs.getString("ProdID");
                b.ProdName = rs.getString("ProdName");
                b.ProdDescription = rs.getString("ProdDescription");
               /*  b.ShipFromAddress = rs.getString("ShipFroAddress");
                b.LayOverAddress = rs.getString("LayOverAddress");
                b.ShipToAddress = rs.getString("ShipToAddress"); */
            } else {
                b.ID = id;
                b.ProdID = "Not";
                b.ProdName = "Not";
                b.ProdDescription = "Not";
               /*  b.ShipFromAddress = "Not";
                b.LayOverAddress = "Not";
                b.ShipToAddress = "Not";  */
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return b;
    }
}

