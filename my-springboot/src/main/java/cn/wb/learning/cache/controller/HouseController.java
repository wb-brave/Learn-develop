package cn.wb.learning.cache.controller;

import cn.wb.learning.cache.entity.House;
import cn.wb.learning.cache.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.cache.controller
 * @email wubin326@qq.com
 * @date 2018/08/22
 */
@RestController
public class HouseController {

    @Autowired
    private HouseRepository repository;

    //http://localhost:8888/saveHouse?id=1&houseName=别墅&houseSize=1220平方米
    @GetMapping("/saveHouse")
    @CachePut(value = "house", key = "#id")
    public House saveHouse(Integer id,String houseName,String houseSize){
        House house = new House(id,houseName, houseSize);
        repository.save(house);
        return house;
    }

    //http://localhost:8888/queryHouse?id=1
    @GetMapping("/queryHouse")
    @Cacheable(value = "house", key = "#id")
    public House queryHouse(Integer id){
        House house = repository.findOne(id);
        return house;
    }

    //http://localhost:8888/deleteHouse?id=1
    @GetMapping("/deleteHouse")
    @CacheEvict(value = "house", key = "#id")
    public String deleteHouse(Integer id){
        repository.delete(id);
        return "success";
    }

    //http://localhost:8888/deleteCache
    @GetMapping("/deleteCache")
    @CacheEvict(value = "house", allEntries = true)
    public void deleteCache() {
    }
}
