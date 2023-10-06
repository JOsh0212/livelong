package world.neverdie.livelong.bookreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.neverdie.livelong.bookreview.domain.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {
}
