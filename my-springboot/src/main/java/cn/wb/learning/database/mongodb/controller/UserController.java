package cn.wb.learning.database.mongodb.controller;

import cn.wb.learning.database.mongodb.entity.User;
import cn.wb.learning.database.mongodb.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.mongodb.controller
 * @email wubin326@qq.com
 * @date 2018/08/14
 */
@RestController
public class UserController {

    @Autowired
    private UserRespository userRespository;
    private static long i = 0;

    @GetMapping("/save")
    public String save() {
        User user = new User(i++, "wb" + i, "18", "dg");
        userRespository.save(user);
        return "success";
    }

    @GetMapping("/userList")
    public List<User> findAll() {
        List<User> userList = userRespository.findAll();
        return userList;
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        userRespository.delete(id);
        return "success1";
    }

    @GetMapping("/update")
    public String update(Long id, String name, String age, String address) {
        User user = new User(id, name, age, address);
        userRespository.save(user);
        return "success2";
    }
}
