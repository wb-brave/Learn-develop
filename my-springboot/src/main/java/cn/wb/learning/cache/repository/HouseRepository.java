package cn.wb.learning.cache.repository;

import cn.wb.learning.cache.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.cache.repository
 * @email wubin326@qq.com
 * @date 2018/08/22
 */
public interface HouseRepository extends JpaRepository<House,Integer> {
}
