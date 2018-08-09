package cn.wb.learning.jsonandxml;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.jsonandxml
 * @email wubin326@qq.com
 * @date 2018/08/08
 */
@RestController
public class UserController {

    @GetMapping(value = "/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public User index(){
        User user = new User("wubin", "18", "dg");
        return user;
    }

    @GetMapping(value = "/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public User xml(){
        User user = new User("wubin", "18", "dg");
        return user;
    }
}
