package com.demos.springbootdemos.Domain;

import com.demos.springbootdemos.Utils.PropertiesUtil;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Properties;

public class MailSender {

    //邮件实体
    private MailEntity mailEntity;


    /**
     * 设置邮件标题
     *
     * @param title 标题信息
     * @return
     */
    public MailSender title(String title) {
        mailEntity.setTitle(title);
        return this;
    }

    /**
     * 设置邮箱内容
     *
     * @param content
     * @return
     */
    public MailSender content(String content) {
        mailEntity.setContent(content);
        return this;
    }

    /**
     * 设置邮件格式
     *
     * @param typeEnum
     * @return
     */
    public MailSender contentType(MailContentTypeEnum typeEnum) {
        mailEntity.setContentType(typeEnum.getValue());
        return this;
    }

    /**
     * 设置请求目标邮件地址
     *
     * @param targets
     * @return
     */
    public MailSender targets(List<String> targets) {
        mailEntity.setList(targets);
        return this;
    }

    public void send() throws Exception {
        //默认使用html内容发送
        if (mailEntity.getContentType() == null) {
            mailEntity.setContentType(MailContentTypeEnum.HTML.getValue());
        }
        if (mailEntity.getTitle() == null || mailEntity.getTitle().trim().length() == 0) {
            throw new Exception("邮件标题没有设置，调用title方法设置");
        }
        if (mailEntity.getContent() == null || mailEntity.getContent().trim().length() == 0) {
            throw new Exception("邮件内容没有设置，调用content方法设置");
        }
        if (mailEntity.getList().size() == 0) {
            throw new Exception("没有接受者邮箱地址，调用targets方法设置");
        }

        //读取properties文件内容
        final PropertiesUtil properties = new PropertiesUtil("mail");
        //创建prop类用于记录邮箱的一些属性
        final Properties prop = new Properties();
        //表示smtp发送邮件，必须进行身份验证
        prop.put("mail.smtp.auth", "true");
        //此处填写smtp服务器
        prop.put("mail.smtp.host", properties.getValue("mail.smtp.service"));
        //设置端口号，QQ邮箱给出了两个端口465/587
        prop.put("mail.smtp.port", properties.getValue("mail.smtp.prot"));
        //设置发送邮箱
        prop.put("mail.user", properties.getValue("mail.from.address"));
        //发送邮箱的16位SMTP口令
        prop.put("mail.password", properties.getValue("mail.from.smtp.pwd"));

        //构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                //用户名，密码
                String userName = prop.getProperty("mail.user");
                String password = prop.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };

        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(prop, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        String nickName = MimeUtility.encodeText(properties.getValue("mail.from.nickname"));
        InternetAddress form = new InternetAddress(nickName + " <" + prop.getProperty("mail.user") + ">");
        message.setFrom(form);

        // 设置邮件标题
        message.setSubject(mailEntity.getTitle());
        //html发送邮件
        if (mailEntity.getContentType().equals(MailContentTypeEnum.HTML.getValue())) {
            // 设置邮件的内容体
            message.setContent(mailEntity.getContent(), mailEntity.getContentType());
        }
        //文本发送邮件
        else if (mailEntity.getContentType().equals(MailContentTypeEnum.TEXT.getValue())) {
            message.setText(mailEntity.getContent());
        }
        //发送邮箱地址
        List<String> targets = mailEntity.getList();
        for (int i = 0; i < targets.size(); i++) {
            try {
                // 设置收件人的邮箱
                InternetAddress to = new InternetAddress(targets.get(i));
                message.setRecipient(Message.RecipientType.TO, to);
                // 最后当然就是发送邮件啦
                Transport.send(message);
            } catch (Exception e) {
                continue;
            }

        }
    }
}
