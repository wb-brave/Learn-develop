package cn.wb.learning.redis.controller;

import cn.wb.learning.redis.entity.City;
import cn.wb.learning.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.redis.controller
 * @email wubin326@qq.com
 * @date 2018/08/21
 */
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/save")
    public String save(String cityId,String cityName,String cityIntroduce){

        City city = new City(cityId, cityName, cityIntroduce);
        redisService.set("city"+cityId,city);
        return "success";
    }

    @GetMapping("/get")
    public City getCity(String cityId){
        return (City) redisService.get("city"+cityId);
    }
}
