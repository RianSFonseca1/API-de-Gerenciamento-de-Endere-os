package gerenciamentoDeEnderecos.demoapigerenciaenderecos.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Cliente;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.ClienteDto;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Endereco;

@Service
public interface ClienteService {
    ResponseEntity adicionarCliente(Cliente cliente);

    ClienteDto buscaCliente(String cpf);

    Endereco verificaEndereco(Cliente cliente);

    boolean verificaCpf(Cliente cliente);


}
