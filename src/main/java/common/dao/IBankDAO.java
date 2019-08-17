package common.dao;

import java.math.BigDecimal;

public interface IBankDAO {
    BigDecimal getBankBalance();
    
    boolean setBankBalance(BigDecimal bankBalance);
    
    boolean bankBalanceAdd(BigDecimal add);
    
    boolean bankBalanceSub(BigDecimal sub);
}
