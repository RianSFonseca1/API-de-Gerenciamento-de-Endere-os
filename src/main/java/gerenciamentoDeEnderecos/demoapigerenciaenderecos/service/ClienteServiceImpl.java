package gerenciamentoDeEnderecos.demoapigerenciaenderecos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Cliente;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.ClienteDto;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Endereco;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.repository.ClienteRepository;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.repository.EnderecoRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired 
    private ConsultaServiceImpl consultaServiceImpl;

    @Override
    public ResponseEntity adicionarCliente(Cliente cliente){
        Endereco endereco = verificaEndereco(cliente);
        if (!verificaCpf(cliente)) {
            enderecoRepository.save(endereco);
            cliente.setEnderecoId(endereco.getId());
            clienteRepository.save(cliente);  
            return ResponseEntity
                .status(HttpStatus.CREATED).body(cliente);
        } else {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("CPF já cadastrado no banco de dados!");
        }
    }

    @Override
    public boolean verificaCpf(Cliente cliente){
        List<Cliente> clientesExistentes = clienteRepository.findAll();
        for (Cliente existente : clientesExistentes) {
            if (existente.getCpf().equals(cliente.getCpf())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Endereco verificaEndereco(Cliente cliente){
        Endereco endereco = consultaServiceImpl.consultaCep(cliente.getCep());
        List<Endereco> enderecosExistentes = enderecoRepository.findAll();
        for (Endereco existente : enderecosExistentes) {
            if (existente.equals(endereco)) {
                // Se encontrar um endereço existente igual ao consultado, retorna o endereço existente
                return existente;
            }
        }
        // Se não encontrar um endereço existente igual ao consultado, retorna o endereço consultado
        return endereco;
    }

    @Override
    public ClienteDto buscaCliente(String cpf) {
        /*Falta criar regras de negócio para tratamento do cpf(id da Entidade Cliente)*/
        Cliente buscaCliente = clienteRepository.findById(cpf).orElse(null);
        Endereco buscaEndereco = enderecoRepository.findById(buscaCliente.getEnderecoId()).orElse(null);
        ClienteDto clienteDto = new ClienteDto(buscaCliente, buscaEndereco);
        return clienteDto;
    }
}
