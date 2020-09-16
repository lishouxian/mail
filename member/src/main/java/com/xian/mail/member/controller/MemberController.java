package com.xian.mail.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.xian.mail.member.feign.CouponFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xian.mail.member.entity.MemberEntity;
import com.xian.mail.member.service.MemberService;
import com.xian.common.utils.PageUtils;
import com.xian.common.utils.R;



/**
 * 会员
 *
 * @author lishouxian
 * @email li.shouxian@outlook.com
 * @date 2020-09-15 20:46:47
 */
@RefreshScope
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;


    @Autowired
    CouponFeignService couponFeignService;


    /**
     * 测试请求
     */
    @RequestMapping("/test")
    public R test(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("张三");
        R r = couponFeignService.memberCoupons();
        return R.ok().put("会员", memberEntity).put("优惠券",r.get("优惠券"));
    }



    @Value("${myuser.name}")
    String name;

    @Value("${myuser.age}")
    Integer age;

    /**
     * 测试请求
     */
    @RequestMapping("/test1")
    public R test1(){
        return R.ok().put("会员", name).put("年龄",age);
    }





    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
