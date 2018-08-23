package cn.wb.learning.shiro.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.shiro.entity
 * @email wubin326@qq.com
 * @date 2018/08/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class SysRole {

    @Id
    @GeneratedValue
    private int roleId;

    @NonNull
    @NotNull
    private String roleName;

    //多对多关系
    @NonNull
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="sysMenuRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="menuId")})
    private List<SysMenu> menuList;

    //多对多关系
    @NonNull
    @ManyToMany
    @JoinTable(name="sysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="userId")})
    private List<SysUser> userList;// 一个角色对应多个用户

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }

    public List<SysMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenu> menuList) {
        this.menuList = menuList;
    }

}
