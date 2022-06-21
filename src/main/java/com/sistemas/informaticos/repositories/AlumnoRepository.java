package com.sistemas.informaticos.repositories;

import org.springframework.stereotype.Repository;

import com.sistemas.informaticos.models.Alumno;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface AlumnoRepository extends CrudRepository <Alumno, Long>{

}
