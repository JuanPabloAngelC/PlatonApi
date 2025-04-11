package com.platon.api.models;

public class Curso {
    private int id;
    private String nombre;
    private String codigo;
    private String profesor;
    private int cupoMaximo;
    private int estudiantesInscritos;
    private String facultad;

    public Curso(int id, String nombre, String codigo, String profesor, int cupoMaximo, int estudiantesInscritos, String facultad) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.profesor = profesor;
        this.cupoMaximo = cupoMaximo;
        this.estudiantesInscritos = estudiantesInscritos;
        this.facultad = facultad;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public String getProfesor() { return profesor; }
    public int getCupoMaximo() { return cupoMaximo; }
    public int getEstudiantesInscritos() { return estudiantesInscritos; }
    public String getFacultad() { return facultad; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setProfesor(String profesor) { this.profesor = profesor; }
    public void setCupoMaximo(int cupoMaximo) { this.cupoMaximo = cupoMaximo; }
    public void setEstudiantesInscritos(int estudiantesInscritos) { this.estudiantesInscritos = estudiantesInscritos; }
    public void setFacultad(String facultad) { this.facultad = facultad; }
}
