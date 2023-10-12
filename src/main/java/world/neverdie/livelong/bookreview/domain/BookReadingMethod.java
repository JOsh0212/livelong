package world.neverdie.livelong.bookreview.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table
@Entity
public class BookReadingMethod {
    @Id
    private Integer id;
    private String toolName;

    @OneToMany private final Set<BookReview> bookReviews = new LinkedHashSet<>();

    protected BookReadingMethod() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookReadingMethod bookReadingMethod)) return false;
        return id!=null && id == bookReadingMethod.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
