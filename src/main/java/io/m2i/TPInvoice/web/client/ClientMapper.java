package io.m2i.TPInvoice.web.client;

import io.m2i.TPInvoice.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDTO(Client Client);

    Client fromDTO(ClientDTO ClientDTO);
}