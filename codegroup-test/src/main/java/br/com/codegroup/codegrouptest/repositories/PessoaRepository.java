package br.com.codegroup.codegrouptest.repositories;
import br.com.codegroup.codegrouptest.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
