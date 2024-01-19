package fooddelivery.infra;

import fooddelivery.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class FoodDeliveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<FoodDelivery>> {

    @Override
    public EntityModel<FoodDelivery> process(EntityModel<FoodDelivery> model) {
        return model;
    }
}
