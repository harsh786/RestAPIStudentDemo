package com.harsh.student.RestAPIStudentDemo;

import org.apache.log4j.Logger;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.util.StringUtils;

import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;
import java.util.Collection;

@Configuration

@ComponentScan("com.harsh.student.RestAPIStudentDemo")
public class RedisConfig extends CachingConfigurerSupport {
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(500);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
		connectionFactory.setUsePool(true);
		connectionFactory.setHostName("localhost");
		connectionFactory.setPort(6379);
		
		return connectionFactory;
	}
	
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return template;
	}
	
	 @Bean("customKeyGenerator")
	    public KeyGenerator keyGenerator() {
	        return new CustomKeyGenerator();
	    }
	
	 
	 @Bean
	public  CacheManager cacheManager() {
		 CacheManager Obj=	   new RedisCacheManager(redisTemplate());
		 
	//	 Obj.getCache("harsh").
		 return Obj;
		 
	     
	
	  }
	 
	 
	 @Bean
	public  CacheResolver cacheResolver() {
		 
		 return new CacheResolver() {
			
			@Override
			public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		 
	     
	
	  }


} 


class CustomKeyGenerator implements KeyGenerator {
	  
    public Object generate(Object target, Method method, Object... params) {
        return target.getClass().getSimpleName() + "_"
          + method.getName() + "_"
          + StringUtils.arrayToDelimitedString(params, "_");
    }
}