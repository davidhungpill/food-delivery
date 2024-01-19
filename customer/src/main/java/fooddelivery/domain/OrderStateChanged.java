package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class OrderStateChanged extends AbstractEvent {

    private Long id;
    private String customerId;
    private String storeId;
    private Long place;
    private Date orderDateTime;
    private String customerName;
    private String menuName;
    private String customerAddress;
    private String orderState;
}
