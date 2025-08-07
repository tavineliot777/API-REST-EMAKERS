package com.example.demo.DTO;

import org.springframework.stereotype.Component;

@Component
public class DTO {
    private Long pessoaId;
    private Long livroId;


    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }
}
