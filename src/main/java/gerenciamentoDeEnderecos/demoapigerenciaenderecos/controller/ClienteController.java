package gerenciamentoDeEnderecos.demoapigerenciaenderecos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Cliente;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.ClienteDto;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Endereco;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.service.ClienteServiceImpl;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.service.ConsultaServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @Autowired 
    private ConsultaServiceImpl consultaServiceImpl;

    /*Esse Endpoint existe para fins de teste, não deve estar no código final, pois 
    a consulta à API externa deve ser apenas no momento do cadastro do Cliente*/
    @GetMapping("{cep}")
    public Endereco consultaCep(@PathVariable("cep") String cep) {
        return consultaServiceImpl.consultaCep(cep);
    }

    @PostMapping("/cadastrarCliente")
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        System.out.println("Requisição Chegou 1"+ cliente.getCep());
        return clienteServiceImpl.adicionarCliente(cliente);
    }

    @GetMapping("/buscaCliente/{cpfCnpj}")
    public ClienteDto buscaCliente(@PathVariable("cpfCnpj") Long cpfCnpj) {
        return clienteServiceImpl.buscaCliente(cpfCnpj);
    }

}

/* Posteriormente deve-se criar um mecanismo para permitir preencher manualmente os campos 
 * Não abrangidos por alguns CEPs.
 */