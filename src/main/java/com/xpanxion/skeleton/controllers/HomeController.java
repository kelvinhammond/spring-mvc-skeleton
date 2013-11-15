/**
 * 
 */
package com.xpanxion.skeleton.controllers;

import java.security.Principal;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.RoleBean;
import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.service.UserService;

/**
 * @author brian
 * @author kelvin
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public ModelAndView getHomePage(Principal principal) {
        ModelAndView mAndV = new ModelAndView("home");
        UserBean user = this.userService.getUser(principal.getName());
        if (user != null) {
            mAndV.addObject("user", user);
        }
        return mAndV;
    }

    @RequestMapping("/testadd")
    public ModelAndView getTestAddPage() {
        UserBean user = this.userService.getUser("test");
        if (user == null) {
            user = new UserBean();
            user.setUsername("test");
            user.setPassword("test");

            RoleBean role = new RoleBean();
            role.setName("user");
            HashSet<RoleBean> roles = new HashSet<RoleBean>(0);
            roles.add(role);
            user.setRoles(roles);

            this.userService.addUser(user);
        }

        ModelAndView mAndV = new ModelAndView("home");
        mAndV.addObject("user", user);
        return mAndV;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "login";
    }

}
