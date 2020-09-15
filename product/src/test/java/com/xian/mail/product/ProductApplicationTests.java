package com.xian.mail.product;

import com.xian.mail.product.entity.BrandEntity;
import com.xian.mail.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductApplicationTests {

	@Autowired
	BrandService brandService;
	@Test
	void contextLoads() {
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setName("");
		brandService.save(brandEntity);
		System.out.println("保存成功");
	}





}
