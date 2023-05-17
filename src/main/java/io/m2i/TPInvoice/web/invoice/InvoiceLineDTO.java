package io.m2i.TPInvoice.web.invoice;

import io.m2i.TPInvoice.web.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLineDTO {

    private Long id;
    private double quantity;
    private ProductDTO product;
    private InvoiceDTO invoice;

}
