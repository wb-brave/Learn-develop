package cn.wb.learning.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.lombok
 * @email wubin326@qq.com
 * @date 2018/08/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LbUser {

    private Integer id;
    private String name;
    private String password;
}
