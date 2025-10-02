package edu.cesde.hotelreservas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.cesde.hotelreservas.service.ReservationService;
import edu.cesde.hotelreservas.service.RoomService;
import edu.cesde.hotelreservas.service.UserService;
import edu.cesde.hotelreservas.model.Reservation;
import edu.cesde.hotelreservas.model.Room;
import edu.cesde.hotelreservas.model.User;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService svc;
    private final UserService userSvc;
    private final RoomService roomSvc;

    public ReservationController(ReservationService svc, UserService userSvc, RoomService roomSvc){
        this.svc = svc; this.userSvc = userSvc; this.roomSvc = roomSvc;
    }

    @GetMapping
    public List<Reservation> all(){return svc.listAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> get(@PathVariable Long id){
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Reservation r){
        // basic validation existence of user and room
        User u = userSvc.findById(r.getUser().getId()).orElse(null);
        Room room = roomSvc.findById(r.getRoom().getId()).orElse(null);
        if(u==null || room==null) return ResponseEntity.badRequest().body("User or Room not found");
        r.setUser(u); r.setRoom(room);
        return ResponseEntity.status(201).body(svc.save(r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
