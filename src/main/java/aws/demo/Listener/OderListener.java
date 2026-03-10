package aws.demo.Listener;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class OderListener {

    @SqsListener("order-queue")
    public void receiveMessage(String message){
        System.out.println("Message received from queue: " + message);
    }
}