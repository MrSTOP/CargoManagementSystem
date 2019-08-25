package common.dao;

import yankunwei.javabean.ProductInfo;

public interface IStorageDAO {
    boolean insertNewProduct(ProductInfo productInfo);
    
    boolean addProductCount(long productID, int count);
    
    boolean decProductCount(long productID, int count);
}
