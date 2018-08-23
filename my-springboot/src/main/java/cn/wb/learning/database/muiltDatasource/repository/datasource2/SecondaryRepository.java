package cn.wb.learning.database.muiltDatasource.repository.datasource2;

import cn.wb.learning.database.muiltDatasource.entity.datasource2.User1;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.muiltDatasource.repository.datasource2
 * @email wubin326@qq.com
 * @date 2018/08/15
 */
public interface SecondaryRepository extends JpaRepository<User1,Integer> {
}
