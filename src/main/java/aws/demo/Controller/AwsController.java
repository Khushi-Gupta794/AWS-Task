package aws.demo.Controller;

import aws.demo.Service.EventBridgeService;
import aws.demo.Service.S3Service;
import aws.demo.Service.SQSProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/aws")
public class AwsController {

    @Autowired
    private S3Service s3Service;

    @Autowired
    private SQSProducer sqsProducer;

    @Autowired
    private EventBridgeService eventBridgeService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file) throws Exception {
        return s3Service.uploadFile(file);
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String msg){
     sqsProducer.sendMessage(msg);
     return "Message Sent";
    }

    @GetMapping("/event")
    public String publishEvent(@RequestParam String msg){
     eventBridgeService.publishOrderEvent(msg);
        return "Event Sent";
    }
}
