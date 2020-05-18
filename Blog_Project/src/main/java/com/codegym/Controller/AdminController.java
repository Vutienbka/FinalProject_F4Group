package com.codegym.Controller;

import com.codegym.Model.UserEntity;
import com.codegym.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = {"/api"})
public class AdminController {
    @Autowired
    IUserService userService;
    //--------------------------TOAN----------------------

    //--------------------------TIEN----------------------

    //--------------------------TU----------------------
    @GetMapping(value = "/getalluser", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserEntity> getAllUser() {
        List<UserEntity> list = this.userService.findAll();
        System.out.println(list.size());
        return list;
    }
    //--------------------------DUNG----------------------


}
