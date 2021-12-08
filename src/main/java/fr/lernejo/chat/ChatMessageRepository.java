package fr.lernejo.chat;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageRepository {
    List <String> msgList;

    public ChatMessageRepository(){
        msgList = new ArrayList<>();
    }
    void addChatMessage(String message){
        if(msgList.size()<10){
            msgList.add(message);
        }
        else{
            msgList.add(message);
            msgList = msgList.subList(msgList.size()-10,msgList.size());
        }
    }

    List<String> getLastTenMessages(){
        return msgList;
    }
}
