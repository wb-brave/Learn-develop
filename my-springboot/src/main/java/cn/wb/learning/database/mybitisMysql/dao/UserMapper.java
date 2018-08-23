package cn.wb.learning.database.mybitisMysql.dao;

import cn.wb.learning.database.mybitisMysql.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.mybitisMysql.dao
 * @email wubin326@qq.com
 * @date 2018/08/14
 */
//@Mapper
public interface UserMapper {
    User findUserByUsername(String username);

    int updateUserByUsername(User user);

    int deleteUserByUsername(String username);

    int saveUser(User user);

    List<User> getUserList();

}
