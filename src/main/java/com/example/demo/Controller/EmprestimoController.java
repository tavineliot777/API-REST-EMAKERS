package com.example.demo.Controller;

import com.example.demo.DTO.DTO;
import com.example.demo.Model.Emprestimo;
import com.example.demo.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> listarEmprestimo(){ return emprestimoService.listar();}

    @PostMapping("/criarEmprestimo")
    public Emprestimo criarEmprestimo(@RequestBody DTO dto){

        Long pessoaId = dto.getPessoaId();
        Long livroId = dto.getLivroId();

        return emprestimoService.criar(pessoaId,livroId);

    }

    @PostMapping("/devolverEmprestimo/{id}")
  public ResponseEntity<String> devolverEmprestimo(@PathVariable Long id){

        emprestimoService.devolver(id);

    return ResponseEntity.ok("iniciando protocolo de devolução!");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEmprestimo(@PathVariable Long id){

        emprestimoService.deletar(id);

    return ResponseEntity.ok("iniciando protocolo de deletação!");
    }

}
