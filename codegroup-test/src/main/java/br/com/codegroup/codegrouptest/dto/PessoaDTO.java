package br.com.codegroup.codegrouptest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PessoaDTO {
    private Long id;
    private String nome;
    private Date datanascimento;
    private String cpf;
    private Boolean funcionario;
}
