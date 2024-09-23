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
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_IncreaseTicket(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener IncreaseTicket : " + paid + "\n\n"
        );

        // Sample Logic //
        Inventory.increaseTicket(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Canceledpayment'"
    )
    public void wheneverCanceledpayment_DecreaseTicket(
        @Payload Canceledpayment canceledpayment
    ) {
        Canceledpayment event = canceledpayment;
        System.out.println(
            "\n\n##### listener DecreaseTicket : " + canceledpayment + "\n\n"
        );

        // Sample Logic //
        Inventory.decreaseTicket(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
