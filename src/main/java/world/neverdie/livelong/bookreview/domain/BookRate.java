package world.neverdie.livelong.bookreview.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import world.neverdie.livelong.bookreview.validation.Score;

import java.util.Objects;

@Getter
@ToString
@Table
@Entity
public class BookRate { //책리뷰 별점
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter @OneToOne(mappedBy = "bookRate", optional = false) private BookReview bookReview;
    @Setter @Score private Integer firstScore;
    @Setter @Score private Integer secondScore;
    @Setter @Score private Integer thirdScore;
    @Setter @Score private Integer fourthScore;
    @Setter @Score private Integer fifthScore;
    @Setter @Score private Double totalScore;

    public BookRate() {}

    private BookRate(BookReview bookReview, Integer firstScore, Integer secondScore, Integer thirdScore, Integer fourthScore, Integer fifthScore, Double totalScore) {
        this.bookReview = bookReview;
        this.firstScore = firstScore;
        this.secondScore = secondScore;
        this.thirdScore = thirdScore;
        this.fourthScore = fourthScore;
        this.fifthScore = fifthScore;
        this.totalScore = totalScore;
    }

    public static BookRate of(BookReview bookReview, int firstScore, int secondScore, int thirdScore, int fourthScore, int fifthScore, double totalScore) { // 별점을 상세 입력한 경우
        return new BookRate(bookReview,firstScore,secondScore,thirdScore,fourthScore,fifthScore,totalScore);
    }

    public static BookRate of(BookReview bookReview, double totalScore) {   // 총점만 입력한 경우
        return new BookRate(bookReview,null,null,null,null,null,totalScore);
    }
    public static BookRate of(BookReview bookReview) {  //  별점 입력 안 한 경우
        return new BookRate(bookReview,null,null,null,null,null,null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookRate bookRate)) return false;
        return id != null && id.equals(bookRate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
