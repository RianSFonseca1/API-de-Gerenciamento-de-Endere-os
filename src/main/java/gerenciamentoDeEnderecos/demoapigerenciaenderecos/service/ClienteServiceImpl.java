package gerenciamentoDeEnderecos.demoapigerenciaenderecos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Cliente adicionarCliente(Cliente cliente) {
        // Consulta o endereço pelo CEP
        Endereco endereco = consultaServiceImpl.consultaCep(cliente.getCep());

        List<Endereco> enderecosExistentes = enderecoRepository.findAll();
        if (!enderecosExistentes.contains(endereco)) {
            enderecoRepository.save(endereco);
        } else {
            for (Endereco existente : enderecosExistentes) {
                if (existente.equals(endereco)) {
                    endereco = existente;
                    break;
                }
            }
        }
        // Define o endereço no cliente
        cliente.setEnderecoId(endereco.getId());
        // Salva o cliente no banco de dados
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteDto buscaCliente(Long cpfCnpj) {
        /*Falta criar regras de negócio para tratamento do cpfCnpj (id da Entidade Cliente)*/
        Cliente buscaCliente = clienteRepository.findById(cpfCnpj).orElse(null);
        Endereco buscaEndereco = enderecoRepository.findById(buscaCliente.getEnderecoId()).orElse(null);
        ClienteDto clienteDto = new ClienteDto(buscaCliente, buscaEndereco);
        return clienteDto;
    }
}
