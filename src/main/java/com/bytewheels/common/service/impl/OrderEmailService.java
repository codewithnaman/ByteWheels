package com.bytewheels.common.service.impl;

import com.bytewheels.common.dto.MailContent;
import com.bytewheels.common.service.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service("orderMailService")
public class OrderEmailService implements MailService {

    private static final String ORDER_MAIL_SUBJECT = "ByteWheels : Thanks for Order";
    private static final String ORDER_MAIL = "order-bytewheels@gmail.com";
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private Configuration freemarkerConfig;

    public void sendMail(String to, MailContent mailContent) {
        Thread emailThread = new Thread(() -> {
            try {
                MimeMessage message = emailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message,
                        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                        StandardCharsets.UTF_8.name());
                helper.addAttachment("logo.png", new ClassPathResource("img/byteWheels.png"));
                Template t = freemarkerConfig.getTemplate("email-template.ftl");
                Map<String, MailContent> model = new HashMap<>();
                model.put("orderResponseDetails", mailContent);
                String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
                helper.setTo(to);
                helper.setText(html, true);
                helper.setSubject(ORDER_MAIL_SUBJECT);
                helper.setFrom(ORDER_MAIL);
                emailSender.send(message);
            } catch (MessagingException | IOException | TemplateException e) {
                e.printStackTrace();
            }
        });
        emailThread.start();
    }
}
