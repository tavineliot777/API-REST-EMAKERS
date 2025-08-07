package com.example.demo.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Livro livro;

    @Column(nullable = false)
    private LocalDate dataEmprestimo;

    private LocalDate dataDevolução;

    private Boolean devolvido;

    public Emprestimo() {
    }

    public Emprestimo(Long id, Pessoa pessoa, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolução, Boolean devolvido) {
        this.id = id;
        this.pessoa = pessoa;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolução = dataDevolução;
        this.devolvido = devolvido;
    }


    public Long getId() {
        return id;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolução() {
        return dataDevolução;
    }

    public void setDataDevolução(LocalDate dataDevolução) {
        this.dataDevolução = dataDevolução;
    }

    public Boolean getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
    }
}
