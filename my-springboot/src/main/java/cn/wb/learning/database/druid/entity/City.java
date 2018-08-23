package cn.wb.learning.database.druid.entity;

import javafx.beans.DefaultProperty;
import lombok.*;

import javax.persistence.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.druid.entity
 * @email wubin326@qq.com
 * @date 2018/08/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String cityName;

    @NonNull
    private String cityIntroduce;
}
