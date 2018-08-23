package cn.wb.learning.database.muiltDatasource.entity.datasource;

import lombok.*;

import javax.persistence.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.muiltDatasource.entity.datasource
 * @email wubin326@qq.com
 * @date 2018/08/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NonNull
    private String username;
    @NonNull
    private String password;
}