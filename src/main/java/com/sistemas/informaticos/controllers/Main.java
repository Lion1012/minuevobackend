package com.sistemas.informaticos.controllers;

import com.sistemas.informaticos.models.Alumno;
import com.sistemas.informaticos.models.Campeon;
import com.sistemas.informaticos.models.Results;
import com.sistemas.informaticos.models.Traducido;
import com.sistemas.informaticos.services.AlumnoService;
import com.sistemas.informaticos.services.CampeonService;
import com.sistemas.informaticos.services.PopulationService;
import com.sistemas.informaticos.services.TraductorService;
import com.sistemas.informaticos.utils.Utils;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    @Autowired
    CampeonService campeonService;

    @Autowired
    TraductorService traductorService;

    @Autowired
    PopulationService populationService;

    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/")
    public String inicio() {
        return "Mi servidor backend";
    }

    @GetMapping("/contar/{palabra}")
    public String cuentaletras(@PathVariable String palabra) {
        return Utils.cuentapalabra(palabra);
    }

    @GetMapping("/guarda")
    public String guardaCampeon(@RequestParam String nombre, @RequestParam String linea) {
        Campeon completo = new Campeon();
        completo.setNombre(nombre);
        completo.setLinea(linea);
        campeonService.guardCampeon(completo);
        return "Campeon creado correctamente.";

    }

    @GetMapping("/listar")
    public String listaCampeones() {
        ArrayList<Campeon> campeones = campeonService.listaCampeon();
        String listado = "Lista de campeones:<br/>";
        for (Campeon campeon : campeones) {
            listado += campeon.getNombre() + "  ";
            listado += campeon.getLinea() + "  ";
            listado += "<br/>";
        }
        return listado;
    }
    @GetMapping("/{palabra}")
    public String transforma(@PathVariable String palabra) {
        return Utils.transformame(palabra);
    }
    @GetMapping("/traduce/{palabra}")
    public String getTranslation(@PathVariable String palabra){
        Traducido traducido = traductorService.getTranslationFromAPI(palabra);
        return traducido.responseData.translatedText;
    }
    @GetMapping("/letradni/{numsDni}")
    public String calculaLetra(@PathVariable String numsDni) {
        for (char i : numsDni.toCharArray() ) {
            if ( ! Character.isDigit(i))
            return "Tienes que poner un numero de 8 cifas sin letras";
        }
        if (numsDni.length()!=8){
            return "Tienes que poner un numero de 8 cifas sin letras";
        }
        int dniCompleto = Integer.parseInt(numsDni);
        return numsDni + Utils.calculaLetra(dniCompleto);
    }
    @GetMapping("/coincidencias")
    public String concideLetras(@RequestParam String nombre1, @RequestParam String nombre2) {
        return nombre1 + nombre2 + " tienen " + Utils.calculaCoincidencias(nombre1, nombre2) + " letras en comun";
    }
    @GetMapping("/habitantes/{lugar}")
    public String getPopulation(@PathVariable String lugar){
        Results results = populationService.getPopulation(lugar);
        return results.results[0].population + "habitantes";
    }
    @GetMapping("/alumno")
    public String guardaAlumno(@RequestParam String nombre, @RequestParam String nota) {
        Alumno completo = new Alumno();
        completo.setNombre(nombre);
        completo.setNotas(nota);
        alumnoService.guardAlumno(completo);
        return "Alumno creado correctamente.";

    }
    @GetMapping("/listaralum")
    public String listaAlumno() {
        ArrayList<Alumno> alumnos = alumnoService.listaAlumno();
        String listado = "Lista de alumnos:<br/>";
        for (Alumno alumno : alumnos) {
            listado += alumno.getNombre() + "  ";
            listado += alumno.getNotas() + "  ";
            listado += "<br/>";
        }
        return listado;
    }
}
