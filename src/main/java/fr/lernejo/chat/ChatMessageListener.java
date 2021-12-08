package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {
    ChatMessageRepository chmRepo = new ChatMessageRepository();
    public void onMessage(String contenu){
        chmRepo.addChatMessage(contenu);
    }
}
