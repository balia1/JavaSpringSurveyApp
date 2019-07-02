package com.sempertech.MySqlProject.boot.controller;

import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {


    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String mainPage(Model model){
        return "data-tables";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String dataPage(Model model) {
        return "user-profile";
    }

    @RequestMapping(value = "/createForm", method = RequestMethod.GET)
    public String creatingForm(Model model){
        return "form-elements";
    }

    @RequestMapping(value = "/callForm", method = RequestMethod.GET)
    public String callingForm(Model model){
        return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model){
        return "form";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpPage(Model model) {
        return "signup";
    }

    @RequestMapping(value = "/addUser" , method = RequestMethod.GET)
    public String signUpRedirect(Model model) {
        return "form-elements";
    }
    @RequestMapping(value = "/forgotpassword" , method = RequestMethod.GET)
    public String forgotPassword(Model model) {
        return "forgotpassword";
    }
}