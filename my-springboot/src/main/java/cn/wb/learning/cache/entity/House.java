package cn.wb.learning.cache.entity;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.cache.entity
 * @email wubin326@qq.com
 * @date 2018/08/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class House implements Serializable {

    @Id
    @GeneratedValue
    private int houseId;

    @NonNull
    @Column(length = 8)
    private String houseName;

    @NonNull
    private String houseSize;
}

