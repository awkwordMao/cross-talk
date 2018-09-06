package cn.hero.model;

/**
 * visitor 实体类
 * Author: lijie
 * CreatTime: 2018/9/5
 */
public class User {

    private Integer userId;
    private String userName;
    private String password;

    public User() {
    }

    public Integer getId() {
        return userId;
    }

    public void setId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
