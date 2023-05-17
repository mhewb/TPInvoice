package io.m2i.TPInvoice.service;

import io.m2i.TPInvoice.entity.*;
import io.m2i.TPInvoice.repository.InvoiceRepository;
import io.m2i.TPInvoice.web.invoice.InvoiceDTO;
import io.m2i.TPInvoice.web.invoice.InvoiceLineDTO;
import io.m2i.TPInvoice.web.invoice.InvoiceMapper;
import io.m2i.TPInvoice.web.product.ProductMapper;
import lombok.AllArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceService {

    private InvoiceRepository invoiceRepository;
    ProductService productService;
    UserService userService;
    InvoiceMapper invoiceMapper;
    public List<Invoice> getInvoiceListPerUser(User user) {
        return invoiceRepository.findInvoicesByUser(user);
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.getReferenceById(id);
    }

    public Invoice createInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceMapper.fromDTO(invoiceDTO);
        List<InvoiceLine> invoiceLines = new ArrayList<>();


        for (InvoiceLineDTO InvoiceLineDTO : invoiceDTO.getInvoiceLineList()) {
            InvoiceLine invoiceLine = new InvoiceLine();

            if (InvoiceLineDTO.getQuantity() != 0) {
                invoiceLine.setQuantity(InvoiceLineDTO.getQuantity());


                Product product = productService.getProductById(InvoiceLineDTO.getProduct().getId());
                invoiceLine.setProduct(product);
            }

            invoiceLine.setInvoice(invoice);
            invoiceLines.add(invoiceLine);
        }

        invoice.setInvoiceLineList(invoiceLines);

        return invoice;

    }
}
