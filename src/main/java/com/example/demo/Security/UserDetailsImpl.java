package com.example.demo.Security;

import com.example.demo.Model.Pessoa;
import com.example.demo.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    final PessoaRepository pessoaRepository;

    public UserDetailsImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Pessoa pessoa = pessoaRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new User(pessoa.getUsername(), pessoa.getPassword(), true, true, true, true, pessoa.getAuthorities());
    }
}
