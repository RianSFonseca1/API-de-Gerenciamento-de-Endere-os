package gerenciamentoDeEnderecos.demoapigerenciaenderecos.service;

import org.springframework.stereotype.Service;

import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Cliente;

@Service
public interface ClienteService {
    Cliente adicionarCliente(Cliente cliente);

    Cliente buscaCliente(Long cpfCnpj);
}
