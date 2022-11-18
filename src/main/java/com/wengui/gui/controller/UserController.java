package com.wengui.gui.controller;

import cn.hutool.core.util.StrUtil;
import com.wengui.gui.common.Constants;
import com.wengui.gui.common.Result;
import com.wengui.gui.entity.DTO.UserDTO;
import com.wengui.gui.entity.User;
import com.wengui.gui.mapper.UserMapper;
import com.wengui.gui.service.Impl.UserServiceImpl;
import com.wengui.gui.service.UserService;
import com.wengui.gui.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO){
        String name = userDTO.getName();
        String password = userDTO.getPassword();
        if(StrUtil.isBlank(name) && StrUtil.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        return Result.success(userService.login(userDTO));
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO){
        return Result.success(userService.register(userDTO));
    }
}
