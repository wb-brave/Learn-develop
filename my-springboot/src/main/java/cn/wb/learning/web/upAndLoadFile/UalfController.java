package cn.wb.learning.web.upAndLoadFile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.web.upAndLoadFile
 * @email wubin326@qq.com
 * @date 2018/08/13
 */
@Controller
public class UalfController {

    //接入请求，起跳转作用
    @RequestMapping("/ualf")
    public String test(){
        return "upAndLoadFile";
    }
}
