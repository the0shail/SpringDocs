package the.zero.shail.sender.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    private final String queueName = "queuePassport";

    @RabbitListener(queues = queueName)
    public void listen(String message) {
        System.out.println("Message read from " + queueName + " : " + message);
    }
}
