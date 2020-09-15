package com.xian.mail.product.dao;

import com.xian.mail.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author lishouxian
 * @email li.shouxian@outlook.com
 * @date 2020-09-15 19:22:23
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
