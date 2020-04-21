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

}
