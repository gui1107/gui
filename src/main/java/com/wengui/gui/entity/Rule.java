package com.wengui.gui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
public class Rule {
    private int Id;
    private String RuleType;
    private String RuleItem;
}
