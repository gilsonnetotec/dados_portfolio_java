package br.com.codegroup.codegrouptest.dto;

import br.com.codegroup.codegrouptest.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO {
    private Long id;
    private String nome;
    private Date datanascimento;
    private String cpf;
    private Boolean funcionario;

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.datanascimento = pessoa.getDatanascimento();
        this.cpf = pessoa.getCpf();
        this.funcionario = pessoa.getFuncionario();
    }
}
