package edu.cesde.hotelreservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.cesde.hotelreservas.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
