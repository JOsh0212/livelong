package world.neverdie.livelong.bookreview.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import world.neverdie.livelong.bookreview.domain.BookCategory;
import world.neverdie.livelong.bookreview.domain.BookRatingSection;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 테스트")
@DataJpaTest
class JPARepositoryTest {

    //Repository
    private final BookCategoryRepository bookCategoryRepository;
    private final BookInfoRepository bookInfoRepository;
    private final BookReviewRepository bookReviewRepository;
    private final BookRatingSectionRepository bookRatingSectionRepository;

    JPARepositoryTest(
            @Autowired BookCategoryRepository bookCategoryRepository,
            @Autowired BookInfoRepository bookInfoRepository,
            @Autowired BookReviewRepository bookReviewRepository,
            @Autowired BookRatingSectionRepository bookRatingSectionRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
        this.bookInfoRepository = bookInfoRepository;
        this.bookReviewRepository = bookReviewRepository;
        this.bookRatingSectionRepository = bookRatingSectionRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestdata_whenSelecting_thenWorksFine(){
        //Given

        //When
        List<BookCategory> bookCategorys = bookCategoryRepository.findAll();
        //Then
        assertThat(bookCategorys)
                .isNotNull()
                .hasSize(1000);
    }

    @DisplayName("[별점섹션네임] insert 테스트")
    @Test
    void givenRatingSectionTestData_whenInsert_thenWorksFine(){
        //Given
        BookCategory bookCategory = BookCategory.of("1002"); //한국문학
        BookRatingSection section = BookRatingSection.of(bookCategory, "내용","감동","캐릭터","유머","생각깊이");

        //When
        bookRatingSectionRepository.save(section);

        //Then
        BookRatingSection savedSection = bookRatingSectionRepository.findById(section.getId()).orElse(null);
        assertThat(section).isEqualTo(savedSection);
    }


    @DisplayName("책정보 update 테스트")
    @Test
    void given_when_then(){
        //Given

        //When

        //Then

    }

}