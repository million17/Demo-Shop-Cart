package application.data.service;

import application.data.model.Category;
import application.data.repository.CategoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class CategoryService {

    private static final Logger logger = LogManager.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getListAllCategories() {
        try {
            return categoryRepository.findAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ArrayList<>();
        }
    }

    public Category findOne(int categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    @Transactional
    public boolean addNewCategory(Category category) {
        try {
            categoryRepository.save(category);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return false;
        }

    }

    @Transactional
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public boolean deleteCategory(int categoryId) {
        try {
            categoryRepository.delete(categoryId);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return false;
        }
    }
}
