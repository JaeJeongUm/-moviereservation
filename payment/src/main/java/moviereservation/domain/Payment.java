package moviereservation.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import moviereservation.PaymentApplication;
import moviereservation.domain.Canceledpayment;
import moviereservation.domain.Paid;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long paymentId;

    private Float amount;

    private Long movieId;

    private String reservationStatus;

    private Integer qty;

    private Date payDt;

    private Integer price;

    private Long reservationId;

    @PostPersist
    public void onPostPersist() {
        Paid paid = new Paid(this);
        paid.publishAfterCommit();

        Canceledpayment canceledpayment = new Canceledpayment(this);
        canceledpayment.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    //<<< Clean Arch / Port Method
    public static void pay(Moviereserved moviereserved) {
        //implement business logic here:

        Payment payment = new Payment();
        payment.setMovieId(moviereserved.getMovieId());
        payment.setQty(moviereserved.getQty());
        payment.setPrice(moviereserved.getQty()*10000);
        payment.setReservationId(moviereserved.getReservationId());
        payment.setReservationStatus("reserve");
        repository().save(payment);


        /** Example 2:  finding and process
        
        repository().findById(moviereserved.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelPay(
        Moviereservationcanceled moviereservationcanceled
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process**/
        
        repository().findById(moviereservationcanceled.getReservationId()).ifPresent(payment->{
            
            //payment // do something
            payment.setReservationStatus("cancel");
            repository().save(payment);
         });
        

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
