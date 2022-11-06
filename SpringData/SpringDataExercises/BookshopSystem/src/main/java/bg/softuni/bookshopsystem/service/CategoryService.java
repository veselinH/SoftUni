package bg.softuni.bookshopsystem.service;

import bg.softuni.bookshopsystem.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService{
    void seedCategories() throws IOException;

    Set<Category> getRandomCategory();
}
