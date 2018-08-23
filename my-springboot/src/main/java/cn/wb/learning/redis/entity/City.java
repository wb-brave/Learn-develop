package cn.wb.learning.redis.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.redis.entity
 * @email wubin326@qq.com
 * @date 2018/08/21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class City implements Serializable{

    private String cityId;

    @NonNull
    private String cityName;

    @NonNull
    private String cityIntroduce;
}
