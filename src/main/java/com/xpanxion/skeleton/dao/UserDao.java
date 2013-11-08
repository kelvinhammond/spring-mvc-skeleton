package com.xpanxion.skeleton.dao;

import java.util.List;

import com.xpanxion.skeleton.dto.entity.UserEntity;

public interface UserDao {

    List<UserEntity> getAllUsers();

    UserEntity getUser(String username);
}
