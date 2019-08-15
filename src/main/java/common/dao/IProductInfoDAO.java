package common.dao;

import java.math.BigDecimal;
import java.util.List;

public interface IProductInfoDAO {
    List<Long> getAllProductID();
    
    BigDecimal getProductSalePriceByID(long productID);
}
