package cn.wb.learning.web.freemaker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.web.freemaker
 * @email wubin326@qq.com
 * @date 2018/08/10
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public String testFm(ModelMap modelMap){
        modelMap.addAttribute("msg","wb freemarker ! ");
        return "freemarker";
    }

}
