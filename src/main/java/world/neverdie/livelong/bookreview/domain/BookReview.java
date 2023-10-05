package world.neverdie.livelong.bookreview.domain;

import jakarta.persistence.*;
import world.neverdie.livelong.bookreview.dto.ReadingStrategies;

import java.time.LocalDateTime;
@Entity
public class BookReview {   // 독후감 테이블
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //독후감 아이디
    private Long userId;   // 사용자 아이디 TODO 나중에 사용자 연결할 것
    private String title;   // 리뷰 타이틀
    @ManyToOne
    private BookInfo bookInfo;  // 책정보
    private LocalDateTime startedReadingDate;   // 읽기 시작한 날
    private LocalDateTime endReadingDate;   // 다 읽은날
    private LocalDateTime recordDate;   // 기록날짜
    private int toolId;    //읽은 방법 TODO 독서도구 -> 책카테고리랑 비슷하게 할 예정
    private ReadingStrategies readingStrategies;    // 독서 전략
    private int bookRate;   // 별점 TODO 테이블로 뺄 예정
    private String oneLineReview;   //한 줄 리뷰
    private String readingReason; //책 선정이유
    private String bookContent; //책 비고
}
