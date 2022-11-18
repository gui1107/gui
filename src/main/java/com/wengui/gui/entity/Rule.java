package com.wengui.gui.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public class Rule {
    private int Id;
    private String RuleType;
    private String RuleItem;
    @JsonIgnore
    private String mark;
}
