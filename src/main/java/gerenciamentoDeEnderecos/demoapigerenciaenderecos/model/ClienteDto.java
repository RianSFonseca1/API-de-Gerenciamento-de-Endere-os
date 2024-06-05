package gerenciamentoDeEnderecos.demoapigerenciaenderecos.model;

import lombok.Data;

@Data
public class ClienteDto {

    private Long cpfCnpj;
    private String nomeCliente;
    private String tipoPessoa;
    private String flagCadastro;
    private String enderecoCep;
    private String enderecoLogradouro;
    private String enderecoBairro;
    private String enderecoLocalidade;
    private String enderecoUf;
    private String enderecoDdd;

    // Construtor
    public ClienteDto(Cliente cliente, Endereco endereco) {
        this.cpfCnpj = cliente.getCpfCnpj();
        this.nomeCliente = cliente.getNomeCliente();
        this.tipoPessoa = cliente.getTipoPessoa();
        this.flagCadastro = cliente.getFlagCadastro();
        this.enderecoCep = endereco.getCep();
        this.enderecoLogradouro = endereco.getLogradouro();
        this.enderecoBairro = endereco.getBairro();
        this.enderecoLocalidade = endereco.getLocalidade();
        this.enderecoUf = endereco.getUf();
        this.enderecoDdd = endereco.getDdd();
    }

}
