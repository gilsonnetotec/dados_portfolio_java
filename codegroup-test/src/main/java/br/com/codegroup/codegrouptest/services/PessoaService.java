package br.com.codegroup.codegrouptest.services;

import br.com.codegroup.codegrouptest.dto.PessoaDTO;
import br.com.codegroup.codegrouptest.entities.Pessoa;
import br.com.codegroup.codegrouptest.repositories.PessoaRepository;
import br.com.codegroup.codegrouptest.services.exceptions.EntityNotFoundException;
import br.com.codegroup.codegrouptest.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Transactional(readOnly = true)
    public Page<PessoaDTO> findAll(PageRequest pageRequest){
        Page<Pessoa>page = repository.findAll(pageRequest);
        return page.map(pessoa -> new PessoaDTO(pessoa));
    }

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long id) {
        Optional<Pessoa> obj = repository.findById(id);
        Pessoa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new PessoaDTO(entity);
    }

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
        }catch (EntityNotFoundException e){
            if(dto.getNome() == null){
                throw new ResourceNotFoundException("Nome não pode ter valor null");
            }
            throw new ResourceNotFoundException("Erro: "+e);
        }
    }
}
