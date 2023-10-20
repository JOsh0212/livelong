package world.neverdie.livelong.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import world.neverdie.livelong.domain.BookReview;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결테스트")
@DataJpaTest
public class JpaRepositoryTest {

    private final BookReviewRepository bookReviewRepository;

    public JpaRepositoryTest(@Autowired BookReviewRepository bookReviewRepository) {
        this.bookReviewRepository = bookReviewRepository;
    }

    @DisplayName("select Test")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){
        //given

        //when
        List<BookReview> bookReviews = bookReviewRepository.findAll();

        //then
        assertThat(bookReviews)
                .isNotNull()
                .hasSize(50);
    }
    @DisplayName("insert Test")
    @Test
    void givenTestData_whenInserting_thenWorksFine(){
        //given
        Long previousCount = bookReviewRepository.count();
        BookReview newBookReview = BookReview.of(1L,"새 글",10L, LocalDateTime.now(),LocalDateTime.now(),1,2,"한줄 평가","유튜브 추천","이책의 TMI를 쓰는 곳","감상은 재미있었다");
        //when
        bookReviewRepository.save(newBookReview);
        //then
        assertThat(bookReviewRepository.count()).isEqualTo(previousCount+1);

    }
    @DisplayName("update Test")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        //given
        BookReview bookReview = bookReviewRepository.findById(1L).orElseThrow();
        System.out.println("bookReview.getTitle() = " + bookReview.getTitle());
        String updateTitle = "변경된 새 글";
        bookReview.setTitle(updateTitle);
        //when
        BookReview savedBookReview = bookReviewRepository.saveAndFlush(bookReview);
        System.out.println("savedBookReview.getTitle() = " + savedBookReview.getTitle());
        //then
        assertThat(savedBookReview).hasFieldOrPropertyWithValue("title",updateTitle);
    }
    @DisplayName("delete Test")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){
        //given
        BookReview bookReview = bookReviewRepository.findById(1L).orElseThrow();
        long previousBookCount = bookReviewRepository.count();

        //when
        bookReviewRepository.delete(bookReview);
        //then
        assertThat(bookReviewRepository.count()).isEqualTo(previousBookCount-1);

    }
}
