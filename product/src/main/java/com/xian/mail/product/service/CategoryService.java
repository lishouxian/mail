package com.xian.mail.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xian.common.utils.PageUtils;
import com.xian.mail.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author lishouxian
 * @email li.shouxian@outlook.com
 * @date 2020-09-15 19:22:23
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();
}

