package fooddelivery.domain;

import fooddelivery.RiderApplication;
import fooddelivery.domain.DeliveryCompleted;
import fooddelivery.domain.OrderPicked;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FoodDelivery_table")
@Data
//<<< DDD / Aggregate Root
public class FoodDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String storeName;

    private String menuName;

    private String customerAddress;

    private String orderState;

    private Boolean pickup;

    @PostPersist
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        OrderPicked orderPicked = new OrderPicked(this);
        orderPicked.publishAfterCommit();

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public static FoodDeliveryRepository repository() {
        FoodDeliveryRepository foodDeliveryRepository = RiderApplication.applicationContext.getBean(
            FoodDeliveryRepository.class
        );
        return foodDeliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void requestForDelivery(CookingStarted cookingStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        FoodDelivery foodDelivery = new FoodDelivery();
        repository().save(foodDelivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookingStarted.get???()).ifPresent(foodDelivery->{
            
            foodDelivery // do something
            repository().save(foodDelivery);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
