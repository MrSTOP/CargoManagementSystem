package common.dao;

public interface IAdministratorDAO {
    boolean checkAdministrator(String userName, String passwordEncrypted);
}
