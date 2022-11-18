package com.wengui.gui.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wengui.gui.common.Constants;
import com.wengui.gui.entity.DTO.UserDTO;
import com.wengui.gui.entity.User;
import com.wengui.gui.exception.ServiceException;
import com.wengui.gui.mapper.UserMapper;
import com.wengui.gui.service.UserService;
import com.wengui.gui.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO login(UserDTO userDTO) {
        User user;
        try {
            user = getUserInfo(userDTO);
        }catch (Exception e){
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        if(user != null){
            BeanUtils.copyProperties(user, userDTO,"true");
            String token = TokenUtils.genToken(user.getId().toString(), user.getPassword());
            userDTO.setToken(token);
            return userDTO;
        }else {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        User user = getUserInfo(userDTO);
        //若无此用户，则新建用户
        if(user == null){
            user = new User();
            BeanUtils.copyProperties(userDTO, user,"true");
            userMapper.insertUser(user);
            return user;
        }

        return user;
    }

    private User getUserInfo(UserDTO userDTO){
        //从数据库查询用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",userDTO.getName());
        queryWrapper.eq("password", userDTO.getPassword());
        return getOne(queryWrapper);
    }
}
