package cn.wb.learning.lombok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.lombok
 * @email wubin326@qq.com
 * @date 2018/08/10
 */
@RestController
public class LbController {

    @GetMapping(value = "/user")
    public LbUser getUser(){
        LbUser wubin = new LbUser(12, "wubin", "123456");
        System.out.println(wubin.toString());
        return wubin;
    }

}
