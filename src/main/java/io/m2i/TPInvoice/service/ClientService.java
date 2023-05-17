package io.m2i.TPInvoice.service;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.User;
import io.m2i.TPInvoice.repository.ClientRepository;
import io.m2i.TPInvoice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    ClientRepository clientRepository;

    public List<Client> getClientListPerUser(User user) {
        return clientRepository.findClientsByUser(user);
    }

}
