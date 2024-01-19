package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPicked extends AbstractEvent {

    private Long id;
    private String orderId;
    private String storeName;
    private String menuName;
    private String customerAddress;
    private String orderState;
    private Boolean pickup;

    public OrderPicked(FoodDelivery aggregate) {
        super(aggregate);
    }

    public OrderPicked() {
        super();
    }
}
//>>> DDD / Domain Event
