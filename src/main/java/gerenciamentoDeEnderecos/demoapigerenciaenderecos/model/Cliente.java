package gerenciamentoDeEnderecos.demoapigerenciaenderecos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Cliente {

    private String nomeCliente;
    @Id
    private Long cpfCnpj;
    private String tipoPessoa;
    private String flagCadastro;
    private String cep;
    // private Endereco endereco;

}
