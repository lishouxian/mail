package com.xian.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xian.common.utils.PageUtils;
import com.xian.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author lishouxian
 * @email li.shouxian@outlook.com
 * @date 2020-09-15 19:22:23
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetial(BrandEntity brand);



}

