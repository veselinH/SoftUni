package bg.softuni.bookshopsystem.service;

import bg.softuni.bookshopsystem.model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);
}
