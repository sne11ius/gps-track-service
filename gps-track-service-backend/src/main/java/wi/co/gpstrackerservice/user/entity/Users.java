package wi.co.gpstrackerservice.user.entity;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, UUID> {

}
