package gerenciamentoDeEnderecos.demoapigerenciaenderecos.service;

import org.springframework.stereotype.Service;
import gerenciamentoDeEnderecos.demoapigerenciaenderecos.model.Endereco;

@Service
public interface ConsultaService {
    Endereco consultaCep(String cep);

}

