package cn.wb.learning.database.druid.servlert;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.druid.servlert
 * @email wubin326@qq.com
 * @date 2018/08/16
 */
@WebServlet(urlPatterns = "/druid/*", initParams = {
        @WebInitParam(name = "allow", value = "127.0.0.1"),//配置登录druid平台的ip白名单，未配置则允许全部
        @WebInitParam(name = "deny", value = ""),//黑名单，未配置则无，优先级大于白名单
        @WebInitParam(name = "loginUsername", value = "wubin"),
        @WebInitParam(name = "loginPassword", value = "123456")
})
public class DruidServlert extends StatViewServlet {

}
