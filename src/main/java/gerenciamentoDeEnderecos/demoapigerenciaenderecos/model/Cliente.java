package gerenciamentoDeEnderecos.demoapigerenciaenderecos.model;

import java.util.Objects;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    /*Falta criar regras de negócio para tratamento do cpf (id da Entidade Cliente)*/
    @Id
    @CPF
    private String cpf;

    @NotBlank
    private String nomeCliente;
    @NotBlank
    private String tipoPessoa;
    @NotBlank
    private String cep;

    private String flagCadastro;
    private Long enderecoId;

}
