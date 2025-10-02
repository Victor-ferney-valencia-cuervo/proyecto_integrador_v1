package edu.cesde.hotelreservas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.cesde.hotelreservas.service.UserService;
import edu.cesde.hotelreservas.model.User;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService svc;
    public UserController(UserService svc){this.svc = svc;}

    @GetMapping
    public List<User> all(){return svc.listAll();}

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id){
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User u){
        User saved = svc.save(u);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User u){
        return svc.findById(id).map(existing -> {
            existing.setUsername(u.getUsername());
            existing.setFullName(u.getFullName());
            existing.setPassword(u.getPassword());
            svc.save(existing);
            return ResponseEntity.ok(existing);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
