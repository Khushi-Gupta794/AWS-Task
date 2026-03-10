package aws.demo.Service;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SQSProducer {

    @Autowired
    private SqsTemplate sqsTemplate;

    public void sendMessage(String message){
    sqsTemplate.send("order-queue", message);
    }

}