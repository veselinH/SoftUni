package bg.softuni.bookshopsystem.service;

import bg.softuni.bookshopsystem.model.entity.Book;
import bg.softuni.bookshopsystem.model.enums.AgeRestriction;
import bg.softuni.bookshopsystem.model.enums.EditionType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);
    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllBooksByEditionTypeAndCopies(EditionType editionType, Integer copies);

    List<Book> findAllBooksWithPriceLowerThanAndHigherThan();

    List<String> findNotReleasedBookTitlesInYear(int year);

    List<String> findAllBooksReleasedBeforeDate(LocalDate date);

    List<String> findAllByTitleContainingGivenString(String substring);

    List<String> findAllBooksWithAuthorsLastNameStartsWith(String substring);

    int findCountOfAllBookWithTitleLengthMoreThan(int titleLength);

    void changePrice(long bookId);

    String findByBookTitle(String bookTitle);
}
