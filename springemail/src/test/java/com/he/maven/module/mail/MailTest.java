package com.he.maven.module.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by heyanjing on 2017/12/8 15:09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"})
public class MailTest {
    private static final Logger log = LoggerFactory.getLogger(MailTest.class);
    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 邮箱注册验证
     */
    @Test
    public void send0() {
        StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！\n");
        sb.append("http://localhost:8080/springmvc/user/register?action=activate&email=");
        sb.append("email");
        sb.append("&validateCode=");
        sb.append("validateCode");
        SimpleMailMessage mail = new SimpleMailMessage();
        try {
            mail.setFrom("1366162208@qq.com");// 发送者,
            mail.setTo("993912685@qq.com");// 接受者
            mail.setSubject("测试主题");// 主题
            mail.setText(sb.toString());// 邮件内容
            javaMailSender.send(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 存文本
     */
    @Test
    public void send1() {
        SimpleMailMessage mail = new SimpleMailMessage();
        try {
            mail.setFrom("1366162208@qq.com");// 发送者,
            mail.setTo("993912685@qq.com");// 接受者
            mail.setSubject("测试主题");// 主题
            mail.setText("发送邮件内容测试");// 邮件内容
            javaMailSender.send(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 带附件
     */
    @Test
    public void send2() {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
        // 你需要使用true作为标记来指出你多条信息所需要发送的内容
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("1366162208@qq.com");
            helper.setTo("993912685@qq.com");
            helper.setText("Check out this image!");
            helper.setSubject("附件");
            // 让我们来把臭名昭著的windows示例文件附件上(这次我们已经复制到c:/)
            FileSystemResource file = new FileSystemResource(new File("D:\\Temp/2.jpg"));
            helper.addAttachment("2.jpg", file);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 内嵌资源
     */
    @Test
    public void send3() {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
        // 你需要使用true作为标记来指出你多条信息所需要发送的内容
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("1366162208@qq.com");
            helper.setTo("993912685@qq.com");
            helper.setText("<html><body><img src='cid:id'></body></html>", true);
            helper.setSubject("附件");
            // 让我们来把臭名昭著的windows示例文件附件上(这次我们已经复制到c:/)
            FileSystemResource file = new FileSystemResource(new File("D:\\Temp/2.jpg"));
            //指定资源id
            helper.addInline("id",file);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
