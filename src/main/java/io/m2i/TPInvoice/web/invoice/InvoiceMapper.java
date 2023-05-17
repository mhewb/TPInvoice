package io.m2i.TPInvoice.web.invoice;


import io.m2i.TPInvoice.entity.Invoice;
import io.m2i.TPInvoice.entity.InvoiceLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceDTO toDTO(Invoice invoice);

    Invoice fromDTO(InvoiceDTO invoiceDTO);

    default String booleanToString(boolean status) {
        return status ? "Paid" : "Pending";
    }

}
