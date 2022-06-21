package com.sistemas.informaticos.services;

import com.sistemas.informaticos.models.Alumno;
import com.sistemas.informaticos.repositories.AlumnoRepository;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;

    public Alumno guardAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
    public ArrayList<Alumno> listaAlumno(){
        ArrayList<Alumno> alumnos = (ArrayList<Alumno>) alumnoRepository.findAll();
        return alumnos;
    }
}
