package fooddelivery.infra;

import fooddelivery.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "readOrderStates",
    path = "readOrderStates"
)
public interface ReadOrderStateRepository
    extends PagingAndSortingRepository<ReadOrderState, Long> {}
