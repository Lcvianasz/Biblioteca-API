package com.example.biblioteca.service;

import com.example.biblioteca.dto.LivroRequestDTO;
import com.example.biblioteca.dto.LivroResponseDTO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Page<LivroResponseDTO> listarTodos(Pageable pageable){
        return livroRepository
                .findAll(pageable)
                .map(this::toResponseDTO);
    }

    public Optional<LivroResponseDTO> buscarPorId(Long id){
        return livroRepository.findById((id))
                .map(this::toResponseDTO);
    }

    public LivroResponseDTO salvar(LivroRequestDTO dto){
        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        livro.setIsbn(dto.getIsbn());
        Livro salvo = livroRepository.save(livro);
        return toResponseDTO(salvo);
    }

    public void deletar(Long id){
        livroRepository.deleteById(id);
    }

    private LivroResponseDTO toResponseDTO(Livro livro){
        return new LivroResponseDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAnoPublicacao(),
                livro.getIsbn()
        );
    }

}
