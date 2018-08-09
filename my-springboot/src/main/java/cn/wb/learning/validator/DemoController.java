package cn.wb.learning.validator;

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.validator
 * @email wubin326@qq.com
 * @date 2018/08/09
 */
@RestController
public class DemoController {

    @PostMapping("/")
    public String testDemo(@Valid Demo demo, BindingResult bindingResult) {

        StringBuffer stringBuffer = new StringBuffer();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError oe : allErrors
                    ) {
                stringBuffer.append(oe.getDefaultMessage()).append("-------------");
            }
        }
        return stringBuffer == null ? "" : stringBuffer.toString();
    }

}
