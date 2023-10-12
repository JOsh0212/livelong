package world.neverdie.livelong.bookreview.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@Table
@Entity
public class BookRatingSection {    //책 별점 세션 이름
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter @OneToOne private BookCategory bookCategory;  //카테고리에 따라 1개 존재
    @Setter @Column(length = 20) private String firstRatingName;
    @Setter @Column(length = 20) private String secondRatingName;
    @Setter @Column(length = 20) private String thirdRatingName;
    @Setter @Column(length = 20) private String fourthRatingName;
    @Setter @Column(length = 20) private String fifthRatingName;

    protected BookRatingSection() {}
    private BookRatingSection(BookCategory bookCategory, String firstRatingName, String secondRatingName, String thirdRatingName, String fourthRatingName, String fifthRatingName) {
        this.bookCategory = bookCategory;
        this.firstRatingName = firstRatingName;
        this.secondRatingName = secondRatingName;
        this.thirdRatingName = thirdRatingName;
        this.fourthRatingName = fourthRatingName;
        this.fifthRatingName = fifthRatingName;
    }
    public static BookRatingSection of(BookCategory bookCategory, String firstRatingName, String secondRatingName, String thirdRatingName, String fourthRatingName, String fifthRatingName) {   //별점 상세 입력시 각 항목은 반드시 다 입력
        return new BookRatingSection(bookCategory,firstRatingName , secondRatingName, thirdRatingName, fourthRatingName, fifthRatingName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookRatingSection bookRatingSection)) return false;
        return id !=null && id.equals(bookRatingSection.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
