package br.com.ifpe.oxefood.modelo.produto;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ifpe.oxefood.util.exception.CategoriaProdutoException;

@Service
public class CategoriaProdutoService {
    @Autowired
    private CategoriaProdutoRepository repository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoriaProduto) {
        List<CategoriaProduto> categorias = repository.findAll();
        for (CategoriaProduto categoria : categorias) {
            if (categoria.getDescricao().equals(categoriaProduto.getDescricao())) {
                throw new CategoriaProdutoException(CategoriaProdutoException.MSG_NOME_CATEGORIA);
            }
        }

        categoriaProduto.setHabilitado(Boolean.TRUE);
        categoriaProduto.setVersao(1L);
        categoriaProduto.setDataCriacao(LocalDate.now());
        return repository.save(categoriaProduto);
    }

    public List<CategoriaProduto> findAll() {

        return repository.findAll();
    }

    public CategoriaProduto findById(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, CategoriaProduto categoriaProdutoAlterado) {

        CategoriaProduto catergoriaProduto = repository.findById(id).get();
        catergoriaProduto.setDescricao(categoriaProdutoAlterado.getDescricao());
        catergoriaProduto.setVersao(catergoriaProduto.getVersao() + 1);
        repository.save(catergoriaProduto);
    }

    @Transactional
    public void delete(Long id) {

        CategoriaProduto catergoriaProduto = repository.findById(id).get();
        catergoriaProduto.setHabilitado(Boolean.FALSE);
        catergoriaProduto.setVersao(catergoriaProduto.getVersao() + 1);

        repository.save(catergoriaProduto);
    }
}
