package cn.wb.learning.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.redis.service
 * @email wubin326@qq.com
 * @date 2019/03/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/03/07        wubin            0.0.1
 */
@Service
public class RedisService1 {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setObject(String key, Object value) {
        //判空
        if (value instanceof String) {
            String temp = (String) value;
            stringRedisTemplate.opsForValue().set(key, temp);
        }

        if (value instanceof List) {
            List<String> list = (List<String>) value;
            for (String s : list) {
                stringRedisTemplate.opsForList().rightPush(key,s);
            }
        }
    }
}
