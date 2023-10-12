package world.neverdie.livelong.bookreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import world.neverdie.livelong.bookreview.domain.BookCategory;
@RepositoryRestResource
public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {
}
