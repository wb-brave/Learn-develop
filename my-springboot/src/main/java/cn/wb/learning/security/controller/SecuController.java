package cn.wb.learning.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.security.controller
 * @email wubin326@qq.com
 * @date 2018/08/17
 */
@Controller
public class SecuController {

    @RequestMapping("/")
    public String index(){
        return "security/index";
    }

    @RequestMapping("/index")
    public String index2(){
        return "security/index";
    }

    @RequestMapping("/user")
    public String user(){
        return "security/user/index";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "security/admin/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "security/login";
    }

    @RequestMapping("/login_error")
    public String login_error(Model model){
        model.addAttribute("login_error", "用户名或密码错误");
        return "security/login";
    }

    @RequestMapping("/logout")
    public String logout(Model model){
        model.addAttribute("login_error", "注销成功");
        return "security/login";
    }

    @RequestMapping("/401")
    public String error(){
        return "security/401";
    }
}
