package world.neverdie.livelong.reviewer.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import world.neverdie.livelong.bookreview.domain.BookReview;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

// TODO 임시, 나중에 security랑 oauth 인증 붙일 예정
@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "nickname")
})
@Entity
public class Reviewer { // user를 reviewer로 정하겠음
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 아이디
    @Setter @Column(nullable = false,length = 66) private String nickname;    //닉네임

    @Setter @OneToMany private Set<BookReview> bookReviews = new LinkedHashSet<>();

    //메타데이터
    @CreatedBy private LocalDateTime createdAt;
    @LastModifiedDate private LocalDateTime modifiedAt;

    protected Reviewer() {}
    private Reviewer(String nickname, Set<BookReview> bookReviews, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.nickname = nickname;
        this.bookReviews = bookReviews;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static Reviewer of(String nickname, Set<BookReview> bookReviews, LocalDateTime createdAt, LocalDateTime modifiedAt){
        return new Reviewer(nickname,bookReviews,createdAt,modifiedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reviewer reviewer)) return false;
        return id!=null && id.equals(reviewer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
