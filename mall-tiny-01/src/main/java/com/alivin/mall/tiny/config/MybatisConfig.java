package com.alivin.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis 配置类
 * @author Fer
 * @date 2021/8/4
 */
@Configuration
@MapperScan("com.alivin.mall.tiny.mbg.mapper")
public class MybatisConfig {
}
