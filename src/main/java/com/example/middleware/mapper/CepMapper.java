package com.example.middleware.mapper;

import com.example.middleware.domain.Address;
import com.example.middleware.dto.external.CepResponse;
import com.example.middleware.dto.internal.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CepMapper {

    @Mapping(target = "rua", source = "logradouro")
    @Mapping(target = "bairro", source = "bairro")
    @Mapping(target = "cidade", source = "localidade")
    @Mapping(target = "estado", source = "uf")
    @Mapping(target = "cep", source = "cep")
    @Mapping(target = "numero", ignore = true)
    Address toAddress(CepResponse response);

    // Address → EnderecoDTO (nomes iguais, mapeia sozinho)
    EnderecoDTO toDTO(Address address);
}
