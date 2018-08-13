package cn.wb.learning.web.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.web.i18n
 * @email wubin326@qq.com
 * @date 2018/08/13
 */
@Controller
public class I18nController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/i18n")
    public String i18n(Model model) {
        Locale local = LocaleContextHolder.getLocale();
        model.addAttribute("message", messageSource.getMessage("message", null, local));
        return "index1";
    }
}
