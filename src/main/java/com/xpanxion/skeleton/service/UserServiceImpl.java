package com.xpanxion.skeleton.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpanxion.skeleton.dao.UserDao;
import com.xpanxion.skeleton.dto.beans.RoleBean;
import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.dto.entity.RoleEntity;
import com.xpanxion.skeleton.dto.entity.UserEntity;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public void addUser(UserBean userBean) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userBean.getId());
        userEntity.setUsername(userBean.getUsername());
        userEntity.setPassword(userBean.getPassword());

        Set<RoleEntity> roles = new HashSet<RoleEntity>(0);
        for (RoleBean roleBean : userBean.getRoles()) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setId(roleBean.getId());
            roleEntity.setName(roleBean.getName());
            roles.add(roleEntity);
        }
        userEntity.setRoles(roles);

        this.userDao.addUser(userEntity);
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        UserBean user = this.getUser(username);
        try {
            if (user != null && this.hashPassword(user.getPassword()).equals(this.hashPassword(password))) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // fall out
        }
        return false;
    }

    @Override
    public UserBean getUser(String username) {
        UserEntity userEntity = this.userDao.getUser(username);
        if (userEntity != null) {
            UserBean userBean = new UserBean();
            userBean.setId(userEntity.getId());
            userBean.setUsername(userEntity.getUsername());
            userBean.setPassword(userEntity.getPassword());

            Set<RoleBean> roles = new HashSet<RoleBean>(0);
            for (RoleEntity roleEntity : userEntity.getRoles()) {
                RoleBean roleBean = new RoleBean();
                roleBean.setId(roleEntity.getId());
                roleBean.setName(roleEntity.getName());
                roles.add(roleBean);
            }
            userBean.setRoles(roles);

            return userBean;
        }
        return null;
    }

    @Override
    public List<UserBean> getUsers() {
        List<UserEntity> users = this.userDao.getAllUsers();
        List<UserBean> output = new ArrayList<UserBean>();
        for (UserEntity entity : users) {
            UserBean bean = new UserBean();
            BeanUtils.copyProperties(entity, bean);
            output.add(bean);
        }
        return output;
    }

    @Override
    public String hashPassword(String password) throws UnsupportedEncodingException {
        // weak hash, should be much strong with salt in production
        return DigestUtils.sha512Hex(password.getBytes("UTF-8"));
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
