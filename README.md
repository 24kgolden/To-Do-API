<div align="center">

<img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring_Boot-3.2.5-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
<img src="https://img.shields.io/badge/Maven-3.9+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
<img src="https://img.shields.io/badge/H2-Database-1316BF?style=for-the-badge&logo=h2&logoColor=white"/>
<img src="https://img.shields.io/badge/Linux-Compatible-FCC624?style=for-the-badge&logo=linux&logoColor=black"/>
<img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge"/>

<br/><br/>

```
 ████████╗ ██████╗ ██████╗  ██████╗      █████╗ ██████╗ ██╗
    ██╔══╝██╔═══██╗██╔══██╗██╔═══██╗    ██╔══██╗██╔══██╗██║
    ██║   ██║   ██║██║  ██║██║   ██║    ███████║██████╔╝██║
    ██║   ██║   ██║██║  ██║██║   ██║    ██╔══██║██╔═══╝ ██║
    ██║   ╚██████╔╝██████╔╝╚██████╔╝    ██║  ██║██║     ██║
    ╚═╝    ╚═════╝ ╚═════╝  ╚═════╝     ╚═╝  ╚═╝╚═╝     ╚═╝
```

### ✅ API REST de Lista de Tareas — Spring Boot 3 + Java 21

</div>

---

## 📸 Vista previa

```
╔══════════════════════════════════════════════════════╗
║            Todo API — Endpoints disponibles           ║
╚══════════════════════════════════════════════════════╝

GET    /api/tasks                → Listar todas las tareas
GET    /api/tasks?completed=true → Filtrar por estado
GET    /api/tasks?priority=HIGH  → Filtrar por prioridad
GET    /api/tasks?search=texto   → Buscar por título
GET    /api/tasks/{id}           → Obtener tarea por ID
POST   /api/tasks                → Crear nueva tarea
PUT    /api/tasks/{id}           → Actualizar tarea
PATCH  /api/tasks/{id}/toggle    → Alternar estado completado
DELETE /api/tasks/{id}           → Eliminar tarea

Base URL: http://localhost:8080
```

---

## ✨ Características

| Endpoint | Descripción |
|----------|-------------|
| `GET /api/tasks` | Lista todas las tareas con sus datos completos |
| `?completed=true/false` | Filtra tareas por estado de completado |
| `?priority=HIGH/MEDIUM/LOW` | Filtra tareas por nivel de prioridad |
| `?search=texto` | Búsqueda de tareas por título (insensible a mayúsculas) |
| `POST /api/tasks` | Crea una nueva tarea con validaciones automáticas |
| `PATCH /{id}/toggle` | Alterna el estado completado de una tarea |
| `DELETE /{id}` | Elimina una tarea, devuelve `404` si no existe |

---

## 🚀 Instalación

### Opción 1 — Clonar y ejecutar directamente

```bash
git clone https://github.com/tu-usuario/todo-api.git
cd todo-api
mvn spring-boot:run
```

La API estará disponible en `http://localhost:8080`

### Opción 2 — Generar y ejecutar JAR

```bash
# Compilar y empaquetar
mvn clean package

# Ejecutar el JAR generado
java -jar target/todo-api-1.0.0.jar
```

### Opción 3 — Solo ejecutar los tests

```bash
mvn test
```

---

## 💻 Ejemplos de uso

```bash
# Crear una tarea
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title": "Aprender Spring Boot", "priority": "HIGH"}'

# Listar todas las tareas
curl http://localhost:8080/api/tasks

# Filtrar tareas pendientes
curl "http://localhost:8080/api/tasks?completed=false"

# Buscar por título
curl "http://localhost:8080/api/tasks?search=spring"

# Marcar como completada
curl -X PATCH http://localhost:8080/api/tasks/1/toggle

# Actualizar una tarea
curl -X PUT http://localhost:8080/api/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{"title": "Título actualizado", "priority": "LOW"}'

# Eliminar una tarea
curl -X DELETE http://localhost:8080/api/tasks/1
```

---

## 📦 Estructura del modelo `Task`

Cada tarea tiene los siguientes campos:

| Campo | Tipo | Descripción |
|-------|------|-------------|
| `id` | `Long` | Identificador único (autogenerado) |
| `title` | `String` | Título obligatorio, máx. 150 caracteres |
| `description` | `String` | Descripción opcional, máx. 500 caracteres |
| `completed` | `boolean` | Estado de completado (por defecto `false`) |
| `priority` | `enum` | Prioridad: `LOW`, `MEDIUM`, `HIGH` |
| `createdAt` | `LocalDateTime` | Fecha de creación (automática) |
| `updatedAt` | `LocalDateTime` | Fecha de última modificación (automática) |

> ⚠️ El campo `title` es obligatorio. Si se omite o se envía vacío, la API responde con `400 Bad Request` y un mensaje descriptivo del error.

---

## 📋 Requisitos

- **Java 21** o superior
- **Maven 3.9+**
- Linux, macOS o WSL

```bash
# Verificar versión de Java
java -version

# Instalar Java 21 en Ubuntu/Debian
sudo apt install openjdk-21-jdk

# Verificar Maven
mvn -version
```

---

## 🔧 Consola H2

En modo desarrollo puedes inspeccionar la base de datos directamente en el navegador:

```
URL:      http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:tododb
Usuario:  sa
Clave:    (dejar vacía)
```

---

## 🏗️ Estructura del proyecto

```
todo-api/
├── pom.xml                                    ← Dependencias Maven
├── README.md
└── src/
    ├── main/
    │   ├── java/com/todoapi/
    │   │   ├── TodoApiApplication.java        ← Punto de entrada
    │   │   ├── DataLoader.java                ← Datos de prueba al iniciar
    │   │   ├── controller/
    │   │   │   └── TaskController.java        ← Endpoints REST
    │   │   ├── service/
    │   │   │   └── TaskService.java           ← Lógica de negocio
    │   │   ├── repository/
    │   │   │   └── TaskRepository.java        ← Acceso a datos (JPA)
    │   │   ├── model/
    │   │   │   └── Task.java                  ← Entidad JPA
    │   │   ├── dto/
    │   │   │   └── TaskDTO.java               ← Records de Request/Response
    │   │   └── exception/
    │   │       ├── TaskNotFoundException.java
    │   │       └── GlobalExceptionHandler.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/com/todoapi/
            └── TaskControllerTest.java        ← Tests de integración
```

---

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si quieres mejorar Todo API:

1. Haz un **fork** del repositorio
2. Crea una rama: `git checkout -b feature/nueva-funcionalidad`
3. Realiza tus cambios y haz commit: `git commit -m "feat: agrega nueva-funcionalidad"`
4. Sube los cambios: `git push origin feature/nueva-funcionalidad`
5. Abre un **Pull Request**

### Ideas para contribuir

- [ ] Documentación interactiva con Swagger / OpenAPI
- [ ] Autenticación con Spring Security + JWT
- [ ] Migración a PostgreSQL con Docker Compose
- [ ] Paginación y ordenamiento en listados
- [ ] Fechas límite (`dueDate`) por tarea
- [ ] CI/CD con GitHub Actions

---

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**. Puedes usarlo, modificarlo y distribuirlo libremente.

---

<div align="center">
Hecho con ☕ Java y 💚 Spring Boot
</div>
