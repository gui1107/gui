package com.wengui.gui.service;

import com.wengui.gui.entity.Rule;

import java.io.IOException;
import java.util.List;

public interface RuleService {
    public List<Rule> readRule(String file) throws IOException;
}
