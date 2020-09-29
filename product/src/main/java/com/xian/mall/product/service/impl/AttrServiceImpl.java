package com.xian.mall.product.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.xian.mall.product.dao.AttrAttrgroupRelationDao;
import com.xian.mall.product.dao.AttrDao;
import com.xian.mall.product.dao.AttrGroupDao;
import com.xian.mall.product.dao.CategoryDao;
import com.xian.mall.product.entity.AttrAttrgroupRelationEntity;
import com.xian.mall.product.entity.AttrGroupEntity;
import com.xian.mall.product.entity.CategoryEntity;
import com.xian.mall.product.vo.AttrResponsVo;
import com.xian.mall.product.vo.AttrVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.common.utils.PageUtils;
import com.xian.common.utils.Query;

import com.xian.mall.product.entity.AttrEntity;
import com.xian.mall.product.service.AttrService;
import org.springframework.util.StringUtils;

import static com.sun.tools.doclint.Entity.copy;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {
    @Autowired
    AttrAttrgroupRelationDao relationDao;

    @Autowired
    AttrGroupDao attrGroupDao;

    @Autowired
    CategoryDao categoryDao;



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveattrVo(AttrVo attrVo) {

        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attrVo,attrEntity);

        this.save(attrEntity);

        AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();

        relationEntity.setAttrGroupId(attrVo.getGroudId());
        relationEntity.setAttrId(attrVo.getAttrId());

        relationDao.insert(relationEntity);
    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params , Long catelogId) {
        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();

        if(catelogId != 0){
            wrapper.eq("catelog)id",catelogId);
        }

        String key = (String) params.get("key");

        if(!StringUtils.isEmpty(key)){
            wrapper.and((wrapper1)->{
                wrapper1.eq("attr_id" ,key).or().like("attr_name",key);
            });
        }

        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrResponsVo> attr_id1 = records.stream().map((attrEntity) -> {
            AttrResponsVo attrResponsVo = new AttrResponsVo();
            BeanUtils.copyProperties(attrEntity, attrResponsVo);


            AttrAttrgroupRelationEntity attr_id = relationDao.selectOne(
                    new QueryWrapper<AttrAttrgroupRelationEntity>().eq(
                            "attr_id", attrEntity.getAttrId()
                    )
            );
            if (attr_id != null) {
                Long attrGroupId = attr_id.getAttrGroupId();
                AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrGroupId);
                String attrGroupName = attrGroupEntity.getAttrGroupName();
                attrResponsVo.setGroupName(attrGroupName);
            }

            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
            if (categoryEntity != null) {
                attrResponsVo.setCatelogName(categoryEntity.getName());

            }


            return attrResponsVo;
        }).collect(Collectors.toList());
        pageUtils.setList(attr_id1);

        return pageUtils;
    }


}