package cn.wb.learning.shiro.config;

import cn.wb.learning.shiro.entity.SysMenu;
import cn.wb.learning.shiro.entity.SysRole;
import cn.wb.learning.shiro.entity.SysUser;
import cn.wb.learning.shiro.repositoty.ShiroRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.shiro.config
 * @email wubin326@qq.com
 * @date 2018/08/17
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private ShiroRepository shiroRepository;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        for (SysRole sysRole : sysUser.getSysRoleList()
                ) {

            simpleAuthorizationInfo.addRole(sysRole.getRoleName());
            for (SysMenu sysMenu : sysRole.getMenuList()
                    ) {
                simpleAuthorizationInfo.addStringPermission(sysMenu.getMenuName());
            }
        }
        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获得当前用户的用户名
        String username = (String) authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());

        //根据用户名找到对象
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser sysUser = shiroRepository.getSysUsersByUsername(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),getName());
        return simpleAuthenticationInfo;
    }
}
