package com.example.demo.Controller;

import com.example.demo.Model.Livro;
import com.example.demo.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Livros")
public class LivroController {

    @Autowired
    private LivroService livroService;


    @GetMapping
    public List<Livro> listarLivro(){return livroService.listar();}

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro){return livroService.criar(livro);}

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {livroService.deletar(id);}

    @PutMapping("/{id}")
    public Livro livroAtualizar(@PathVariable Long id, @RequestBody Livro livro){return livroService.atualizar(id,livro);}
}
