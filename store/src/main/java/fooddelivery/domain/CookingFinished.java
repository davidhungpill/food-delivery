package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CookingFinished extends AbstractEvent {

    private Long id;
    private String orderDateTime;
    private String customerAddress;
    private String menuId;
    private String orderState;
    private Boolean isConfirmed;

    public CookingFinished(Order aggregate) {
        super(aggregate);
    }

    public CookingFinished() {
        super();
    }
}
//>>> DDD / Domain Event
