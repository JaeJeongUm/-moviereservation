package moviereservation.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moviereservation.domain.*;
import moviereservation.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TicketDecresed extends AbstractEvent {

    private Long id;
    private String movieTitle;
    private Integer stock;
    private Long movieId;

    public TicketDecresed(Inventory aggregate) {
        super(aggregate);
    }

    public TicketDecresed() {
        super();
    }
}
//>>> DDD / Domain Event
