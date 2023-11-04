/********************************************************************
 * Name: Rodney Dugger Sr
 * Date: 11/04/23
 * Assignment: CIS319 Week 5 - Course Project
 *
 *
 * This is the Product class and it implements the Interface class
 * adds 9 additional parameters and 3 constructors as well as getters 
 * and setters for access to its parameters.
 */

public class Product {
    public int ID;
    public String ProdID;
    public String ProdName;
    public String ProdDescription;
    //private double ProdPrice;
    /* private int TotalDemandQty;
    private int TotalExcessQty;
    private double SellersPrice;
    private double BuyersOffer;
    private double AuctionPrice;
     */
    public Product(int iD, String prodID, String prodName, String prodDescription) {
        ProdID = prodID;
        ProdName = prodName;
        ProdDescription = prodDescription;
        //ProdPrice = productPrice;
    }
    public Product(String prodID, String prodName, String prodDescription) {        
    }
    
   /*   public Product(int totalDemandQty, int totalExcessQty, double sellersPrice, 
            double buyersOffer, double auctionPrice) {
        TotalDemandQty = totalDemandQty;
        TotalExcessQty = totalExcessQty;
        SellersPrice = sellersPrice;
        BuyersOffer = buyersOffer;
        AuctionPrice = auctionPrice;
       }
    */

    public Product() {
        
    }
    //Getters and setters
    public String getProdID() {
        return ProdID;
    }
    public void setProdID(String prodID) {
        ProdID = prodID;
    }

    public String getProdName() {
        return ProdName;
    }
    public void setProdName(String prodName) {
        ProdName = prodName;
    }

    public String getProductDescription() {
        return ProdDescription;
    }
    public void setProdDescription(String prodDescription) {
        ProdDescription = prodDescription;
    }

    /* public double getProdPrice() {
        return ProdPrice;
    }
    public void setProdPrice(double prodPrice) {
        ProdPrice = prodPrice;
    }

    public int getTotalDemandQty() {
          return TotalDemandQty;    //ProdID.Concrete_Inventory.DemandQty;
        
    }
    public void setTotalDemandQty(int totalDemandQty) {
        TotalDemandQty = totalDemandQty; //ProdID.Concrete_Inventory.totalDemand;
    }

    public int getTotalExcessQty() {
        return TotalExcessQty;
    }
    public void setTotalExcessQty(int totalExcessQty) {
        TotalExcessQty = totalExcessQty; //ProdID.Congrete_Inventory.ExcessQty;
    }

    public double getBuyersOffer() {
        return BuyersOffer;
    }
    public void setBuyersOffer(double buyersOffer) {
        BuyersOffer = buyersOffer; //ProdID.Concrete_Inventory.BestPrice
    } 

    public double getSellersPrice() {
        return SellersPrice;
    }
    public void setSellersPrice(double sellersPrice) {
        SellersPrice = sellersPrice;
    }

    public double getAuctionPrice() {
        return AuctionPrice;
    }
    public void setAuctionPrice(double auctionPrice) {
        AuctionPrice = auctionPrice;
    }
 */
//    // @Override
//     public String getCompanyInfo() {
//         return String.format("");
//     }
//    // @Override
//     public String getProductsInfo() {
//         return String.format("The product information for this company:");
//     }
//    // @Override
//     public String getPersonsInfo() {
//         return String.format("The sellers price for this product is: %s" +
//                 "%nThe buyers offer price is: %s%nThe auction prise for this product is: " +
//                 "%s%n");
//     }
    
//     @Override
//     public String toString() {
//         return String.format("This is my %s%nHere you can find your Company" +
//         " Information:%n%s%nHere you can find your product information:%n%s" +
//         "%nHere you can find your Persons Member Information:%n%s", getClass(),
//         getCompanyInfo(), getProductsInfo(), getPersonsInfo());
//     } 
}
