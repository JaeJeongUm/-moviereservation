package moviereservation.domain;

import java.util.*;
import lombok.*;
import moviereservation.domain.*;
import moviereservation.infra.AbstractEvent;

@Data
@ToString
public class Canceledpayment extends AbstractEvent {

    private Long id;
    private Long paymentId;
    private Float amount;
    private String reservedStatus;
    private String movieTitle;
    private Long reservationStatus;
    private Integer qty;
    private Date payDt;
    private Long movieId;
}
