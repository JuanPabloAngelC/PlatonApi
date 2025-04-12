Platon API – Gestión de Cursos

Este proyecto fue desarrollado como parte del examen de CES3

--------------------------------------------------------------------------------------------------------------

Variante implementada

Variante A - Gestión de Cursos
Corresponde a documento de identidad terminado en número par (En este caso = 4)

--------------------------------------------------------------------------------------------------------------

Su objetivo es implementar una API REST que permita registrar, listar y filtrar cursos académicos, utilizando Java, Servlets, almacenamiento en memoria y Tomcat como servidor de aplicaciones.

--------------------------------------------------------------------------------------------------------------

¿Qué se hizo en el proyecto?

- Se creó una API REST desde cero usando Java y Servlets.
- Se configuró el servidor Apache Tomcat para desplegar la aplicación.
- Se implementó un modelo de cursos con validaciones básicas.
- Se manejaron respuestas en formato JSON usando la librería GSON.
- Se utilizó Git para control de versiones, con los commits requeridos por el examen.
- Se implementaron tres endpoints funcionales:
    - Registrar curso POST /cursos
    - Listar todos los cursos GET /cursos
    - Filtrar cursos por facultad GET /cursos/facultad?nombre=X

--------------------------------------------------------------------------------------------------------------

Estructura del proyecto

PlatonApi
```plaintext
├───src
│ ├───main
│ │ ├───java
│ │ │ └───com
│ │ │ └───platon
│ │ │ └───api
│ │ │ ├───models // Clases que representan la estructura de datos.
│ │ │ │ └───Curso.java // Clase que representa un curso con sus atributos.
│ │ │ ├───services // Lógica de negocio y almacenamiento en memoria.
│ │ │ │ └───CursoService.java // Clase que gestiona cursos en memoria (agregar, listar, buscar).
│ │ │ └───servlets // Endpoints HTTP expuestos para la API.
│ │ │ └───CursoServlet.java // Servlet que maneja las peticiones POST y GET para los cursos.
```
--------------------------------------------------------------------------------------------------------------

ENDPOINTS

/Platon_Api_war_exploded/

Registrar un curso
POST /cursos

Ejemplo de petición:

```json
{
"nombre": "Estructuras de Datos",
"codigo": "INF102",
"profesor": "Ana Gómez",
"cupoMaximo": 40,
"estudiantesInscritos": 10,
"facultad": "Ingenieria"
}
```

GET /cursos
Listar todos los cursos

GET /cursos/facultad?nombre=Ingenieria
Buscar cursos por facultad (En este caso Ingenieria)

--------------------------------------------------------------------------------------------------------------

Validaciones aplicadas

- No se permite registrar cursos con el mismo código.

- El cupo máximo debe ser mayor que cero.