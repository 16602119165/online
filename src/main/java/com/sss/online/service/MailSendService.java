package com.sss.online.service;

import com.sss.online.vo.QJGLVO;

/**
 * @author
 * @create 2019-07-05-10:56
 */
public interface MailSendService {
    void sendSimpleMail(QJGLVO qjglvo);
    void sendComplex(QJGLVO qjglvo);
}
