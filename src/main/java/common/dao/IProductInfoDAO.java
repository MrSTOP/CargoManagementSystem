package common.dao;

import yankunwei.javabean.ProductInfo;

import java.math.BigDecimal;
import java.util.List;

public interface IProductInfoDAO {
    List<Long> getAllProductID();
    
    BigDecimal getProductSalePriceByID(long productID);
    
    boolean insertProduct(ProductInfo productInfo);
    
    List<ProductInfo> getAllProductInfo();
}
