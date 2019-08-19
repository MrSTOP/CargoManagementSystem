package common;


import yanzichao.bean.SupplierInfo;

import java.math.BigDecimal;
import java.util.List;

public interface ISupplierDAO {
    List<Long> getAllSupplierID();

    boolean delterSupplier(long SupplierID);

    List<SupplierInfo> getAllSupplierInfo();

    boolean updateSupplier(SupplierInfo supplierInfo);

    SupplierInfo findSupplier(long SupplierID);

    boolean insertSupplier(SupplierInfo supplierInfo);

}
