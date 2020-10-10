package com.xian.mall.product.dao;

import com.xian.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author lishouxian
 * @email li.shouxian@outlook.com
 * @date 2020-09-15 19:22:23
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {

}
