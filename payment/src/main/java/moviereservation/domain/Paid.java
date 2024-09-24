package moviereservation.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moviereservation.domain.*;
import moviereservation.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Paid extends AbstractEvent {

    private Long id;
    private Long paymentId;
    private Float amount;
    private String reservedStatus;
    private String movieTitle;
    private Long reservationStatus;
    private Integer qty;
    private Date payDt;
    private Long movieId;
    private Integer price;

    public Paid(Payment aggregate) {
        super(aggregate);
    }

    public Paid() {
        super();
    }
}
//>>> DDD / Domain Event
