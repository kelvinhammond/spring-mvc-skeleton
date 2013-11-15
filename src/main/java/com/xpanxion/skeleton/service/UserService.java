package com.xpanxion.skeleton.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.xpanxion.skeleton.dto.beans.UserBean;

public interface UserService {

    void addUser(UserBean userBean);

    boolean authenticateUser(String username, String password);

    UserBean getUser(String username);

    List<UserBean> getUsers();

    String hashPassword(String password) throws UnsupportedEncodingException;
}
