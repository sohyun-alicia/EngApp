package com.austin.home.controller;

import com.austin.home.model.Memo;
import com.austin.home.model.User;
import com.austin.home.repository.MemoRepository;
import com.austin.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String User(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user/userinfo";
    }
}
