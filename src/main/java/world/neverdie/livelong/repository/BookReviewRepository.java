package world.neverdie.livelong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.neverdie.livelong.domain.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview,Long> {
}
