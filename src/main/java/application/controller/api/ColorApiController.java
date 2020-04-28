package application.controller.api;

import application.data.model.Color;
import application.data.service.ColorService;
import application.model.api.BaseApiResult;
import application.model.api.DataApiResult;
import application.model.dto.ColorDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/color")
public class ColorApiController {

    private final static Logger logger = LogManager.getLogger(ColorApiController.class);


    @Autowired
    private ColorService colorService;

    @PostMapping("/create")
    public BaseApiResult createColor(@RequestBody ColorDTO dto) {
        BaseApiResult result = new BaseApiResult();
        try {
            if (dto != null) {
                Color color = new Color();
                color.setName(dto.getName());
                color.setShortDesc(dto.getShortDesc());
                color.setCreatedDate(new Date());

                colorService.addNewColor(color);

                result.setSuccess(true);
                result.setMessage("Create color success !");
            } else {
                result.setSuccess(false);
            }


        } catch (Exception ex) {
            logger.error(ex.getMessage());

            result.setSuccess(false);
            result.setMessage("Create color Fails !");
        }

        return result;
    }

    @PostMapping("/update/{colorId}")
    public BaseApiResult updateColor(@PathVariable int colorId,
                                     @RequestBody ColorDTO dto) {
        BaseApiResult result = new BaseApiResult();

        try {
            Color color = colorService.findOne(colorId);
            color.setName(dto.getName());
            color.setShortDesc(dto.getShortDesc());
            color.setCreatedDate(new Date());


            colorService.updateColor(color);

            result.setSuccess(true);
            result.setMessage("Update color success !");


        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setSuccess(true);
            result.setMessage("Update color fails !");
        }

        return result;
    }

    @PostMapping("/detail/{colorId}")
    public DataApiResult detailColor(@PathVariable int colorId) {
        DataApiResult result = new DataApiResult();

        try {
            Color colorEntity = colorService.findOne(colorId);
            if (colorEntity != null) {
                ColorDTO dto = new ColorDTO();
                dto.setName(colorEntity.getName());
                dto.setShortDesc(colorEntity.getShortDesc());
                dto.setCreatedDate(colorEntity.getCreatedDate());

                result.setData(dto);
                result.setMessage("Details Color success ! ");
                result.setSuccess(true);

            } else {
                result.setSuccess(false);
                result.setMessage("Can't not find color !");
            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setMessage("Details Color Fails ! ");
            result.setSuccess(true);
        }

        return result;
    }

    @PostMapping("/delete/{colorId}")
    public BaseApiResult deleteColor(@PathVariable int colorId) {
        BaseApiResult result = new BaseApiResult();

        try {
            colorService.deleteColor(colorId);
            result.setMessage("Delete Color success ! ");
            result.setSuccess(true);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setMessage("Delete Color fails ! ");
            result.setSuccess(false);
        }

        return result;
    }

}
