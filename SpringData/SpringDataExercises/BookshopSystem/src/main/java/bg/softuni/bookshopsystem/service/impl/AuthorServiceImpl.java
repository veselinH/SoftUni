package bg.softuni.bookshopsystem.service.impl;

import bg.softuni.bookshopsystem.model.entity.Author;
import bg.softuni.bookshopsystem.model.entity.Book;
import bg.softuni.bookshopsystem.repository.AuthorRepository;
import bg.softuni.bookshopsystem.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static bg.softuni.bookshopsystem.service.impl.FilePaths.AUTHORS_FILE_PATH;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(AUTHORS_FILE_PATH))
                .stream()
                .filter(row -> !row.isEmpty())
                .forEach(authorName -> {
                    String[] fullName = authorName.split("\\s+");
                    Author author = new Author(fullName[0], fullName[1]);

                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomID = ThreadLocalRandom
                .current().nextLong(1, authorRepository.count() + 1);
        return authorRepository
                .findById(randomID)
                .orElse(null);
    }

    @Override
    public List<String> getAllAuthorsOrderByCountOfTheirBooks() {
        return authorRepository
                .findAllByBooksSizeDESC()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBook().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllAuthorsWithFirstNameEndingWith(String substring) {
        return authorRepository.findAllByFirstNameEndingWith(substring)
                .stream()
                .map(author -> String.format("%s %s",
                        author.getFirstName(), author.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllAuthorsAndTheirTotalCopies() {
        return authorRepository
                .findAll()
                .stream()
                .map(author -> String.format("%s %s - %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author
                                .getBook()
                                .stream()
                                .map(Book::getCopies)
                                .reduce(Integer::sum)
                                .orElse(0)))
                .collect(Collectors.toList());
    }
}
