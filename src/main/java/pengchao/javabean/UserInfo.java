package pengchao.javabean;

public class UserInfo {

    private long userID;
    private String userName;
    private String email;
    private String address;
    private String phone;

    public UserInfo() {
        this(-1, null, null, null, null);
    }

    public UserInfo(long userID, String userName, String phone, String email, String address) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}