package cn.wb.learning.database.mybitisMysql.controller;

import cn.wb.learning.database.mybitisMysql.dao.UserMapper;
import cn.wb.learning.database.mybitisMysql.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.mybitisMysql.controller
 * @email wubin326@qq.com
 * @date 2018/08/14
 */
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/update")
    public String updateUser(String username, String password) {
        User user = new User(username, password);
        int i = userMapper.updateUserByUsername(user);
        return i > 0 ? "update success" : "update fail";
    }

    @GetMapping("/delete")
    public String deleteUser(String username) {
        int i = userMapper.deleteUserByUsername(username);
        return i > 0 ? "delete success" : "delete fail";
    }

    @GetMapping("/find")
    public List<User> find() {
        List<User> userList = userMapper.getUserList();
        return userList;
    }

    @GetMapping("/insert")
    public String save(String username, String password) {
        User user = new User(username, password);
        int i = userMapper.saveUser(user);
        return i > 0 ? "save success" : "save fail";
    }

    @GetMapping("/findBy")
    public User findByUsername(String username){
        User user = userMapper.findUserByUsername(username);
        return user;
    }
}
