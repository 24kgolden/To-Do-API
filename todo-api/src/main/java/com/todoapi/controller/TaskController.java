package com.todoapi.controller;

import com.todoapi.dto.TaskDTO.TaskRequest;
import com.todoapi.dto.TaskDTO.TaskResponse;
import com.todoapi.model.Task;
import com.todoapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // GET /api/tasks               → Todas las tareas
    // GET /api/tasks?completed=true → Filtrar por estado
    // GET /api/tasks?priority=HIGH  → Filtrar por prioridad
    // GET /api/tasks?search=texto   → Buscar por título
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAll(
            @RequestParam(required = false) Boolean completed,
            @RequestParam(required = false) Task.Priority priority,
            @RequestParam(required = false) String search
    ) {
        if (completed != null) return ResponseEntity.ok(service.findByStatus(completed));
        if (priority != null)  return ResponseEntity.ok(service.findByPriority(priority));
        if (search != null)    return ResponseEntity.ok(service.search(search));
        return ResponseEntity.ok(service.findAll());
    }

    // GET /api/tasks/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // POST /api/tasks
    @PostMapping
    public ResponseEntity<TaskResponse> create(@Valid @RequestBody TaskRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    // PUT /api/tasks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request
    ) {
        return ResponseEntity.ok(service.update(id, request));
    }

    // PATCH /api/tasks/{id}/toggle
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<TaskResponse> toggle(@PathVariable Long id) {
        return ResponseEntity.ok(service.toggleCompleted(id));
    }

    // DELETE /api/tasks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
