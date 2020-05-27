package com.yufei.learn.authservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yufei.wang
 * @date 2020/05/24 22:00
 */
@Configuration
@MapperScan(basePackages = {"com.yufei.learn.authservice.mapper"})
public class MybatisPlusConfig {

}
