package the.zero.shail.sender.listeners;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Sender {
    private final RabbitTemplate rabbitTemplate;
    static String exchangeName = "docExchange";

    public void send(String json){
        rabbitTemplate.convertAndSend(exchangeName, "doc", json);
    }
}
