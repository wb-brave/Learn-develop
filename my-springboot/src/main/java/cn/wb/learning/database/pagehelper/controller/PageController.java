package cn.wb.learning.database.pagehelper.controller;

import cn.wb.learning.database.pagehelper.dao.UserMapper;
import cn.wb.learning.database.pagehelper.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.pagehelper.controller
 * @email wubin326@qq.com
 * @date 2018/08/17
 */
@RestController
public class PageController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/selects")
    public Page<User> selects(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> selects = userMapper.selects();
        return selects;
    }
}
