package gerenciamentoDeEnderecos.demoapigerenciaenderecos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
