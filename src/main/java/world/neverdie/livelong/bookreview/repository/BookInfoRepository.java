package world.neverdie.livelong.bookreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.neverdie.livelong.bookreview.domain.BookInfo;

public interface BookInfoRepository extends JpaRepository<BookInfo,Long> {
}
