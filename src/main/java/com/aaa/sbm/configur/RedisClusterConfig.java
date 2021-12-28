package com.aaa.sbm.configur;

import com.aaa.sbm.property.RedisProperties;
import com.aaa.sbm.util.MyCustomCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisClientConfig;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2021/12/28 10:36
 */

@Configuration
public class RedisClusterConfig {
    @Resource
    private RedisProperties redisProperties;
    /**
     * 实例化 redis集群的连接工厂类
     * @return
     * <bean id='jedisConnectionFactory' class='org.springframework.data.redis.connection.jedis.JedisConnectionFactory'>
     *      *               <constructor-args0 name=clusterConfig ref ='clusterConfig'></constructor-arg0>
     *      *               <constructor-args1 name=poolConfig ref ='poolConfig'></constructor-arg1>
     *      *           </bean>
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        //实例化并返回
        JedisConnectionFactory jedisConnectionFactory=
                new JedisConnectionFactory(configuration(),jedisPoolConfig());
        return jedisConnectionFactory;
    }

    /**
     * 实例化连接redis 集群 配置 并且依赖注入
     * @return
     */
    @Bean
    public RedisClusterConfiguration configuration(){
        //实例化对象
        RedisClusterConfiguration redisClusterConfiguration=
                new RedisClusterConfiguration();
        //获取配置
        String nodes = redisProperties.getNodes();
        //分割配置得到的数组
        String[] split = nodes.split(",");
        for (String node:split
             ) {
            String[] split1 = node.split(":");
            RedisNode redisNode=new RedisNode(split1[0],Integer.valueOf(split1[1]));
            redisClusterConfiguration.addClusterNode(redisNode);
        }
        return redisClusterConfiguration;
    }
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
        jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
        jedisPoolConfig.setTestOnBorrow(redisProperties.isTestOnBorrow());
        return jedisPoolConfig;
    }
    @Bean
    public void  setJedisConnectionFactory(){
        //
        MyCustomCache.setJedisConnectionFactory(jedisConnectionFactory());
    }

}
