package com.aaa.sbm.util;

import com.mysql.jdbc.log.Log;
import io.swagger.models.auth.In;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2021/12/28 11:31
 */
public class MyCustomCache implements Cache {
    //提供一个接受 String 参数作为 id 的构造器  缓存的唯一标识，不用自己赋值，每次缓存任何对象时，都会自动生成一个唯一的ID
    private String id;
    //依赖注入redis集群连接的数据源
    private static JedisConnectionFactory jedisConnectionFactory;
//  //实例化读写策略类   读读共享   读写互斥  写读互斥  写写互斥
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
//使用静态方法给jedisConnectionFactory赋值
    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory){
        MyCustomCache.jedisConnectionFactory = jedisConnectionFactory;
    }

    /**
     * 空构造
     */
    public MyCustomCache(){

    }

    /**
     * id必须不能为空
     * @param id
     */
    public MyCustomCache(String id) {
        if (null==id){
            throw new IllegalArgumentException("id不能为空");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        //获取连接对象   aaa  111
        //需要序列化 实例化序列类  spring整合redis包提供的
        //序列化key和value
        RedisConnection connection =jedisConnectionFactory.getConnection();
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer=
                new JdkSerializationRedisSerializer();
        byte[] serialize = jdkSerializationRedisSerializer.serialize(key);
        byte[] serialize1 = jdkSerializationRedisSerializer.serialize(value);
        connection.set(serialize,serialize1);
    }

    @Override
    public Object getObject(Object key) {
        //获取连接对象
        RedisConnection connection=jedisConnectionFactory.getConnection();
        //需要序列化 实例化序列类 spring 整合redis包提供的
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer=new JdkSerializationRedisSerializer();
        //序列化 key 和 value
        byte[] serialize = jdkSerializationRedisSerializer.serialize(key);
        byte[] bytes = connection.get(serialize);
        return jdkSerializationRedisSerializer.deserialize(bytes);
    }

    @Override
    public Object removeObject(Object key) {
        RedisConnection connection=jedisConnectionFactory.getConnection();
        //需要序列化 实例化序列类 spring 整合redis包提供的
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer=new JdkSerializationRedisSerializer();
        byte[] serializeKey = jdkSerializationRedisSerializer.serialize(key);;

        return connection.expire(serializeKey,0);

    }

    @Override
    public void clear() {
    //获取连接对象
        RedisConnection connection = jedisConnectionFactory.getConnection();
        //清空单前库
        connection.flushDb();
        //清空所有库
        connection.flushAll();
    }

    @Override
    public int getSize() {
        RedisConnection connection = jedisConnectionFactory.getConnection();
        Long aLong = connection.dbSize();

        return Integer.valueOf(aLong.toString());
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
