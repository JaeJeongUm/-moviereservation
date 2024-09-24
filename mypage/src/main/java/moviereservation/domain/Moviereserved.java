package moviereservation.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import moviereservation.infra.AbstractEvent;

@Data
public class Moviereserved extends AbstractEvent {

    private Long id;
    private String userId;
    private Long reservationId;
    private Date reserveDt;
    private Integer qty;
    private String movieTitle;
    private String reservationStatus;
    private Long movieId;
}
