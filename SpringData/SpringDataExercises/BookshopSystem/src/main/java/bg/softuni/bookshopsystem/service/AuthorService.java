package bg.softuni.bookshopsystem.service;

import bg.softuni.bookshopsystem.model.entity.Author;

import java.io.IOException;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();
}
