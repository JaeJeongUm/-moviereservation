package moviereservation.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import moviereservation.TicketApplication;
import moviereservation.domain.TicketDecresed;
import moviereservation.domain.Ticketincreased;

@Entity
@Table(name = "Inventory_table")
@Data
//<<< DDD / Aggregate Root
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String movieTitle;

    private Integer stock;

    private Long movieId;

    @PostPersist
    public void onPostPersist() {
        Ticketincreased ticketincreased = new Ticketincreased(this);
        ticketincreased.publishAfterCommit();

        TicketDecresed ticketDecresed = new TicketDecresed(this);
        ticketDecresed.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = TicketApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void increaseTicket(Paid paid) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        */

        repository().findById(paid.getMovieId()).ifPresent(inventory->{
            inventory.setStock(inventory.getStock()+paid.getQty()); // do something
            repository().save(inventory);
         });
        

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void decreaseTicket(Canceledpayment canceledpayment) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        */

        repository().findById(canceledpayment.getMovieId()).ifPresent(inventory->{
            inventory.setStock(inventory.getStock()-canceledpayment.getQty()); // do something
            repository().save(inventory);
         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
