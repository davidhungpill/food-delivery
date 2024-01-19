package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "foodDeliveries",
    path = "foodDeliveries"
)
public interface FoodDeliveryRepository
    extends PagingAndSortingRepository<FoodDelivery, Long> {}
