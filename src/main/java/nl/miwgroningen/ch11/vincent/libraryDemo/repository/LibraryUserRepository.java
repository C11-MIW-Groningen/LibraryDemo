package nl.miwgroningen.ch11.vincent.libraryDemo.repository;

import nl.miwgroningen.ch11.vincent.libraryDemo.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {
    Optional<LibraryUser> findByUsername(String username);
}
