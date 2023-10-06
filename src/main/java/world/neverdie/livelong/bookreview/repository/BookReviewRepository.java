package world.neverdie.livelong.bookreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.neverdie.livelong.bookreview.domain.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview,Long> {
}
