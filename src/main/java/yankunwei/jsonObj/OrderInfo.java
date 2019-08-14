package yankunwei.jsonObj;

public class OrderInfo {
    private int userID = 0;
    private int productID = 0;
    private int productCount = 0;
    
    public OrderInfo() {
    }
    
    public OrderInfo(int userID, int productID, int productCount) {
        this.userID = userID;
        this.productID = productID;
        this.productCount = productCount;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public int getProductID() {
        return productID;
    }
    
    public int getProductCount() {
        return productCount;
    }
    
    @Override
    public String toString() {
        return "userID:" + userID + "productID:" + productID + "productCount:" + productCount;
    }
}
