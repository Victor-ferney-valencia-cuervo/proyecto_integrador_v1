package edu.cesde.hotelreservas.service;

import edu.cesde.hotelreservas.model.Room;
import edu.cesde.hotelreservas.repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository repo;
    public RoomService(RoomRepository repo){this.repo = repo;}
    public List<Room> listAll(){return repo.findAll();}
    public Optional<Room> findById(Long id){return repo.findById(id);}
    public Room save(Room r){return repo.save(r);}
    public void delete(Long id){repo.deleteById(id);}
}
