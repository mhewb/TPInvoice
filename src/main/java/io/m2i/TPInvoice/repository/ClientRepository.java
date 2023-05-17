package io.m2i.TPInvoice.repository;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findClientsByUser(User user);
    boolean existsClientByIdAndUser(Long id, User user);
}
