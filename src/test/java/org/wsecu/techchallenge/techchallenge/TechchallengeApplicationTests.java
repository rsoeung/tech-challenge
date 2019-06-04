package org.wsecu.techchallenge.techchallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.wsecu.techchallenge.techchallenge.controllers.UserController;
import org.wsecu.techchallenge.techchallenge.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TechchallengeApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	public void contextLoads() {
		assertNotNull("UserController is null", userController);
	}

	@Test
	public void shouldReturnUserByUsername() {
		String username = "johndoe";
		
		User user = userController.getUserByUsername(username);
		
		assertNotNull("User is null", user);
		assertEquals("Wrong user returned!", username, user.getUsername());
	}

	@Test
	public void shouldReturnUserWithUpdatedEmailAndName() {
		String username = "johndoe";
		String email = "johndoeupdate@wsecu.org";
		String name = "john doe doe";

		User user = userController.getUserByUsername(username);
		user.setEmail(email);
		user.setName(name);
		
		ResponseEntity<User> newuser = userController.updateUser(user);

		assertNotNull("User is null", user);
		assertEquals("Wrong email!", email, newuser.getBody().getEmail());
		assertEquals("Wrong name!", name, newuser.getBody().getName());
	}

}
