package io.m2i.TPInvoice.repository;

import io.m2i.TPInvoice.entity.Product;
import io.m2i.TPInvoice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByUser(User user);

    boolean existsProductByIdAndUser(Long id, User user);
}
