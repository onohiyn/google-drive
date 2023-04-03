package drive.domain;

import drive.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class VideoProcessing extends AbstractEvent {

    private Long id;
    private Long fileId;
    private String url;
}
