package io.m2i.TPInvoice.web.product;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.Product;
import io.m2i.TPInvoice.web.client.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product Product);

    Product fromDTO(ProductDTO ProductDTO);
}
