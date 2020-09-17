package com.xian.mail.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 使用逻辑删除
 * 1,配置全局的逻辑删除规则
 * 2,加上逻辑删除注解
 */


@MapperScan("com.xian.mail.product.dao")
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
