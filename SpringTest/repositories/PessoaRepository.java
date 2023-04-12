package com.unifacisa.SpringTest.repositories;


import org.springframework.data.repository.CrudRepository;

import com.unifacisa.SpringTest.entities.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, String>{


}
