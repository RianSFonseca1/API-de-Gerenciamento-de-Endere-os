package gerenciamentoDeEnderecos.demoapigerenciaenderecos.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        Endereco outroEndereco = (Endereco) obj;

        return Objects.equals(this.cep, outroEndereco.cep) &&
            Objects.equals(this.logradouro, outroEndereco.logradouro) &&
            Objects.equals(this.bairro, outroEndereco.bairro) &&
            Objects.equals(this.localidade, outroEndereco.localidade) &&
            Objects.equals(this.uf, outroEndereco.uf) &&
            Objects.equals(this.ddd, outroEndereco.ddd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, logradouro, bairro, localidade, uf, ddd);
    }

}
