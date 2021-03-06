package com.xian.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xian.common.utils.PageUtils;
import com.xian.mall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author lishouxian
 * @email li.shouxian@outlook.com
 * @date 2020-09-15 20:46:47
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

