package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingStarted extends AbstractEvent {

    private Long id;
    private String orderDateTime;
    private String customerAddress;
    private String menuId;
    private String orderState;
    private Boolean isConfirmed;
}
