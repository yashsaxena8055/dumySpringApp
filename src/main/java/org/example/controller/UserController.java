package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;




    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView logedIn(@ModelAttribute User user) {

        ModelAndView modelAndView = new ModelAndView();
        List<User> users = service.getAllUsers();
        for (User user1 : users) {
            if (user1.getEmail().equals(user.getEmail())) {
                if (user1.getPassword().equals(user.getPassword())) {
                    user.setName(user1.getName());
                    modelAndView.setViewName("home");
                    modelAndView.addObject("user",user);

                    return modelAndView;
                }
            }
        }

        return new ModelAndView();
    }

    @RequestMapping("/logout")
    public String logout(){
        return "index";
    }

    @RequestMapping("/addUserPage")
    public String addUserPage(){
        return "addUsers";
    }


    @RequestMapping("/home")
    public String home(){
        return "home";
    }
//    @RequestMapping(value = "/addUsers", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public String addUsers(@RequestBody User user){
//
////        user.setPassword(user.getPassword());
////              service.addUsers(newUser);
//              return "addUsers";
//
//  }
    @RequestMapping(value = "/addUsers",method = RequestMethod.POST)
    public String addUsers(@ModelAttribute User user){

          service.addUsers(user);
        return "addUsers";

    }

}



