package io.m2i.TPInvoice.repository;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String aString);


}
