package io.m2i.TPInvoice.web;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.Product;
import io.m2i.TPInvoice.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    List<Client> clientList;
    List<Product> productList;
}
