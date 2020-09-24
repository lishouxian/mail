package com.xian.mall.member.dao;

import com.xian.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author lishouxian
 * @email li.shouxian@outlook.com
 * @date 2020-09-15 20:46:47
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
