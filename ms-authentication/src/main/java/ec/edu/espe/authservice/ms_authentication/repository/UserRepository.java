package ec.edu.espe.authservice.ms_authentication.repository;

import ec.edu.espe.authservice.ms_authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}