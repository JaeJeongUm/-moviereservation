package moviereservation.domain;

import java.util.*;
import lombok.*;
import moviereservation.domain.*;
import moviereservation.infra.AbstractEvent;

@Data
@ToString
public class Moviereserved extends AbstractEvent {

    private Long id;
    private String reservationStatus;
    private Integer qty;
    private Date reserveDt;
    private String movieTitle;
    private String userId;
    private Long reservationId;
    private Long movieId;
}
