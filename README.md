# 📝 Todo API — Spring Boot 3 + Java 21

API REST completa para gestión de tareas (To-Do) con Spring Boot, JPA y base de datos H2 en memoria.

---

## 🚀 Requisitos

- Java 21+
- Maven 3.9+

---

## ▶️ Ejecutar el proyecto

```bash
# Compilar y ejecutar
mvn spring-boot:run

# Ejecutar tests
mvn test

# Generar JAR ejecutable
mvn clean package
java -jar target/todo-api-1.0.0.jar
```

---

## 🌐 Endpoints disponibles

Base URL: `http://localhost:8080/api/tasks`

| Método   | Endpoint                  | Descripción                        |
|----------|---------------------------|------------------------------------|
| GET      | `/api/tasks`              | Listar todas las tareas            |
| GET      | `/api/tasks?completed=true` | Filtrar por estado               |
| GET      | `/api/tasks?priority=HIGH`  | Filtrar por prioridad            |
| GET      | `/api/tasks?search=texto`   | Buscar por título                |
| GET      | `/api/tasks/{id}`         | Obtener tarea por ID               |
| POST     | `/api/tasks`              | Crear nueva tarea                  |
| PUT      | `/api/tasks/{id}`         | Actualizar tarea completa          |
| PATCH    | `/api/tasks/{id}/toggle`  | Marcar/desmarcar como completada   |
| DELETE   | `/api/tasks/{id}`         | Eliminar tarea                     |

---

## 📦 Ejemplo de request

```json
POST /api/tasks
Content-Type: application/json

{
  "title": "Aprender Spring Boot",
  "description": "Completar el tutorial oficial",
  "priority": "HIGH"
}
```

Prioridades válidas: `LOW`, `MEDIUM`, `HIGH`

---

## 🔧 Consola H2 (desarrollo)

Disponible en: `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:mem:tododb`
- **Usuario:** `sa`
- **Contraseña:** *(vacía)*

---

## 🏗️ Estructura del proyecto

```
src/main/java/com/todoapi/
├── TodoApiApplication.java       # Punto de entrada
├── DataLoader.java               # Datos de prueba
├── controller/
│   └── TaskController.java       # Endpoints REST
├── service/
│   └── TaskService.java          # Lógica de negocio
├── repository/
│   └── TaskRepository.java       # Acceso a datos (JPA)
├── model/
│   └── Task.java                 # Entidad JPA
├── dto/
│   └── TaskDTO.java              # Request/Response DTOs
└── exception/
    ├── TaskNotFoundException.java
    └── GlobalExceptionHandler.java
```

---

## 📌 Próximos pasos sugeridos

- [ ] Agregar Swagger/OpenAPI (`springdoc-openapi`)
- [ ] Implementar Spring Security + JWT
- [ ] Migrar a PostgreSQL con Docker Compose
- [ ] Configurar CI/CD con GitHub Actions
