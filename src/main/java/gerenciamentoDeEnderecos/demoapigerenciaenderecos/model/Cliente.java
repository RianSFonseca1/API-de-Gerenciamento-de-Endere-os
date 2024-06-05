package gerenciamentoDeEnderecos.demoapigerenciaenderecos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    /*Falta criar regras de negócio para tratamento do cpfCnpj (id da Entidade Cliente)*/
    private Long cpfCnpj;

    private String nomeCliente;
    private String tipoPessoa;
    private String flagCadastro;
    private String cep;
    private Long enderecoId;

}
