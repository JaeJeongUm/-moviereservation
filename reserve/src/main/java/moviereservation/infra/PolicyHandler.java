package moviereservation.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import moviereservation.config.kafka.KafkaProcessor;
import moviereservation.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ReserveRepository reserveRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ticketincreased'"
    )
    public void wheneverTicketincreased_UpdateStatus(
        @Payload Ticketincreased ticketincreased
    ) {
        Ticketincreased event = ticketincreased;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + ticketincreased + "\n\n"
        );

        // Sample Logic //
        Reserve.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TicketDecresed'"
    )
    public void wheneverTicketDecresed_UpdateStatus(
        @Payload TicketDecresed ticketDecresed
    ) {
        TicketDecresed event = ticketDecresed;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + ticketDecresed + "\n\n"
        );

        // Sample Logic //
        Reserve.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ticketincreased'"
    )
    public void wheneverTicketincreased_NotifyToReservationComeplete(
        @Payload Ticketincreased ticketincreased
    ) {
        Ticketincreased event = ticketincreased;
        System.out.println(
            "\n\n##### listener NotifyToReservationComeplete : " +
            ticketincreased +
            "\n\n"
        );

        // Sample Logic //
        Reserve.notifyToReservationComeplete(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TicketDecresed'"
    )
    public void wheneverTicketDecresed_NotifyToReservationComeplete(
        @Payload TicketDecresed ticketDecresed
    ) {
        TicketDecresed event = ticketDecresed;
        System.out.println(
            "\n\n##### listener NotifyToReservationComeplete : " +
            ticketDecresed +
            "\n\n"
        );

        // Sample Logic //
        Reserve.notifyToReservationComeplete(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
