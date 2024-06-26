package org.example.validateusers.controller;

import org.example.validateusers.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {
    @GetMapping("/users")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/validateUsers")
    public ModelAndView checkValidate(@Validated @ModelAttribute("user") User user,
                                       BindingResult bindingResult) {

        if(bindingResult.hasFieldErrors()){
        return new ModelAndView("/index");
        }
        return new ModelAndView("/result");
    }
}
