package br.com.ifpe.oxefood.api.fornecedor;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FornecedorRequest {
    @NotNull(message = "O Nome é de preenchimento obrigatório")
    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
    private String nome;

    private String endereco;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;

    @NotNull(message = "O valor de mercado deve ser preenchido")
    @NotBlank(message = "O valor de mercado deve ser preenchido")
    private Double valorMercador;

    private String paginaWeb;

    private String contatoVendedor;

    public Fornecedor build() {

        return Fornecedor.builder()
                .nome(nome)
                .endereco(endereco)
                .dataFundacao(dataFundacao)
                .valorMercador(valorMercador)
                .paginaWeb(paginaWeb)
                .contatoVendedor(contatoVendedor)
                .build();
    }
}
