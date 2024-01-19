package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private String customerName;
    private String menuName;
    private String storeId;
    private Long place;
    private Date orderDateTime;
    private String customerAddress;
    private String orderState;
}
