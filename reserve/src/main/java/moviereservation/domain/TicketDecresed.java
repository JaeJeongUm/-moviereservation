package moviereservation.domain;

import java.util.*;
import lombok.*;
import moviereservation.domain.*;
import moviereservation.infra.AbstractEvent;

@Data
@ToString
public class TicketDecresed extends AbstractEvent {

    private Long id;
    private String movieTitle;
    private Integer stock;
    private Long movieId;
}
