package com.xian.mall.order.dao;

import com.xian.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author lishouxian
 * @email li.shouxian@outlook.com
 * @date 2020-09-15 20:41:33
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
