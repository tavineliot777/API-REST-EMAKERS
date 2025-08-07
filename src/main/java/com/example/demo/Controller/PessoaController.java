package com.example.demo.Controller;

import com.example.demo.Model.Pessoa;
import com.example.demo.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listarPessoas(){return pessoaService.listar();}

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa){return pessoaService.criar(pessoa);}

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id){pessoaService.deletar(id);}

    @PutMapping("/{id}")
    public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){return pessoaService.atualizar(id, pessoa);}

}
