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
public class SysMenu {

    @Id
    @GeneratedValue
    private Integer menuId;

    @NonNull
    @NotNull
    private String menuName;

    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sysMenuRole", joinColumns = {@JoinColumn(name = "menuId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList;
}
