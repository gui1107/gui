package com.wengui.gui.controller;

import com.alibaba.fastjson.JSON;
import com.wengui.gui.common.Result;
import com.wengui.gui.entity.Rule;
import com.wengui.gui.entity.User;
import com.wengui.gui.mapper.RuleMapper;
import com.wengui.gui.service.Impl.RuleServicelmpl;
import com.wengui.gui.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RuleController {
    @Autowired
    RuleServicelmpl ruleServicelmpl;

    @Autowired
    RuleMapper ruleMapper;

    @Autowired
    RuleService ruleService;

    //规则读取
    @GetMapping("/read")
    public Result readrule(@RequestParam String file) throws IOException {
        return Result.success(ruleService.readrule(file));
    }

    @GetMapping("/page")
    public Result findpage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum = (pageNum -1) * pageSize;
        List<User> users = ruleMapper.findAll();
        int total = users.size();
        List<Rule>  data = ruleMapper.selectPage(pageNum,pageSize);
        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return Result.success(res);
    }

}
