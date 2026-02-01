package com.example.biblioteca.service;

import com.example.biblioteca.dto.LivroResponseDTO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
public class LivroServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroService livroService;

    @Test
    void deveListarTodosLivros() {

        Livro livro = new Livro();
        livro.setTitulo("Clean Code");

        Page<Livro> page =
                new PageImpl<>(List.of(livro));

        Pageable pageable = PageRequest.of(0, 10);

        when(livroRepository.findAll(pageable))
                .thenReturn(page);

        Page<LivroResponseDTO> resultado =
                livroService.listarTodos(pageable);

        assertThat(resultado).isNotEmpty();
        assertThat(resultado.getContent().get(0).getTitulo())
                .isEqualTo("Clean Code");
    }
}
