package edu.cesde.hotelreservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.cesde.hotelreservas.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
