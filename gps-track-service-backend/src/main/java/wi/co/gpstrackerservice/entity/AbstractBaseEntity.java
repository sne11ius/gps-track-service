package wi.co.gpstrackerservice.entity;

import static javax.persistence.AccessType.*;
import java.util.UUID;
import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;


@Access(FIELD)
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractBaseEntity {

    @Id
    @Column(columnDefinition="BINARY(16)")
    @Getter
    private UUID id = UUID.randomUUID();

}
