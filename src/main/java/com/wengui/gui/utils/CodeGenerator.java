package com.wengui.gui.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * mp 代码生成器
 */
public class CodeGenerator {
//    public static void main(String[] args) {
//        generate();
//    }
//
//    private static void generate(){
//        FastAutoGenerator.create("jdbc:mysql://localhost:3306/waf?serverTimezone=GMT%2b8", "root", "1234")
//                .globalConfig(builder -> {
//                    builder.author("文贵") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
//                            .outputDir("D:\\java IntelliJ IDEA\\test\\gui\\src\\main\\java"); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com/wengui/gui") // 设置父包名
//                            .moduleName("") // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\java IntelliJ IDEA\\test\\gui\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
//                })
//                .strategyConfig(builder -> {
//                    builder.addInclude("user") // 设置需要生成的表名
//                            .addTablePrefix(); // 设置过滤表前缀
//                })
////                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();
//    }
}
