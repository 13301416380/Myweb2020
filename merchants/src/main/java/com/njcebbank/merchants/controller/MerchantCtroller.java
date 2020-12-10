package com.njcebbank.merchants.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.njcebbank.merchants.annotation.UserRoles;
import com.njcebbank.merchants.bo.MerchantBo;
import com.njcebbank.merchants.service.MerchantService;
import com.njcebbank.merchants.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author：不许人间见白头 Time：2020/12/2 17:28
 */
@RestController
public class MerchantCtroller {
    @Autowired
    private MerchantService merchantService;


    //获取所有特约商户
    @UserRoles(roles = {"1","1001","1002"})//自定义权限拦截注解
    @RequestMapping(value = "/getMerchantList", method = RequestMethod.GET)
    public PageInfo<MerchantBo> getPageInfo(@RequestParam Map<String, Object> map) {
        PageInfo<MerchantBo> pageInfomerchantList = merchantService.getMerchantList(map);
        return pageInfomerchantList;
    }

    @Transactional
    @RequestMapping(value = "/addmerchant", method = RequestMethod.POST)
    public Map<String, Object> addMerchant(HttpServletRequest request,@RequestBody Map<String,Object> map) {
        //根据名称获取请求头的值
       String token = request.getHeader("Authorization");
        String userid="";
       if(token!=null){
           //解析用户id
             userid = JWTUtil.getUserName(token);
        }

        Map<String, Object> result = new HashMap<>();
       //获取前端添加数据
        List<Object> merchants = (List<Object>) map.get("merchants");
        List<MerchantBo> list = new ArrayList<MerchantBo>();
        Date date = new Date();//添加时间
        Map<String, Object> params = new HashMap<>();
        //遍历前端list
        for (Object merchant: merchants) {
            //map和实体类直接转换
            MerchantBo m = JSON.parseObject(JSON.toJSONString(merchant), MerchantBo.class);
            m.setAdddate(date);
            m.setUserid(userid);
            m.setIsstate(1);
            String merchanttype = m.getMerchanttype();
            Double lat = m.getLat();
            Double lng = m.getLng();
            params.put("merchanttype",merchanttype);
            params.put("lat",lat);
            params.put("lng",lng);
            //判断是否存在相同商户
            int existence = merchantService.isExistence(params);
            if (existence >0) {
                result.put("status", "error");
                result.put("message", m.getTitle()+"\n该商户已添加");
                return result;
            }
            //添加进新的list集合
            list.add(m);
        }
        //添加商户
        int count = merchantService.addMerchants(list);

        if (count > 0) {
            result.put("status", "success");
            result.put("message", "添加成功");
        } else {
            result.put("status", "error");
            result.put("message", "添加失败");
        }
        return result;
    }


}
