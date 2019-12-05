package com.docswebapps.homeinventoryservice.bootstrap;
import com.docswebapps.homeinventoryservice.domain.Category;
import com.docswebapps.homeinventoryservice.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("categoryBaseDataInsert")
@Order(2)
public class CategoryBaseDataInsert implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public CategoryBaseDataInsert(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(Category.builder().name("ELECTRONIC").build());
            categoryRepository.save(Category.builder().name("BOOKS").build());
            categoryRepository.save(Category.builder().name("JEWELERY").build());
            categoryRepository.save(Category.builder().name("FURNITURE").build());
        }
    }
}
