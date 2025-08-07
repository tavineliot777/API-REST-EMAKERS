package com.example.demo.Service;

import com.example.demo.Model.Livro;
import com.example.demo.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;


    public List<Livro> listar(){return livroRepository.findAll();}

    public Livro criar(Livro livro){return livroRepository.save(livro);}

    public void deletar(Long id){livroRepository.deleteById(id);}

    public Livro atualizar(Long id, Livro livroAtualizado){

        Livro livroAntigo = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro nao encontrado!"));


                livroAntigo.setQuantidade(livroAtualizado.getQuantidade());
                livroAntigo.setAutor(livroAtualizado.getAutor());
                livroAntigo.setNome(livroAtualizado.getNome());

                return livroRepository.save(livroAntigo);

    }

}
