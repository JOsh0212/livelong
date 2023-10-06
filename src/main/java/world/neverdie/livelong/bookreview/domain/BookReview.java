package world.neverdie.livelong.bookreview.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import world.neverdie.livelong.bookreview.dto.ReadingStrategies;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "startedReadingDate"),
        @Index(columnList = "endReadingDate"),
        @Index(columnList = "recordDate"),
        @Index(columnList = "readingStrategies"),
        @Index(columnList = "oneLineReview"),
})
@Entity
public class BookReview {   // 독후감 테이블
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //독후감 아이디

    @Setter private Long userId;   // 사용자 아이디 TODO 나중에 사용자 연결할 것
    @Setter @Column(columnDefinition = "VARCHAR(1000) CHARACTER SET UTF8") private String title;   // 리뷰 타이틀
    @Setter @ManyToOne(optional = false) private BookInfo bookInfo;  // 책정보
    @Setter private LocalDateTime startedReadingDate;   // 읽기 시작한 날
    @Setter private LocalDateTime endReadingDate;   // 다 읽은날
    @Setter private LocalDateTime recordDate;   // 기록날짜
    @Setter private int toolId;    //읽은 방법 TODO 독서도구 -> 책카테고리랑 비슷하게 할 예정
    @Setter private ReadingStrategies readingStrategies;    // 독서 전략
    @Setter private int bookRate;   // 별점 TODO 테이블로 뺄 예정
    @Setter @Column(length = 1000) private String oneLineReview;   //한 줄 리뷰
    @Setter private String readingReason; //책 선정이유
    @Setter private String bookContent; //책 비고

    //메타데이터
    @CreatedBy private LocalDateTime createdAt;
    @LastModifiedDate private LocalDateTime modifiedAt;

    protected BookReview() {}

    private BookReview(Long userId, String title, BookInfo bookInfo, LocalDateTime startedReadingDate, LocalDateTime endReadingDate, LocalDateTime recordDate, int toolId, ReadingStrategies readingStrategies, int bookRate, String oneLineReview, String readingReason, String bookContent) {
        this.userId = userId;
        this.title = title;
        this.bookInfo = bookInfo;
        this.startedReadingDate = startedReadingDate;
        this.endReadingDate = endReadingDate;
        this.recordDate = recordDate;
        this.toolId = toolId;
        this.readingStrategies = readingStrategies;
        this.bookRate = bookRate;
        this.oneLineReview = oneLineReview;
        this.readingReason = readingReason;
        this.bookContent = bookContent;
    }
    public static BookReview of(Long userId, String title, BookInfo bookInfo, LocalDateTime startedReadingDate, LocalDateTime endReadingDate, LocalDateTime recordDate, int toolId, ReadingStrategies readingStrategies, int bookRate, String oneLineReview, String readingReason, String bookContent) {
        return new BookReview(userId, title, bookInfo, startedReadingDate, endReadingDate, recordDate, toolId, readingStrategies, bookRate, oneLineReview, readingReason, bookContent);
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
