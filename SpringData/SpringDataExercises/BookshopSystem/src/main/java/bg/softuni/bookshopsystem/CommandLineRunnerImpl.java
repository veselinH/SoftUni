package bg.softuni.bookshopsystem;

import bg.softuni.bookshopsystem.model.entity.Book;
import bg.softuni.bookshopsystem.model.enums.AgeRestriction;
import bg.softuni.bookshopsystem.model.enums.EditionType;
import bg.softuni.bookshopsystem.service.AuthorService;
import bg.softuni.bookshopsystem.service.BookService;
import bg.softuni.bookshopsystem.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final Scanner scanner;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, Scanner scanner) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        System.out.println("Please select exercise:");
        int exerciseNumber = Integer.parseInt(scanner.nextLine());

        switch (exerciseNumber) {
            case 1 -> bookTitlesByAgeRestriction();
            case 2 -> goldenBooks();
            case 3 -> booksByPriceLowerThan5AndHigherThan40();
            case 4 -> notReleaseBooks();
            case 5 -> booksReleasedBeforeDate();
            case 6 -> authorsSearch();
            case 7 -> booksSearch();
            case 8 -> bookTitlesSearch();
            case 9 -> countBooks();
            case 10 -> totalBookCopies();
            case 11 -> reducedBook();
            case 99 -> test();
        }

    }

    private void reducedBook() {
        System.out.println("Please select book title:");
        String bookTitle = scanner.nextLine();

        System.out.println(bookService.findByBookTitle(bookTitle));
    }

    private void test() {

        bookService.changePrice(1L);
    }

    private void totalBookCopies() {
        authorService.findAllAuthorsAndTheirTotalCopies()
                .forEach(System.out::println);
    }

    private void countBooks() {
        System.out.println("Enter title length:");
        int titleLength = Integer.parseInt(scanner.nextLine());
        System.out.println(bookService.findCountOfAllBookWithTitleLengthMoreThan(titleLength));
    }

    private void bookTitlesSearch() {
        System.out.println("Please enter string:");
        String substring = scanner.nextLine();

        bookService.findAllBooksWithAuthorsLastNameStartsWith(substring)
                .forEach(System.out::println);
    }

    private void booksSearch() {
        System.out.println("Please enter string:");
        String substring = scanner.nextLine();
        bookService.findAllByTitleContainingGivenString(substring)
                .forEach(System.out::println);
    }

    private void authorsSearch() {
        System.out.println("Please enter a string:");
        String substring = scanner.nextLine();
        authorService.findAllAuthorsWithFirstNameEndingWith(substring)
                .forEach(System.out::println);
    }

    private void booksReleasedBeforeDate() {
        System.out.println("Please enter date:");
        LocalDate releaseDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService.findAllBooksReleasedBeforeDate(releaseDate)
                .forEach(System.out::println);
    }

    private void notReleaseBooks() {
        System.out.println("Please enter year:");
        int year = Integer.parseInt(scanner.nextLine());

        bookService
                .findNotReleasedBookTitlesInYear(year)
                .forEach(System.out::println);
    }

    private void booksByPriceLowerThan5AndHigherThan40() {
        for (Book book : bookService.findAllBooksWithPriceLowerThanAndHigherThan()) {
            System.out.printf("%s - $%.2f%n", book.getTitle(), book.getPrice());
        }
    }

    private void goldenBooks() {
        Integer copies = Integer.valueOf("5000");
        EditionType editionType = EditionType.GOLD;
        bookService.findAllBooksByEditionTypeAndCopies(editionType, copies)
                .forEach(System.out::println);
    }

    private void bookTitlesByAgeRestriction() {
        System.out.println("Please enter age restriction:");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(scanner.nextLine().toUpperCase());

        bookService.findAllByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
