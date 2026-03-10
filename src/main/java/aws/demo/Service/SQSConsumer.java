package aws.demo.Service;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SQSConsumer {
    @SqsListener("order-queue")
    public void receiveMessage(String message){
    System.out.println("Message received from queue: " + message);
    }
}
