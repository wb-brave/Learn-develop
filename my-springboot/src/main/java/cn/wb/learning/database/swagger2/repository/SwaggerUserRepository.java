package cn.wb.learning.database.swagger2.repository;

import cn.wb.learning.database.swagger2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.swagger2.repository
 * @email wubin326@qq.com
 * @date 2018/08/16
 */
public interface SwaggerUserRepository extends JpaRepository<User,Integer> {
    User findById(int id);
}
