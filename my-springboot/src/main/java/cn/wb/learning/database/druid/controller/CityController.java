package cn.wb.learning.database.druid.controller;

import cn.wb.learning.database.druid.entity.City;
import cn.wb.learning.database.druid.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.druid.controller
 * @email wubin326@qq.com
 * @date 2018/08/16
 */
@RestController
public class CityController {

    private static final int i = 0;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/save")
    public String save(String name,String introduce) {
        City city = new City(name,introduce);
        cityRepository.save(city);
        return "saved";
    }

    @GetMapping("/find")
    public City findOne(int id){
        return cityRepository.findOne(id);
    }

    @GetMapping("/update")
    public String update(int id,String cityUsername,String cityIntroduce){
        City city = new City(id, cityUsername, cityIntroduce);
        cityRepository.save(city);
        return "updated";
    }

    public String delete(int id){
        cityRepository.delete(id);
        return "deleted";
    }
}
