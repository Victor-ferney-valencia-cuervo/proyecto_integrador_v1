package edu.cesde.hotelreservas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.cesde.hotelreservas.service.RoomService;
import edu.cesde.hotelreservas.model.Room;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService svc;
    public RoomController(RoomService svc){this.svc = svc;}

    @GetMapping
    public List<Room> all(){return svc.listAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Room> get(@PathVariable Long id){
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody Room r){
        return ResponseEntity.status(201).body(svc.save(r));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> update(@PathVariable Long id, @RequestBody Room r){
        return svc.findById(id).map(existing -> {
            existing.setNumber(r.getNumber());
            existing.setType(r.getType());
            existing.setPrice(r.getPrice());
            existing.setAvailable(r.getAvailable());
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
