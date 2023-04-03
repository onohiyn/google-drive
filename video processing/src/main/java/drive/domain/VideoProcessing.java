package drive.domain;

import drive.domain.*;
import drive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoProcessing extends AbstractEvent {

    private Long id;
    private Long fileId;
    private String url;

    public VideoProcessing(Video aggregate) {
        super(aggregate);
    }

    public VideoProcessing() {
        super();
    }
}
