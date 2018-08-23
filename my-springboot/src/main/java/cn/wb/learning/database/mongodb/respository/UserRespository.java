package cn.wb.learning.database.mongodb.respository;

import cn.wb.learning.database.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.mongodb.respository
 * @email wubin326@qq.com
 * @date 2018/08/14
 */
public interface UserRespository extends MongoRepository<User,Long> {
}
