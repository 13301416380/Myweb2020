package com.sunny.redisjedis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：不许人间见白头 Time：2020/11/25 9:01
 */
@RestController
@RequestMapping("redis")
public class RandomLogAndLat {
    @Autowired
    private   StringRedisTemplate redisTemplate;
    @RequestMapping("/test")
    public Map<String,Object> getDedistest(){
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        // Long add = redisTemplate.opsForSet().add("redistest", "测试1");

//        for (int i = 0; i < 10; i++) {
//             redisTemplate.opsForSet().add(i+"", "测试1");
//        }
//        redisTemplate.opsForGeo().add("baidumap", new Point(14.361389, 39.115556), "bj" );
//        List<Point> baidumap = redisTemplate.opsForGeo().position("baidumap","nj","bj");
//        System.out.println(baidumap);
        for (int i = 0; i < 1; i++) {
            List<Point> list=null;
            Map<String, String> jw =  randomLonLat(-180, 180, -90, 90);

            double w = Double.parseDouble(jw.get("W"));
            double j = Double.parseDouble(jw.get("J"));
             redisTemplate.opsForGeo().add("baidumap", new Point(w, j), "addr" + i);
            list = redisTemplate.opsForGeo().position("baidumap", "addr" + i);
            map.put(i+"",list.get(0));
            System.out.println("纬度 :"+jw.get("J") + " , 经度 :" + jw.get("W"));
        }
        data.put("data",map);
            return  data;
    }
    /**
     * @Title: randomLonLat
     * @Description: 在矩形内随机生成经纬度
     * @param MinLon：最新经度  MaxLon： 最大经度   MinLat：最新纬度   MaxLat：最大纬度    type：设置返回经度还是纬度
     * @return
     * @throws
     */
    public static Map<String, String> randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat) {
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        Map<String, String> map = new HashMap<String, String>();
        map.put("J", lon);
        map.put("W", lat);
        return map;
    }

}
