package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {

        entregador.setHabilitado(Boolean.TRUE);
        entregador.setVersao(1L);
        entregador.setDataCriacao(LocalDate.now());
        return repository.save(entregador);
    }

    public List<Entregador> findAll() {

        return repository.findAll();
    }

    public Entregador findById(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Entregador entregadorAlterado) {

        Entregador entregador = repository.findById(id).get();
        entregador.setNome(entregadorAlterado.getNome());
        entregador.setCpf(entregadorAlterado.getCpf());
        entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
        entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
        entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
        entregador.setRg(entregadorAlterado.getRg());
        entregador.setQtdEntregas(entregadorAlterado.getQtdEntregas());
        entregador.setValorFrete(entregadorAlterado.getValorFrete());
        entregador.setRua(entregadorAlterado.getRua());
        entregador.setNumero(entregadorAlterado.getNumero());
        entregador.setBairro(entregadorAlterado.getBairro());
        entregador.setCidade(entregadorAlterado.getCidade());
        entregador.setCep(entregadorAlterado.getCep());
        entregador.setEstado(entregadorAlterado.getEstado());
        entregador.setComplemento(entregadorAlterado.getComplemento());
        entregador.setAtivo(entregadorAlterado.getAtivo());

        entregador.setVersao(entregador.getVersao() + 1);
        repository.save(entregador);
    }

    @Transactional
    public void delete(Long id) {

        Entregador entregador = repository.findById(id).get();
        entregador.setHabilitado(Boolean.FALSE);
        entregador.setVersao(entregador.getVersao() + 1);

        repository.save(entregador);
    }
}