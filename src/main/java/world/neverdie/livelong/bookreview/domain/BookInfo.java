package world.neverdie.livelong.bookreview.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import world.neverdie.livelong.bookreview.dto.BookType;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "isbn"),
        @Index(columnList = "publishDate"),
        @Index(columnList = "bookCategory"),
})
@Entity
public class BookInfo { //책정보 entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 책 아이디

    @Setter @Column(nullable = false,length = 1000) private String title;   //책 제목
    @Setter @Column(nullable = false) private String author;  //작가명 TODO 나중에 작가 테이블 뺄 예정
    @Setter private String translator;  //역자명 TODO 나중에 역자 테이블 뺄 예정
    @Setter @Column(nullable = false,length = 100) private String publisher;   // 출판사
    @Setter @Column(nullable = false) private LocalDateTime publishDate;  //출판일자
    @Setter @Column(nullable = false) private String thumbnail;   //책 썸네일
    @Setter @Column(nullable = false,length = 13) private String isbn;    //책 ISBN(13)
    @Setter private int bookCategory;   //KDC 번호 TODO 나중에 카테고리 테이블 뺄 예정
    @Enumerated(EnumType.STRING) private BookType bookType;    //책 타입
    @Setter private int length; // 쪽수
    @Setter private String firstLine;   //첫문장
    @Setter private String summary; //책 소개 혹은 줄거리

    protected BookInfo() {}
    private BookInfo(String title, String author, String translator, String publisher, LocalDateTime publishDate, String thumbnail, String isbn, int bookCategory, BookType bookType, int length, String firstLine, String summary) {
        this.title = title;
        this.author = author;
        this.translator = translator;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.thumbnail = thumbnail;
        this.isbn = isbn;
        this.bookCategory = bookCategory;
        this.bookType = bookType;
        this.length = length;
        this.firstLine = firstLine;
        this.summary = summary;
    }
    public static BookInfo of(String title, String author, String translator, String publisher, LocalDateTime publishDate, String thumbnail, String isbn, int bookCategory, BookType bookType, int length, String firstLine, String summary){
        return new BookInfo(title,author,translator,publisher,publishDate,thumbnail,isbn,bookCategory,bookType,length,firstLine,summary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof BookInfo bookInfo)) return false;
        return id != null && id.equals(bookInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
