package com.sensetime.study.service;


import javax.servlet.http.HttpServletRequest;

import com.sensetime.study.model.Mail;

public interface MailService {

    /**
     * 发送简单邮件
     * @param mail
     */
    void sendSimpleMail(Mail mail);

    /**
     * 发送带附件的邮件
     * @param mail
     * @param request
     */
    void sendAttachmentsMail(Mail mail, HttpServletRequest request);

    /**
     * 发送静态资源  一张照片
     * @param mail
     * @throws Exception
     */
    void sendInlineMail(Mail mail) throws Exception;

    /**
     * 发送模板邮件
     * @param mail
     */
    void sendTemplateMail(Mail mail);
}