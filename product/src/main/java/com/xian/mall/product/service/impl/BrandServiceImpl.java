package com.xian.mall.product.service.impl;

import com.xian.mall.product.dao.BrandDao;
import com.xian.mall.product.service.CategoryBrandRelationService;
import com.xian.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.common.utils.PageUtils;
import com.xian.common.utils.Query;

import com.xian.mall.product.entity.BrandEntity;
import com.xian.mall.product.service.BrandService;
import org.springframework.util.StringUtils;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {
    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        if (StringUtils.isEmpty(key)){
            IPage<BrandEntity> page = this.page(
                    new Query<BrandEntity>().getPage(params),
                    new QueryWrapper<BrandEntity>()
            );
            return new PageUtils(page);
        }else {

            IPage<BrandEntity> page = this.page(
                    new Query<BrandEntity>().getPage(params),
                    new QueryWrapper<BrandEntity>().eq("brand_id",key).or().like("name",key)
            );

            return new PageUtils(page);

        }



    }

    @Override
    public void updateDetial(BrandEntity brand) {
        this.updateById(brand);
        if (!StringUtils.isEmpty(brand.getName())){
            categoryBrandRelationService.updateBrand(brand.getBrandId(),brand.getName());
            //TODO 关联其他
        }
    }

}