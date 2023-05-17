package io.m2i.TPInvoice.web.invoice;

import io.m2i.TPInvoice.entity.Invoice;
import io.m2i.TPInvoice.entity.InvoiceLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceLineMapper {

    InvoiceLineDTO toDTO(InvoiceLine invoiceLine);

    InvoiceLine fromDTO(InvoiceLineDTO invoiceLineDTO);


}
