package com.wengui.gui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wengui.gui.entity.DTO.UserDTO;
import com.wengui.gui.entity.User;

public interface UserService extends IService<User> {
    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);
}
