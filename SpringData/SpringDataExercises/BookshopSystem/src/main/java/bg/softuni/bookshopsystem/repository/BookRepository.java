package bg.softuni.bookshopsystem.repository;

import bg.softuni.bookshopsystem.model.entity.Book;
import bg.softuni.bookshopsystem.model.enums.AgeRestriction;
import bg.softuni.bookshopsystem.model.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String authorFirstName,
                                                                                      String authorLastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    @Query("SELECT b FROM Book AS b WHERE b.price NOT BETWEEN :lower AND :upper")
    List<Book> findAllByPriceBeforeAndPriceAfter(BigDecimal lower, BigDecimal upper);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate lower, LocalDate upper);

    List<Book> findAllByTitleContainingIgnoreCase(String substring);

    List<Book> findAllByAuthor_LastNameStartsWith(String str);

    @Query("SELECT count(b) FROM Book b WHERE LENGTH(b.title) > :length")
    int countOfBooksWithTitleLengthMoreThan(@Param(value = "length") int titleLength);

    @Procedure("change_book_price_by_id")
    void changeBookPriceById(@Param("book_id") long id);

    Book findByTitle(String title);
}
