package cn.wb.learning.database.muiltDatasource.repository.datasource;

import cn.wb.learning.database.muiltDatasource.entity.datasource.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.muiltDatasource.repository.datasource
 * @email wubin326@qq.com
 * @date 2018/08/15
 */
public interface PrimaryRepository extends JpaRepository<User,Integer> {
}
