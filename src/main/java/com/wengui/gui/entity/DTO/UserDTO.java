package com.wengui.gui.entity.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String nickname;
    private String password;
    private String telphone;


    private String token;
}
