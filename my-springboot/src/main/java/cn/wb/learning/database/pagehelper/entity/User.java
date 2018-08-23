package cn.wb.learning.database.pagehelper.entity;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.pagehelper.entity
 * @email wubin326@qq.com
 * @date 2018/08/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Alias("user")
public class User {

    private int id;

    @NonNull
    private String username;

    @NonNull
    private String password;
}
