package com.example.BackEnd.controller;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackEnd.model.Classe;
import com.example.BackEnd.service.ClasseService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/classe")
public class ClasseController {

    @Autowired
    private ClasseService service;

    @Operation(summary = "Listar todas as classes", description = "Retorna uma lista com todas as classes cadastradas.")
    @GetMapping
    public List<Classe> listarClasses() {
        return service.listAll();
    }

    @Operation(summary = "Listar classe por ID", description = "Retorna uma classe específica com base no seu ID.")
    @GetMapping("/{id}")
    public Classe listarClasseId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listId(id);
    }

    @Operation(summary = "Criar nova classe", description = "Cadastra uma nova classe no sistema.")
    @PostMapping("/novo")
    public Classe criarClasse(@RequestBody Classe body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @Operation(summary = "Editar classe existente", description = "Atualiza as informações de uma classe existente com base no ID.")
    @PutMapping("/{id}")
    public Classe editarClasse(@RequestBody Classe body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @Operation(summary = "Deletar classe", description = "Remove uma classe do sistema com base no seu ID.")
    @DeleteMapping("/{id}")
    public void deletarClasse(@PathVariable UUID id) throws RelationNotFoundException {
        service.deleteId(id);
    }

}
