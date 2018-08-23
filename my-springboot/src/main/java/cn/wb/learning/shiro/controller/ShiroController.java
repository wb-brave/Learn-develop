package cn.wb.learning.shiro.controller;

import cn.wb.learning.shiro.repositoty.ShiroRepository;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.shiro.controller
 * @email wubin326@qq.com
 * @date 2018/08/17
 */
@Controller
public class ShiroController {

    @Autowired
    private ShiroRepository shiroRepository;

    @GetMapping({"/","/index"})
    public String index(){
        return"index";
    }

    @GetMapping("/403")
    public String unauthorizedRole(){
        return "403";
    }

    @GetMapping("/delete")
    //@RequiresPermissions("delete")
    @RequiresRoles("admin")
    public String delete(){
        return "delete";
    }

    @GetMapping("/select")
    @RequiresPermissions("select")
    public String select(){
        return "select";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        //根据异常判断错误类型
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密码不正确";
            } else {
                msg = "else >> "+exception;
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }
}
