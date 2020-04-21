package application.controller.api;


import application.data.model.Category;
import application.data.service.CategoryService;
import application.model.api.BaseApiResult;
import application.model.api.DataApiResult;
import application.model.dto.CategoryDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController {

    private static final Logger logger = LogManager.getLogger(CategoryApiController.class);

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public BaseApiResult createCategory(@RequestBody CategoryDTO dto) {
        BaseApiResult result = new BaseApiResult();

        try {
            Category category = new Category();
            category.setName(dto.getName());
            category.setShortDesc(dto.getShortDesc());
            category.setCreatedDate(new Date());

            categoryService.addNewCategory(category);

            result.setMessage("Create category success ! ");
            result.setSuccess(true);
        } catch (Exception ex) {
            logger.error(ex.getMessage());

            result.setMessage("Create category fails ! ");
            result.setSuccess(false);
        }

        return result;
    }

    @PostMapping("/detail/{categoryId}")
    public BaseApiResult detailCategory(@PathVariable int categoryId) {
        DataApiResult result = new DataApiResult();

        try {
            Category categoryEntity = categoryService.findOne(categoryId);
            if (categoryEntity == null) {
                result.setMessage("Can't not find category ");
                result.setSuccess(false);
            } else {
                CategoryDTO dto = new CategoryDTO();
                dto.setName(categoryEntity.getName());
                dto.setShortDesc(categoryEntity.getShortDesc());
                dto.setCreatedDate(categoryEntity.getCreatedDate());

                result.setData(dto);
                result.setMessage("Category Details success ! ");
                result.setSuccess(true);
            }
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage("Category Fail ! ");
            logger.error(ex.getMessage());
        }
        return result;
    }

    @PostMapping("/update/{categoryId}")
    public BaseApiResult updateCategory(@PathVariable int categoryId,
                                        @RequestBody CategoryDTO dto) {
        BaseApiResult result = new BaseApiResult();

        try {
            Category category = categoryService.findOne(categoryId);
            category.setName(dto.getName());
            category.setShortDesc(dto.getShortDesc());
            category.setCreatedDate(new Date());
            categoryService.updateCategory(category);

            result.setMessage("Category update success ! ");
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setMessage("Category update Fail ! ");
            logger.error(ex.getMessage());
        }
        return result;
    }

    @PostMapping("/delete/{categoryId}")
    public BaseApiResult deleteCategory(@PathVariable int categoryId) {
        BaseApiResult result = new BaseApiResult();

        try {
            categoryService.deleteCategory(categoryId);
            result.setSuccess(true);
            result.setMessage("Delete category " + categoryId + " success !");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setMessage("Delete fails !");
            result.setSuccess(false);
        }

        return result;
    }
}
