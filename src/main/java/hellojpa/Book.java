package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("B")
public class Book extends Item{

    private String author;
    private String jsbn;
}
