package com.xpanxion.skeleton.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@NamedQuery(name = "roles.getAll", query = "from RoleEntity")
public class RoleEntity {

    private long id;
    private String name;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    public long getId() {
        return this.id;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return this.name;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
