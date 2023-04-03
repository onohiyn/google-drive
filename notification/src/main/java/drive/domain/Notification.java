package drive.domain;

import drive.NotificationApplication;
import drive.domain.Notified;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Notification_table")
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        Notified notified = new Notified(this);
        notified.publishAfterCommit();
    }

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = NotificationApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }

    public static void notifyToUser(FileUploaded fileUploaded) {
        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        Notified notified = new Notified(notification);
        notified.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);

            Notified notified = new Notified(notification);
            notified.publishAfterCommit();

         });
        */

    }

    public static void notifyToUser(VideoProcessing videoProcessing) {
        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        Notified notified = new Notified(notification);
        notified.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(videoProcessing.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);

            Notified notified = new Notified(notification);
            notified.publishAfterCommit();

         });
        */

    }
}
