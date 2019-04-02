package cn.wb.learning.redis.controller;

import cn.wb.learning.redis.entity.City;
import cn.wb.learning.redis.service.RedisService;
import cn.wb.learning.redis.service.RedisService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.redis.controller
 * @email wubin326@qq.com
 * @date 2018/08/21
 */
@RestController
public class RedisController1 {

    @Autowired
    private RedisService1 redisService;

    @GetMapping("/setstring")
    public String setString(String name, String value) {
        redisService.setObject(name, value);
        return "success";
    }

    @GetMapping("/setlist")
    public String getCity(String cityId) {

        ArrayList<String> arrayList = new ArrayList<>();
        String[] split = "wu bin shi da shuai ge".split(" ");
        for (String s : split) {
            arrayList.add(s);
        }

        redisService.setObject("wo", arrayList);
        return "success";
    }

    @GetMapping("/setlistobj")
    public String getCity1(String cityId) {

        ArrayList<City> arrayList = new ArrayList<>();
        int i = 0;
        while (++i < 6) {
            arrayList.add(new City("wu" + i, "bin"));
        }
        redisService.setObject("wuu", arrayList);
        return "success";
    }
}
