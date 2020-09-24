package com.xian.mall.member.feign;

import com.xian.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("coupon")
public interface CouponFeignService {


    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();


}
