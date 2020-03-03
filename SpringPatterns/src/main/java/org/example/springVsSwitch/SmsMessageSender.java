package org.example.springVsSwitch;

import org.springframework.stereotype.Component;

@Component
public class SmsMessageSender implements MessageSender {

    @Override
    public String sendMessage() {
        return "SMS message";
    }

    @Override
    public String myCode() {
        return "SMS";
    }
}
