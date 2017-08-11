package base.model;

import java.io.Serializable;

/**
 * @Author: luoyi
 * @Description:
 * @Date: 14:04 2017/8/2
 * @Version: 1.0.0
 * @Modified By: xxx
 */
public class UserInfo implements Serializable {


    private int Id;

     private String username;

     private String phone;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
