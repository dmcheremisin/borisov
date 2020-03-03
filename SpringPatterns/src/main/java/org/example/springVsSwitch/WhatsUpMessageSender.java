package org.example.springVsSwitch;

import org.springframework.stereotype.Component;

@Component
public class WhatsUpMessageSender implements MessageSender {

    @Override
    public String sendMessage() {
        return "WhatsUp message";
    }

    @Override
    public String myCode() {
        return "WhatsUp";
    }
}
