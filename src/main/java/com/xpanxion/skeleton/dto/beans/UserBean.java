package com.xpanxion.skeleton.dto.beans;

import java.util.Set;

public class UserBean {

    private long id;

    private String username;

    private String password;

    private Set<RoleBean> roles;

    public long getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public Set<RoleBean> getRoles() {
        return this.roles;
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

    public void setRoles(Set<RoleBean> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
