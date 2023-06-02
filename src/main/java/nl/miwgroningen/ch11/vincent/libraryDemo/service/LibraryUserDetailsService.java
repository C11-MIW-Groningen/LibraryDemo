package nl.miwgroningen.ch11.vincent.libraryDemo.service;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.LibraryUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Provide details for a user
 */

@Service
@RequiredArgsConstructor
public class LibraryUserDetailsService implements UserDetailsService {
    private final LibraryUserRepository libraryUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return libraryUserRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Deze gebruiker bestaat niet."));
    }
}
