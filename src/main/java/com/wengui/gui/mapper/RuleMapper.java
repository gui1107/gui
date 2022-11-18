package com.wengui.gui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wengui.gui.entity.Rule;
import com.wengui.gui.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface RuleMapper extends BaseMapper<Rule> {
    @Select("select * from postrule limit #{pageNum},#{pageSize}")
    List<Rule> selectPage(Integer pageNum, Integer pageSize);

    @Insert("insert into postrule(id, ruletype, ruleitem) values(#{Id},#{RuleType},#{RuleItem})")
    void postRuleInsert( Rule rule);

    @Select("select * from postrule")
    List<User> findAll();
}
