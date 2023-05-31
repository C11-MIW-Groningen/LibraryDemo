package nl.miwgroningen.ch11.vincent.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * A physical manifestation of a book
 */

@Entity
@Getter @Setter
public class Copy {
    @Id @GeneratedValue
    private Long copyId;

    private Boolean available = true;

    @ManyToOne
    private Book book;
}
