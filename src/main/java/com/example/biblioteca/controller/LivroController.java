package com.example.biblioteca.controller;

import com.example.biblioteca.dto.LivroRequestDTO;
import com.example.biblioteca.dto.LivroResponseDTO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    @GetMapping
    public Page<LivroResponseDTO> listarTodos(
            @PageableDefault(
                    size = 5,
                    sort = "titulo"
            )
            Pageable pageable){
        return livroService.listarTodos(pageable);
    }
    @GetMapping("/{id}")
    public LivroResponseDTO buscarPorId(@PathVariable Long id){
        return livroService.buscarPorId(id).orElse(null);
    }
    @PostMapping
    public LivroResponseDTO salvar(@RequestBody LivroRequestDTO dto){
        return livroService.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        livroService.deletar(id);
    }

}