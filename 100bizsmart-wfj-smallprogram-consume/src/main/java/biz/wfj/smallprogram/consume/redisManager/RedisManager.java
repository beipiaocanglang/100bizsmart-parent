package biz.wfj.smallprogram.consume.redisManager;

import faner.dplatform.api.frame.redis.JedisService;
import faner.dplatform.api.frame.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisManager {
	
	@Autowired(required=false)
    private RedisService redisService;
	
	@Autowired(required=false)
    private JedisService jedisService;
}
