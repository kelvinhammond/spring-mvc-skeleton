package com.xpanxion.skeleton.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xpanxion.skeleton.dto.entity.TestEntity;

@Repository
public class TestDaoImpl implements TestDao {

    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<TestEntity> getAllItems() {
        return this.sessionFactory.openSession().getNamedQuery("test.getAll").list();
    }

    @Resource
    public void setSesionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }
}
