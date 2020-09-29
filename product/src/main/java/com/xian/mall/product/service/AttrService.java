package com.xian.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xian.common.utils.PageUtils;
import com.xian.mall.product.entity.AttrEntity;
import com.xian.mall.product.vo.AttrVo;

import java.util.Map;

/**
 * 商品属性
 *
 * @author lishouxian
 * @email li.shouxian@outlook.com
 * @date 2020-09-15 19:22:24
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveattrVo(AttrVo attrVo);

    PageUtils queryBaseAttrPage(Map<String, Object> params,Long catelogId);

}

