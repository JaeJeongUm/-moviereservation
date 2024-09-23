package moviereservation.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moviereservation.domain.*;
import moviereservation.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Ticketincreased extends AbstractEvent {

    private Long id;
    private String movieTitle;
    private Integer stock;
    private Long movieId;

    public Ticketincreased(Inventory aggregate) {
        super(aggregate);
    }

    public Ticketincreased() {
        super();
    }
}
//>>> DDD / Domain Event
