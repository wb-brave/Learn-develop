package cn.wb.learning.database.swagger2.swagger;

import cn.wb.learning.database.swagger2.entity.User;
import cn.wb.learning.database.swagger2.repository.SwaggerUserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.swagger2.swagger
 * @email wubin326@qq.com
 * @date 2018/08/16
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户操作接口", tags = {"用户操作接口"})
public class UserWagger {

    @Autowired
    SwaggerUserRepository userRepository;

    @ApiOperation(value = "获取用户详细信息", notes = "根据用户的id查找用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", dataType = "Integer")
    @GetMapping("/findById")
    public User findById(@RequestParam(value = "id") int id) {
        User user = userRepository.findById(id);
        return user;
    }

    @ApiOperation(value = "查找所有用户信息", notes = "查找全部用户")
    @GetMapping("/findAll")
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据用户的id查找用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String")
    })
    @GetMapping("/update")
    public String upadate(@RequestParam(value = "id") int id, @RequestParam("username") String username, @RequestParam("password") String password) {

        User user = new User(id, username, password);
        userRepository.save(user);
        return "update success";
    }

    @ApiOperation(value="删除用户", notes="根据用户的id来删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true,paramType = "query", dataType = "Integer")
    @DeleteMapping(value="/deleteUserById")
    public String deleteUserById(@RequestParam(value = "id")int id){
        User user = userRepository.findById(id);
        userRepository.delete(user);
        return "success!";
    }

    @ApiOperation(value = "保存用户信息", notes = "保存用户信息")
    @PostMapping("/save")
    public String save(@RequestBody @ApiParam(name = "用户对象", value = "传入json格式", required = true) User user) {
        User save = userRepository.save(user);
        return "save success";
    }
}
