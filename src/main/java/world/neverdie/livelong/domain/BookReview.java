package world.neverdie.livelong.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Entity
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "startDate"),
        @Index(columnList = "endDate"),
        @Index(columnList = "oneLineComment")
})
public class BookReview {   // 책 리뷰 적기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id자동 생성
    private Long id;    // 책 리뷰 id
    @Setter private Long userId;   // TODO user 만들면 변경
    @Setter @Column(length = 100) private String title; // 한글 기준 50자, default 값은 제목없음 TODO 이걸 java로 할까, 아님 sql로 할까
    @Setter private Long bookInfoId;    // TODO 책 정보 추가하면 변경 예정
    @Setter private LocalDateTime startDate;    //시작일
    @Setter private LocalDateTime endDate;  //종료일
    @Setter private int readingMethodId; //TODO 책 읽은 방법 추가하면 변경 예정
    @Setter private int readingStrategy;   //독서 전략 TODO enum? 테이블?
    @Setter @Column(length = 100) private String oneLineComment;   //한줄 리뷰, 인덱싱 걸기
    @Setter @Column(columnDefinition = "TEXT") private String readingReasons;  // 책선정이유
    @Setter @Column(columnDefinition = "TEXT") private String content; // 책 비고
    @Setter @Column(columnDefinition = "TEXT") private String review;  // 책감상

    //메타데이터
    @CreatedBy private LocalDateTime createdBy;
    @LastModifiedBy private LocalDateTime modifiedBy;

    protected BookReview() {}

    private BookReview(Long userId, String title, Long bookInfoId, LocalDateTime startDate, LocalDateTime endDate, int readingMethodId, int readingStrategy, String oneLineComment, String readingReasons, String content, String review) {
        this.userId = userId;
        this.title = title;
        this.bookInfoId = bookInfoId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.readingMethodId = readingMethodId;
        this.readingStrategy = readingStrategy;
        this.oneLineComment = oneLineComment;
        this.readingReasons = readingReasons;
        this.content = content;
        this.review = review;
    }
    public static BookReview of(Long userId, String title, Long bookInfoId, LocalDateTime startDate, LocalDateTime endDate, int readingMethodId, int readingStrategy, String oneLineComment, String readingReasons, String content, String review) {
        return new BookReview(userId, title, bookInfoId, startDate, endDate, readingMethodId, readingStrategy, oneLineComment, readingReasons, content, review);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookReview bookReview)) return false;
        return id!=null&&id.equals(bookReview.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
