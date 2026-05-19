package com.todoapi;

import com.todoapi.model.Task;
import com.todoapi.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(TaskRepository repository) {
        return args -> {
            repository.save(new Task("Configurar el proyecto", "Instalar dependencias y verificar la estructura", Task.Priority.HIGH));
            repository.save(new Task("Escribir los tests", "Cubrir los endpoints con pruebas unitarias e integración", Task.Priority.HIGH));
            repository.save(new Task("Documentar la API", "Agregar Swagger/OpenAPI para documentación interactiva", Task.Priority.MEDIUM));
            repository.save(new Task("Revisar seguridad", "Agregar Spring Security y JWT", Task.Priority.MEDIUM));
            repository.save(new Task("Desplegar en producción", "Configurar Docker y CI/CD", Task.Priority.LOW));
        };
    }
}
