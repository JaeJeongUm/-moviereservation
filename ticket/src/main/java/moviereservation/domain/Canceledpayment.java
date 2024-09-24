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
    private Date payDt;
    private Integer price;
    private Long reservationId;
    private Integer qty;
    private String movieTitle;
    private String reservationStatus;
    private Long movieId;
}
