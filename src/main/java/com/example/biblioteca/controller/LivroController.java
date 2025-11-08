package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    // Listar todos os livros
    @GetMapping
    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    // Adicionar um livro
    @PostMapping
    public List<Livro> adicionarLista(@RequestBody List<Livro> livros) {
        return livroRepository.saveAll(livros);
    }


    // Buscar livro por id
    @GetMapping("/{id}")
    public Livro buscar(@PathVariable Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    // Atualizar livro
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        return livroRepository.findById(id).map(l -> {
            l.setTitulo(livroAtualizado.getTitulo());
            l.setAutor(livroAtualizado.getAutor());
            l.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            l.setIsbn(livroAtualizado.getIsbn());
            return livroRepository.save(l);
        }).orElse(null);
    }

    // Deletar livro
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        livroRepository.deleteById(id);
    }
}
