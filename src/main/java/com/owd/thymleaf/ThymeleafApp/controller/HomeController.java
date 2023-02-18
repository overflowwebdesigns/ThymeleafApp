package com.owd.thymleaf.ThymeleafApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("homeHeader", "Welcome to Thymeleaf XXE Test Bench");
        return "hello";
    }

    @GetMapping({ "/message/", "/message/{msg}" })
    @ResponseBody
    public ModelAndView messageParams(@PathVariable(required = false) String msg) {
        var mav = new ModelAndView();
        mav.addObject("header", "Messages");
        mav.addObject("message1", "This is a custom message");
        mav.addObject("message2", "This is also a custom message");
        mav.addObject("message3", "This is also also a custom message");
        mav.addObject("message4", "This is a user controlled value ");
        mav.addObject("message5", msg);
        mav.setViewName("message");
        return mav;
    }

}