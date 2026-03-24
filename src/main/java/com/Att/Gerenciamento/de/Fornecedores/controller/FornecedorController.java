package com.Att.Gerenciamento.de.Fornecedores.controller;

import com.Att.Gerenciamento.de.Fornecedores.entity.Fornecedor;
import com.Att.Gerenciamento.de.Fornecedores.service.FornecedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    // POST - Criar fornecedor
    @PostMapping
    public Fornecedor criar(@RequestBody Fornecedor fornecedor) {
        return service.salvar(fornecedor);
    }

    // GET - Listar todos
    @GetMapping
    public List<Fornecedor> listar() {
        return service.listarTodos();
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public Fornecedor buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    // DELETE - Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}