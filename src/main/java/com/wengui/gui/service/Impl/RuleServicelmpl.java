package com.wengui.gui.service.Impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wengui.gui.entity.Rule;
import com.wengui.gui.mapper.RuleMapper;
import com.wengui.gui.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class RuleServicelmpl extends ServiceImpl<RuleMapper, Rule> implements RuleService {
    @Autowired
    RuleMapper ruleMapper;

    private String  rulePath = "D:\\java IntelliJ IDEA\\IntelliJ IDEA 2022.2.1\\code\\test\\domo\\src\\wengui\\";

    private Boolean ruleInsert(String ruleType, Rule rule){
        if(ruleType.equals("post")){
            ruleMapper.postRuleInsert(rule);
            return true;
        }
        return false;
    }

    public List<Rule> readrule(String file) throws IOException {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        List<Rule> list = new ArrayList<>();
        String path = rulePath + file;
        FileInputStream fis = new FileInputStream(path);

        // 防止路径乱码   如果utf-8 乱码  改GBK   用UTF-8，在电脑上自己创建的txt  用GBK
        InputStreamReader isr = new  InputStreamReader(fis, StandardCharsets.UTF_8);

        BufferedReader br = new BufferedReader(isr);
        String ruleStr = "";
        String line = "";

        /*
            读取全部规则，合并字符串
            字符串数据可能过长
            后续需改进
         */
        while ((line = br.readLine()) != null) {
            ruleStr += line;
        }
        //去除多余符号 [ ]
        ruleStr = ruleStr.replace("[","").replace("]","");
        //多个规则分割
        String[] strArr = ruleStr.split("},");

        for (String str: strArr){
            //加入 } 变成 json 格式
            if(str.lastIndexOf("}") != str.length()-1){
                str += "}";
            }

            //将 json 字符串 转换 对象实体
            Rule rule = JSON.parseObject(str, Rule.class);
            String rep = rule.getRuleItem().replace("\\","\\\\");;
            rule.setRuleItem(rep);
            System.out.println(rule);

            //数据库插入
            ruleInsert("post", rule);

            //list 为返回对象
            list.add(rule);
        }

        //资源关闭
        br.close();
        isr.close();
        fis.close();
        return list;
    }
}
