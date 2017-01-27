package wi.co.gpstrackerservice.user.entity;

import static javax.persistence.AccessType.FIELD;

import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.leandreck.endpoints.annotations.TypeScriptType;

@TypeScriptType
@Entity
@Access(FIELD)
public class User {

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    private String id = UUID.randomUUID().toString();

    @Column(name = "FIRST_NAME", nullable = false, insertable = true, updatable = true)
	@NotEmpty
    private String firstname;

    @Column(name = "EMAIL", nullable = false, insertable = true, updatable = true)
	@Email
    private String email;

    public String getId() {
    	return id;
    }

    public void setId(final String uuid) {
    	this.id = uuid;
    }

    public String getFirstname() {
    	return firstname;
    }

    public void setFirstname(final String firstname) {
    	this.firstname = firstname;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

}
