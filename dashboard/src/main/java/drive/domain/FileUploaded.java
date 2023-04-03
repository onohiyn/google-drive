package drive.domain;

import drive.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class FileUploaded extends AbstractEvent {

    private Long id;
    private String name;
    private String type;
    private String path;
    private Integer size;
}
