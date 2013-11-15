package com.xpanxion.skeleton.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xpanxion.skeleton.dto.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(UserEntity user) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> getAllUsers() {
        return this.sessionFactory.openSession().getNamedQuery("user.getAll").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserEntity getUser(String username) {
        List<UserEntity> users = this.sessionFactory.openSession().getNamedQuery("user.getByUsername").setString("username", username).list();
        return (users.isEmpty() ? null : users.get(0));
    }

}
