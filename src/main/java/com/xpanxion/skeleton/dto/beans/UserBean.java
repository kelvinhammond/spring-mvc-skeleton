package com.xpanxion.skeleton.dto.beans;

import java.util.Date;
import java.util.Set;

public class UserBean {

    private long id;

    private String username;

    private String firstname;

    private String lastname;

    private Date lastlogin;

    private Date currentlogin;

    private String password;

    private Set<RoleBean> roles;

    public String getFirstname() {
        return this.firstname;
    }

    public long getId() {
        return this.id;
    }

    public Date getLastlogin() {
        return this.lastlogin;
    }

    public String getLastname() {
        return this.lastname;
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Date getCurrentlogin() {
        return currentlogin;
    }

    public void setCurrentlogin(Date currentlogin) {
        this.currentlogin = currentlogin;
    }
}
