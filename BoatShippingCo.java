/**************************************************************
 * Name: Rodney Dugger Sr
 * Date: 11/04/23
 * Assignment: CIS319 Week 5 - Course Project
 * 
 * This is the BoatShippingCo class and it extends the Product class. There
 * are 5 parameters added including 1 ArrayList composition element of 
 * type Transport_Industry. Two constructors are provided as well as
 * getters and setters for access to its parameters. Methods are added
 * to add and remove elements from the Boats ArrayList. A tostring is
 * also added for formatting a string for any class that may need it.
 */

public class BoatShippingCo extends Product {
    public int ID;
   /*  public String ShipFromAddress;
    public String LayOverAddress;
    public String ShipToAddress; */
    //private ArrayList<Transport_Industry> Boats;

    public BoatShippingCo(int iD, String prodID, String prodName, String prodDescription) {
            super(prodID,prodName,prodDescription);
        ID = iD;
       /*  ShipFromAddress = shipFromAddress;
        LayOverAddress = layOverAddress;
        ShipToAddress = shipToAddress; */
    }

    public BoatShippingCo(String prodID, String prodName, String prodDescription) {
            super(prodID,prodName,prodDescription);
       /*  ShipFromAddress = shipFromAddress;
        LayOverAddress = layOverAddress;
        ShipToAddress = shipToAddress; */
    }

   /*  public BoatShippingCo(int totalDemandQty, int totalExcessQty, double sellersPrice, 
            double buyersOffer, double auctionPrice) {
            super(totalDemandQty,totalExcessQty,sellersPrice,buyersOffer,auctionPrice);
    }
    */
    
    public BoatShippingCo() { 
           
    }
    
    //Getters and setters
    /* public String getShipFromAddress() {
        return ShipFromAddress;
    }
    public void setShipFromAddress(String shipFromAddress) {
        ShipFromAddress = shipFromAddress;
    }

    public String getLayOverAddress() {
        return LayOverAddress;
    }
    public void setLayOverAddress(String layOverAddress) {
        LayOverAddress = layOverAddress;
    }

    public String getShipToAddress() {
        return ShipToAddress;
    }
    public void setShipToAddress(String shipToAddress) {
        ShipToAddress = shipToAddress;
    }
     */


    //Get the full concrete manifest for the shipping frait
   /*  public ArrayList<Transport_Industry> getTrucks() {
        return Boats;
    }
    //Add a concrete using a concrete object
    public void addTransport_Industry(Transport_Industry val) {
        Boats.add(val);
    }
    //Add a concrete by creating one based on parameters
    public void addTransport_Industry(String shippingFraitID, String transpoterName, String transporterPhoneNum) {
        Boats.add(new Transport_Industry(shippingFraitID, transpoterName, transporterPhoneNum));
    }
    //Remove any concrete product from manifest that match the provided prodID
    public void removeTransport_Industry(String shippingFraitID) {
        Boats.removeIf(n -> (n.getShippingFraitID() == shippingFraitID));
    }
 */
    // public String toString() {
    //     return String.format("This is my: %s%nProductID: %s%nProduct Name: %s%n" +
    //         "Product Discription :%s%nBeing Shipped From: %s%n" +
    //         "Shippment Stopped at: %s%nShipment Destination: %s%n",
    //         getClass(), super.getProdID(), super.getProdName(), super.getProductDescription());
    // }
}
