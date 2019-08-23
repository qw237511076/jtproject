package com.jt.manager.controller;

import com.jt.manager.pojo.User;
import com.jt.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author sumail
 * @date 2019/8/23 0023-${time}
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("userList",list);
        return "userList";
    }
}
