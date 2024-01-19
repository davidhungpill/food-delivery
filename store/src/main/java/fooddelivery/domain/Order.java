package fooddelivery.domain;

import fooddelivery.StoreApplication;
import fooddelivery.domain.CookingFinished;
import fooddelivery.domain.CookingStarted;
import fooddelivery.domain.OrderConfimed;
import fooddelivery.domain.OrderRejected;
import fooddelivery.domain.OrderinfoTransered;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderDateTime;

    private String customerAddress;

    private String menuId;

    private String orderState;

    private Boolean isConfirmed;

    @PostPersist
    public void onPostPersist() {
        OrderinfoTransered orderinfoTransered = new OrderinfoTransered(this);
        orderinfoTransered.publishAfterCommit();

        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();

        CookingFinished cookingFinished = new CookingFinished(this);
        cookingFinished.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        OrderConfimed orderConfimed = new OrderConfimed(this);
        orderConfimed.publishAfterCommit();

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = StoreApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public static void transferOrderInfo(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void transferOrderInfo(OrderCanceled orderCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
