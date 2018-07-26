package cn.wb.spring.first.springmvc.sample.controller;

import cn.wb.spring.first.springmvc.sample.entity.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class UserController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

        List<User> users = new ArrayList<User>();
        User user = new User("w","b");
        User user1 = new User("w1","b1");
        users.add(user);
        users.add(user1);
        return new ModelAndView("userlist","users",users);
    }
}
