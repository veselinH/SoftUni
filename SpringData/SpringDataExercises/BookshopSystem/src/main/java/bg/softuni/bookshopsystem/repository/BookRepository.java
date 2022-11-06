package bg.softuni.bookshopsystem.repository;

import bg.softuni.bookshopsystem.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
