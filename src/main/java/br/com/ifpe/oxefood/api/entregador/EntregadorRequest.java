package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

   private String nome;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   private String cpf;

   private String foneCelular;

   private String foneFixo;

   private String rg;
   
   private Integer qtdEntregas;
   
   private Double valorFrete;
   
   private String rua;
   
   private Integer numero;
   
   private String bairro;
   
   private String cidade;
   
   private String cep;
   
   private String estado;
   
   private String complemento;

   private Boolean ativo;

   public Entregador build() {
      return Entregador.builder()
            .nome(nome)
            .dataNascimento(dataNascimento)
            .cpf(cpf)
            .foneCelular(foneCelular)
            .foneFixo(foneFixo)
            .rg(rg)
            .qtdEntregas(qtdEntregas)
            .valorFrete(valorFrete)
            .rua(rua)
            .numero(numero)
            .bairro(bairro)
            .cidade(cidade)
            .cep(cep)
            .estado(estado)
            .complemento(complemento)
            .ativo(ativo)
            .build();

   }
}