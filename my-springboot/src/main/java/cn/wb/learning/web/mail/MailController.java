package cn.wb.learning.web.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.web.mail
 * @email wubin326@qq.com
 * @date 2018/08/13
 */
@RestController
public class MailController {

    private static final Log log = LogFactory.getLog(MailController.class);

    //获取resources目录下的 application.properties 里面的配置
    @Value("${mail.fromMail.sender}")
    private String sender;

    @Value("${mail.fromMail.receiver}")
    private String receviewr;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * @param null
     * @return
     * @throws
     * @author wubin
     * @date 2018-08-13 15:20
     * @description 发送简单的文本邮件
     * @since
     */
    @RequestMapping("/sendMail")
    public String sendMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(receviewr);
        simpleMailMessage.setSubject("吴彬");
        simpleMailMessage.setText("你好啊 spring! ");
        javaMailSender.send(simpleMailMessage);
        log.info("邮件已发。");
        return "success";
    }

    /**
     * @param null
     * @return
     * @throws
     * @author wubin
     * @date 2018-08-13 16:14
     * @description 发送HTML内容邮件
     * @since
     */
    @RequestMapping("sendHtmlMail")
    public String sendHtmlMail() {
        String content = "\"<html>\\n\" +\n" +
                "                \"<body>\\n\" +\n" +
                "                \"    <h3>hello world ! 这是一封Html邮件!</h3>\\n\" +\n" +
                "                \"</body>\\n\" +\n" +
                "                \"</html>\";\n" +
                "\n";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            //mimeMessage 帮助类
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            //设置发送者
            mimeMessageHelper.setFrom(sender);
            //设置接收者
            mimeMessageHelper.setTo(receviewr);
            //设置发送者名称
            mimeMessageHelper.setSubject("吴彬");
            //设置发送内容
            mimeMessageHelper.setText(content, true);
            //发送
            javaMailSender.send(mimeMessage);
            log.info("HTML邮件已发送");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "success html";
    }

    /**
     * @param null
     * @return
     * @throws
     * @author wubin
     * @date 2018-08-13 16:32
     * @description 发送带有附件的邮件
     * @since
     */
    @RequestMapping("sendAttachMail")
    public String sendAttachMail() {
        String filePath = "/Users/wufan/DeskTop/test/new.txt";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(receviewr);
            mimeMessageHelper.setText("这是一封带有附件的邮件");
            mimeMessageHelper.setSubject("查收附件");

            //获取文件系统数据源
            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(0, filePath.lastIndexOf(".") + 1);
            //将附件关联到mimeMessage
            mimeMessageHelper.addAttachment(fileName, fileSystemResource);

            //发送
            javaMailSender.send(mimeMessage);
            log.info("附件邮件已发送");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "success2";
    }

    /**
     * @param null
     * @return
     * @throws
     * @author wubin
     * @date 2018-08-13 17:19
     * @description 发送带有图片的邮件（按照html的体制）
     * @since
     */
    @RequestMapping("/sendPhotoMail")
    public String sendPhotoMail() {
        String id = "wufan1";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + id + "\' ></body></html>";
        String filePath = "/Users/wufan/Desktop/wb/school/rest/card-photo/IMG_0121111.jpg";
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(receviewr);
            mimeMessageHelper.setSubject("带有图片的邮件");
            mimeMessageHelper.setText(content, true);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            //将图片内嵌到网页中
            mimeMessageHelper.addInline(id, fileSystemResource);

            javaMailSender.send(mimeMessage);
            log.info("带有图片的邮件已发送");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "success3";
    }
}
