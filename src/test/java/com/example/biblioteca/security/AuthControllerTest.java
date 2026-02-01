package com.example.biblioteca.security;

import com.example.biblioteca.controller.AuthController;
import com.example.biblioteca.controller.LivroController;
import com.example.biblioteca.dto.LivroResponseDTO;
import com.example.biblioteca.dto.LoginRequestDTO;
import com.example.biblioteca.dto.LoginResponseDTO;
import com.example.biblioteca.security.JwtService;
import com.example.biblioteca.service.LivroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;


import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LivroController.class)
class LivroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LivroService livroService;

    @Test
    @WithMockUser
    void deveRetornarListaDeLivrosPaginada() throws Exception {

        LivroResponseDTO dto = new LivroResponseDTO(
                1L,
                "Domain Driven Design",
                "Eric Evans",
                2003,
                "123456"
        );

        Page<LivroResponseDTO> page =
                new PageImpl<>(List.of(dto));

        when(livroService.listarTodos(any(Pageable.class)))
                .thenReturn(page);

        mockMvc.perform(get("/api/livros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].titulo")
                        .value("Domain Driven Design"));
    }
}

