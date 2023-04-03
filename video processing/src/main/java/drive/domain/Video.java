package drive.domain;

import drive.VideoProcessingApplication;
import drive.domain.VideoProcessing;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long fileId;

    private String url;

    @PostPersist
    public void onPostPersist() {
        VideoProcessing videoProcessing = new VideoProcessing(this);
        videoProcessing.publishAfterCommit();
    }

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }

    public static void streamFileToVidio(FileUploaded fileUploaded) {
        /** Example 1:  new item 
        Video video = new Video();
        repository().save(video);

        VideoProcessing videoProcessing = new VideoProcessing(video);
        videoProcessing.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);

            VideoProcessing videoProcessing = new VideoProcessing(video);
            videoProcessing.publishAfterCommit();

         });
        */

    }
}
