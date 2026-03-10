package aws.demo.Config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.eventbridge.EventBridgeClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;


import java.net.URI;

@Configuration
public class AwsConfig {

    @Bean
    public S3Client s3Client() {
    return S3Client.builder().endpointOverride(URI.create("http://localhost:4566")).region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("test", "test"))
                )
                .serviceConfiguration(S3Configuration.builder().pathStyleAccessEnabled(true).build()
                )
                .build();
    }

    @Bean
    public EventBridgeClient eventBridgeClient() {
        return EventBridgeClient.builder().endpointOverride(URI.create("http://localhost:4566")).region(Region.US_EAST_1).credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("test", "test")))
                .build();
    }

}