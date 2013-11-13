/**
 * 
 */
package com.xpanxion.skeleton.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.service.UserService;

/**
 * @author brian
 * 
 */
@Controller
public class HomeController {

    private UserService userService;

    @RequestMapping("**/home")
    public ModelAndView getHomePage() {
        ModelAndView mAndV = new ModelAndView("home");
        return mAndV;
    }

    @Resource
    void setUserService(UserService service) {
        this.userService = service;
    }

}
