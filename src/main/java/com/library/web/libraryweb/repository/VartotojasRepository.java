package com.library.web.libraryweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.library.web.libraryweb.model.Vartotojas;

public interface VartotojasRepository extends CrudRepository<Vartotojas, Integer>{

    List<Vartotojas> deleteById(int id);
}
