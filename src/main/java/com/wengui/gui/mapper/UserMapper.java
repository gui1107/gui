package com.wengui.gui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wengui.gui.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user limit #{pageNum},#{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize);

    @Insert("insert into user(name, password) values(#{name},#{password})")
    void insertUser(User user);
}
