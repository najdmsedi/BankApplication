package tn.iit.springbootprojectbankapplication.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tn.iit.springbootprojectbankapplication.entity.User;
import tn.iit.springbootprojectbankapplication.service.UserService;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @ResponseBody
    @PostMapping("/")
    public User createAdmin(@RequestBody User user){
        return userService.saveUser(user);
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<Integer> loginAdmin(@RequestBody User user) {
        return userService.login(user);
    }



}
