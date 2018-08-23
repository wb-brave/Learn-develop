package cn.wb.learning.database.muiltDatasource.controller;

import cn.wb.learning.database.muiltDatasource.entity.datasource.User;
import cn.wb.learning.database.muiltDatasource.entity.datasource2.User1;
import cn.wb.learning.database.muiltDatasource.repository.datasource.PrimaryRepository;
import cn.wb.learning.database.muiltDatasource.repository.datasource2.SecondaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.muiltDatasource.controller
 * @email wubin326@qq.com
 * @date 2018/08/15
 */
@RestController
public class DBsController {
    @Autowired
    private PrimaryRepository primaryRepository;
    @Autowired
    private SecondaryRepository secondaryRepository;

    @GetMapping("/user2")
    public String testDatasource1(){
        User user = new User("wubin2","123");
        primaryRepository.save(user);
        return "success";
    }

    @GetMapping("/user3")
    public String testDatasource2(){
        User1 user1 = new User1("wubin3","123");
        secondaryRepository.save(user1);
        return "success";
    }
}
