package io.m2i.TPInvoice.web.client;

import io.m2i.TPInvoice.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private String companyName;
    private String phoneNumber;
    private Address address;
}
