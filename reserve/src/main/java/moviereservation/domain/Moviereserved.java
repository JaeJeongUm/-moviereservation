package moviereservation.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moviereservation.domain.*;
import moviereservation.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Moviereserved extends AbstractEvent {

    private Long id;
    private String userId;
    private Long reservationId;
    private Date reserveDt;
    private Integer qty;
    private String movieTitle;
    private String reservationStatus;
    private Long movieId;

    public Moviereserved(Reserve aggregate) {
        super(aggregate);
    }

    public Moviereserved() {
        super();
    }
}
//>>> DDD / Domain Event
