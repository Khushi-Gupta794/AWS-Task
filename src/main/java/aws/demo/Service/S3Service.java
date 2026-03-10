package aws.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Service
public class S3Service {

    @Autowired
    private S3Client s3Client;

    public String uploadFile(MultipartFile file) throws IOException {

        String bucket = "demo-bucket";

        s3Client.putObject(PutObjectRequest.builder().bucket(bucket).key(file.getOriginalFilename()).build(),
                RequestBody.fromBytes(file.getBytes())
        );

        return "File Uploaded";
    }
}