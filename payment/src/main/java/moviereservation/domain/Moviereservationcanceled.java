package moviereservation.domain;

import java.util.*;
import lombok.*;
import moviereservation.domain.*;
import moviereservation.infra.AbstractEvent;

@Data
@ToString
public class Moviereservationcanceled extends AbstractEvent {

    private Long id;
    private String reservedStatus;
    private Integer qty;
    private Date reserveDt;
    private String movieTitle;
    private String userId;
    private Long reservationId;
}
