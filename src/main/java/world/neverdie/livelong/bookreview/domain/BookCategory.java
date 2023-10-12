package world.neverdie.livelong.bookreview.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.ToString;

import java.awt.print.Book;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table
@Entity
public class BookCategory { // 책 카테고리 - kdc(한국십진분류포) 사용, 정해진 데이터 setter 없음
    @Id @Column(nullable = false) private String kdc;    // 십진코드
    @Column(nullable = false) private String kdcName; // 코드이름
    private String majorCode;  // 대분류
    private String middleCode; // 중분류

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "bookCategory")
    private final Set<BookInfo> bookInfos = new LinkedHashSet<>();    // 카테고리별 책 가져오기, 양방향 바인드 안함, cascade 안씀
    protected BookCategory() {}
    private BookCategory(String kdc, String kdcName, String majorCode, String middleCode) {
        this.kdc = kdc;
        this.kdcName = kdcName;
        this.majorCode = majorCode;
        this.middleCode = middleCode;
    }
    public static BookCategory of(String kdc, String kdcName, String majorCode, String middleCode) {
        return new BookCategory(kdc,kdcName,majorCode,middleCode);
    }
    public static BookCategory of(String kdc) {
        return new BookCategory(kdc,null,null,null);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookCategory bookCategory)) return false;
        return kdc!=null && kdc.equals(bookCategory.kdc);
    }
    @Override
    public int hashCode() {
        return Objects.hash(kdc);
    }
}
