package io.m2i.TPInvoice;

import io.m2i.TPInvoice.entity.*;
import io.m2i.TPInvoice.repository.UserRepository;
import io.m2i.TPInvoice.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
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

		Role role = new Role(1L, "USER");
		roleRepository.save(role);

		User user1 = new User();
		user1.setFirstName("Jean");
		user1.setLastName("Michel");
		user1.setEmail("admin@my-invoice.fr");
		user1.setPassword(passwordEncoder.encode("qwerty"));
		user1.setRoleList(Arrays.asList(role));

		User user2 = new User();
		user2.setFirstName("User");
		user2.setLastName("User");
		user2.setEmail("user");
		user2.setPassword(passwordEncoder.encode("user"));
		user2.setRoleList(Arrays.asList(role));

		Address address1 = new Address();
		address1.setStreetNumber("3bis");
		address1.setStreetName("rue des Lilas");
		address1.setZipCode("44000");
		address1.setCity("Nantes");

		Address address2 = new Address();
		address2.setStreetNumber("4");
		address2.setStreetName("boulevard des Roses");
		address2.setZipCode("44000");
		address2.setCity("Nantes");

		Client client1 = new Client();
		client1.setCompanyName("Company1");
		client1.setPhoneNumber("554433221100");
		client1.setAddress(address1);
		Client client2 = new Client();
		client2.setCompanyName("Company2");
		client2.setPhoneNumber("001122334455");
		client2.setAddress(address2);

		client1.setUser(user1);
		client2.setUser(user2);
		user1.getClientList().add(client1);
		user2.getClientList().add(client2);

		Product product1 = new Product();
		product1.setUser(user1);
		user1.getProductList().add(product1);
		product1.setPriceExcludingTax(15.65);
		product1.setDescription("description1");
		product1.setName("Produit1");

		Product product2 = new Product();
		product2.setUser(user1);
		user1.getProductList().add(product2);
		product2.setPriceExcludingTax(350);
		product2.setDescription("description2");
		product2.setName("Produit2");

		InvoiceLine invoiceLine1 = new InvoiceLine();
		invoiceLine1.setProduct(product1);
		invoiceLine1.setQuantity(3);

		InvoiceLine invoiceLine2 = new InvoiceLine();
		invoiceLine2.setProduct(product2);
		invoiceLine2.setQuantity(1);

		Invoice invoice = new Invoice();
		invoice.setIssueDate(LocalDate.of(2023,2,17));
		invoice.setClient(client1);
		user1.getInvoiceList().add(invoice);
		invoice.setUser(user1);
		invoice.getInvoiceLineList().add(invoiceLine1);
		invoiceLine1.setInvoice(invoice);
		invoice.getInvoiceLineList().add(invoiceLine2);
		invoiceLine2.setInvoice(invoice);

		userRepository.save(user1);
		userRepository.save(user2);

	}

}
