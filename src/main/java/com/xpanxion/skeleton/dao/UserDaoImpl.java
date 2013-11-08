package com.xpanxion.skeleton.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xpanxion.skeleton.dto.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> getAllUsers() {
        return this.sessionFactory.openSession().getNamedQuery("user.getAll").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserEntity getUser(String username) {
        List<UserEntity> users = this.sessionFactory.openSession().getNamedQuery("user.getAll").setString("username", username).list();
        return (users.isEmpty() ? null : users.get(0));
    }

    @Resource
    public void setSesionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }

}
