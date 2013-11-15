package com.xpanxion.skeleton.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpanxion.skeleton.dto.beans.RoleBean;
import com.xpanxion.skeleton.dto.beans.UserBean;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;

    public Collection<? extends GrantedAuthority> getAuthorities(Set<RoleBean> roles) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(0);
        for (RoleBean role : roles) {
            authList.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toUpperCase()));
        }
        return authList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean user = this.userService.getUser(username);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, this.getAuthorities(user.getRoles()));
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
