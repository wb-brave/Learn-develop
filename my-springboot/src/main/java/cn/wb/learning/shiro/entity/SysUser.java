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
public class SysUser {

    @Id
    @GeneratedValue
    private int userId;

    @NonNull
    @NotNull
    private String username;

    @NonNull
    @NotNull
    private String password;

    @NonNull
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "sysUserRole",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> sysRoleList;

}
