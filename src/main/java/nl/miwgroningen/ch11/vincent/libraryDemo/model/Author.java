package nl.miwgroningen.ch11.vincent.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Describes someone who has written or is writing a book
 */

@Entity
@Getter @Setter
public class Author {

    @Id @GeneratedValue
    private Long authorId;

    @Column(nullable = false)
    private String firstName;
    private String infixName = "";
    @Column(nullable = false)
    private String lastName;

    public String getDisplayName() {
        String displayName = firstName;

        if (!infixName.equals("")) {
            displayName += " " + infixName;
        }

        displayName += " " + lastName;
        return displayName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
