package com.example.demo.Service;


import com.example.demo.Model.Pessoa;
import com.example.demo.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> listar(){return pessoaRepository.findAll();}

    public Pessoa criar(Pessoa pessoa){return pessoaRepository.save(pessoa);}

    public void deletar(Long id){pessoaRepository.deleteById(id);}

    public Pessoa atualizar(Long id, Pessoa pessoaAtualizada){


        Pessoa pessoa = pessoaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setUsername(pessoaAtualizada.getUsername());
        pessoa.setIdade(pessoaAtualizada.getIdade());
        pessoa.setPassword(pessoaAtualizada.getPassword());

       return pessoaRepository.save(pessoa);


    }



}
