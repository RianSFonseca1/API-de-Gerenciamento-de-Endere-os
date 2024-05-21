package gerenciamentoDeEnderecos.demoapigerenciaenderecos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Endereco;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{cep}")
    public Endereco consultaCep(@PathVariable("cep") String cep) {
        return restTemplate
                .getForEntity(String
                        .format("https://viacep.com.br/ws/%s/json/", cep), Endereco.class)
                .getBody();

    }

}
