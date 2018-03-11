package com.bytewheels.common.service;

import com.bytewheels.common.dto.MailContent;

public interface MailService {

    void sendMail(String to, MailContent mailContent);
}
