package wi.co.gpstrackerservice.entity;

import static javax.persistence.AccessType.FIELD;

import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@Access(FIELD)
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractBaseEntity {

    @Id
    @Column(columnDefinition="BINARY(16)")
    private UUID id = UUID.randomUUID();

    public String getId() {
    	return id.toString();
    }

    public void setId(final String uuid) {
    	this.id = UUID.fromString(uuid);
    }

}
