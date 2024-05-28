package gerenciamentoDeEnderecos.demoapigerenciaenderecos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Cliente;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente adicionarCliente(Cliente cliente) {
        System.out.println("Requisição chegou 2");
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscaCliente(Long cpfCnpj) {
        return clienteRepository.findById(cpfCnpj).orElse(null);
    }
}
