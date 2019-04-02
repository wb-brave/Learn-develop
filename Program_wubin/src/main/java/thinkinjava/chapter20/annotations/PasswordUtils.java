package thinkinjava.chapter20.annotations;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter20.annotations
 * @email wubin326@qq.com
 * @date 2018/12/29
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/29        wubin            0.0.1
 */
public class PasswordUtils {

    @UseCase(id = 47, desc = "password must contain one numeric at least")
    public boolean validatePassword(String pw){
        return pw.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryPassword(String pw){
        return new StringBuilder(pw).reverse().toString();
    }

    @UseCase(id = 49, desc = "new passwords can't equal pre pw")
    public boolean checkForNewPassword(String pw, List<String> prepw){
        return prepw.contains(pw);
    }

}
