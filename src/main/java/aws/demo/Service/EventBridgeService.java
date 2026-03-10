package aws.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.eventbridge.EventBridgeClient;
import software.amazon.awssdk.services.eventbridge.model.PutEventsRequest;
import software.amazon.awssdk.services.eventbridge.model.PutEventsRequestEntry;

@Service
public class EventBridgeService {

    @Autowired
    private EventBridgeClient client;

    public void publishOrderEvent(String order){
    PutEventsRequestEntry entry = PutEventsRequestEntry.builder().eventBusName("demo-bus")
                        .source("order.service")
                        .detailType("orderCreated")
                        .detail("{\"order\":\""+order+"\"}")
                        .build();

        client.putEvents(PutEventsRequest.builder().entries(entry).build()
        );
        System.out.println("event published");
    }
}
