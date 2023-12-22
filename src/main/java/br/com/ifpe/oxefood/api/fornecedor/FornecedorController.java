package br.com.ifpe.oxefood.api.fornecedor;

import javax.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;
import br.com.ifpe.oxefood.modelo.fornecedor.FornecedorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/fornecedor")
@CrossOrigin

public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody @Valid FornecedorRequest request) {
        Fornecedor fornecedor = fornecedorService.save(request.build());
        return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Fornecedor> findAll() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public Fornecedor findById(@PathVariable Long id) {
        return fornecedorService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        fornecedorService.delete(id);
        return ResponseEntity.ok().build();
    }

}
