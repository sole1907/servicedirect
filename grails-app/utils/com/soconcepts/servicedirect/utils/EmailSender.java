/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soconcepts.servicedirect.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author SOUL
 */
public class EmailSender extends Thread {

    private String emailmsg;
    private Map<String, String> rootMap;
    private String from;
    private String to;
    private String subject;
    private String baseUrl;

    public EmailSender(String emailmsg, Map<String, String> rootMap, String from, String to, String subject, String baseUrl) {
        this.emailmsg = emailmsg;
        this.rootMap = rootMap;
        this.from = from;
        this.subject = subject;
        this.to = to;
        this.baseUrl = baseUrl;
    }

    @Override
    public void run() {
        Properties props = new Properties();
        try {
            //props.load(new FileInputStream(new File("mailsettings.properties")));
            props.load(new InputStreamReader(UtilityMethods.class.getClassLoader().getResourceAsStream("mailsettings.properties")));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "info@servicedirect.com.ng", "info@2014!");
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);

            BodyPart body = new MimeBodyPart();

            // freemarker stuff.
            Configuration cfg = new Configuration();
            cfg.setClassForTemplateLoading(UtilityMethods.class, "/");
            Template template = cfg.getTemplate("html-mail-template.ftl");
            Writer out = new StringWriter();
            Map<String, String> emailMap = new HashMap<String, String>();
            emailMap.put("body", emailmsg);
            emailMap.put("baseurl", baseUrl);
            template.process(emailMap, out);
            template = new Template("emailTemplate", new StringReader(out.toString()), cfg);
            out = new StringWriter();
            template.process(rootMap, out);
            // freemarker stuff ends.

            /* you can add html tags in your text to decorate it. */
            body.setContent(out.toString(), "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(body);

            //body = new MimeBodyPart();
            //String filename = "hello.txt";
            //DataSource source = new FileDataSource(filename);
            //body.setDataHandler(new DataHandler(source));
            //body.setFileName(filename);
            //multipart.addBodyPart(body);
            message.setContent(multipart, "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Done....");
    }
}
