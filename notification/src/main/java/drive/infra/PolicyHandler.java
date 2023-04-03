package drive.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import drive.config.kafka.KafkaProcessor;
import drive.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileUploaded'"
    )
    public void wheneverFileUploaded_NotifyToUser(
        @Payload FileUploaded fileUploaded
    ) {
        FileUploaded event = fileUploaded;
        System.out.println(
            "\n\n##### listener NotifyToUser : " + fileUploaded + "\n\n"
        );

        // Sample Logic //
        Notification.notifyToUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VideoProcessing'"
    )
    public void wheneverVideoProcessing_NotifyToUser(
        @Payload VideoProcessing videoProcessing
    ) {
        VideoProcessing event = videoProcessing;
        System.out.println(
            "\n\n##### listener NotifyToUser : " + videoProcessing + "\n\n"
        );

        // Sample Logic //
        Notification.notifyToUser(event);
    }
}
