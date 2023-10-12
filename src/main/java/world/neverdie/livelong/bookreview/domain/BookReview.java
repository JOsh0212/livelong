package world.neverdie.livelong.bookreview.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import world.neverdie.livelong.bookreview.dto.ReadingStrategies;
import world.neverdie.livelong.reviewer.domain.Reviewer;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "startDate"),
        @Index(columnList = "endDate"),
        @Index(columnList = "readingStrategies"),
        @Index(columnList = "oneLineReview"),
})
@Entity
public class BookReview {   // 독후감 테이블
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //독후감 아이디

    @Setter @ManyToOne(optional = false) private Reviewer reviewer;
    @Setter @Column(columnDefinition = "VARCHAR(1000) CHARACTER SET UTF8") private String title;   // 리뷰 타이틀
    @Setter @ManyToOne(optional = false) private BookInfo bookInfo;  // 책정보
    @Setter private LocalDateTime startDate;   // 읽기 시작한 날
    @Setter private LocalDateTime endDate;   // 다 읽은날
    @Setter @OneToOne private BookReadingMethod bookReadingMethod;    //읽은 방법
    @Setter private ReadingStrategies readingStrategies;    // 독서 전략
    @Setter @OneToOne(optional = false) private BookRate bookRate;   // 별점
    @Setter @Column(length = 1000) private String oneLineReview;   //한 줄 리뷰
    @Setter private String readingReason; //책 선정이유
    @Setter private String bookContent; //책 비고

    //메타데이터
    @CreatedBy @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Column(updatable = false) private LocalDateTime createdAt;
    @LastModifiedDate @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) private LocalDateTime modifiedAt;

    protected BookReview() {}

    private BookReview(Reviewer reviewer, String title, BookInfo bookInfo, LocalDateTime startDate, LocalDateTime endDate, BookReadingMethod bookReadingMethod, ReadingStrategies readingStrategies, BookRate bookRate, String oneLineReview, String readingReason, String bookContent, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.reviewer = reviewer;
        this.title = title;
        this.bookInfo = bookInfo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookReadingMethod = bookReadingMethod;
        this.readingStrategies = readingStrategies;
        this.bookRate = bookRate;
        this.oneLineReview = oneLineReview;
        this.readingReason = readingReason;
        this.bookContent = bookContent;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    private static BookReview of(Reviewer reviewer, String title, BookInfo bookInfo, LocalDateTime startDate, LocalDateTime endDate, BookReadingMethod bookReadingMethod, ReadingStrategies readingStrategies, BookRate bookRate, String oneLineReview, String readingReason, String bookContent, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        return new BookReview(reviewer,title,bookInfo,startDate,endDate,bookReadingMethod,readingStrategies,bookRate,oneLineReview, readingReason, bookContent, createdAt, modifiedAt);
    }

    private static BookReview of(Reviewer reviewer) {
        return new BookReview(reviewer,null,null,null,null,null,null,null,null, null, null, null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookReview bookReview)) return false;
        return id!=null && id.equals(bookReview.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
