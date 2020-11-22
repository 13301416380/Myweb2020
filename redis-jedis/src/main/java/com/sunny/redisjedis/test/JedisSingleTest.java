package com.sunny.redisjedis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author：不许人间见白头 Time：2020/11/16 10:30
 */
public class JedisSingleTest {


    public static void main(String[] args) {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(5);

        // timeout，这里既是连接超时又是读写超时，从Jedis 2.8开始有区分connectionTimeout和soTimeout的构造函数
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "101.132.136.153", 6381, 3000, null);

        Jedis jedis = null;
        //从redis连接池里拿出一个连接执行命令
         jedis = jedisPool.getResource();
         jedis.set("myname" ,"孙朝丹");
        System.out.println(jedis.get("myname"));
        if (jedis!=null){
             jedis.close();
         }

    }
}
