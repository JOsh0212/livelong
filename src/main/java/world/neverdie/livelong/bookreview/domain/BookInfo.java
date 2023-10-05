package world.neverdie.livelong.bookreview.domain;

import jakarta.persistence.*;
import world.neverdie.livelong.bookreview.dto.BookType;

import java.time.LocalDateTime;
@Entity
public class BookInfo { //책정보 entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 책 아이디
    private String title;   //책 제목
    private String author;  //작가명 TODO 나중에 작가 테이블 뺄 예정
    private String translator;  //역자명 TODO 나중에 역자 테이블 뺄 예정
    private String publisher;   // 출판사
    private LocalDateTime publishDate;  //출판일자
    private String thumbnail;   //책 썸네일
    private String isbn;    //책 ISBN(13)
    private int bookCategory;   //KDC 번호 TODO 나중에 카테고리 테이블 뺄 예정
    @Enumerated(EnumType.STRING) private BookType bookType;    //책 타입
    private int length; // 쪽수
    private String firstLine;   //첫문장
    private String summary; //책 소개 혹은 줄거리
}
