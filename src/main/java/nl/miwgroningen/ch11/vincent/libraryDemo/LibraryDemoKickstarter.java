package nl.miwgroningen.ch11.vincent.libraryDemo;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.ch11.vincent.libraryDemo.model.LibraryUser;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.LibraryUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Get the application of the ground
 */

@SpringBootApplication
@RequiredArgsConstructor
public class LibraryDemoKickstarter implements CommandLineRunner {
    private final LibraryUserRepository libraryUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (libraryUserRepository.findByUsername("admin").isEmpty()) {
            LibraryUser admin = new LibraryUser();
            admin.setUsername("admin");
            admin.setAdministrator(true);
            admin.setPassword(passwordEncoder.encode("changeThisNow"));
            libraryUserRepository.save(admin);
            System.err.println("Admin created remember to change the password!");
        } else {
            System.err.println("Admin already exists nothing to do here");
        }
    }
}
