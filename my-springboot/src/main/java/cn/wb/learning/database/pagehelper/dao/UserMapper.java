package cn.wb.learning.database.pagehelper.dao;

import cn.wb.learning.database.pagehelper.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;


/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.pagehelper.dao
 * @email wubin326@qq.com
 * @date 2018/08/17
 */
//@Mapper 通常springboot不能自动装载成功
// 在启动了类加上 @MapperScan(basePackages = "cn.wb.learning.database.pagehelper.dao")
public interface UserMapper {

    @Select("select * from user")
    Page<User> selects();
}
