package cn.wb.learning.database.swagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.swagger2.entity
 * @email wubin326@qq.com
 * @date 2018/08/16
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "user")
public class User {

    @ApiModelProperty(value = "主键id",hidden = true)
    @GeneratedValue
    @Id
    private int id;

    @ApiModelProperty(value = "用户名")
    @NonNull
    @NotNull
    @Column
    private String username;

    @ApiModelProperty(value = "密码")
    @NonNull
    @NotNull
    @Column
    private String password;
}
