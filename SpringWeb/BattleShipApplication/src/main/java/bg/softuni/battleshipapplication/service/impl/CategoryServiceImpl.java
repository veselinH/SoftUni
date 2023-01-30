package bg.softuni.battleshipapplication.service.impl;

import bg.softuni.battleshipapplication.model.entity.Category;
import bg.softuni.battleshipapplication.model.entity.enums.CategoryEnum;
import bg.softuni.battleshipapplication.repository.CategoryRepository;
import bg.softuni.battleshipapplication.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Category category1 = new Category();
            Category category2 = new Category();
            Category category3 = new Category();

            category1.setName(CategoryEnum.BATTLE);
            category2.setName(CategoryEnum.CARGO);
            category3.setName(CategoryEnum.PATROL);
            categoryRepository.saveAll(Set.of(category1, category2, category3));
        }
    }
}
