package com.example.middleware.mapper;

import com.example.middleware.domain.Address;
import com.example.middleware.dto.external.CepResponse;
import com.example.middleware.dto.internal.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CepMapper {
    @Mapping(source = "logradouro", target = "street")
    @Mapping(source = "bairro", target = "district")
    @Mapping(source = "localidade", target = "city")
    @Mapping(source = "uf", target = "state")
    @Mapping(source = "cep", target = "zipCode")
    Address toAddress(CepResponse response);

    @Mapping(source = "street", target = "rua")
    @Mapping(source = "number", target = "numero")
    @Mapping(source = "district", target = "bairro")
    @Mapping(source = "city", target = "cidade")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "zipCode", target = "cep")
    EnderecoDTO toDTO(Address address);

}
