package com.xian.mall.product;

import com.xian.mall.product.entity.BrandEntity;
import com.xian.mall.product.service.BrandService;
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
