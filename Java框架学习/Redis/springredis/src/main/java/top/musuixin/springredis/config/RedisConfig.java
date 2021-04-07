package top.musuixin.springredis.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    private RedisConnectionFactory redisConnectionFactory = null;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大连接数
        jedisPoolConfig.setMaxTotal(100);
        //最小空闲连接数
        jedisPoolConfig.setMinIdle(20);
        //当池内没有可用连接时，最大等待时间
        jedisPoolConfig.setMaxWaitMillis(10000);
        //其他属性可以自行添加
        return jedisPoolConfig;
    }

    /**
     * @param
     * @return
     */
    @Bean
    @Scope
    public RedisConnectionFactory redisConnectionFactory(@Autowired JedisPoolConfig jedisPoolConfig) {
        if (redisConnectionFactory != null) {
            return redisConnectionFactory;
        }
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        //设置redis服务器的host或者ip地址
        redisStandaloneConfiguration.setHostName("127.0.0.1");
        redisStandaloneConfiguration.setPort(6379);
        //获得默认的连接池构造
        //这里需要注意的是，edisConnectionFactoryJ对于Standalone模式的没有（RedisStandaloneConfiguration，JedisPoolConfig）的构造函数，对此
        //我们用JedisClientConfiguration接口的builder方法实例化一个构造器，还得类型转换
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcf = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        //修改我们的连接池配置
        jpcf.poolConfig(jedisPoolConfig);
        //通过构造器来构造jedis客户端配置
        JedisClientConfiguration jedisClientConfiguration = jpcf.build();
        redisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
        return redisConnectionFactory;
    }

    @Bean("redisTemplate")
    public RedisTemplate<String, Object> ininRedisTemplate() {
        RedisTemplate<String, Object> objectObjectRedisTemplate = new RedisTemplate<>();
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        objectObjectRedisTemplate.setHashValueSerializer(stringSerializer);
        objectObjectRedisTemplate.setValueSerializer(stringSerializer);
        objectObjectRedisTemplate.setKeySerializer(stringSerializer);
        objectObjectRedisTemplate.setValueSerializer(stringSerializer);
        objectObjectRedisTemplate.setHashKeySerializer(stringSerializer);
        objectObjectRedisTemplate.setHashValueSerializer(stringSerializer);
        objectObjectRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return objectObjectRedisTemplate;
    }
}