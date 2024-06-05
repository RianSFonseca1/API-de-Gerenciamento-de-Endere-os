package gerenciamentoDeEnderecos.demoapigerenciaenderecos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}