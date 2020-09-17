package com.xian.mail.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.common.utils.PageUtils;
import com.xian.common.utils.Query;

import com.xian.mail.product.dao.CategoryDao;
import com.xian.mail.product.entity.CategoryEntity;
import com.xian.mail.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //查出所有分类,组装成
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //组装树形结构
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity ->
             categoryEntity.getParentCid() == 0
        ).map((menu) -> {
            menu.setChildrens(getChildrens(menu,entities));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());



        return level1Menus;
    }



    //递归查找所有菜单的子菜单
    public List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all){


        List<CategoryEntity> childrens = all.stream().filter(categoryEntity -> categoryEntity.getParentCid() == root.getCatId()
        ).map(categoryEntity -> {
            categoryEntity.setChildrens(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return childrens;
    }


    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 1. 检查当前删除的菜单,是否被引用


        baseMapper.deleteBatchIds(asList);
    }

}














