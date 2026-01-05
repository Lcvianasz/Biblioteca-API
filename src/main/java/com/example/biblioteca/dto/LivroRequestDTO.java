package com.example.biblioteca.dto;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivroRequestDTO {

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String isbn;
}
