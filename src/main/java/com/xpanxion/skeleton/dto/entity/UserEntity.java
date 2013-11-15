package com.xpanxion.skeleton.dto.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "user.getAll", query = "from UserEntity"), @NamedQuery(name = "user.getByUsername", query = "from UserEntity where username = :username") })
public class UserEntity {

    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Date lastlogin;
    private Set<RoleEntity> roles = new HashSet<RoleEntity>(0);

    @Column
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    public long getId() {
        return this.id;
    }

    @Column
    public Date getLastlogin() {
        return this.lastlogin;
    }

    @Column
    public String getLastname() {
        return this.lastname;
    }

    @Column
    public String getPassword() {
        return this.password;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = true, updatable = false) })
    public Set<RoleEntity> getRoles() {
        return this.roles;
    }

    @Column(unique = true, nullable = false)
    public String getUsername() {
        return this.username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @param id
     *            the id to set
     */
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

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
