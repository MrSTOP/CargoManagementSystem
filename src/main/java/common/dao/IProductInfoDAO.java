package common.dao;

import yankunwei.javabean.ProductInfo;

import java.math.BigDecimal;
import java.util.List;

public interface IProductInfoDAO {
    List<Long> getAllProductID();
    
    BigDecimal getProductSalePriceByID(long productID);
    
    BigDecimal getProductBuyPriceByID(long productID);
    
    ProductInfo getProductInfoByID(long productID);
    
    long getSupplierByID(long productID);
    
    boolean insertProduct(ProductInfo productInfo);
    
    boolean updateProduct(ProductInfo productInfo);
    
    boolean deleteProduct(ProductInfo productInfo);
    
    boolean deleteProductByID(long productID);
    
    List<ProductInfo> getAllProductInfo();
}
