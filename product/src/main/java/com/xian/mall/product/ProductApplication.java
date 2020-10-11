package com.xian.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 使用逻辑删除
 * 1,配置全局的逻辑删除规则
 * 2,加上逻辑删除注解
 */

@EnableFeignClients(basePackages = "com.xian.mall.product.feign")

@MapperScan("com.xian.mall.product.dao")
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
