package org.example.springVsSwitch;

import org.springframework.stereotype.Component;

@Component
public class ViberMessageSender implements MessageSender {

    @Override
    public String sendMessage() {
        return "Viber message";
    }

    @Override
    public String myCode() {
        return "Viber";
    }
}
