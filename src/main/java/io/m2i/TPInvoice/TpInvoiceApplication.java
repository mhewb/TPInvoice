package io.m2i.TPInvoice;

import io.m2i.TPInvoice.entity.Role;
import io.m2i.TPInvoice.entity.User;
import io.m2i.TPInvoice.repository.UserRepository;
import io.m2i.TPInvoice.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
@AllArgsConstructor
public class TpInvoiceApplication implements CommandLineRunner {

	UserRepository userRepository;
	RoleRepository roleRepository;
	BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TpInvoiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setFirstName("Jean");
		user.setLastName("Michel");
		user.setEmail("admin@my-invoice.fr");
		user.setPassword(passwordEncoder.encode("qwerty"));
		user.setRoleList(Arrays.asList(roleRepository.findByName("USER").get()));

//		userRepository.save(user);
	}

}
