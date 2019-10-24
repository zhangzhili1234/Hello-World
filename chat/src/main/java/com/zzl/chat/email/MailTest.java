package com.zzl.chat.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

/**
 * @author john(coder_john@163.com)
 * @desc mail测试类
 * @date 2019-07-22
 */
@RestController
public class MailTest {

    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String form;

    @GetMapping("/email")
    public void sendEmail(){
        sendHTMLMail();
    }

    private void sendHTMLMail() {
        try {
            MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(form);
            mimeMessageHelper.setTo("497305473@qq.com");
            mimeMessageHelper.setSubject("测试邮件");
            String sb = "<h1>SpirngBoot测试邮件HTML</h1>" + "<p style='color:#F00'>你是真的太棒了！</p>" +
                    "<p style='text-align:right'>右对齐</p>";
            mimeMessageHelper.setText(sb, true);
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            System.out.println("邮件发送失败" + e.getMessage());
        }
    }

}
