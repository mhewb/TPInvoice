package io.m2i.TPInvoice.web.invoice;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.InvoiceLine;
import io.m2i.TPInvoice.web.client.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {
    private Long id;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private String PaymentMethod;
    private String status; // false = pending, true = paid
    private String note; // In case pending is for a good reason
    private ClientDTO client;
    private List<InvoiceLineDTO> invoiceLineList;

}
