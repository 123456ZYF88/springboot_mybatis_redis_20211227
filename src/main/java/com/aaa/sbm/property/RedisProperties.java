package com.aaa.sbm.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 配置文件
 * @date 2021/12/28 10:06
 */
@Component
@PropertySource("classpath:project.properties")//读取配置文件
// 也可以同时读取多个配置文件
@ConfigurationProperties(prefix = "redis") //只读以 redis 为开头的配置文件
@Data
public class RedisProperties {
    //最大能够保持空闲状态的链接数
    private int maxIdle;
    //最大连接数
    private int maxTotal;
    //最大的等待时长
    private int maxWaitMillis;
    //当调用borrow Object方法时，是否进行有效性检查
    private boolean testOnBorrow;
    //集群节点配置
    private String nodes;

}
