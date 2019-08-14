package yankunwei.dao;

import java.math.BigDecimal;
import java.util.List;

public interface IProductInfoDAO {
    List<Integer> getAllProductID();
    
    BigDecimal getProductSalePriceByID(int productID);
}
