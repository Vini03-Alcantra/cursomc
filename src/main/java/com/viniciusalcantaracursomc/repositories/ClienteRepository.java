package com.viniciusalcantaracursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniciusalcantaracursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
