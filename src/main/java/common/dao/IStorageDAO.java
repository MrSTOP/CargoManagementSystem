package common.dao;

public interface IStorageDAO {
    boolean canSaleProduct(long productID, int count);
}
