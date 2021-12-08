package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatMessageController {
    private ChatMessageListener chMsgListen;

    public ChatMessageController(ChatMessageListener chLst){
        this.chMsgListen = chLst;
    }
    @GetMapping(path = "/api/message")
    public List<String> getmessage(){
        return chMsgListen.chmRepo.getLastTenMessages();
    }

}
