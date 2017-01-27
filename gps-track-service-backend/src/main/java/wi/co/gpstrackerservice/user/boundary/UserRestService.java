package wi.co.gpstrackerservice.user.boundary;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.leandreck.endpoints.annotations.TypeScriptEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import wi.co.gpstrackerservice.user.entity.User;
import wi.co.gpstrackerservice.user.entity.Users;

@TypeScriptEndpoint
@RestController
@RequestMapping("/api/users")
public class UserRestService {

	@Autowired
	private Users users;

	@RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> loadUsers() {
		final ArrayList<User> result = new ArrayList<>();
		users.findAll().forEach(result::add);
		return result;
	}

	@RequestMapping(method = POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public @ResponseBody User createOrUpdateUser(@Valid @RequestBody final User user, final BindingResult bindingResult) {
		return users.save(user);
	}

	@RequestMapping(method = DELETE, value = "/{uuid}", produces = APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable final String uuid) {
		users.delete(uuid);
	}

}
