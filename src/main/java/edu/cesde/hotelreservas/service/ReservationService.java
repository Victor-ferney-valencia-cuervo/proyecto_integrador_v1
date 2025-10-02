package edu.cesde.hotelreservas.service;

import edu.cesde.hotelreservas.model.Reservation;
import edu.cesde.hotelreservas.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository repo;
    public ReservationService(ReservationRepository repo){this.repo = repo;}
    public List<Reservation> listAll(){return repo.findAll();}
    public Optional<Reservation> findById(Long id){return repo.findById(id);}
    public Reservation save(Reservation r){return repo.save(r);}
    public void delete(Long id){repo.deleteById(id);}
}
