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
    private Float amount;
    private String movieTitle;
    private Long reservationStatus;
    private Integer qty;
    private Date payDt;
    private Long movieId;
    private Integer price;
    private Long reservationId;

    public Canceledpayment(Payment aggregate) {
        super(aggregate);
    }

    public Canceledpayment() {
        super();
    }
}
//>>> DDD / Domain Event
