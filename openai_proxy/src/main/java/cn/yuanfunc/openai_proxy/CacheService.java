package cn.yuanfunc.openai_proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public CacheService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void cacheResponse(String key, String response) {
        redisTemplate.opsForValue().set(key, response, 10, TimeUnit.MINUTES);
    }

    public String getResponse(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            throw new RuntimeException("This is a test exception");

        }
    }

//    public String getCachedValue(String key) {
//        return stringRedisTemplate.opsForValue().get(key);
//    }
}
