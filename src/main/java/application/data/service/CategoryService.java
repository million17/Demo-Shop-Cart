package application.data.service;

import application.data.model.Category;
import application.data.repository.CategoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CategoryService {

    private static final Logger logger = LogManager.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getListAllCategories(){
        try {
            return categoryRepository.findAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ArrayList<>();
        }
    }
}
