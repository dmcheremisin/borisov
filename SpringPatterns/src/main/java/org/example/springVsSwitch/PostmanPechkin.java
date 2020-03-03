package org.example.springVsSwitch;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostmanPechkin {

    private final Map<String, MessageSender> messageSenderMap;

    public PostmanPechkin(List<MessageSender> senders) {
        messageSenderMap = senders.stream().collect(Collectors.toMap(MessageSender::myCode, m -> m));
    }

    public void sendMessage(String channel) {
//        switch(channel) {
//            case "Viber":
//                ....
//        }
        System.out.println(messageSenderMap.get(channel).sendMessage());
    }
}
