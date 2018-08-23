package cn.wb.learning.shiro.repositoty;

import cn.wb.learning.shiro.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.shiro.repositoty
 * @email wubin326@qq.com
 * @date 2018/08/17
 */
public interface ShiroRepository extends JpaRepository<SysUser,Integer>{

    SysUser getSysUsersByUsername(String username);
}
