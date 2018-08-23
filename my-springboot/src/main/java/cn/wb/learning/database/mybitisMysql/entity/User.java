package cn.wb.learning.database.mybitisMysql.entity;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.mybitisMysql.entity
 * @email wubin326@qq.com
 * @date 2018/08/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Alias("user")
public class User {
    private int id;
    @NonNull
    private String user_name;
    @NonNull
    private String pass_word;
}
