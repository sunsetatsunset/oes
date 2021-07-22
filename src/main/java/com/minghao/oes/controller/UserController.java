package com.minghao.oes.controller;

import com.minghao.oes.domain.User;
import com.minghao.oes.mapper.UserMapper;
import com.minghao.oes.service.UserService;
import com.minghao.oes.service.impl.UserServiceImpl;
import com.minghao.oes.viewmodel.UserLoginVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "用户类")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public User getUser() {
        User user = userService.getUserById(1);
        return user;
    }

    @ApiOperation(value = "登录方法")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void userLogin( @RequestBody @Valid User user) {
        User loginUser = userService.getUserByUserName(user.getUserName());
        if(userService.getUserByUserName(user.getUserName()) == null) {
            System.out.println("该用户不存在");
            return ;
        }
        User newUser = new User();
        newUser.setUserName(loginUser.getUserName());
        newUser.setPassword(loginUser.getPassword());
        userService.insertUser(newUser);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerUser(@RequestBody @Valid User user) {

    }
}
