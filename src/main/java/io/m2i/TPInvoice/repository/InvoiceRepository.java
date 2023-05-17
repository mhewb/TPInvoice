package io.m2i.TPInvoice.repository;

import io.m2i.TPInvoice.entity.Invoice;
import io.m2i.TPInvoice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    public List<Invoice> findInvoicesByUser(User user);

}
