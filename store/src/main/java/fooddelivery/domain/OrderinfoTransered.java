package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderinfoTransered extends AbstractEvent {

    private Long id;
    private String orderDateTime;
    private String customerAddress;
    private String menuId;

    public OrderinfoTransered(Order aggregate) {
        super(aggregate);
    }

    public OrderinfoTransered() {
        super();
    }
}
//>>> DDD / Domain Event
