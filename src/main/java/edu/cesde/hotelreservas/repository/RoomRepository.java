package edu.cesde.hotelreservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.cesde.hotelreservas.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
