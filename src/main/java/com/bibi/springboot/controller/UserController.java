package com.bibi.springboot.controller;

import com.bibi.springboot.common.util.Message;
import com.bibi.springboot.model.User;
import com.bibi.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/users"})
@Api(value = "userController", description = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户信息", notes = "通过用户ID来查询用户信息")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Message getById(@PathVariable(value = "userId") Long userId) {
        User user = userService.getById(userId);
        return Message.success().add("user", user);
    }

    @ApiOperation(value = "创建用户信息")
    @RequestMapping(method = RequestMethod.POST)
    public Message create(@RequestBody User user) {
        User newUser = userService.create(user);
        return Message.success().add("user", newUser);
    }

}
