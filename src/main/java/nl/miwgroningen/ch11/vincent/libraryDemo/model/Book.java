package nl.miwgroningen.ch11.vincent.libraryDemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * General information about a book, not a physical book!
 */

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;

    @Column(unique = true)
    private String title;
    private String author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Copy> copies;

    public int getNumberOfAvailableCopies() {
        int count = 0;

        for (Copy copy : copies) {
            if (copy.getAvailable()) {
                count++;
            }
        }

        return count;
    }
}
