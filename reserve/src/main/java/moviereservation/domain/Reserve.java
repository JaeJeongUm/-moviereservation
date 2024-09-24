package moviereservation.domain;

import moviereservation.domain.Moviereserved;
import moviereservation.domain.Moviereservationcanceled;
import moviereservation.ReserveApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Reserve_table")
@Data

//<<< DDD / Aggregate Root
public class Reserve  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String userId;
    
    
    
    
    private Long reservationId;
    
    
    
    
    private Date reserveDt;
    
    
    
    
    private Integer qty;
    
    
    
    
    private String movieTitle;
    
    
    
    
    private String reservationStatus;
    
    
    
    
    private Long movieId;

    @PostPersist
    public void onPostPersist(){


        Moviereserved moviereserved = new Moviereserved(this);
        moviereserved.publishAfterCommit();



        Moviereservationcanceled moviereservationcanceled = new Moviereservationcanceled(this);
        moviereservationcanceled.publishAfterCommit();

    
    }

    public static ReserveRepository repository(){
        ReserveRepository reserveRepository = ReserveApplication.applicationContext.getBean(ReserveRepository.class);
        return reserveRepository;
    }



    public void moviereserve(){
        //implement business logic here:
        
        
        
        moviereservation.external.PaymentQuery paymentQuery = new moviereservation.external.PaymentQuery();
        ReserveApplication.applicationContext
            .getBean(moviereservation.external.Service.class)
            .( paymentQuery);
    }
    public void moviereservecancel(){
        //implement business logic here:
        
        
        
    }

//<<< Clean Arch / Port Method
    public static void updateStatus(Ticketincreased ticketincreased){
        
        //implement business logic here:

        /** Example 1:  new item 
        Reserve reserve = new Reserve();
        repository().save(reserve);

        */

        /** Example 2:  finding and process
        
        repository().findById(ticketincreased.get???()).ifPresent(reserve->{
            
            reserve // do something
            repository().save(reserve);


         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void updateStatus(TicketDecresed ticketDecresed){
        
        //implement business logic here:

        /** Example 1:  new item 
        Reserve reserve = new Reserve();
        repository().save(reserve);

        */

        /** Example 2:  finding and process
        
        repository().findById(ticketDecresed.get???()).ifPresent(reserve->{
            
            reserve // do something
            repository().save(reserve);


         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void notifyToReservationComeplete(Ticketincreased ticketincreased){
        
        //implement business logic here:

        /** Example 1:  new item 
        Reserve reserve = new Reserve();
        repository().save(reserve);

        */

        /** Example 2:  finding and process
        
        repository().findById(ticketincreased.get???()).ifPresent(reserve->{
            
            reserve // do something
            repository().save(reserve);


         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void notifyToReservationComeplete(TicketDecresed ticketDecresed){
        
        //implement business logic here:

        /** Example 1:  new item 
        Reserve reserve = new Reserve();
        repository().save(reserve);

        */

        /** Example 2:  finding and process
        
        repository().findById(ticketDecresed.get???()).ifPresent(reserve->{
            
            reserve // do something
            repository().save(reserve);


         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
