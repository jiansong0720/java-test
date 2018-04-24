package ltd.service.webservice;

import ltd.config.MailConfig;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * Created by song on 2017/11/24.
 */
@Service
public class MailService {

    @Resource
    private Mailer mailer;
    @Resource
    private MailConfig mailConfig;

    /**
     * 发送邮件
     */
    public void sendMail(String toName, String to, String subject, String content) throws UnsupportedEncodingException, MessagingException {
        Email email = new EmailBuilder().from(mailConfig.getPersonal(), mailConfig.getEmailForm()).to(toName, to).subject(subject).text(content).build();
        mailer.sendMail(email);
    }

}
