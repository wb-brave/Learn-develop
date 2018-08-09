package cn.wb.learning.validator;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.validator
 * @email wubin326@qq.com
 * @date 2018/08/09
 */
public class Demo {

    @NotEmpty(message = "用户名不允许为空")
    @Length(min = 6, max = 8, message = "用户名长度在6-8之间")
    private String username;

    @NotEmpty(message = "密码不允许为空")
    @Length(min = 6, message = "密码长度不允许小于6")
    private String password;

    @Email(message = "请输入正确的邮箱")
    private String email;

    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误")
    private String idCard;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
