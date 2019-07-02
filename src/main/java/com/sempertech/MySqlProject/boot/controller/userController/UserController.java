package com.sempertech.MySqlProject.boot.controller.userController;

import com.sempertech.MySqlProject.repository.SurveyAnswersRepository;
import com.sempertech.MySqlProject.repository.UserInterface;
import com.sempertech.MySqlProject.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private SurveyAnswersRepository surveyAnswersRepository;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    public Users addUser(@RequestBody Users users) {
        users.setRole("USER_ROLE");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        userInterface.save(users);
        return users;
    }




}

