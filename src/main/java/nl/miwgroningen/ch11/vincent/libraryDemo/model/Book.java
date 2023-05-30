package nl.miwgroningen.ch11.vincent.libraryDemo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * General information about a book, not a physical book!
 */

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;
    private String title;
    private String author;
}
