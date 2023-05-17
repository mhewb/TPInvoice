package io.m2i.TPInvoice.service;

import io.m2i.TPInvoice.entity.*;
import io.m2i.TPInvoice.repository.ClientRepository;
import io.m2i.TPInvoice.repository.InvoiceRepository;
import io.m2i.TPInvoice.repository.ProductRepository;
import io.m2i.TPInvoice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;
    ClientRepository clientRepository;
    ProductRepository productRepository;
    InvoiceRepository invoiceRepository;

    public Client addClient(User user, Client client) {

        client.setUser(user);
        user.setClientList(clientRepository.findClientsByUser(user));
        user.getClientList().add(client);

        userRepository.save(user);

        return client;
    }

    public Product addProduct(User user, Product product) {

        product.setUser(user);
        user.setProductList(productRepository.findProductByUser(user));
        user.getProductList().add(product);

        userRepository.save(user);

        return product;

    }

    public Invoice addInvoice(User user, Invoice invoice) {

        invoice.setUser(user);
        user.setInvoiceList(invoiceRepository.findInvoicesByUser(user));
        user.getInvoiceList().add(invoice);

        userRepository.save(user);

        return invoice;

    }

}
