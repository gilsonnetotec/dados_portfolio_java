package br.com.codegroup.codegrouptest.mappers;

import br.com.codegroup.codegrouptest.dto.PessoaDTO;
import br.com.codegroup.codegrouptest.entities.Pessoa;
import org.modelmapper.ModelMapper;

public class PessoaMapper {
    private final ModelMapper modelMapper;

    public PessoaMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PessoaDTO toDTO(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaDTO.class);
    }
}
