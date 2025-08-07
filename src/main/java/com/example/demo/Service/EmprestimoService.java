package com.example.demo.Service;

import com.example.demo.Model.Emprestimo;
import com.example.demo.Model.Livro;
import com.example.demo.Model.Pessoa;
import com.example.demo.Repository.EmprestimoRepository;
import com.example.demo.Repository.LivroRepository;
import com.example.demo.Repository.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {


    final EmprestimoRepository emprestimoRepository;

    final PessoaRepository pessoaRepository;

    final LivroRepository livroRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, PessoaRepository pessoaRepository, LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.pessoaRepository = pessoaRepository;
        this.livroRepository = livroRepository;
    }

    public List<Emprestimo> listar(){return emprestimoRepository.findAll();}

    public Emprestimo criar(Long pessoaId,Long livroId){

        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Essa pessoa não existe no banco de dados!"));

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Esse livro não existe no banco de dados!"));

                Emprestimo emprestimoNovo = new Emprestimo();

        emprestimoNovo.setDataEmprestimo(LocalDate.now());
        emprestimoNovo.setLivro(livro);
        emprestimoNovo.setPessoa(pessoa);
        emprestimoNovo.setDevolvido(false);

        return emprestimoRepository.save(emprestimoNovo);
    }

    public ResponseEntity<String> devolver(Long id){

        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprestimo não existe no banco de dados"));

        emprestimo.setDevolvido(true);
        emprestimo.setDataDevolução(LocalDate.now());

        emprestimoRepository.save(emprestimo);

        return ResponseEntity.ok("Emprestimo devolvido!");

    }

    public ResponseEntity<String> deletar(Long id){

        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprestimo não existe!"));

        emprestimoRepository.delete(emprestimo);

        return ResponseEntity.ok("Emprestimo deletado com sucesso!");
    }

}
