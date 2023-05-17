package io.m2i.TPInvoice.service;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.User;
import io.m2i.TPInvoice.repository.ClientRepository;
import io.m2i.TPInvoice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;

    public Client getClientById(Long id) {
        return clientRepository.getReferenceById(id);
    }
    public List<Client> getClientListPerUser(User user) {
        return clientRepository.findClientsByUser(user);
    }
    public void editClient(Client client, User user) {
        client.setUser(user);
        clientRepository.save(client);
    }

    public void deleteClient(Client client, User user) {

        boolean condition = clientRepository.existsClientByIdAndUser(client.getId(), user);
        if (! condition) {
            throw new RuntimeException("Client not belonging to User"); // TODO: Personalise Exceptions
        }
        clientRepository.delete(client);
    }


}
