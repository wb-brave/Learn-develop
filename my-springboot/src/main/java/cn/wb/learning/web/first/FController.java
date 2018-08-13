package cn.wb.learning.web.first;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.web.first
 * @email wubin326@qq.com
 * @date 2018/08/10
 */
@RestController
public class FController {

    @RequestMapping("/")
    public String test(){
        return "wubin is great";
    }

}
