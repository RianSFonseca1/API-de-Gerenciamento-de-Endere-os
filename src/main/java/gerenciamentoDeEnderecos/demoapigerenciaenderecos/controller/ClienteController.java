package gerenciamentoDeEnderecos.demoapigerenciaenderecos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Cliente;

import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Endereco;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.service.ClienteServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping("{cep}")
    public Endereco consultaCep(@PathVariable("cep") String cep) {
        return restTemplate
                .getForEntity(String
                        .format("https://viacep.com.br/ws/%s/json/", cep), Endereco.class)
                .getBody();
    }

    @PostMapping("/cadastrarCliente")
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        System.out.println("Requisição Chegou 1");
        return clienteServiceImpl.adicionarCliente(cliente);
    }

    @GetMapping("/buscaCliente/{cpfCnpj}")
    public Cliente buscaCliente(@PathVariable("cpfCnpj") Long cpfCnpj) {
        return clienteServiceImpl.buscaCliente(cpfCnpj);
    }

}
