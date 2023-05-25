package com.db.entity;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-22 10:52
 */
public class Administrator {
    private String username ;
    private String passwd;

    public Administrator(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
