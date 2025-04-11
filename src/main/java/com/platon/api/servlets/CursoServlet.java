package com.platon.api.servlets;

import com.google.gson.Gson;
import com.platon.api.models.Curso;
import com.platon.api.services.CursoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CursoServlet", urlPatterns = {"/cursos", "/cursos/facultad"})
public class CursoServlet extends HttpServlet {

    private CursoService cursoService = new CursoService();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Leer el JSON enviado
        BufferedReader reader = req.getReader();
        Curso nuevoCurso = gson.fromJson(reader, Curso.class);

        boolean agregado = cursoService.agregarCurso(nuevoCurso);
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        if (agregado) {
            resp.setStatus(HttpServletResponse.SC_CREATED);
            out.print("{\"mensaje\":\"Curso creado correctamente\"}");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"mensaje\":\"Error al crear el curso. Código duplicado o cupo inválido\"}");
        }
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String path = req.getServletPath(); // Esto captura la ruta como /cursos o /cursos/facultad

        if ("/cursos".equals(path)) {
            List<Curso> lista = cursoService.listarCursos();
            String json = gson.toJson(lista);
            out.print(json);
        } else if ("/cursos/facultad".equals(path)) {
            String facultad = req.getParameter("nombre");

            if (facultad != null) {
                List<Curso> cursosPorFacultad = cursoService.obtenerCursosPorFacultad(facultad);
                String json = gson.toJson(cursosPorFacultad);
                out.print(json);
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print("{\"error\":\"Falta el parámetro 'nombre'\"}");
            }
        }

        out.flush();
    }
}

