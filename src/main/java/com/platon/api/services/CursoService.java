package com.platon.api.services;

import com.platon.api.models.Curso;

import java.util.ArrayList;
import java.util.List;


public class CursoService {
    private List<Curso> cursos = new ArrayList<>();
    private int currentId = 1;



    public boolean agregarCurso(Curso curso) {
        // Validar que el código no esté repetido
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(curso.getCodigo())) {
                return false;
            }
        }

        // Validar que el cupo máximo sea mayor que 0
        if (curso.getCupoMaximo() <= 0) {
            return false;
        }

        // Asignar ID y agregar
        curso.setId(currentId++);
        cursos.add(curso);
        return true;
    }

    private List<Curso> curso = new ArrayList<>();

    public List<Curso> listarCursos() {
        return cursos;
    }

    public List<Curso> buscarPorFacultad(String facultad) {
        List<Curso> resultado = new ArrayList<>();
        for (Curso c : cursos) {
            if (c.getFacultad().equalsIgnoreCase(facultad)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public List<Curso> obtenerCursosPorFacultad(String facultad) {
        List<Curso> resultado = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getFacultad().equalsIgnoreCase(facultad)) {
                resultado.add(curso);
            }
        }
        return resultado;
    }


}

