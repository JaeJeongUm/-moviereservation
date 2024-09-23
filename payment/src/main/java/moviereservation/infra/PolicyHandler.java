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
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Moviereserved'"
    )
    public void wheneverMoviereserved_Pay(
        @Payload Moviereserved moviereserved
    ) {
        Moviereserved event = moviereserved;
        System.out.println(
            "\n\n##### listener Pay : " + moviereserved + "\n\n"
        );

        // Sample Logic //
        Payment.pay(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Moviereservationcanceled'"
    )
    public void wheneverMoviereservationcanceled_CancelPay(
        @Payload Moviereservationcanceled moviereservationcanceled
    ) {
        Moviereservationcanceled event = moviereservationcanceled;
        System.out.println(
            "\n\n##### listener CancelPay : " +
            moviereservationcanceled +
            "\n\n"
        );

        // Sample Logic //
        Payment.cancelPay(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
