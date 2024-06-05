package gerenciamentoDeEnderecos.demoapigerenciaenderecos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Endereco;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Endereco consultaCep(String cep) {
        return restTemplate
                .getForEntity(String
                        .format("https://viacep.com.br/ws/%s/json/", cep), Endereco.class)
                .getBody();
    }
}
