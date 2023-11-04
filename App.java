/********************************************************************
 * Name: Rodney Dugger Sr
 * Date: 11/04/23
 * Assignment: CIS319 Week 5 - Course Project
 *
 * Main application class.
*/
import java.sql.Connection;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        final String dbName = "Dugger.db";
        System.out.println("\nRodney Dugger Sr, Week 5 Course Project\n");
        Connection conn = SQLiteDatabase.connect(dbName);

        if (conn != null) {
            if (BoatShippingCoDb.createTable(conn)) {
                //Create
                BoatShippingCoDb.addBoatShippingCo(conn, new BoatShippingCo("rm456", "ReadyMix", "80bl Bag"));
                BoatShippingCoDb.addBoatShippingCo(conn, new BoatShippingCo("pr321", "Prestressed", "Hardened"));
                BoatShippingCoDb.addBoatShippingCo(conn, new BoatShippingCo("pv907", "Pervious", "30% porous"));
                BoatShippingCoDb.addBoatShippingCo(conn, new BoatShippingCo("qs456", "QuickSet", "Hardens in 45 minutes")); 

                //Update
                BoatShippingCo boatShippingCoToUpdate = new BoatShippingCo(2,"pr500", "ReadyMix", "80bl Bag");
                BoatShippingCoDb.updateBoatShippingCo(conn, boatShippingCoToUpdate);
                BoatShippingCo updatedBoatShippingCo = BoatShippingCoDb.getBoatShippingCo(conn, boatShippingCoToUpdate.ID);
                System.out.println("\nUpdate BoatShippingCo");
                printBoatShippingCo(updatedBoatShippingCo);
                
                //Delete
                BoatShippingCoDb.deleteBoatShippingCo(conn, boatShippingCoToUpdate.ID);
                 BoatShippingCoDb.deleteBoatShippingCo(conn, 1);
                
                System.out.println("\nAll BoatShippingCos in the Database");
                printBoatShippingCos(BoatShippingCoDb.getAllBoatShippingCos(conn));

                System.out.println("\nBoatShippingCos in the Database by ID");
                printBoatShippingCo(BoatShippingCoDb.getBoatShippingCo(conn, 3));
                printBoatShippingCo(BoatShippingCoDb.getBoatShippingCo(conn, 4));

                System.out.println("\nAll BoatShippingCos using an invalid ID");
                printBoatShippingCo(BoatShippingCoDb.getBoatShippingCo(conn, -4));
                printBoatShippingCo(BoatShippingCoDb.getBoatShippingCo(conn, -9));
            
            }
        }
    }
    private static void printBoatShippingCos(ArrayList<BoatShippingCo> boatShippingCos) {
        for (BoatShippingCo b : boatShippingCos) {
            printBoatShippingCo(b); 
        }
    }
    

    private static void printBoatShippingCo(BoatShippingCo b) {
        System.out.println("\nBoatShippingCo " + b.ID + ": ");
        System.out.println("    " + b.ProdID);
        System.out.println("    " + b.ProdName);
        System.out.println("    " + b.ProdDescription);
       /*  System.out.println("    " + b.ShipFromAddress);
        System.out.println("    " + b.LayOverAddress);
        System.out.println("    " + b.ShipToAddress); */
    } 
}
