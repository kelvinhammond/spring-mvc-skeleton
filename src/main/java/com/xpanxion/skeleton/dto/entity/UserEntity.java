package com.xpanxion.skeleton.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({ @NamedQuery(name = "user.getAll", query = "from UserEntity"), @NamedQuery(name = "user.getByUsername", query = "from UserEntity where username = :username") })
public class UserEntity {

    private long id;
    private String username;
    private String password;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    public long getId() {
        return this.id;
    }

    @Column
    public String getPassword() {
        return this.password;
    }

    @Column
    public String getUsername() {
        return this.username;
    }

    /**
     * @param id
     *            the id to set
     */
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
