package com.xpanxion.skeleton.dto.beans;

public class UserBean {

    private long id;

    private String username;

    private String password;

    public long getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}