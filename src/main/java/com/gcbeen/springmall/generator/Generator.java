package com.gcbeen.springmall.generator;

import java.util.Collections;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

// cms_*：内容管理模块相关表
// oms_*：订单管理模块相关表
// pms_*：商品模块相关表
// sms_*：营销模块相关表
// ums_*：会员模块相关表

/**
 * 生成代码
 */
public class Generator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mall?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "root", "JavaScriptGO@123456")
	.globalConfig(builder -> {
		builder.author("mybatis plus generator") // 设置作者
            // // 开启 swagger 模式
			.enableSwagger()
			// 覆盖已生成文件
			.fileOverride()
			// 输出目录 : 项目目录 + 父包名
			// 设置项目目录
			.outputDir("/Users/gcbeen/00-guide/back_end_pro/springmall/src/main/java");
	})
	.packageConfig(builder -> {
		builder.parent("com.gcbeen.springmall.generator") // 设置父包名
			.moduleName("") // 设置父包模块名
            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/gcbeen/00-guide/back_end_pro/springmall/src/main/resources/mapper/generator")); // 设置mapperXml生成路径
	})
	.strategyConfig(builder -> {
		// cms_*：内容管理模块相关表
		// oms_*：订单管理模块相关表
		// pms_*：商品模块相关表
		// sms_*：营销模块相关表
		// ums_*：会员模块相关表
		builder.addTablePrefix("cms_", "oms_", "pms_", "sms_", "ums_");
			// .addInclude("t_simple") // 设置需要生成的表名
			// .addTablePrefix("", ""); // 设置过滤表前缀
	})
	.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
	.execute();

    }
}
