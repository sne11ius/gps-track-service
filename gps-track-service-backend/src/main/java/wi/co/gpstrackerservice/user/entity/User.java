package wi.co.gpstrackerservice.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.leandreck.endpoints.annotations.TypeScriptType;
import lombok.Getter;
import lombok.Setter;
import wi.co.gpstrackerservice.entity.AbstractBaseEntity;

@TypeScriptType
@Entity
public class User extends AbstractBaseEntity {

	@Getter
    @Setter
    @Column(name = "FIRST_NAME", nullable = false, insertable = true, updatable = true)
	@NotEmpty
    private String firstname;


	@Getter
    @Setter
    @Column(name = "EMAIL", nullable = false, insertable = true, updatable = true)
	@Email
    private String email;

}
