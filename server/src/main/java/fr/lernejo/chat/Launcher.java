package fr.lernejo.chat;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        template.setRoutingKey("chat_messages");

        while(true){
            System.out.println("Input a message, we will sent it for you (q for quit)");
            String rponse = scan.nextLine();
            if(rponse.equals("q")){
                System.out.println("Goodbye.");
                System.exit(0);
            }
            template.convertAndSend((rponse));
            System.out.println("Message sent.");
        }
    }
}
