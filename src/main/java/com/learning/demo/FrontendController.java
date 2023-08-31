package com.learning.demo;

import com.learning.demo.user.IUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping
public class FrontendController {

    private final IUserRepository repository;
    public FrontendController(IUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hello")
    public String sayHello(Model model){

        model.addAttribute("userName","Teacher1");
        model.addAttribute("studentList",this.repository.findStudentsWithOzuEmail());
        model.addAttribute("theDate",new java.util.Date());

        return "helloworld";
    }

    @GetMapping("/login-page")
    public String login(Model model){



        return "login";
    }

}
