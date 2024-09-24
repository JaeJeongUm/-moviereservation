package moviereservation.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moviereservation.domain.*;
import moviereservation.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Canceledpayment extends AbstractEvent {

    private Long id;
    private Long paymentId;
    private Date payDt;
    private Integer price;
    private Long reservationId;
    private Integer qty;
    private String movieTitle;
    private String reservationStatus;
    private Long movieId;

    public Canceledpayment(Payment aggregate) {
        super(aggregate);
    }

    public Canceledpayment() {
        super();
    }
}
//>>> DDD / Domain Event
