package common.dao;

import yanzichao.bean.SupplierInfo;

import java.util.List;

public interface ISupplierInfoDAO {
    List<Long> getAllSupplierID();
    
    boolean deleteSupplier(long SupplierID);
    
    List<SupplierInfo> getAllSupplierInfo();
    
    boolean updateSupplier(SupplierInfo supplierInfo);
    
    SupplierInfo findSupplier(long SupplierID);
    
    boolean insertSupplier(SupplierInfo supplierInfo);
}
