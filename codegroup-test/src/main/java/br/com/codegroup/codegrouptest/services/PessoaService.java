package br.com.codegroup.codegrouptest.services;

import br.com.codegroup.codegrouptest.dto.PessoaDTO;
import br.com.codegroup.codegrouptest.entities.Pessoa;
import br.com.codegroup.codegrouptest.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Transactional
    public PessoaDTO insert(PessoaDTO dto) {
        try {
            Pessoa entity = new Pessoa();
            entity.setId(dto.getId());
            entity.setNome(dto.getNome());
            entity.setCpf(dto.getCpf());
            entity.setDatanascimento(dto.getDatanascimento());
            entity.setFuncionario(dto.getFuncionario());

            entity = repository.save(entity);

            return new PessoaDTO(entity);
        }catch (Exception e){
            return dto;
        }
    }
}
