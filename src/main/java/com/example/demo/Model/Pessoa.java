package com.example.demo.Model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Pessoas")
public class Pessoa implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false, unique = true)
    private String password;
    @Column(nullable = false)
    private int idade;

    @ManyToMany
    @JoinTable(
            name = "pessoa_livro",
            joinColumns = @JoinColumn (name= "pessoas_id"),
            inverseJoinColumns = @JoinColumn(name = "livros_id")
    )
    private Set<Livro> livros = new HashSet<>();

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String username, String password, int idade) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
