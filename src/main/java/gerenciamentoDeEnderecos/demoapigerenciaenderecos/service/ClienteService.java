package gerenciamentoDeEnderecos.demoapigerenciaenderecos.service;

import org.springframework.stereotype.Service;

import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Cliente;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.ClienteDto;

@Service
public interface ClienteService {
    Cliente adicionarCliente(Cliente cliente);

    ClienteDto buscaCliente(Long cpfCnpj);
}
