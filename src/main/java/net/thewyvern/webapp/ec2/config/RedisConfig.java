package net.thewyvern.webapp.ec2.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author matthewd
 *
 * Note that elisticache redis isn't quite redis...
 * 
 * See: https://github.com/spring-projects/spring-session/issues/97
 *      https://github.com/spring-projects/spring-session/issues/124
 *
 */

@EnableRedisHttpSession
public class RedisConfig {

	static Properties redisProps;
	
	{
		redisProps = new Properties();
		try {
			InputStream is = new FileInputStream("redis.properties");
			redisProps.load(is);
		} catch (FileNotFoundException e) {
			System.out.println("Could not found config file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not load properties file");
			e.printStackTrace();
		}		
	}
	
	

	@Bean
	public static ConfigureRedisAction configureRedisAction() {
	    return ConfigureRedisAction.NO_OP;
	}
	
    @Bean
    public static JedisConnectionFactory jedisConnectionFactory() {
      
      JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig());
      jedisConnectionFactory.setHostName(redisProps.getProperty("spring_session_redis_host"));
      jedisConnectionFactory.setPort(Integer.parseInt(redisProps.getProperty("spring_session_redis_port")));
      jedisConnectionFactory.setPassword(redisProps.getProperty("spring_session_redis_password"));
      jedisConnectionFactory.setDatabase(Integer.parseInt(redisProps.getProperty("spring_session_redis_database")));
      jedisConnectionFactory.setTimeout(Integer.parseInt(redisProps.getProperty("spring_session_redis_timeout")));
      jedisConnectionFactory.setUsePool(Boolean.parseBoolean(redisProps.getProperty("spring_session_redis_use_pool")));
      return jedisConnectionFactory;
    }

    @Bean
    public static JedisPoolConfig jedisPoolConfig() {
      JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
      jedisPoolConfig.setTestOnBorrow(Boolean.parseBoolean(redisProps.getProperty("spring_session_redis_pool_test_on_borrow")));
      jedisPoolConfig.setMaxTotal(Integer.parseInt(redisProps.getProperty("spring_session_redis_pool_max_total")));
      jedisPoolConfig.setMaxIdle(Integer.parseInt(redisProps.getProperty("spring_session_redis_pool_max_idle")));
      jedisPoolConfig.setMinIdle(Integer.parseInt(redisProps.getProperty("spring_session_redis_pool_min_idle")));
      return jedisPoolConfig;
    }
}
