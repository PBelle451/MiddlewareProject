package com.example.middleware.mapper;

import com.example.middleware.dto.external.CepResponse;
import com.example.middleware.dto.internal.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CepMapper {
    @Mapping(source = "logradouro", target = "rua")
    @Mapping(source = "localidade", target = "cidade")
    @Mapping(source = "uf", target = "estado")
    EnderecoDTO toEndereco(CepResponse response);

}
