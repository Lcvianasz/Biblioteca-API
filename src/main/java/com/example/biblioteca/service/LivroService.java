package com.example.biblioteca.service;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    public List<Livro> listarTodos(){
        return livroRepository.findAll();
    }
    public Optional<Livro> buscarPorId(Long id){
        return livroRepository.findById((id));
    }
    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }
    public void deletar(Long id){
        livroRepository.deleteById(id);
    }

}
