package moviereservation.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import moviereservation.infra.AbstractEvent;

@Data
public class Moviereserved extends AbstractEvent {

    private Long id;
    private String reservedStatus;
    private Integer qty;
    private Date reserveDt;
    private String movieTitle;
    private String userId;
    private Long reservationId;
}
