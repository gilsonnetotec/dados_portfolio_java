package br.com.codegroup.codegrouptest.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column
    private Date datanascimento;

    @Column(length = 14)
    private String cpf;

    @Column
    private Boolean funcionario;

}
